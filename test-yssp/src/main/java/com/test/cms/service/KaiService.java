package com.test.cms.service;

import com.test.tools.util.QingYinResult;

import java.util.Map;

public interface KaiService {
    /**
     * 用户登录判断
     *
     * @param userMap
     * @return
     */
    QingYinResult WXLoginRegist(Map<String, String> userMap);

    QingYinResult userAdd(String temporaryBill, String encryptedData, String iv,String sessionKeys);

    String paySuccess(String oddNumber, String openid, String formid, String money, String name);

    QingYinResult findAllUser(Integer page, Integer rows);
}
