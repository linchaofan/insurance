package org.lcf.ins.controller;

import javax.servlet.http.HttpSession;

import org.lcf.ins.dto.ChangePwdDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.dto.UserInfoDTO;
import org.lcf.ins.entity.Pay;
import org.lcf.ins.entity.Seller;
import org.lcf.ins.entity.User;
import org.lcf.ins.enums.ErrorEnum;
import org.lcf.ins.service.SellerService;
import org.lcf.ins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SellerService sellerService;
	
<<<<<<< HEAD
	//游客登录
	@RequestMapping(value="/visitorLogin")
	public String visitorLogin(Model model,HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("seller");
		return "index";
	}
	
=======
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
	@RequestMapping(value="/userLogin")
	public String login(Model model,String phone,String pwd,HttpSession httpSession){
		User user = userService.loginValidate(phone, pwd);
		if(user!=null){
			httpSession.setAttribute("user", user);
			httpSession.removeAttribute("seller");
			return "/index";
		}
		model.addAttribute("errorMsg","登录失败，账号或者密码错误！");
		return "/login";
	}
	
	@RequestMapping(value="/sellerLogin")
	public String sLogin(Model model,String sname,String spwd,HttpSession session){
		Seller seller = sellerService.loginValidate(sname, spwd);
		if(seller!=null){
			session.setAttribute("seller", seller);
			session.removeAttribute("user");
			return "/index";
		}
		model.addAttribute("errorMsg","登录失败，账号或者密码错误！");
		return "/login";
	}
	
	@RequestMapping(value="/reLogin")
	public String reLogin(Model model,String phone,String pwd,HttpSession httpSession){
		User user = userService.loginValidate(phone, pwd);
		if(user!=null){
			httpSession.setAttribute("user", user);
<<<<<<< HEAD
			return "/index";
=======
			return "/right";
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
		}
		model.addAttribute("errorMsg","登录失败，账号或者密码错误！");
		return "/relogin";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/register")
	public String register(Model model,UserInfoDTO userInfo){
		ResultDTO result = userService.insertUser(userInfo);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg",result.getMessage());
<<<<<<< HEAD
			return "/right";
=======
			return "/register";
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
		}
		return "/successRe";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/sellerRegister")
	public String sellerRegister(Model model,Seller seller){
		ResultDTO result = userService.insertSeller(seller);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg",result.getMessage());
			return "/register";
		}
		return "/successRe";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/changePwd")
	public String changePwd(Model model,ChangePwdDTO pwdDTO){
		ResultDTO result = userService.changeUserPwd(pwdDTO);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg",result.getMessage());
			return "/changePwd";
		}
		return "/successChangePwd";
	}
	
	@RequestMapping(value="/myWallet")
	public String myWallet(String holderPhone,HttpSession session){
		ResultDTO<Pay> result = userService.selectWallet(holderPhone);
		Pay pay = result.getData();
		session.setAttribute("pay", pay);
		return "/myAccount"; 
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/recharge")
	public String recharge(String money,HttpSession session){
		Object obj = session.getAttribute("pay");
		ResultDTO<String> result = userService.updateAccount(money, obj);
		return "successRecharge";
	}
	
}
