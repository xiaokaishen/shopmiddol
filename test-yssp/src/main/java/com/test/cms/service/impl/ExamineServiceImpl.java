package com.test.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.cms.service.ExamineService;
import com.test.dao.ShopExamineMapper;
import com.test.dao.ShopStoreMapper;
import com.test.pojo.ShopExamine;
import com.test.pojo.ShopReport;
import com.test.pojo.ShopStore;
import com.test.tools.util.DateUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ShopExamineMapper shopExamineMapper;
    @Autowired
    private ShopStoreMapper shopStoreMapper;

    @Override
    public Integer addExamine(ShopReport shopReport) {
        ShopExamine shopExamine = new ShopExamine();
        //审核门店id
        shopExamine.setExamineStoreId(shopReport.getReportStoreId());
        //审核门店名称
        ShopStore shopStore = shopStoreMapper.selectByPrimaryKey(shopReport.getReportStoreId());
        System.out.println("ssssssssssssss"+shopStore);
        shopExamine.setExamineStoreName(shopStore.getStoreDistributorJc());
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

    @Override
    public ShopExamine findUserByPojo(String reportName, String reportPhone) {
        ShopExamine shopExamine = shopExamineMapper.selectByPojo(reportName,reportPhone);
        return shopExamine;
    }

    @Override
    public QingYinResult examineYorNbyId(Integer examineId,byte examineState) {
        ShopExamine shopExamine = shopExamineMapper.selectByPrimaryKey(examineId);
        shopExamine.setExamineState(examineState);
        int i = shopExamineMapper.updateByPrimaryKey(shopExamine);
        if(i==1){
            return QingYinResult.ok();
        }
        return QingYinResult.build(400,"审核状态未修改成功");
    }

    @Override
    public QingYinResult paymentYorNbyId(Integer examineId) {
        ShopExamine shopExamine = shopExamineMapper.selectByPrimaryKey(examineId);
        shopExamine.setPaymentState((byte)1);
        int i = shopExamineMapper.updateByPrimaryKey(shopExamine);
        if(i==1){
            return QingYinResult.ok();
        }
        return QingYinResult.build(400,"支付情况未修改成功");
    }
}
