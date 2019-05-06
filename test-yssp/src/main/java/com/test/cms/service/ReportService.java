package com.test.cms.service;

import com.test.pojo.ShopReport;
import com.test.tools.util.QingYinResult;

import java.util.List;

public interface ReportService {
    QingYinResult findAllUser(Integer page, Integer rows);

    List<ShopReport> allUser();

    Integer addReport(ShopReport shopReport);

    ShopReport findUserByPojo(String reportName, String reportPhone);
    //导入信息
    void addUser(List<ShopReport> list);

}
