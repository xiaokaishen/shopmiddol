package com.test.cms.controller;

import com.alibaba.fastjson.JSON;
import com.test.cms.service.ReportService;
import com.test.pojo.ShopReport;
import com.test.tools.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "findAllUser", method = RequestMethod.POST)
    public QingYinResult findAllUser(@RequestBody Map<?, ?> map) {
        Integer page = (Integer) map.get("page");
        Integer rows = (Integer) map.get("rows");
        System.out.println(page + "===" + rows);
        QingYinResult result = reportService.findAllUser(page, rows);
        return result;
    }

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "setReport", method = RequestMethod.POST)
    public QingYinResult setReport(@RequestBody Map<?, ?> map){

        ShopReport shopReport = JsonUtils.ObjectToPojo(map.get("shopReport"), ShopReport.class);
        System.out.println("shopReport:======="+shopReport);
        if(shopReport!=null&&!"".equals(shopReport)){
            Integer index = reportService.addReport(shopReport);
            if(index==1){
                return QingYinResult.ok();
            }
        }

        return QingYinResult.build(400,"添加失败");
    }

    /**
     * 导入excel
     * @param
     * @return
     */
    @RequestMapping(value = "loadExcel",method=RequestMethod.POST)
    public  QingYinResult loadExcel(@RequestBody Map<String,String> map){
        //获得json字符串
        String para = map.get("para");
        //解析为list对象集合
        List<ShopReport> list = JSON.parseArray(para, ShopReport.class);
        //保存到数据库中
        try{
            reportService.addUser(list);
        }catch (Exception e){
            e.printStackTrace();
            return new QingYinResult(500,"系统内部错误!!!",null);
        }


        return new QingYinResult(200,"导入成功",null);
    }



}
