package com.test.cms.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.test.cms.service.KaiService;
import com.test.dao.ShopUserAuthsMapper;
import com.test.dao.ShopUserMapper;
import com.test.pojo.QyUserAuths;
import com.test.pojo.ShopUser;
import com.test.pojo.ShopUserAuths;
import com.test.pojo.UserResult;
import com.test.smallApp.utils.SmallAppUtils;
import com.test.tools.util.*;
import com.test.utils.JsonUtil;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KaiServiceImpl implements KaiService {

    @Autowired
    private ShopUserAuthsMapper shopUserAuthsMapper;
    @Autowired
    private ShopUserMapper shopUserMapper;
    //你好啊
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
                    shopUser.setCreatetime(new Date());// 创建时间
                    shopUser.setUpdatetime(new Date());// 更新时间
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
                            return QingYinResult.ok(user);
                        } else {
                            shopUserMapper.deleteByPrimaryKey(userid);// 删除添加的用户
                            return QingYinResult.build(400, "添加用户失败");
                        }
                    } else {
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
                    return QingYinResult.ok(user);
                } else if (openIdAuthsList.size() == 1 && unionAuthsList.size() == 1) {// 授权登录过

                    userid = openIdAuthsList.get(0).getPrimarykeyid();
                    ShopUser user = shopUserMapper.selectShopUserIntegralVieByid(userid);// 查询用户信息
                    String wxname =user.getWxname();
                    if(wxname!=null) {
                        wxname =user.getWxname();
                        user.setWxname(HtmlCapeUtil.unescapeHtml(wxname));
                    }
                    return QingYinResult.ok(user);
                } else {
                    return QingYinResult.build(500, "授权出错了,请联系管理员");
                }

            } else {// unionid为空
                return QingYinResult.build(500, "添加微信用户出错了,请联系网站管理员");
            }

        } catch (Exception e) {
            return QingYinResult.build(501, ExceptionUtil.getStackTrace(e));
        }

    }
}
