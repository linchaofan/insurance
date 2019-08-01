package org.lcf.ins.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.lcf.ins.dao.InsuredMapper;
import org.lcf.ins.dao.OrderInfoMapper;
import org.lcf.ins.dao.PayMapper;
import org.lcf.ins.dao.ProductMapper;
import org.lcf.ins.dao.ProductSchemeMapper;
import org.lcf.ins.dao.UserMapper;
import org.lcf.ins.dto.InsureOrderDTO;
import org.lcf.ins.dto.ProductDetailDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.Insured;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.OrderInfoExample;
import org.lcf.ins.entity.Pay;
import org.lcf.ins.entity.PayExample;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.ProductExample;
import org.lcf.ins.entity.ProductScheme;
import org.lcf.ins.entity.ProductSchemeExample;
import org.lcf.ins.entity.User;
import org.lcf.ins.entity.UserExample;
import org.lcf.ins.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@Service
public class InsService {

	@Autowired
	ProductSchemeMapper productSchemeMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	OrderInfoMapper orderInfoMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	InsuredMapper insuredMapper;
	@Autowired
	PayMapper payMapper;
	@Autowired
	OrderService orderService;
	@Autowired
	InsuredService insuredService;

	// 获取方案价格
	@SuppressWarnings("unchecked")
	public ResultDTO<String> getSchemePrice(String code, String age, String hasSocial, String coverage, String deadLine)
			throws JsonParseException, JsonMappingException, IOException {
		ResultDTO<String> result = ResultDTO.newSuccess();
		String price;
		String productCode = null;
		String insuredAge = null;
		String social = null;
		String cov = null;
		String dead = null;
		ObjectMapper mapper = new ObjectMapper();
		if (code != null) {
			productCode = mapper.readValue(code, String.class);
		} else {
			productCode = "off";
		}
		ProductSchemeExample example = new ProductSchemeExample();
		ProductSchemeExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<ProductScheme> list = productSchemeMapper.selectByExample(example);
		if (age != null) {
			insuredAge = mapper.readValue(age, String.class);
			int length1 = list.get(0).getAgeRange().length();
			int length2 = list.get(list.size()-1).getAgeRange().length();
			int min = Integer.parseInt(list.get(0).getAgeRange().substring(length1 - 2, length1))-10; 
			int max = Integer.parseInt(list.get(list.size()-1).getAgeRange().substring(length2 - 2, length2));
			if(Integer.parseInt(insuredAge)<min||Integer.parseInt(insuredAge)>max){
				result = ResultDTO.newFail("被保人年龄不符合");
				return result;
			}
		} else {
			insuredAge = "off";
		}
		if (hasSocial != null) {
			social = mapper.readValue(hasSocial, String.class);
		} else {
			social = "off";
		}
		cov = mapper.readValue(coverage, String.class);
		if (coverage == null) {
			cov = "off";
		} 
		dead = mapper.readValue(deadLine, String.class);
		if (dead == null) {
			dead = "off";
		} 
		for (ProductScheme scheme : list) {
			int length = scheme.getAgeRange().length();
			int minAge = Integer.parseInt(scheme.getAgeRange().substring(length - 2, length)) - 10;
			int maxAge = Integer.parseInt(scheme.getAgeRange().substring(length - 2, length));
			if (Integer.parseInt(insuredAge) > minAge && Integer.parseInt(insuredAge) <= maxAge
					&& social.equals(scheme.getHasSocial()) && cov.equals(scheme.getCoverage())
					&& dead.equals(scheme.getDeadline())) {
				price = scheme.getPrice().toString();
				result.setData(price);
				return result;
			}
		}
		result = ResultDTO.newFail("获取报价失败");
		return null;
	}

