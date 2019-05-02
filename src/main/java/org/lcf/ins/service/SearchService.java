package org.lcf.ins.service;

import java.util.ArrayList;
import java.util.List;

import org.lcf.ins.dao.ProductMapper;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	
	@Autowired
	ProductMapper productMapper;
	
	@SuppressWarnings("unchecked")
	public ResultDTO<List<Product>> searchProduct(String productName,String productType){
		ResultDTO<List<Product>> result = ResultDTO.newSuccess();
		List<Product> list = new ArrayList<>();
		String typeCode = null;
		if(productType.equals("医疗")){
			typeCode = "yiliao";
		}
		if(productType.equals("人寿")){
			typeCode = "renshou";
		}
		if(productType.equals("意外")){
			typeCode = "yiwai";
		}
		if(productType.equals("旅游")){
			typeCode = "lvyou";
		}
		List<Product> products = productMapper.selectByNameAndType(productName, typeCode);
		if(products.size()==0){
			result = ResultDTO.newFail("暂无相匹配的搜索结果");
		}
		for(Product product : products){
			list.add(product);
		}
		result.setData(list);
		return result;
	}

}
