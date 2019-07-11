package org.lcf.ins.service;

import org.lcf.ins.dao.InsuredMapper;
import org.lcf.ins.dao.OrderInfoMapper;
import org.lcf.ins.dao.ProductMapper;
import org.lcf.ins.dao.ProductSchemeMapper;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.InsuredExample;
import org.lcf.ins.entity.ProductExample;
import org.lcf.ins.entity.ProductSchemeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

	@Autowired
	OrderService orderService;
	@Autowired
	OrderInfoMapper orderInfoMapper;
	@Autowired
	InsuredMapper insuredMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	ProductSchemeMapper productSchemeMapper;
	
	//删除核保记录
	@SuppressWarnings("unchecked")
	public ResultDTO<String> deleteCheck(Integer orderId){
		ResultDTO<String> result = ResultDTO.newSuccess();
		orderInfoMapper.deleteByPrimaryKey(orderId);
		InsuredExample example = new InsuredExample();
		InsuredExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		insuredMapper.deleteByExample(example);
		result.setData("删除成功！");
		return result;
	}
	
	//删除商品
	@SuppressWarnings("unchecked")
	public ResultDTO<String> deleteProduct(String productCode){
		ResultDTO<String> result = ResultDTO.newSuccess();
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(productCode);
		productMapper.deleteByExample(example);
		ProductSchemeExample schemeExample = new ProductSchemeExample();
		ProductSchemeExample.Criteria criteria1 = schemeExample.createCriteria();
		criteria1.andProductCodeEqualTo(productCode);
		productSchemeMapper.deleteByExample(schemeExample);
		result.setData("删除成功");
		return result;
	}
}
