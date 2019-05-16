package com.test.dao;

import com.test.pojo.ShopStore;
import com.test.pojo.ShopStoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopStoreMapper {
    int countByExample(ShopStoreExample example);

    int deleteByExample(ShopStoreExample example);

    int deleteByPrimaryKey(Integer storeId);

    int insert(ShopStore record);

    int insertSelective(ShopStore record);

    List<ShopStore> selectByExample(ShopStoreExample example);

    ShopStore selectByPrimaryKey(Integer storeId);

    int updateByExampleSelective(@Param("record") ShopStore record, @Param("example") ShopStoreExample example);

    int updateByExample(@Param("record") ShopStore record, @Param("example") ShopStoreExample example);

    int updateByPrimaryKeySelective(ShopStore record);

    int updateByPrimaryKey(ShopStore record);

    List<ShopStore> findAllStore();

    List<ShopStore> getProvince();


    List<ShopStore> getStoreCity(@Param("storeProvince") String province);

    List<ShopStore> getStoreRegion(@Param("storeCity") String city);


    List<String> getCity();

    List<String> getRegion();

    List<ShopStore> getStoreByRegion(@Param("storeRegion") String region);
}