package org.lcf.ins.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lcf.ins.entity.Product;
import org.lcf.ins.entity.ProductExample;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);
    
    List<Product> selectByNameAndType(@Param("name") String name,@Param("typeCode") String typeCode);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}