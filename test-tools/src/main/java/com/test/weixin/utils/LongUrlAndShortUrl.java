package com.test.weixin.utils;

import com.test.tools.util.HttpClientUtil;
import com.test.tools.util.JsonUtils;

import net.sf.json.JSONObject;

/**
 * @ClassName: LongUrlAndShortUrl
 * @Description: 长短链接转换
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月20日 下午5:05:32
 * @version V1.0
 */
public class LongUrlAndShortUrl {

	
	/**
	 * 微信长链接转短链接  
     *
	 * @param longurl
	 * @param token
	 * @return
	 */
	public static String Long2Short(String longurl, String token) {
		String url = WXConstant.S_URL.replace("ACCESS_TOKEN", token);
		String param = "{\"action\":\"long2short\"," + "\"long_url\":\"" + longurl + "\"}";

		JSONObject httpRequest = HttpClientUtil.httpRequest(url, "POST", param);
		
		System.out.println(JsonUtils.objectToJson(httpRequest));
		
		int errcode = (int) httpRequest.get("errcode");

		if (errcode == 0) {
			return (String) httpRequest.get("short_url");

		} else {
			return "0";

		}

	}

}
