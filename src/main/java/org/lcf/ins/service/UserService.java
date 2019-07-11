package org.lcf.ins.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.lcf.ins.dao.PayMapper;
import org.lcf.ins.dao.SellerMapper;
import org.lcf.ins.dao.UserMapper;
import org.lcf.ins.dto.ChangePwdDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.dto.UserInfoDTO;
import org.lcf.ins.entity.Pay;
import org.lcf.ins.entity.PayExample;
import org.lcf.ins.entity.Seller;
import org.lcf.ins.entity.User;
import org.lcf.ins.entity.UserExample;
import org.lcf.ins.enums.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	PayMapper payMapper;
	@Autowired
	SellerMapper sellerMapper;
	
	@SuppressWarnings("unchecked")
	public ResultDTO<List<User>> selectAllUsers(){
		ResultDTO<List<User>> result = ResultDTO.newSuccess();
		List<User> users = userMapper.selectAll();
		result.setData(users);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ResultDTO<UserInfoDTO> selectUserById(Integer userId) {
		ResultDTO<UserInfoDTO> result = ResultDTO.newSuccess();
		UserInfoDTO userInfo = new UserInfoDTO();
		User user = userMapper.selectByPrimaryKey(userId);
		if(user == null) {
			LOGGER.info("用户不存在");
			result = ResultDTO.newFail("用户不存在。");
			return result;
		}
		BeanUtils.copyProperties(user, userInfo);
		result.setData(userInfo);
		return result;
	}
	

	@SuppressWarnings("rawtypes")
	public ResultDTO insertUser(UserInfoDTO userInfo) {
		ResultDTO result = ResultDTO.newSuccess();
		User user = new User();
		if(userInfo == null) {
			LOGGER.info("用户数据为空");
			return result = ResultDTO.newFail("用户数据为空");
		}
		if(checkUser(userInfo).getStatus()!=ErrorEnum.success.getErrorCode()) {
			return checkUser(userInfo);
		}
		BeanUtils.copyProperties(userInfo, user);
		userMapper.insert(user);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public ResultDTO insertSeller(Seller seller){
		ResultDTO result = ResultDTO.newSuccess();
		if(seller==null){
			return result = ResultDTO.newFail("数据为空");
		}
		if(checkSeller(seller).getStatus()!=ErrorEnum.success.getErrorCode()){
			return checkSeller(seller);
		}
		sellerMapper.insert(seller);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResultDTO checkUser(UserInfoDTO userInfo) {
		ResultDTO result = ResultDTO.newSuccess();
		if(userInfo == null) {
			return result = ResultDTO.newFail("用户填写信息为空！");
		}
		if(StringUtils.isBlank(userInfo.getName())) {
			return result = ResultDTO.newFail("请填写姓名");
		}
		if(StringUtils.isBlank(userInfo.getNumberId())) {
			return result = ResultDTO.newFail("请填写身份证号码");
		}
		if(StringUtils.isBlank(userInfo.getPhone())) {
			return result = ResultDTO.newFail("手机号码不能为空");
		} else {
			if(userInfo.getPhone().length()!=11) {
				return result = ResultDTO.newFail("请正确填写手机号码");
			}
		}
		if(StringUtils.isBlank(userInfo.getEmail())) {
			return result = ResultDTO.newFail("请填写电子邮箱");
		}
		if(StringUtils.isBlank(userInfo.getGender())) {
			return result = ResultDTO.newFail("请填写性别");
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResultDTO checkSeller(Seller seller) {
		ResultDTO result = ResultDTO.newSuccess();
		if(seller == null) {
			return result = ResultDTO.newFail("用户填写信息为空！");
		}
		if(StringUtils.isBlank(seller.getName())) {
			return result = ResultDTO.newFail("请填写名称");
		}
		if(StringUtils.isBlank(seller.getCompany())) {
			return result = ResultDTO.newFail("请填写公司名称");
		}
		if(StringUtils.isBlank(seller.getPassword())) {
			return result = ResultDTO.newFail("密码不能为空");
		}
		return result;
	}
	
	public User loginValidate(String phone,String pwd){
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone).andPasswordEqualTo(pwd);
		List<User> users = userMapper.selectByExample(userExample);
		if(users.size()==1){
			return users.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public ResultDTO changeUserPwd(ChangePwdDTO pwdDTO){
		ResultDTO result = ResultDTO.newSuccess();
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(pwdDTO.getPhone());
		criteria.andNumberIdEqualTo(pwdDTO.getNumberId());
		List<User> users = userMapper.selectByExample(userExample);
		if(users.size()==0){
			return result=ResultDTO.newFail("用户不存在！");
		}
		if(!pwdDTO.getOldPwd().equals(users.get(0).getPassword())){
			return result=ResultDTO.newFail("用户密码错误！");
		}
		User user = new User();
		user.setId(users.get(0).getId());
		user.setPassword(pwdDTO.getPassword());
		userMapper.updateByPrimaryKeySelective(user);
		return result;
	}
	
	//我的钱包
	@SuppressWarnings("unchecked")
	public ResultDTO<Pay> selectWallet(String holderPhone){
		ResultDTO<Pay> result = ResultDTO.newSuccess();
	    PayExample example = new PayExample();
	    PayExample.Criteria criteria = example.createCriteria();
	    criteria.andUserPhoneEqualTo(holderPhone);
	    List<Pay> list = payMapper.selectByExample(example);
	    if(list.size()==0){
	    	UserExample userExample = new UserExample();
	    	UserExample.Criteria criteria1 = userExample.createCriteria();
	    	criteria1.andPhoneEqualTo(holderPhone);
	    	List<User> users = userMapper.selectByExample(userExample);
	    	User user = users.get(0);
	    	Pay pay = new Pay();
	    	pay.setUserName(user.getName());
	    	pay.setUserPhone(user.getPhone());
	    	pay.setUserPassword(user.getPassword());
	    	pay.setAccount(0);
	    	payMapper.insert(pay);
	    	result.setData(pay);
	    	return result;
	    } else {
	    	Pay pay = list.get(0);
	    	result.setData(pay);
	    	return result;
	    }
	}
	
	//充值
	@SuppressWarnings("unchecked")
	public ResultDTO<String> updateAccount(String money,Object obj){
		ResultDTO<String> result = ResultDTO.newSuccess();
		Pay pay = (Pay) obj;
		Integer totalAccount;
		Integer account = pay.getAccount();
		totalAccount = account + Integer.parseInt(money);
		pay.setAccount(totalAccount);
		payMapper.updateByPrimaryKeySelective(pay);
		return result;
	}
}
