package com.test.cms.controller;

import com.test.cms.service.KaiService;
import com.test.smallApp.utils.SmallAppAdvice;
import com.test.tools.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("kai")
public class KaiController {

    @Autowired
    private KaiService kaiService;

    /**
     * 登录登录
     * @param map
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public QingYinResult login(@RequestBody Map<String,Object> map){
        System.out.println(map);

        String code = IdolUtils.toString(map.get("code"));
        Map<String, String> userMap = SmallAppAdvice.getUserMap(code);
        // 临时票据获取失败
        if(userMap == null){
            return QingYinResult.build(401,"调用失败");
        }

        QingYinResult result = kaiService.WXLoginRegist(userMap);

        return result;
    }

    /**
     * 用户注册
     * @param map
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public QingYinResult userAdd(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        String temporaryBill = IdolUtils.toString(map.get("TemporaryBill"));
        String encryptedData = IdolUtils.toString(map.get("EncryptedData"));
        String iv = IdolUtils.toString(map.get("IV"));
        String sessionKey = IdolUtils.toString(map.get("session_key"));
        // 对用户进行判断
        QingYinResult result = kaiService.userAdd(temporaryBill, encryptedData, iv,sessionKey);

        return result;
    }

    @RequestMapping(value = "paySuccess",method = RequestMethod.POST)
    public QingYinResult paySuccess(@RequestBody Map<?,?> map){
        //单号
        String oddNumber = new Random().nextInt(10000)+"";
        //openid
//        String openid = IdolUtils.toString(map.get("openid"));
        String openid = "oHjjI5Ypf5ltbFB-PLCXXh3EqUEI";
        //用户formid
        String formid = IdolUtils.toString(map.get("formid"));
        //金额
        String money = IdolUtils.toString(map.get("money"));
        //商品名称
        String name = IdolUtils.toString(map.get("name"));

        System.out.println("formId:"+formid+"    money:"+money+"    name:"+name);

        String paymsg = kaiService.paySuccess(oddNumber,openid,formid,money,name);
        return QingYinResult.ok(paymsg);
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "findAllUser",method = RequestMethod.POST)
    public QingYinResult findAllUser(@RequestBody Map<?,?> map){
        Integer page = (Integer) map.get("page");
        Integer rows = (Integer) map.get("rows");
        System.out.println(page+"==="+rows);
        QingYinResult result = kaiService.findAllUser(page,rows);
        return result;
    }

}
