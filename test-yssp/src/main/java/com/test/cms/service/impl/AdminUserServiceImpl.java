package com.test.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.cms.service.IAdminUserService;
import com.test.dao.ShopCmsUserMapper;
import com.test.pojo.ShopCmsUser;
import com.test.tools.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tools.util.IDUtil;
import com.test.tools.util.MD5Util;
import com.test.tools.util.QingYinResult;

/**
 * 
 * @ClassName: IAdminUserServiceImpl
 * @Description: 后台用户登录操作sevice实现类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月31日 下午1:12:41
 *
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {
//	private Logger log = LoggerFactory.getLogger(AdminUserServiceImpl.class);

//	@Autowired
//	private ShopCmsUser shopCmsUser;
//	@Autowired
//	private IJedisClient jedisClient;

	@Autowired
	private ShopCmsUserMapper shopCmsUserMapper;

	/**
	 * 后台用户登录
	 */
	@Override
	public QingYinResult loginAdmin(String cmsUserName, String adminPass) {
		System.out.println("cmsUserName:"+cmsUserName +"adminPass:"+adminPass);
		List<ShopCmsUser> cmsUsers = shopCmsUserMapper.selectByCmsUserName(cmsUserName);
		// 未查到该用户名
		if (cmsUsers.size() == 0 || cmsUsers == null) {
			return QingYinResult.build(400, "请输入正确的用户名");
		} else if (cmsUsers.size() == 1) {
			// 获取用户信息
			ShopCmsUser shopCmsUser = cmsUsers.get(0);
			// 获取用户登录密码
			String cmsUserPass = shopCmsUser.getCmsUserPass();
			// 判断用户密码是否匹配
			if (!cmsUserPass.equals(MD5Util.string2MD5(adminPass))) {
				return QingYinResult.build(400, "请输入正确的用户密码");
			}
			shopCmsUser.setCmsUserPass(null);
			// 用户名密码校验通过 生成token
			String token = IDUtil.generateShortUuid();
			// 将用户临时数据缓存到redis中
//			jedisClient.set("AdminUserToken:" + token, JsonUtils.objectToJson(ysspCmsUser));
//			// 设置token的过期时间1800s
//			jedisClient.expire("AdminUserToken:" + token, 1800);
			return QingYinResult.ok(token);
		} else {
			return QingYinResult.build(500, "用户信息出错，请联系管理员");
		}
	}



	/**
	 * 根据token获取用户信息
	 */
	@Override
	public QingYinResult getAdminInfo(String token) {

		if (token.length() != 32) {
			return QingYinResult.build(40001, "非法的token");
		}
		//String access_token = TokenUtil.getSmallAppToken();
		//String adminUserJson = jedisClient.get("AdminUserToken:" + token);
		// 没有取到用户信息
		/*if (StringUtils.isBlank(adminUserJson)) {
			return QingYinResult.build(40003, "用户登录信息过期");
		}
		ShopCmsUser ysspCmsUser = JsonUtils.jsonToPojo(adminUserJson, ShopCmsUser.class);
		// 更新token的过期时间
		jedisClient.expire("AdminUserToken:" + token, 1800);*/
		Map<String, Object> map = new HashMap<>();
		map.put("AdminUser", "");
		return QingYinResult.ok(map);

	}

	/*@Override
	public QingYinResult logoutUser(String token) {
		jedisClient.del("AdminUserToken:" + token);
		return QingYinResult.ok();

	}

	@Override
	public ShopCmsUser getUserInfo(HttpServletRequest request) {
		String token = request.getHeader("Authorization");// 获取token信息
		String adminUserJson = jedisClient.get("AdminUserToken:" + token);

		ShopCmsUser ysspCmsUser = JsonUtils.jsonToPojo(adminUserJson, ShopCmsUser.class);
		// 更新token的过期时间
		jedisClient.expire("AdminUserToken:" + token, 1800);
		return ysspCmsUser;

	}*/
}
