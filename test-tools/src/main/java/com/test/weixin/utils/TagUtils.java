package com.test.weixin.utils;

import com.test.tools.util.HttpClientUtil;
import com.test.tools.util.JsonUtils;

import net.sf.json.JSONObject;

/**
 * 用户标签管理类
 * 
 * @author Administrator
 *
 */
public final class TagUtils {

	/**
	 * 获取某个标签下所有用户
	 * 
	 * @param accessToken
	 *            token 根据TokenUtil.getToken()获取
	 * @param tagID
	 *            标签ID
	 * @return
	 */
	public static JSONObject getTagListTOTagID(String accessToken, int tagID) {

		String url = (WXConstant.GET_TAG_LIST_URL).replace("ACCESS_TOKEN", accessToken);
		// 发送给微信服务器的数据
		String jsonStr = "{\"tagid\": " + tagID + ",\"next_openid\": \"\"}";
		JSONObject result = HttpClientUtil.httpRequest(url, "POST", jsonStr);

		return result;
	}

	/**
	 * 获取该公众号下所有标签
	 * 
	 * @param accessToken
	 *            token 根据TokenUtil.getToken()获取
	 * @return
	 */
	public static JSONObject getAllTag(String accessToken) {

		String url = (WXConstant.GET_TAG).replace("ACCESS_TOKEN", accessToken);
		// 发送给微信服务器的数据
		JSONObject result = HttpClientUtil.httpRequest(url, "POST", "");

		return result;
	}

	public static void main(String[] args) {
		JSONObject allTag = TagUtils.getTagListTOTagID(TokenUtil.getToken(), 101);
		System.out.println(JsonUtils.objectToJson(allTag));
	}

}
