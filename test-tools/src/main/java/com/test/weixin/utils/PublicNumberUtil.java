package com.test.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: PublicNumberUtil
 * @Description: 用户是否关注公众号操作类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月12日 上午9:13:05
 *
 */
public class PublicNumberUtil {
	private static Logger log = LoggerFactory.getLogger(PublicNumberUtil.class);

	/**
	 * 根据用户openID判断用户是否已经关注公众号
	 * 
	 * @param openid
	 *            用户openid
	 * @return
	 */
	public static Boolean judgeIsFollow(String openid) {

		// 拼接请求地址
		String requestUrl = WXConstant.FOLLOW_URL;
		requestUrl = requestUrl.replace("ACCESS_TOKEN", TokenUtil.getToken());
		requestUrl = requestUrl.replace("OPENID", openid);

		// 调用接口创建菜单
		JSONObject jsonObject = HttpClientUtil.httpRequest(requestUrl, "GET", null);

		int subscribe = jsonObject.getInt("subscribe");

		log.debug("subscribe===" + subscribe);

		if (subscribe == 0) {// 未关注

			return true;
		} else {// 已关注

			return false;
		}

	}
}
