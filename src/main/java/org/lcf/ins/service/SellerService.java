package org.lcf.ins.service;

import java.util.ArrayList;
import java.util.List;

import org.lcf.ins.dao.SellerMapper;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.OrderInfo;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.Seller;
import org.lcf.ins.entity.SellerExample;
import org.lcf.ins.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

	@Autowired
	SellerMapper sellerMapper;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	
	public Seller loginValidate(String sname,String pwd){
		SellerExample example = new SellerExample();
		SellerExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(sname);
		criteria.andPasswordEqualTo(pwd);
		List<Seller> sellers = sellerMapper.selectByExample(example);
		if(sellers.size()!=0){
			return sellers.get(0);
		}
		return null;
	}
	
	//根据sellerId查询订单记录
	@SuppressWarnings("unchecked")
	public ResultDTO<List<OrderInfo>> selectOrderBySellerId(Integer sellerId){
		ResultDTO<List<OrderInfo>> result = ResultDTO.newSuccess();
		ResultDTO<List<Product>> result1 = productService.selectProductBySellerId(sellerId);
		List<Product> products = result1.getData();
		List<OrderInfo> list = new ArrayList<>();
		for(Product product : products){
			ResultDTO<List<OrderInfo>> result2 = orderService.selectByProductCode(product.getCode());
			if(result2.getStatus()!=ErrorEnum.success.getErrorCode()){
				continue;
			}
			List<OrderInfo> orders = result2.getData();
			if(orders.size()==0){
				continue;
			}
			for(OrderInfo order : orders){
				if(order.getCheckStatus()==4||order.getCheckStatus()==5||order.getCheckStatus()==6){
					list.add(order);
				}
			}
		}
		if(list.size()==0){
			return result = ResultDTO.newFail("暂无任何订单~");
		}
		result.setData(list);
		return result;
	}
}
