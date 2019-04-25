package com.test.dao;

import com.test.pojo.ShopUser;
import com.test.pojo.ShopUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopUserMapper {
    int countByExample(ShopUserExample example);

    int deleteByExample(ShopUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    List<ShopUser> selectByExample(ShopUserExample example);

    ShopUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByExample(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);

    ShopUser selectShopUserIntegralVieByid(long userid);

    List<ShopUser> selectAll();
}