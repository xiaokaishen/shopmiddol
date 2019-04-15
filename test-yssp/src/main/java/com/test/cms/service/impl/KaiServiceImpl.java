package com.test.cms.service.impl;


import com.test.cms.service.KaiService;
import com.test.dao.IJedisClient;
import com.test.pojo.QyUserAuths;
import com.test.pojo.UserResult;
import com.test.tools.util.IDUtil;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KaiServiceImpl implements KaiService {
    @Autowired
    private IJedisClient jedisClient;


    @Override
    public QingYinResult WXLoginRegist(Map<String, String> userMap) {
        UserResult userResult = new UserResult();
        String openId = userMap.get("openid");
        // 如果openId和unionId查询都存在数据，则以unionId为准
        if (!"".equals(openId)) {// 如果微信openId不为空
            List<QyUserAuths> unionAuthsList = new ArrayList<>();
            if (unionAuthsList.size() == 0 || unionAuthsList == null) {// 未查到授权信息
                String temporaryBill = IDUtil.generateShortUuid();
                userResult.setTemporaryBill(temporaryBill);
                userResult.setSessionKey(userMap.get("session_key"));
//                jedisClient.set("TemporaryBill:" + temporaryBill, JsonUtils.objectToJson(userMap));// 将用户临时数据缓存到redis中
                return QingYinResult.build(401, "用户未授权", userResult);
            }  else {
                return QingYinResult.build(500, "授权出错了，请联系管理员");
            }

        } else {// 如果微信unionId为空，则以openId为准
            return QingYinResult.build(500, "系统出错了，请联系网站管理员");
        }
    }
}
