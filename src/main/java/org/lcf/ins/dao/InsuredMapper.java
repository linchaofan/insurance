package org.lcf.ins.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lcf.ins.entity.Insured;
import org.lcf.ins.entity.InsuredExample;

public interface InsuredMapper {
    long countByExample(InsuredExample example);

    int deleteByExample(InsuredExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Insured record);

    int insertSelective(Insured record);

    List<Insured> selectByExample(InsuredExample example);

    Insured selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Insured record, @Param("example") InsuredExample example);

    int updateByExample(@Param("record") Insured record, @Param("example") InsuredExample example);

    int updateByPrimaryKeySelective(Insured record);

    int updateByPrimaryKey(Insured record);
}