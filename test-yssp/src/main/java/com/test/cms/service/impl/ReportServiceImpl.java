package com.test.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.cms.service.ReportService;
import com.test.dao.ShopReportMapper;
import com.test.pojo.ShopReport;
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

    @Override
    public List<ShopReport> allUser() {
        List<ShopReport> shopReports = shopReportMapper.findAllUser();
        return shopReports;
    }

    @Override
    public Integer addReport(ShopReport shopReport) {
        int insert = shopReportMapper.insert(shopReport);
        return insert;
    }

    @Override
    public ShopReport findUserByPojo(String reportName, String reportPhone) {
        ShopReport shopReport = shopReportMapper.selectByPojo(reportName,reportPhone);
        return shopReport;
    }
    /**
     * 导入信息
     * @param list
     */
    @Override
    public void addUser(List<ShopReport> list) {
        // todo 对象的id要做处理,因为id为主键不允许重复,时间可能要处理一下
        for (ShopReport shopReport : list) {
            shopReportMapper.insert(shopReport);
        }

    }

}
