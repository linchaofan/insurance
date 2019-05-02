package org.lcf.ins.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lcf.ins.entity.Pay;
import org.lcf.ins.entity.PayExample;

public interface PayMapper {
    long countByExample(PayExample example);

    int deleteByExample(PayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pay record);

    int insertSelective(Pay record);

    List<Pay> selectByExample(PayExample example);

    Pay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pay record, @Param("example") PayExample example);

    int updateByExample(@Param("record") Pay record, @Param("example") PayExample example);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}