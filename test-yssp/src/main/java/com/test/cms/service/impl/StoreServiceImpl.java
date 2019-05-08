package com.test.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.cms.service.StoreService;
import com.test.dao.ShopStoreMapper;
import com.test.pojo.ShopStore;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private ShopStoreMapper shopStoreMapper;

    @Override
    public QingYinResult findAllStore(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<ShopStore> list = shopStoreMapper.findAllStore();

        return QingYinResult.ok(list);
    }

    @Override
    public void addUser(List<ShopStore> list) {
        for (ShopStore shopStore : list) {
            shopStoreMapper.insert(shopStore);
        }
    }

    @Override
    public QingYinResult delStoreById(Integer storeId) {
        ShopStore shopStore = shopStoreMapper.selectByPrimaryKey(storeId);
        shopStore.setStoreState((byte)0);
        int i = shopStoreMapper.updateByPrimaryKeySelective(shopStore);
        if(i==1){
            return QingYinResult.ok();
        }
        return QingYinResult.build(400,"删除未成功");
    }

    @Override
    public List<String> getProvince() {
        List<String> list = shopStoreMapper.getProvince();
        return list;
    }

    @Override
    public List<String> getStoreCity(String province) {
        return shopStoreMapper.getStoreCity(province);
    }

    @Override
    public List<String> getStoreRegion(String city) {
        return shopStoreMapper.getStoreRegion(city);
    }



    @Override
    public List<String> getCity() {
        return shopStoreMapper.getCity();
    }

    @Override
    public List<String> getRegion() {
        return shopStoreMapper.getRegion();
    }

    @Override
    public List<ShopStore> getStoreByRegion(String region) {
        return shopStoreMapper.getStoreByRegion(region);
    }
}
