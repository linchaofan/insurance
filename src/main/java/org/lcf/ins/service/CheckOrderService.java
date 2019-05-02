package org.lcf.ins.service;

import java.util.ArrayList;
import java.util.List;

import org.lcf.ins.dao.InsuredMapper;
import org.lcf.ins.dao.UserMapper;
import org.lcf.ins.dto.CheckOrderDTO;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.Insured;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.User;
import org.lcf.ins.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOrderService {
	
	@Autowired
	OrderService orderService;
	@Autowired
	UserMapper userMapper;
	@Autowired
	InsuredMapper insuredMapper;
	@Autowired
	InsuredService insuredService;
	@Autowired
	ProductService productService;
	
	@SuppressWarnings("unchecked")
	public ResultDTO<List<CheckOrderDTO>> myCheckOrder(Integer holderId){
		ResultDTO<List<CheckOrderDTO>> result = ResultDTO.newSuccess();
		List<CheckOrderDTO> list = new ArrayList<>();
		ResultDTO<List<OrderInfo>> result1 = orderService.selectOrderByHolderId(holderId);
		if(result1.getStatus()!=ErrorEnum.success.getErrorCode()){
			return result = ResultDTO.newFail("您目前还没有任何核保记录哦~");
		}
		List<OrderInfo> orders = result1.getData();
		for(OrderInfo order : orders){
			CheckOrderDTO checkOrder = new CheckOrderDTO();
			int status = order.getCheckStatus();
			User holder = userMapper.selectByPrimaryKey(order.getHolderId());
			ResultDTO<Insured> result2 = insuredService.selectInsuredByOrderId(order.getId());
			Insured insured = result2.getData();
			if(status==1||status==2||status==3){
				checkOrder.setOrderId(order.getId());
				checkOrder.setProductName(order.getProductName());
				checkOrder.setProposalNo(order.getProposalNo());
				checkOrder.setCheckStatus(order.getCheckStatus());			
				checkOrder.setHolderName(holder.getName());
				checkOrder.setHolderPhone(holder.getPhone());
				checkOrder.setInsuredName(insured.getName());
				checkOrder.setInsuredSex(insured.getGender());
				checkOrder.setInsuredNumberId(insured.getNumberId());
				checkOrder.setInsuredPhone(insured.getPhone());
				checkOrder.setInsuredBirth(insured.getBirthday());
				checkOrder.setInsuredEmail(insured.getEmail());
				checkOrder.setInsuredAddress(insured.getAddress());
				list.add(checkOrder);
			}			
		}
		result.setData(list);
		return result;
	}
	
	//根据sellerId获取核保记录
	@SuppressWarnings("unchecked")
	public ResultDTO<List<CheckOrderDTO>> getCheckOrderBySellerID(Integer sellerId){
		ResultDTO<List<CheckOrderDTO>> result = ResultDTO.newSuccess();
		List<CheckOrderDTO> list = new ArrayList<>();
		ResultDTO<List<Product>> result1 = productService.selectProductBySellerId(sellerId);
		List<Product> products = result1.getData();
		for(Product product : products){
			ResultDTO<List<OrderInfo>> result2 = orderService.selectByProductCode(product.getCode());
			if(result2.getStatus()!=ErrorEnum.success.getErrorCode()){
				continue;
			}
			List<OrderInfo> orders = result2.getData();
			for(OrderInfo order : orders){
				CheckOrderDTO checkOrder = new CheckOrderDTO();
				int status = order.getCheckStatus();
				User holder = userMapper.selectByPrimaryKey(order.getHolderId());
				ResultDTO<Insured> result3 = insuredService.selectInsuredByOrderId(order.getId());
				Insured insured = result3.getData();
				if(status==1||status==2||status==3){
					checkOrder.setOrderId(order.getId());
					checkOrder.setProductName(order.getProductName());
					checkOrder.setProposalNo(order.getProposalNo());
					checkOrder.setCheckStatus(order.getCheckStatus());			
					checkOrder.setHolderName(holder.getName());
					checkOrder.setHolderPhone(holder.getPhone());
					checkOrder.setInsuredName(insured.getName());
					checkOrder.setInsuredSex(insured.getGender());
					checkOrder.setInsuredNumberId(insured.getNumberId());
					checkOrder.setInsuredPhone(insured.getPhone());
					checkOrder.setInsuredBirth(insured.getBirthday());
					checkOrder.setInsuredEmail(insured.getEmail());
					checkOrder.setInsuredAddress(insured.getAddress());
					list.add(checkOrder);
				}			
			}
		}
		if(list.size()==0){
			return result = ResultDTO.newFail("暂无任何核保记录");
		}
		result.setData(list);
		return result;
	}

}
