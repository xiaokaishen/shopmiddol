package com.test.cms.service;

import com.test.pojo.ShopStore;
import com.test.tools.util.QingYinResult;

import java.util.List;

public interface StoreService {
    QingYinResult findAllStore(Integer page, Integer rows);

    void addUser(List<ShopStore> list);

    QingYinResult delStoreById(Integer storeId);


    List<String> getProvince();

    List<String> getStoreCity(String province);

    List<String> getStoreRegion(String city);

    
    
    List<String> getCity();

    List<String> getRegion();

    List<ShopStore> getStoreByRegion(String region);
}
