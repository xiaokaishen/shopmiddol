package com.test.cms.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.cms.service.KaiService;
import com.test.dao.ShopUserAuthsMapper;
import com.test.dao.ShopUserMapper;
import com.test.pojo.*;
import com.test.smallApp.utils.SmallAppConstant;
import com.test.smallApp.utils.SmallAppUtils;
import com.test.tools.util.*;
import com.test.utils.JsonUtil;
import com.test.weixin.utils.TokenUtil;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class KaiServiceImpl implements KaiService{

    @Autowired
    private ShopUserAuthsMapper shopUserAuthsMapper;
    @Autowired
    private ShopUserMapper shopUserMapper;

    @Autowired
    private DataSourceTransactionManager txManager;


    @Override
    public QingYinResult WXLoginRegist(Map<String, String> userMap) {

        UserResult userResult = new UserResult();
        String openId = userMap.get("openid");
        // 如果openId和unionId查询都存在数据，则以unionId为准
        if (!"".equals(openId)) {// 如果微信openId不为空
            List<QyUserAuths> unionAuthsList = new ArrayList<>();
            if (unionAuthsList.size() == 0 || unionAuthsList == null) {// 未查到授权信息
                String temporaryBill = IDUtil.generateShortUuid();
                userResult.setTemporaryBill(temporaryBill);
                userResult.setSessionKey(userMap.get("session_key"));
//                jedisClient.set("TemporaryBill:" + temporaryBill, JsonUtils.objectToJson(userMap));// 将用户临时数据缓存到redis中
                return QingYinResult.build(401, "用户未授权", userResult);
            }else if (unionAuthsList.size() == 1) {
                Long primarykeyid = unionAuthsList.get(0).getPrimarykeyid();
                ShopUser integralView = shopUserMapper.selectByPrimaryKey(primarykeyid);
                //userIntegralViewMapper.updateUserUpdateTime(primarykeyid, DateUtils.getDate());
                String wxname =integralView.getWxname();
                if(wxname !=null) {
                    integralView.setWxname(HtmlCapeUtil.unescapeHtml(wxname));
                }
                integralView.setPassword(null);
                return QingYinResult.ok(integralView);
            }  else {
                return QingYinResult.build(500, "授权出错了，请联系管理员");
            }

        } else {// 如果微信unionId为空，则以openId为准
            return QingYinResult.build(500, "系统出错了，请联系网站管理员");
        }
    }

    @Override
    public QingYinResult userAdd(String temporaryBill, String encryptedData, String iv,String sessionKey) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
        TransactionStatus status = txManager.getTransaction(def); // 获得事务状态
        try {
            @SuppressWarnings("unchecked")
            JSONObject decryptData = SmallAppUtils.decryptData(encryptedData, iv, sessionKey);
            System.out.println("decryptData:"+decryptData);
            StringBuffer buffer = JsonUtil.stringtojson(decryptData.toString());
            System.out.println(buffer);
            String unionId = decryptData.getString("unionId");
            String openId = decryptData.getString("openId");
            if(!"".equals(openId)){
                long userid = 0;
                String nickname = decryptData.getString("nickName");
                if(nickname !=null) {
                    nickname = EmojiParser.parseToHtmlDecimal(nickname);
                }
                String sex = decryptData.getString("gender");
                String headImgUrl = decryptData.getString("avatarUrl");
                String usercity = decryptData.getString("province");

                List<ShopUserAuths> unionAuthsList = shopUserAuthsMapper.selectByShopUserAuthsList("UNIDONID", unionId);
                List<ShopUserAuths> openIdAuthsList = shopUserAuthsMapper.selectByShopUserAuthsList("YSSP_XCX_OPENID", openId);
                System.out.println("unionAuthsList长度："+unionAuthsList.size());
                System.out.println("openIdAuthsList长度："+openIdAuthsList.size());
                /**
                 * // 用户从未在开放平台授权过
                 */
                if((unionAuthsList.size()==0||unionAuthsList == null)&&(openIdAuthsList.size()==0||openIdAuthsList==null)){
                    userid = IDUtil.getUserId();// 获取一个用户id
                    ShopUser shopUser = new ShopUser();
                    shopUser.setHeadPortraitUrl(headImgUrl);// 头像url
                    shopUser.setOpenid(openId);// 小程序openid
                    shopUser.setWxname(nickname);// 微信昵称
                    shopUser.setSex(sex);// 用户性别
                    shopUser.setId(userid);// 会员id
                    shopUser.setCreatetime(DateUtils.getNow());// 创建时间
                    shopUser.setUpdatetime(DateUtils.getNow());// 更新时间
                    shopUser.setUserCity(usercity);
                    int addShopUser = shopUserMapper.insertSelective(shopUser);
                    //用户添加成功
                    if(addShopUser==1){
                        System.out.println("添加成功的主键："+shopUser.getId());

                        List<ShopUserAuths> auths = new ArrayList<>();

                        // 用户登录权限表信息
                        ShopUserAuths openidAuths = new ShopUserAuths();
                        openidAuths.setCredential(UUID.randomUUID().toString());
                        openidAuths.setIdentifier(openId);
                        openidAuths.setIdentityType("YSSP_XCX_OPENID");
                        openidAuths.setPrimarykeyid(userid);
                        openidAuths.setVerified((byte) 1);// 默认为1，授权登录

                        auths.add(openidAuths);

                        ShopUserAuths unionAuths = new ShopUserAuths();// 用户登录权限表信息
                        unionAuths.setCredential(UUID.randomUUID().toString());
                        if("".equals(unionId)||unionId == null){
                            unionAuths.setIdentifier("空的，没有");
                        }
                        else{
                            unionAuths.setIdentifier(unionId);
                        }
                        unionAuths.setIdentityType("UNIDONID");
                        unionAuths.setPrimarykeyid(userid);
                        unionAuths.setVerified((byte) 1);// 默认为1，授权登录

                        auths.add(unionAuths);

                        int insert = shopUserAuthsMapper.insertListShopUserAuths(auths);
                        System.out.println("插入"+insert);
                        if (insert == 2) {
                            ShopUser user = shopUserMapper.selectShopUserIntegralVieByid(userid);
                            String wxname =user.getWxname();
                            if(wxname!=null) {
                                wxname =user.getWxname();
                                user.setWxname(HtmlCapeUtil.unescapeHtml(wxname));
                            }

                            txManager.commit(status);
                            return QingYinResult.ok(user);
                        } else {
                            txManager.rollback(status);
                            shopUserMapper.deleteByPrimaryKey(userid);// 删除添加的用户
                            return QingYinResult.build(400, "添加用户失败");
                        }
                    } else {
                        txManager.rollback(status);
                        return QingYinResult.build(400, "添加用户失败");
                    }
                } else if (unionAuthsList.size() == 1 && (openIdAuthsList.size() == 0 || openIdAuthsList == null)) {// 授权登录过
                    // unionId授权过
                    // 查询用户id
                    userid = unionAuthsList.get(0).getPrimarykeyid();
                    // 授权该openid登录
                    List<ShopUserAuths> auths = new ArrayList<>();
                    ShopUserAuths openidAuths = new ShopUserAuths();// 用户登录权限表信息
                    openidAuths.setCredential(UUID.randomUUID().toString());
                    openidAuths.setIdentifier(openId);
                    openidAuths.setIdentityType("YSSP_XCX_OPENID");
                    openidAuths.setPrimarykeyid(userid);
                    openidAuths.setVerified((byte) 1);// 默认为1，授权登录

                    auths.add(openidAuths);
                    shopUserAuthsMapper.insertListShopUserAuths(auths);// 添加授权

                    ShopUser user = shopUserMapper.selectShopUserIntegralVieByid(userid);// 查询用户信息
                    String wxname =user.getWxname();
                    if(wxname!=null) {
                        wxname =user.getWxname();
                        user.setWxname(HtmlCapeUtil.unescapeHtml(wxname));
                    }
                    txManager.commit(status);
                    return QingYinResult.ok(user);
                } else if (openIdAuthsList.size() == 1 && unionAuthsList.size() == 1) {// 授权登录过

                    userid = openIdAuthsList.get(0).getPrimarykeyid();
                    ShopUser user = shopUserMapper.selectShopUserIntegralVieByid(userid);// 查询用户信息
                    String wxname =user.getWxname();
                    if(wxname!=null) {
                        wxname =user.getWxname();
                        user.setWxname(HtmlCapeUtil.unescapeHtml(wxname));
                    }
                    txManager.commit(status);
                    return QingYinResult.ok(user);
                } else {
                    txManager.rollback(status);
                    return QingYinResult.build(500, "授权出错了,请联系管理员");
                }

            } else {// unionid为空
                txManager.rollback(status);
                return QingYinResult.build(500, "添加微信用户出错了,请联系网站管理员");
            }

        } catch (Exception e) {
            txManager.rollback(status);
            return QingYinResult.build(501, ExceptionUtil.getStackTrace(e));
        }

    }

    @Override
    public String paySuccess(String oddNumber, String openid, String formid, String money, String name) {

        RestTemplate restTemplate = new RestTemplate();

        // 获取access_token
        String access_token = TokenUtil.getSmallAppToken();
        System.out.println("access_token666:"+access_token);
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send" + "?access_token=" + access_token;

        //拼接推送的模版
        WxMssVo wxMssVo = new WxMssVo();
        wxMssVo.setTouser(openid);
        wxMssVo.setForm_id(formid);
        wxMssVo.setTemplate_id(SmallAppConstant.TemplateId);

        Map<String, TemplateData> map = new HashMap<>();
//        //单号
//        TemplateData keyword1 = new TemplateData();
//        keyword1.setValue(oddNumber);
//        map.put("keyword1",keyword1);
//        //金额
//        TemplateData keyword2 = new TemplateData();
//        keyword1.setValue(money);
//        map.put("keyword2",keyword2);
//        //下单时间
//        TemplateData keyword3 = new TemplateData();
//        keyword1.setValue(new Date().toString());
//        map.put("keyword3",keyword3);
//        //物品名称
//        TemplateData keyword4 = new TemplateData();
//        keyword1.setValue(name);
//        map.put("keyword4",keyword4);
//        //支付时间
//        TemplateData keyword5 = new TemplateData();
//        keyword1.setValue(new Date().toString());
//        map.put("keyword5",keyword5);

        System.out.println(map.toString());

        wxMssVo.setData(map);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(url, wxMssVo, String.class);

        return forEntity.getBody();
    }

    @Override
    public QingYinResult findAllUser(Integer page,Integer rows) {

        PageHelper.startPage(page,rows);
        List<ShopUser> shopUsers = shopUserMapper.selectAll();
        return QingYinResult.ok(shopUsers);
    }
}
