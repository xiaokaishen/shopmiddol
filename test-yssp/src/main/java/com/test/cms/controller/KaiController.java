package com.test.cms.controller;

import com.test.cms.service.KaiService;
import com.test.smallApp.utils.SmallAppAdvice;
import com.test.tools.util.IdolUtils;
import com.test.tools.util.QingYinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("kai")
public class KaiController {

    //你好啊
    @Autowired
    private KaiService kaiService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public QingYinResult login(@RequestBody Map<String,Object> map){
        System.out.println(map);

        String code = IdolUtils.toString(map.get("code"));
        Map<String, String> userMap = SmallAppAdvice.getUserMap(code);
        // 临时票据获取失败
        if(userMap == null){
            return QingYinResult.build(401,"调用失败");
        }

        QingYinResult result = kaiService.WXLoginRegist(userMap);

        return result;
    }

}
