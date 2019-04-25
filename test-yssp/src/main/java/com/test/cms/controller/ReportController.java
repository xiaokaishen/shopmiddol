package com.test.cms.controller;

import com.test.cms.service.ReportService;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "findAllUser",method = RequestMethod.POST)
    public QingYinResult findAllUser(@RequestBody Map<?,?> map){
        Integer page = (Integer) map.get("page");
        Integer rows = (Integer) map.get("rows");
        System.out.println(page+"==="+rows);
        QingYinResult result = reportService.findAllUser(page,rows);
        return result;
    }

}
