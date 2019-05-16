package com.test.cms.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.test.cms.service.StoreService;
import com.test.dao.ShopStoreMapper;
import com.test.pojo.ShopReport;
import com.test.pojo.ShopStore;
import com.test.pojo.Vo;
import com.test.tools.util.IdolUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ShopStoreMapper shopStoreMapper;
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
            List<ShopStore> allStore = shopStoreMapper.findAllStore();
            storeService.updateStore(allStore);
        }catch (Exception e){
            e.printStackTrace();
            return new QingYinResult(500,"系统内部错误!!!",null);
        }
        return new QingYinResult(200,"导入成功",null);
    }
    /**
     * 二维码生成
     * @param vo
     * @return
     */
    @RequestMapping(value = "getE", method = RequestMethod.POST)
    public QingYinResult getE(@RequestBody Vo vo) {
        //通过id查询数据
        System.out.println("当前点击的id为:" + vo.getId());
      ShopStore shopStore=   storeService.findById(vo.getId());
        //id保存
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象
        session.setAttribute("id",vo.getId());
        //返回对象
        return new QingYinResult(200, "成功", shopStore);


    }


    /**
     * 获取门店联动数据
     * @return
     */
    /*@RequestMapping(value = "getStoreLinkage",method = RequestMethod.GET)
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
    }*/

    /**
     * 获取门店联动数据
     * @return
     */
    @RequestMapping(value = "getStoreLinkage",method = RequestMethod.GET)
    public QingYinResult getStoreLinkage(){
        //省份
        List<ShopStore> provinces = storeService.getProvince();
        provinces.forEach(province->{
            List<ShopStore> citys = storeService.getStoreCity(province.getStoreProvince());
            province.setChildList(citys);
            citys.forEach(city->{
                List<ShopStore> regions = storeService.getStoreRegion(city.getStoreCity());
                city.setChildList(regions);
                regions.forEach(region->{
                    List<ShopStore> stores = storeService.getStoreByRegion(region.getStoreRegion());
                    region.setChildList(stores);
                });
            });
        });
        return QingYinResult.ok(provinces);
    }
    /**
     * 初始化加载所有所有门店
     * @return
     */
    @RequestMapping(value = "selectAllStore",method = RequestMethod.GET)
    public QingYinResult selectAllStore(){
        QingYinResult result = storeService.selectAllStore();
        return result;
    }

    /**
     * 扫描二维码之后根据门店id获取门店名称
     */
    @RequestMapping(value = "findStoreNameById",method = RequestMethod.POST)
    public QingYinResult findStoreNameById(@RequestBody Map<?,?> map){

        String storeId = IdolUtils.toString(map.get("storeId"));
        ShopStore store = storeService.findById(storeId);

        return QingYinResult.ok(store);
    }

}
