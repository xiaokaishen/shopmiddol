package com.test.dao;

import com.test.pojo.ShopExamine;
import com.test.pojo.ShopExamineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopExamineMapper {
    int countByExample(ShopExamineExample example);

    int deleteByExample(ShopExamineExample example);

    int deleteByPrimaryKey(Integer examineId);

    int insert(ShopExamine record);

    int insertSelective(ShopExamine record);

    List<ShopExamine> selectByExample(ShopExamineExample example);

    ShopExamine selectByPrimaryKey(Integer examineId);

    int updateByExampleSelective(@Param("record") ShopExamine record, @Param("example") ShopExamineExample example);

    int updateByExample(@Param("record") ShopExamine record, @Param("example") ShopExamineExample example);

    int updateByPrimaryKeySelective(ShopExamine record);

    int updateByPrimaryKey(ShopExamine record);

    List<ShopExamine> findAllExamine();
}