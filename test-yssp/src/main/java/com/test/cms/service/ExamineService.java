package com.test.cms.service;

import com.test.pojo.ShopExamine;
import com.test.pojo.ShopReport;
import com.test.tools.util.QingYinResult;

import java.util.List;

public interface ExamineService {
    Integer addExamine(ShopReport shopReport);

    QingYinResult findAllExamine(Integer page, Integer rows);

    void addUser(List<ShopExamine> list);
}
