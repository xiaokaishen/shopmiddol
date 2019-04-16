package com.test.dao;

import com.test.pojo.ShopUser;
import com.test.pojo.ShopUserAuths;
import com.test.pojo.ShopUserAuthsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopUserAuthsMapper {
    int countByExample(ShopUserAuthsExample example);

    int deleteByExample(ShopUserAuthsExample example);

    int deleteByPrimaryKey(Integer userAuthsId);

    int insert(ShopUserAuths record);

    int insertSelective(ShopUserAuths record);

    List<ShopUserAuths> selectByExample(ShopUserAuthsExample example);

    ShopUserAuths selectByPrimaryKey(Integer userAuthsId);

    int updateByExampleSelective(@Param("record") ShopUserAuths record, @Param("example") ShopUserAuthsExample example);

    int updateByExample(@Param("record") ShopUserAuths record, @Param("example") ShopUserAuthsExample example);

    int updateByPrimaryKeySelective(ShopUserAuths record);

    int updateByPrimaryKey(ShopUserAuths record);

    List<ShopUserAuths> selectByShopUserAuthsList(@Param("identityType") String identityType,
                                                @Param("identifier") String id);

}