package com.test.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.HttpClientUtil;
import com.test.weixin.pojo.Menu;
import com.test.weixin.pojo.PersonMenu;

import net.sf.json.JSONObject;

/**
 * @ClassName: WXCustomMenuUtil
 * @Description: 微信自定义菜单Util
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月15日 下午3:54:17
 * @version V1.0
 */
public class WXCustomMenuUtil {
	private static Logger log = LoggerFactory.getLogger(WXCustomMenuUtil.class);

	/**
	 * 创建通用菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createCurrencyMenu(Menu menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = (WXConstant.CURRENCY_MENU_URL_ADD).replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println("jsonMenu===" + jsonMenu);
		// 调用接口创建菜单
		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

	/**
	 * 查询通用菜单
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String selectCurrencyMenu(String accessToken) {
		String result = null;
		// 拼装创建菜单的url
		String url = (WXConstant.CURRENCY_MENU_URL_SEL).replace("ACCESS_TOKEN", accessToken);
		// 调用接口创建菜单
		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "GET", null);
		result = jsonObject.toString();

		return result;
	}

	/**
	 * 删除通用菜单
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String delCurrencyMenu(String accessToken) {
		String result = null;
		// 拼装创建菜单的url
		String url = (WXConstant.CURRENCY_MENU_URL_DEL).replace("ACCESS_TOKEN", accessToken);
		// 调用接口创建菜单
		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "GET", null);
		result = jsonObject.toString();

		return result;
	}

	/**
	 * 创建自定义菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static String createPersonMenu(PersonMenu menu, String accessToken) {
		String result = null;
		// 拼装创建菜单的url
		String url = (WXConstant.PERSONALIZED_MENU_ADD).replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {

			result = jsonObject.toString();

		}

		return result;
	}

	/**
	 * 删除自定义菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static String delPersonMenu(String accessToken) {
		String result = null;
		// 拼装创建菜单的url
		String url = (WXConstant.PERSONALIZED_MENU_DEL).replace("ACCESS_TOKEN", accessToken);

		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "POST", null);
		result = jsonObject.toString();

		return result;
	}
	
	/**
	 * 获取已经创建的标签
	 */
	
	public static String getTag(String accessToken) {
		String result = null;
		// 拼装创建菜单的url
		String url = (WXConstant.GET_TAG).replace("ACCESS_TOKEN", accessToken);

		JSONObject jsonObject = HttpClientUtil.httpRequest(url, "POST", null);
		result = jsonObject.toString();

		return result;
	}
	
	

}
