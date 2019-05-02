package org.lcf.ins.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.lcf.ins.dto.CheckOrderDTO;
import org.lcf.ins.dto.OrderDetailDTO;
import org.lcf.ins.dto.PolicyDTO;
import org.lcf.ins.dto.PolicyDetailDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.enums.ErrorEnum;
import org.lcf.ins.service.CheckOrderService;
import org.lcf.ins.service.DeleteService;
import org.lcf.ins.service.OrderService;
import org.lcf.ins.service.SellerService;
import org.lcf.ins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CheckOrderService checkOrderService;
	
	@Autowired
	DeleteService deleteService;
	
	@Autowired
	SellerService sellerService;
	
	//订单列表
	@RequestMapping(value="/orderList")
	public String orderList(Model model,Integer holderId,HttpSession session){
		ResultDTO<List<OrderInfo>> result = orderService.selectOrderByHolderIdAndStatus(holderId);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorOrderList";
		}
		List<OrderInfo> orders = result.getData();
		session.setAttribute("orders", orders);
		return "/orderList";
	}
	
	//承保方订单列表
	@RequestMapping(value="/sellerOrderList")
	public String sellerOrderList(Model model,Integer sellerId,HttpSession session){
		ResultDTO<List<OrderInfo>> result = sellerService.selectOrderBySellerId(sellerId);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorOrderList";
		}
		List<OrderInfo> orders = result.getData();
		session.setAttribute("orders", orders);
		return "/orderList";
	}
	
	//订单明细
	@RequestMapping(value="/orderDetail")
	public String orderDetail(Integer orderId,HttpSession session){
		ResultDTO<OrderDetailDTO> result = orderService.selectOrderById(orderId);
		OrderDetailDTO order = result.getData();
		session.setAttribute("order", order);
		return "/orderDetail";
	} 
	
	//用户核保记录
	@RequestMapping(value="/myCheck")
	public String myCheck(Model model,Integer holderId,HttpSession session){
		ResultDTO<List<CheckOrderDTO>> result = checkOrderService.myCheckOrder(holderId);
		List<CheckOrderDTO> checkOrders = result.getData();
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorMyCheck";
		}
		session.setAttribute("checkOrders", checkOrders);
		return "/myCheck";
	}
	
	//承保方核保记录
	@RequestMapping(value="/sellerCheckList")
	public String sellerCheckList(Model model,Integer sellerId,HttpSession session){
		ResultDTO<List<CheckOrderDTO>> result = checkOrderService.getCheckOrderBySellerID(sellerId);
		List<CheckOrderDTO> checkOrders = result.getData();
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorMyCheck";
		}
		session.setAttribute("checkOrders", checkOrders);
		return "/myCheck";
	}
	
	//核保记录详情
	@RequestMapping(value="/myCheckDetail")
	public String myCheckDetail(Integer orderId,HttpSession session){
		ResultDTO<OrderInfo> result1 = orderService.selectOrderInfoById(orderId);
		OrderInfo order = result1.getData();
		ResultDTO<CheckOrderDTO> result = orderService.checkOrderDetail(order.getHolderId(), orderId, order);
		CheckOrderDTO checkOrder = result.getData();
		session.setAttribute("checkOrder", checkOrder);
		return "/myCheckDetail";
	}
	
	//删除核保记录
	@RequestMapping(value="/deleteCheckOrder")
	public String deleteCheckOrder(Model model,Integer orderId){
		ResultDTO<String> result = deleteService.deleteCheck(orderId);
	    model.addAttribute("msg", result.getData());
	    return "/successDel";
	}
	
	//删除订单记录
		@RequestMapping(value="/deleteOrder")
		public String deleteOrder(Model model,Integer orderId){
			ResultDTO<String> result = deleteService.deleteCheck(orderId);
		    model.addAttribute("msg", result.getData());
		    return "/successDelOrder";
		}
	
	//保单查询
	@RequestMapping(value="/myPolicy")
	public String myPolicy(Model model,Integer holderId,HttpSession session){
		ResultDTO<List<OrderInfo>> result = orderService.selectOrderByHolderId(holderId);
		if(result.getStatus()!=ErrorEnum.success.getErrorCode()){
			model.addAttribute("errorMsg", result.getMessage());
			return "/errorMyPolicy";
		}
		ResultDTO<List<PolicyDTO>> result1 = orderService.selectPolicy(result.getData());
		List<PolicyDTO> polices = result1.getData();
		session.setAttribute("polices", polices);
		return "myPolicy";
	}
	
	//保单明细
	@RequestMapping(value="/policyDetail")
	public String policyDetail(Model model,Integer orderId,HttpSession session){
		ResultDTO<PolicyDetailDTO> result = orderService.getPolicyDetail(orderId);
		PolicyDetailDTO policyDetail = result.getData();
		session.setAttribute("policyDetail", policyDetail);
		return "policyDetail";
	}
}
