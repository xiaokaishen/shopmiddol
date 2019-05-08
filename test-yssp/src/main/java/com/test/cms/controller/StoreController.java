package com.test.cms.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.test.cms.service.StoreService;
import com.test.pojo.ShopStore;
import com.test.tools.util.IdolUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;


    /**
     * 查询所有门店
     * @param map
     * @return
     */
    @RequestMapping(value = "findAllStore",method = RequestMethod.POST)
    public QingYinResult findAllStore(@RequestBody Map<?,?> map){
        Integer page = IdolUtils.toInt(map.get("page"));
        Integer rows = IdolUtils.toInt(map.get("rows"));
        QingYinResult result = storeService.findAllStore(page,rows);
        return result;
    }

    /**
     * 根据门店Id删除门店 软删除
     * @param map
     * @return
     */
    @RequestMapping(value = "delStoreById",method = RequestMethod.POST)
    public QingYinResult delStoreById(@RequestBody Map<?,?> map){
        Integer storeId = IdolUtils.toInt(map.get("storeId"));
        QingYinResult result = storeService.delStoreById(storeId);
        return result;
    }

    /**
     * 导入excel
     * @param
     * @return
     */
    @RequestMapping(value = "loadExcel",method=RequestMethod.POST)
    public  QingYinResult loadExcel(@RequestBody Map<String,String> map){
        //获得json字符串
        String para = map.get("para");
        //解析为list对象集合
        List<ShopStore> list = JSON.parseArray(para, ShopStore.class);
        //保存到数据库中
        try{
            storeService.addUser(list);
        }catch (Exception e){
            e.printStackTrace();
            return new QingYinResult(500,"系统内部错误!!!",null);
        }
        return new QingYinResult(200,"导入成功",null);
    }

    /**
     * 获取门店省份数据
     */
    @RequestMapping(value = "getStoreProvince",method = RequestMethod.GET)
    public QingYinResult getStoreProvince(){
        //省份
        List<String> provinces = storeService.getProvince();
        provinces.forEach(str->{
            System.out.println(str);
        });
        return QingYinResult.ok(provinces);
    }

    /**
     * 根据省份获取城市
     * @param map
     * @return
     */
    @RequestMapping(value = "getStoreCity",method = RequestMethod.POST)
    public QingYinResult getStoreCity(@RequestBody Map<?,?> map){
        String province = IdolUtils.toString(map.get("province"));
        //城市
        List<String> citys = storeService.getStoreCity(province);

        return QingYinResult.ok(citys);
    }

    /**
     * 根据城市获取区域
     * @param map
     * @return
     */
    @RequestMapping(value = "getStoreRegion",method = RequestMethod.POST)
    public QingYinResult getStoreRegion(@RequestBody Map<?,?> map){
        String city = IdolUtils.toString(map.get("city"));
        //城市
        List<String> regions = storeService.getStoreRegion(city);

        return QingYinResult.ok(regions);
    }

    /**
     * 获取门店联动数据
     * @return
     */
    @RequestMapping(value = "getStoreLinkage",method = RequestMethod.GET)
    public QingYinResult getStoreLinkage(){
        Map map = new HashMap<>();
        //省份
        List<String> provinces = storeService.getProvince();

        provinces.forEach(province->{
            Map res = new HashMap<>();
            List<String> citys = storeService.getStoreCity(province);
            citys.forEach(city->{
                List<String> regions = storeService.getStoreRegion(city);
                Map regionMap = new HashMap<>();
                regions.forEach(region->{
                   List<ShopStore> stores = storeService.getStoreByRegion(region);
                    regionMap.put(region,stores);
                });
                res.put(city,regionMap);
            });
            map.put(province,res);
        });

        return QingYinResult.ok(map);
    }


}
