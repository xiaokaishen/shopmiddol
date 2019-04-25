package com.test.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.cms.service.ReportService;
import com.test.dao.ShopReportMapper;
import com.test.pojo.ShopReport;
import com.test.pojo.ShopUser;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ShopReportMapper shopReportMapper;

    @Override
    public QingYinResult findAllUser(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<ShopReport> shopReports = shopReportMapper.findAllUser();
        return QingYinResult.ok(shopReports);
    }
}
