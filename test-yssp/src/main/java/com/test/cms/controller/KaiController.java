package com.test.cms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.cms.service.KaiService;
import com.test.pojo.QyUserAuths;
import com.test.smallApp.utils.SmallAppAdvice;
import com.test.smallApp.utils.SmallAppUtils;
import com.test.tools.util.*;
import com.vdurmont.emoji.EmojiParser;
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





}
