package com.test.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.cms.service.ExamineService;
import com.test.dao.ShopExamineMapper;
import com.test.pojo.ShopExamine;
import com.test.pojo.ShopReport;
import com.test.tools.util.DateUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ShopExamineMapper shopExamineMapper;

    @Override
    public Integer addExamine(ShopReport shopReport) {
        ShopExamine shopExamine = new ShopExamine();
        //审核门店id
        shopExamine.setExamineStoreId(4399);
        //审核门店名称
        shopExamine.setExamineStoreName("4S店某某俱乐部");
        //审核用户id
        shopExamine.setExamineUserId(shopReport.getReportId());
        //审核用户名称
        shopExamine.setExamineUserName(shopReport.getReportName());
        //审核用户手机号码
        shopExamine.setExamineUserPhone(shopReport.getReportPhone());
        //审核用户支付宝账号
        shopExamine.setExamineUserAlipay(shopReport.getReportAlipay());
        //审核状态
        shopExamine.setExamineState((byte)0);
        //支付状态
        shopExamine.setPaymentState((byte)0);
        //创建时间
        shopExamine.setExamineEstablishTime(DateUtils.getNow());
        //修改时间
        shopExamine.setExamineModifyTime(DateUtils.getNow());

        int insert = shopExamineMapper.insert(shopExamine);

        return insert;
    }

    @Override
    public QingYinResult findAllExamine(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<ShopExamine> shopExamines = shopExamineMapper.findAllExamine();
        return QingYinResult.ok(shopExamines);
    }

    @Override
    public void addUser(List<ShopExamine> list) {
        for (ShopExamine shopExamine : list) {
            shopExamineMapper.insert(shopExamine);
        }
    }
}
