package org.lcf.ins.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lcf.ins.dao.InsuredMapper;
import org.lcf.ins.dao.OrderInfoMapper;
import org.lcf.ins.dao.ProductMapper;
import org.lcf.ins.dao.SellerMapper;
import org.lcf.ins.dao.UserMapper;
import org.lcf.ins.dto.CheckOrderDTO;
import org.lcf.ins.dto.OrderDetailDTO;
import org.lcf.ins.dto.PolicyDTO;
import org.lcf.ins.dto.PolicyDetailDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.Insured;
import org.lcf.ins.entity.InsuredExample;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.OrderInfoExample;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.ProductExample;
import org.lcf.ins.entity.Seller;
import org.lcf.ins.entity.User;
import org.lcf.ins.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderInfoMapper orderInfoMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	InsuredMapper insuredMapper;
	@Autowired 
	InsuredService insuredService;
	@Autowired 
	SellerMapper sellerMapper;
	@Autowired
	ProductMapper productMapper;

	
	//根据ID查询订单
	@SuppressWarnings("unchecked")
	public ResultDTO<OrderInfo> selectOrderInfoById(Integer OrderId){
		ResultDTO<OrderInfo> result = ResultDTO.newSuccess();
		OrderInfo order = orderInfoMapper.selectByPrimaryKey(OrderId);
		if(order==null){
			return result=ResultDTO.newFail("订单不存在");
		}
		result.setData(order);
		return result;
	}
	
	//根据投保人id查询order
	@SuppressWarnings("unchecked")
	public ResultDTO<List<OrderInfo>> selectOrderByHolderId(Integer holderId){
		ResultDTO<List<OrderInfo>> result = ResultDTO.newSuccess();
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andHolderIdEqualTo(holderId);
		List<OrderInfo> orders = orderInfoMapper.selectByExample(orderInfoExample);
		if(orders.size()==0){
			return result=ResultDTO.newFail("您目前还没有订单哦~");
		}
		result.setData(orders);
		return result;
	}
	
	//根据Id获取订单明细
	@SuppressWarnings("unchecked")
	public ResultDTO<OrderDetailDTO> selectOrderById(Integer OrderId){
		ResultDTO<OrderDetailDTO> result = ResultDTO.newSuccess();
		OrderInfo order = orderInfoMapper.selectByPrimaryKey(OrderId);
		User holder = userMapper.selectByPrimaryKey(order.getHolderId());
//		Insured insured = insuredMapper.selectByPrimaryKey(order.getInsuredId());
		InsuredExample example = new InsuredExample();
		InsuredExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(OrderId);
		List<Insured> insureds = insuredMapper.selectByExample(example);
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		orderDetail.setProductName(order.getProductName());
		orderDetail.setLinkNo(order.getLinkNo());
		orderDetail.setProposalNo(order.getProposalNo());
		orderDetail.setPolicyNo(order.getPolicyNo());
		orderDetail.setHolderName(holder.getName());
		orderDetail.setInsuredName(insureds.get(0).getName());
		orderDetail.setOrderDate(sdf.format(order.getCreateTime()));
		orderDetail.setPolicyNum(order.getPolicyNum());
		orderDetail.setPrice(order.getTotalPrice());
		result.setData(orderDetail);
		return result;
	}
	
	//根据投保人id查询订单记录
	@SuppressWarnings("unchecked")
	public ResultDTO<List<OrderInfo>> selectOrderByHolderIdAndStatus(Integer holderId){
		ResultDTO<List<OrderInfo>> result = ResultDTO.newSuccess();
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andHolderIdEqualTo(holderId);
		List<OrderInfo> orders = orderInfoMapper.selectByExample(orderInfoExample);
		if(orders.size()==0){
			return result=ResultDTO.newFail("您目前还没有订单哦~");
		}
		List<OrderInfo> list = new ArrayList<>();
		for(OrderInfo order : orders){
			if(order.getCheckStatus()==4||order.getCheckStatus()==5||order.getCheckStatus()==6){
				list.add(order);
			}
		}
		result.setData(list);
		return result;
	}
	
	
	//获取核保记录详情
	@SuppressWarnings("unchecked")
	public ResultDTO<CheckOrderDTO> checkOrderDetail(Integer holderId,Integer orderId,OrderInfo order){
		ResultDTO<CheckOrderDTO> result = ResultDTO.newSuccess();
		User holder = userMapper.selectByPrimaryKey(holderId);
		ResultDTO<Insured> result1 = insuredService.selectInsuredByOrderId(orderId);
		Insured insured = result1.getData();
		CheckOrderDTO checkOrder = new CheckOrderDTO();
		checkOrder.setProductName(order.getProductName());
		checkOrder.setProposalNo(order.getProposalNo());
		checkOrder.setHolderName(holder.getName());
		checkOrder.setHolderPhone(holder.getPhone());
		checkOrder.setInsuredName(insured.getName());
		checkOrder.setInsuredSex(insured.getGender());
		checkOrder.setInsuredNumberId(insured.getNumberId());
		checkOrder.setInsuredPhone(insured.getPhone());
		checkOrder.setInsuredBirth(insured.getBirthday());
		checkOrder.setInsuredEmail(insured.getEmail());
		checkOrder.setInsuredAddress(insured.getAddress());
		checkOrder.setCheckStatus(order.getCheckStatus());
		result.setData(checkOrder);
		return result;
	}
	
	//获取保单
	@SuppressWarnings("unchecked")
	public ResultDTO<List<PolicyDTO>> selectPolicy(List<OrderInfo> orders){
		ResultDTO<List<PolicyDTO>> result = ResultDTO.newSuccess();
		List<PolicyDTO> list = new ArrayList<>();
		for(OrderInfo order : orders){
			if(order.getCheckStatus()==5){
			PolicyDTO policy = new PolicyDTO();
			Product product = productMapper.selectByPrimaryKey(order.getProductId());
			Seller seller = sellerMapper.selectByPrimaryKey(product.getSellerId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			policy.setOrderId(order.getId());
			policy.setProductName(order.getProductName());
			policy.setCompanyName(seller.getName());
			if(order.getEndDate()!=null){
				policy.setEndDate(sdf.format(order.getEndDate()));
			} else {
				policy.setEndDate(null);
			}
			list.add(policy);
			}
		}
		result.setData(list);
		return result;
	}
	
	//获取保单明细
	@SuppressWarnings("unchecked")
	public ResultDTO<PolicyDetailDTO> getPolicyDetail(Integer orderId){
		ResultDTO<PolicyDetailDTO> result = ResultDTO.newSuccess();
		PolicyDetailDTO policyDetail = new PolicyDetailDTO();
		OrderInfo order = orderInfoMapper.selectByPrimaryKey(orderId);
		Product product = productMapper.selectByPrimaryKey(order.getProductId());
		Seller seller = sellerMapper.selectByPrimaryKey(product.getSellerId());
		User holder = userMapper.selectByPrimaryKey(order.getHolderId());
		ResultDTO<Insured> result1 = insuredService.selectInsuredByOrderId(orderId);
		Insured insured = result1.getData();
		policyDetail.setProductName(order.getProductName());
		policyDetail.setCompanyName(seller.getName());
		policyDetail.setHolderName(holder.getName());
		policyDetail.setHolderNumberId(holder.getNumberId());
		policyDetail.setInsuredName(insured.getName());
		policyDetail.setInsuredNumberId(insured.getNumberId());
		policyDetail.setTotalPrice(order.getTotalPrice());
		policyDetail.setTotalAmount(order.getTotalAmount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		policyDetail.setBeginDate(sdf.format(order.getBeginDate()));
		if(order.getEndDate()!=null){
			policyDetail.setEndDate(sdf.format(order.getEndDate()));
		} else {
			policyDetail.setEndDate(null);
		}
		result.setData(policyDetail);
		return result;
	}
	
	//更新order的checkStatuus、生成流水号
	@SuppressWarnings("unchecked")
	public ResultDTO<String> updateCheckStatus(String proposalNo,Integer checkStatus){
		ResultDTO<String> result = ResultDTO.newSuccess();
		OrderInfoExample example = new OrderInfoExample();
		OrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProposalNoEqualTo(proposalNo);
		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		OrderInfo order = list.get(0);
		//生成流水号
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String linkNo = "1" + df.format(time).toString();
		order.setLinkNo(linkNo);
		order.setCheckStatus(checkStatus);
		orderInfoMapper.updateByPrimaryKeySelective(order);
		return result;
	}
	
	//根据productCode获取订单列表
	@SuppressWarnings("unchecked")
	public ResultDTO<List<OrderInfo>> selectByProductCode(String productCode){
		ResultDTO<List<OrderInfo>> result = ResultDTO.newSuccess();
		OrderInfoExample example = new OrderInfoExample();
		OrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductCodeEqualTo(productCode);
		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		if(list.size()==0){
			result = ResultDTO.newFail("暂无该产品的任何订单");
			return result;
		}
		result.setData(list);
		return result;
	}
}
