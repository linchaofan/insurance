package org.lcf.ins.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpSession;
import org.lcf.ins.dto.InsureOrderDTO;
import org.lcf.ins.dto.ProductDetailDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.Pay;
import org.lcf.ins.enums.ErrorEnum;
import org.lcf.ins.service.InsService;
import org.lcf.ins.service.InsuredService;
import org.lcf.ins.service.OrderService;
import org.lcf.ins.service.ProductService;
import org.lcf.ins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import net.sf.json.JSONObject;

@Controller
public class InsController {

	@Autowired
	ProductService productService;
	@Autowired
	InsService insService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	@Autowired
	InsuredService insuredService;
	
	@RequestMapping(value = "/getPrice")
	@ResponseBody
	public ResultDTO<String> getPrice(String code,String age,String hasSocial,String coverage,String deadLine,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		ResultDTO<String> result = insService.getSchemePrice(code, age, hasSocial, coverage, deadLine);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			return result;
		}
		String schemePrice = result.getData();
		session.setAttribute("schemePrice", schemePrice);
		return result;
	}
	
	@RequestMapping(value = "/checkOrder")
	@ResponseBody
	public String checkOrder(Model model,@RequestBody String data,HttpSession session) throws Exception{
		ResultDTO<InsureOrderDTO> result = insService.checkOrder(data, session);
		InsureOrderDTO insOrder = result.getData();
		session.setAttribute("checkStatus", result.getData());
		session.setAttribute("insOrder", insOrder);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			session.setAttribute("errorMsg", result.getMessage());
			return "checkOrderResult";
		}
		session.setAttribute("errorMsg", null);
		return "checkOrderResult";
	}
	
	@RequestMapping(value = "/checkOrderResult")
	public String checkOrderResult(Model model,HttpSession session){
		String msg = (String) session.getAttribute("errorMsg");
		session.removeAttribute("errorMsg");
		if(msg!=null){
			model.addAttribute("errorMsg", msg);
			return "checkOrderResult";
		}
		return "checkOrderResult";
	}
	
	//从订单页
	@RequestMapping(value="/goPay")
	public String goPay(Model model,Integer orderId,HttpSession session){
		ResultDTO<InsureOrderDTO> result = insService.getInsOrderByOrderId(orderId);
		ResultDTO<OrderInfo> result1 = orderService.selectOrderInfoById(orderId);
		OrderInfo order = result1.getData();
		ResultDTO<ProductDetailDTO> result2 = productService.selectProductDetailByCode(order.getProductCode(),session);
		ProductDetailDTO productDetail = result2.getData();
		Long schemePrice = order.getTotalPrice();
		String proposalNo = order.getProposalNo();
		InsureOrderDTO insOrder = result.getData();
        session.setAttribute("insOrder", insOrder);
        session.setAttribute("schemePrice", schemePrice);
        session.setAttribute("productDetail", productDetail);
        session.setAttribute("proposalNo", proposalNo);
		return "payOrder";
	}
	
	@RequestMapping(value = "/payOrder")
	public String payOrder(String proposalNo,Integer checkStatus){
		ResultDTO<String> result = orderService.updateCheckStatus(proposalNo, checkStatus);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			return null;
		}
		return "payOrder";
	}
	
	@RequestMapping(value = "/readyPay")
	public String readyPay(String holderPhone,HttpSession session){
		ResultDTO<Pay> result = userService.selectWallet(holderPhone);
		session.setAttribute("account", result.getData().getAccount());
		return "readyPay";
	}
	
	@RequestMapping(value = "/pay")
	public String pay(String holderPhone,String price,String proposalNo,Model model) throws ParseException{
		ResultDTO<String> result = insService.pay(holderPhone, price,proposalNo);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "errorPay";
		}
		return "successPay";
	}
}