	// 核保
	@SuppressWarnings("unchecked")
	public ResultDTO<InsureOrderDTO> checkOrder(String data, HttpSession session) throws Exception {
		ResultDTO<InsureOrderDTO> result = ResultDTO.newSuccess();
		ObjectMapper mapper = new ObjectMapper();
		InsureOrderDTO insOrder = mapper.readValue(data, InsureOrderDTO.class);
		OrderInfo order = new OrderInfo();
		ProductDetailDTO productDetail = (ProductDetailDTO) session.getAttribute("productDetail");
		String productCode = session.getAttribute("productCode").toString();
		// 生成投保单号
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String proposalNo = "2" + df.format(time).toString();
		// 核实保费
		Long schemePrice = Long.parseLong(session.getAttribute("schemePrice").toString());
		ProductSchemeExample example = new ProductSchemeExample();
		ProductSchemeExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<ProductScheme> list = productSchemeMapper.selectByExample(example);
		boolean tag = false;
		for (ProductScheme scheme : list) {
			if (scheme.getPrice().equals(schemePrice)) {
				tag = true;
				// 判断被保人年龄是否符合方案
				String birth = insOrder.getInsuredBirth();
				String getBirth = insOrder.getInsuredNumberId().substring(6, 14);
				if (!(getBirth.equals(birth.replace("-", "")))) {
					order.setCheckStatus(3);
					result = ResultDTO.newFail("核保失败,被保人年龄有误");
					break;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(birth.toString());
				int age = getAge(birthday);
				int length = scheme.getAgeRange().length();
				int minAge = Integer.parseInt(scheme.getAgeRange().substring(length - 2, length)) - 10;
				int maxAge = Integer.parseInt(scheme.getAgeRange().substring(length - 2, length));
				if (!(age <= maxAge && age > minAge)) {
					order.setCheckStatus(3);
					result = ResultDTO.newFail("核保失败,被保人年龄与方案不匹配");
					break;
				}
				order.setSchemeId(scheme.getId());
				order.setTotalAmount(Long.parseLong(scheme.getCoverage()));
				break;
			}
		}
		if (!tag) {
			order.setCheckStatus(3);
			result = ResultDTO.newFail("核保失败,保费与方案不匹配");
		}

		// 核实投保人信息
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria1 = userExample.createCriteria();
		criteria1.andPhoneEqualTo(insOrder.getHolderPhone());
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			order.setCheckStatus(3);
			return result = ResultDTO.newFail("核保失败，并非您本人投保");
		} else {
			if (!(insOrder.getHolderName().equals(users.get(0).getName()))
					|| !(insOrder.getHolderNumberId().equals(users.get(0).getNumberId()))) {
				order.setCheckStatus(3);
				result = ResultDTO.newFail("核保失败，投保人信息不匹配");
			}
			order.setHolderId(users.get(0).getId());
		}
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria2 = productExample.createCriteria();
		criteria2.andCodeEqualTo(productCode);
		List<Product> products = productMapper.selectByExample(productExample);

		// 插入核保信息
		if (result.getStatus() == ErrorEnum.success.getErrorCode()) {
			order.setCheckStatus(2);
		}
		order.setProductName(productDetail.getName());
		order.setProposalNo(proposalNo);
		order.setProductId(products.get(0).getId());
		order.setProductName(products.get(0).getName());
		order.setProductCode(productCode);
		order.setTotalPrice(schemePrice);
		order.setPolicyNum(1);
		order.setCreateTime(time);
		orderInfoMapper.insertSelective(order);

		// 插入被保人信息
		OrderInfoExample orderExample = new OrderInfoExample();
		OrderInfoExample.Criteria criteria3 = orderExample.createCriteria();
		criteria3.andProposalNoEqualTo(proposalNo);
		List<OrderInfo> justOrder = orderInfoMapper.selectByExample(orderExample);
		Insured insured = new Insured();
		insured.setOrderId(justOrder.get(0).getId());
		insured.setName(insOrder.getInsuredName());
		insured.setNumberId(insOrder.getInsuredNumberId());
		insured.setGender(insOrder.getInsuredSex());
		insured.setBirthday(insOrder.getInsuredBirth());
		insured.setPhone(insOrder.getInsuredPhone());
		insured.setEmail(insOrder.getInsuredEmail());
		insured.setAddress(insOrder.getInsuredAddress());
		insuredMapper.insertSelective(insured);

		result.setData(insOrder);
		session.setAttribute("proposalNo", proposalNo);
		return result;
	}

