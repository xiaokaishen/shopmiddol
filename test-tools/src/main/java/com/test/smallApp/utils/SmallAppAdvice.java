package com.test.smallApp.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.HttpClientUtil;
import com.test.tools.util.JsonUtils;
import com.test.weixin.pojo.SNSUserInfo;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: SmallAppAdvice
 * @Description: 小程序授权操作工具类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月21日 下午3:00:19
 *
 */
public class SmallAppAdvice {
	private static Logger log = LoggerFactory.getLogger(SmallAppAdvice.class);

	/**
	 * 根据临时票据id获取用户openid和微信unionid
	 * 
	 * @param code
	 * @return
	 */
	public static SNSUserInfo getSNSUserInfo(String code) {
		SNSUserInfo snsUserInfo = null;
		// 拼接请求地址
		String requestUrl = SmallAppConstant.Login_Credential_Verification;
		requestUrl = requestUrl.replace("APPID", SmallAppConstant.AppID).replace("SECRET", SmallAppConstant.AppSecret)
				.replace("JSCODE", code);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = HttpClientUtil.httpRequest(requestUrl, "GET", null);
		log.debug("jsonObject===" + JsonUtils.objectToJson(jsonObject));

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				log.debug("aaa=="+jsonObject.has("unionid"));

				// 用户唯一授权unionId
				if (jsonObject.has("unionid")) {
					snsUserInfo.setUnionid(jsonObject.getString("unionid"));
				} else {
					snsUserInfo.setUnionid("");
				}

				// 用户特权信息
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;

	}
	
	
	/**
	 * 根据临时票据id获取用户openid和微信unionid
	 * 
	 * @param code
	 * @return
	 */
	public static Map<String, String> getUserMap(String code) {
		Map<String , String> map=null;
		// 拼接请求地址
		String requestUrl = SmallAppConstant.Login_Credential_Verification;
		requestUrl = requestUrl.replace("APPID", SmallAppConstant.AppID).replace("SECRET", SmallAppConstant.AppSecret)
				.replace("JSCODE", code);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = HttpClientUtil.httpRequest(requestUrl, "GET", null);
		log.debug("jsonObject===" + JsonUtils.objectToJson(jsonObject));

		if (null != jsonObject) {
			try {
				map=new HashMap<>();
				map.put("openid", jsonObject.getString("openid"));
				map.put("session_key", jsonObject.getString("session_key"));
			} catch (Exception e) {
				map = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return map;

	}

}
