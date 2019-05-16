package com.test.cms.service.impl;

import com.currency.config.CurrencyConfig;
import com.github.pagehelper.PageHelper;
import com.test.cms.service.StoreService;
import com.test.dao.ShopStoreMapper;
import com.test.pojo.ShopStore;
import com.test.tools.util.IDUtil;
import com.test.tools.util.IdolUtils;
import com.test.tools.util.QingYinResult;
import com.test.utils.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private ShopStoreMapper shopStoreMapper;

    private String url;

    @Override
    public QingYinResult findAllStore(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<ShopStore> list = shopStoreMapper.findAllStore();

        return QingYinResult.ok(list);
    }

    @Override
    public ShopStore findById(String id) {
        int i = Integer.parseInt(id);
        ShopStore shopStore = shopStoreMapper.selectByPrimaryKey(i);
        return shopStore;
    }

    @Override
    public void addUser(List<ShopStore> list) {
        for (ShopStore shopStore : list) {
            //10.将数据存储到数据库
            shopStore.setStoreState((byte) 1);
            shopStoreMapper.insert(shopStore);
            System.out.println("----------------------------"+shopStore.getStoreId());
        }

    }

    @Override
    public void updateStore(List<ShopStore> list){
        //            long userId = IDUtil.getUserId();
        //二维码生成
        //1.对象id
//            Integer storeId = shopStore.getStoreId();
//            String id = storeId + "";
        //3.图片路径
//        //3.1展示路径
//        String url1 = "http://sc.middol.com/images";
//        //3.2下载路径
//        String url2 = "http://sc.middol.com/download";
        //本地使用的路径

//            String realPath = "/home/images";
        String realPath = "E:/home/images";
        list.forEach(store->{
            try {
                String id = store.getStoreId()+"";

                File file = new File(realPath);
                if (!file.exists()) {
                    file.mkdir();
                }
                //4.二维码中的内容
//                String text = CurrencyConfig.Front_Mobile_Url + "/h5/#/pages/user/user?id="+id;
                //                String text ="https://www.baidu.com";
                String text = "http://sc.middol.com/h5/#/pages/user/user?id="+id;
                //5.加入标识--为了更好识别图片的名称(目前将id作为唯一标识)
                text = text + "@" + id;
                //6.生成二维码

                QRCodeUtil.encode(text, "", realPath, true);

                //7.图片所在位置
                url = realPath + "/" + id + ".jpg";
                System.out.println("图片所在位置:" + url);
                //8.路径处理
                String viewUrl = "http://sc.middol.com/images" + "/" + id + ".jpg";
                String downloadUrl = "http://sc.middol.com/download" + "/" + id + ".jpg";
                //9.存储
                store.setStoreViewUrl(viewUrl);
                store.setStoreDownloadUrl(downloadUrl);
                shopStoreMapper.updateByPrimaryKey(store);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
    public List<ShopStore> getProvince() {
        List<ShopStore> list = shopStoreMapper.getProvince();
        return list;
    }

    @Override
    public List<ShopStore> getStoreCity(String province) {
        return shopStoreMapper.getStoreCity(province);
    }

    @Override
    public List<ShopStore> getStoreRegion(String city) {
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

    @Override
    public QingYinResult selectAllStore() {
        List<ShopStore> allStore = shopStoreMapper.findAllStore();
        return QingYinResult.ok(allStore);
    }
}
