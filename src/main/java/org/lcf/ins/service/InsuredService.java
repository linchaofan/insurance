package org.lcf.ins.service;

import java.util.List;

import org.lcf.ins.dao.InsuredMapper;
import org.lcf.ins.dto.ResultDTO;
import org.lcf.ins.entity.Insured;
import org.lcf.ins.entity.InsuredExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuredService {
	
	@Autowired
	InsuredMapper insuredMapper;
	
	@SuppressWarnings("unchecked")
	public ResultDTO<Insured> selectInsuredByOrderId(Integer orderId){
		ResultDTO<Insured> result = ResultDTO.newSuccess();
		InsuredExample insuredExample = new InsuredExample();
		InsuredExample.Criteria criteria = insuredExample.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<Insured> insureds = insuredMapper.selectByExample(insuredExample);
		if(insureds.size()==0){
			return result=ResultDTO.newFail("没找到对应的被保人数据");
		}
		result.setData(insureds.get(0));
		return result;
	}

}
