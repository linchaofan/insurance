package org.lcf.ins.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lcf.ins.entity.ProductScheme;
import org.lcf.ins.entity.ProductSchemeExample;

public interface ProductSchemeMapper {
    long countByExample(ProductSchemeExample example);

    int deleteByExample(ProductSchemeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductScheme record);

    int insertSelective(ProductScheme record);

    List<ProductScheme> selectByExample(ProductSchemeExample example);

    ProductScheme selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductScheme record, @Param("example") ProductSchemeExample example);

    int updateByExample(@Param("record") ProductScheme record, @Param("example") ProductSchemeExample example);

    int updateByPrimaryKeySelective(ProductScheme record);

    int updateByPrimaryKey(ProductScheme record);
}