	// 支付
	@SuppressWarnings("unchecked")
	public ResultDTO<String> pay(String holderPhone, String price, String proposalNo) throws ParseException {
		ResultDTO<String> result = ResultDTO.newSuccess();
		PayExample example = new PayExample();
		PayExample.Criteria criteria = example.createCriteria();
		criteria.andUserPhoneEqualTo(holderPhone);
		List<Pay> list = payMapper.selectByExample(example);
		Pay pay = list.get(0);
		OrderInfoExample orderExample = new OrderInfoExample();
		OrderInfoExample.Criteria criteria1 = orderExample.createCriteria();
		criteria1.andProposalNoEqualTo(proposalNo);
		List<OrderInfo> orders = orderInfoMapper.selectByExample(orderExample);
		OrderInfo order = orders.get(0);
		ProductSchemeExample schemeExample = new ProductSchemeExample();
		ProductSchemeExample.Criteria criteria2 = schemeExample.createCriteria();
		criteria2.andProductCodeEqualTo(order.getProductCode());
		List<ProductScheme> schemes = productSchemeMapper.selectByExample(schemeExample);
		ProductScheme scheme = schemes.get(0);
		if (pay.getAccount() < Integer.parseInt(price)) {
			result = ResultDTO.newFail("付款失败，账户余额不足，请及时充值哦~");
			// 更新订单状态
			order.setCheckStatus(6);
			orderInfoMapper.updateByPrimaryKeySelective(order);
			return result;
		}
		int account = pay.getAccount() - Integer.parseInt(price);
		pay.setAccount(account);

		// 添加保单号以及保障期
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String policyNo = "3" + df.format(time).toString();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String beginDate = df1.format(date);
		String endDate = getEndDate(date, scheme.getDeadline());
		order.setCheckStatus(5);
		order.setPolicyNo(policyNo);
		order.setBeginDate(df1.parse(beginDate.toString()));
		if(endDate!=null){
			order.setEndDate(df1.parse(endDate.toString()));
		} else {
			order.setEndDate(null);
		}

		payMapper.updateByPrimaryKeySelective(pay);
		orderInfoMapper.updateByPrimaryKeySelective(order);
		result.setMessage("恭喜您，付款成功！");
		return result;
	}

	@SuppressWarnings("unchecked")
	public ResultDTO<InsureOrderDTO> getInsOrderByOrderId(Integer orderId) {
		ResultDTO<InsureOrderDTO> result = ResultDTO.newSuccess();
		ResultDTO<Insured> result2 = insuredService.selectInsuredByOrderId(orderId);
		Insured insured = result2.getData();
		InsureOrderDTO insOrder = new InsureOrderDTO();
		insOrder.setInsuredName(insured.getName());
		insOrder.setInsuredPhone(insured.getPhone());
		insOrder.setInsuredNumberId(insured.getNumberId());
		insOrder.setInsuredEmail(insured.getEmail());
		insOrder.setInsuredAddress(insured.getAddress());
		result.setData(insOrder);
		return result;
	}

	// 根据出生日期获取年龄
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}

	// 获取结束日期
	public static String getEndDate(Date currentTime, String deadLine) {
		String endDate;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(currentTime);
		if (deadLine.equals("7天")) {
			c.add(Calendar.DAY_OF_MONTH, 7);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("15天")) {
			c.add(Calendar.DAY_OF_MONTH, 15);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("30天")) {
			c.add(Calendar.DAY_OF_MONTH, 30);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("6个月")) {
			c.add(Calendar.MONTH, 6);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("1年")) {
			c.add(Calendar.YEAR, 1);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("2年")) {
			c.add(Calendar.YEAR, 2);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if (deadLine.equals("3年")) {
			c.add(Calendar.YEAR, 3);
			endDate = df.format(c.getTime());
			return endDate;
		}
		if(deadLine.equals("off")) {
			return null;
		}

		return null;
	}

}
