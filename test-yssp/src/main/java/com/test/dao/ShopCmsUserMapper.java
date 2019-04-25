package com.test.dao;

import com.test.pojo.ShopCmsUser;
import com.test.pojo.ShopCmsUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCmsUserMapper {
    int countByExample(ShopCmsUserExample example);

    int deleteByExample(ShopCmsUserExample example);

    int deleteByPrimaryKey(Long cmsUserId);

    int insert(ShopCmsUser record);

    int insertSelective(ShopCmsUser record);

    List<ShopCmsUser> selectByExample(ShopCmsUserExample example);

    ShopCmsUser selectByPrimaryKey(Long cmsUserId);

    int updateByExampleSelective(@Param("record") ShopCmsUser record, @Param("example") ShopCmsUserExample example);

    int updateByExample(@Param("record") ShopCmsUser record, @Param("example") ShopCmsUserExample example);

    int updateByPrimaryKeySelective(ShopCmsUser record);

    int updateByPrimaryKey(ShopCmsUser record);

    List<ShopCmsUser> selectByCmsUserName(String cmsUserName);
}