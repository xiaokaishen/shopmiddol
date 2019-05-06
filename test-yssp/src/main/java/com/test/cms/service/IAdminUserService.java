package com.test.cms.service;


import com.test.tools.util.QingYinResult;

/**
 * 
 * @ClassName: IAdminUserService
 * @Description: 后台管理系统用户操作service接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月31日 下午1:10:07
 *
 */
public interface IAdminUserService {

	/**
	 * 后台用户登录
	 * 
	 * @param adminName
	 * @param adminPass
	 * @return
	 */
	QingYinResult loginAdmin(String adminName, String adminPass);

	QingYinResult getAdminInfo(String token);

	/**
	 * 后台获取用户信息
	 * 
	 * @param token
	 * @return
	 */
	/*QingYinResult getAdminInfo(String token);

	*//**
	 * 后台用户退出登录
	 * 
	 * @param token
	 * @return
	 *//*
	QingYinResult logoutUser(String token);

	*//**
	 * 根据request信息获取用户信息
	 * 
	 * @param
	 * @return
	 *//*
	ShopCmsUser getUserInfo(HttpServletRequest request);*/
}
