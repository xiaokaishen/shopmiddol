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
}
