package com.test.cms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.cms.service.IAdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.tools.util.IdolUtils;
import com.test.tools.util.QingYinResult;

/**
 * 
 * @ClassName: AdminController
 * @Description: 艺术私品后台管理员接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月30日 下午4:57:52
 *
 */
@RestController
@RequestMapping("AdminUser")
public class AdminController {
	private Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private IAdminUserService adminUserService;

	/**
	 * 后台用户的登录
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public QingYinResult loginAdmin(@RequestBody Map<?, ?> map) {
		System.out.println("111111111111111111111");
		System.out.println(map.toString());
		// 获取用户名
		String adminName = IdolUtils.toString(map.get("username"));
		// 获取密码
		String adminPass = IdolUtils.toString(map.get("password"));
		QingYinResult result = adminUserService.loginAdmin(adminName, adminPass);
		return result;
	}

	/**
	 * 后台获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userInfo", method = RequestMethod.POST)
	public QingYinResult getAdminInfo(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		QingYinResult result = adminUserService.getAdminInfo(token);
		return result;

	}

	/**
	 * 后台用户退出登录
	 * 
	 * @param request
	 * @return
	 */
	/*@RequestMapping(value = "logout", method = RequestMethod.POST)
	public QingYinResult logoutUser(HttpServletRequest request) {

		String token = request.getHeader("Authorization");// 获取token信息
		log.debug("token===" + token);

		QingYinResult result = adminUserService.logoutUser(token);

		return result;

	}*/
}
