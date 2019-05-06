package com.test.cms.controller;

import com.alibaba.fastjson.JSON;
import com.test.cms.service.ExamineService;
import com.test.cms.service.ReportService;
import com.test.pojo.ShopExamine;
import com.test.pojo.ShopReport;
import com.test.tools.util.JsonUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("examine")
public class ExamineController {

    @Autowired
    private ExamineService examineService;
    @Autowired
    private ReportService reportService;

    /**
     * 根据用户名称和手机号查询用户提交的信息
     * @param map
     * @return
     */
    @RequestMapping(value = "findUser",method = RequestMethod.POST)
    public QingYinResult findUser(@RequestBody Map<?, ?> map){
        ShopReport shopReport = JsonUtils.ObjectToPojo(map.get("shopReport"), ShopReport.class);
        if(shopReport==null||"".equals(shopReport)){
            return QingYinResult.build(400,"请输入姓名或手机号");
        }
        //名称
        String reportName = shopReport.getReportName();
        //手机号码
        String reportPhone = shopReport.getReportPhone();
        ShopReport report = reportService.findUserByPojo(reportName,reportPhone);
        System.out.println("结果:==="+report);
        return QingYinResult.ok(report);
    }

    /**
     * 根据查询出来的用户信息去审核
     * @param map
     * @return
     */
    @RequestMapping(value = "setExamine",method = RequestMethod.POST)
    public QingYinResult setExamine(@RequestBody Map<?, ?> map){
        ShopReport shopReport = JsonUtils.ObjectToPojo(map.get("shopExamine"), ShopReport.class);
        ShopReport userByPojo = reportService.findUserByPojo(shopReport.getReportName(), shopReport.getReportPhone());

        if(userByPojo!=null||!"".equals(userByPojo)){
            return QingYinResult.build(404,"审核信息已提交成功,请勿重复提交");
        }

        if(shopReport==null||"".equals(shopReport)){
            return QingYinResult.build(400,"缺少需要审核的用户信息");
        }
        Integer index = examineService.addExamine(shopReport);
        if(index==1){
            return QingYinResult.ok();
        }
        return QingYinResult.build(404,"审核信息没有提交成功");
    }

    /**
     * 查询所有审核用户
     */
    @RequestMapping(value = "findAllExamine", method = RequestMethod.POST)
    public QingYinResult findAllUser(@RequestBody Map<?, ?> map) {
        Integer page = (Integer) map.get("page");
        Integer rows = (Integer) map.get("rows");
        System.out.println(page + "===" + rows);
        QingYinResult result = examineService.findAllExamine(page, rows);
        return result;
    }
    /**
     * 导入excel
     * @param
     * @return
     */
    @RequestMapping(value = "loadExcel",method=RequestMethod.POST)
    public  QingYinResult loadExcel(@RequestBody Map<String,String> map){
        System.out.println("进来了");
        //获得json字符串
        String para = map.get("para");
        //解析为list对象集合
        List<ShopExamine> list = JSON.parseArray(para, ShopExamine.class);
        System.out.println("導入的數據："+list);
        //保存到数据库中
        try{
            examineService.addUser(list);
        }catch (Exception e){
            e.printStackTrace();
            return new QingYinResult(500,"系统内部错误!!!",null);
        }


        return new QingYinResult(200,"导入成功",null);
    }


}
