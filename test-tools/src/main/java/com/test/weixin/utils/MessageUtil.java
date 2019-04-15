package com.test.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.HttpClientUtil;
import com.test.tools.util.JsonUtils;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: MessageUtil
 * @Description: 微信消息回复工具类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月4日 下午3:03:41
 *
 */
public class MessageUtil {

	private static Logger log = LoggerFactory.getLogger(MessageUtil.class);

	/**
	 * 给用户发送一个模板消息
	 * 
	 * @param url
	 *            点击链接跳转URL
	 * @param openid
	 *            用户id
	 * @param fontColor
	 *            字体颜色
	 * @param tempID
	 *            模板ID
	 * @param m
	 *            发送数据封装
	 * @return
	 */
	public static Boolean postTemplateMessageToOpenid(String data) {

		// 拼装创建菜单的url
		log.info("发送模版消息"+data);
		String postUrl = WXConstant.TEMPLATE_MESSAGE_URL.replace("ACCESS_TOKEN", TokenUtil.getToken());
		log.info("发送模版消息中"+postUrl);
		JSONObject jsonObject = HttpClientUtil.httpRequest(postUrl, "POST", data);
		log.info("发送模版消息结束"+jsonObject);
		System.out.println(JsonUtils.objectToJson(jsonObject));

		if (null != jsonObject) {
			try {

				return true;

			} catch (Exception e) {

				log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
				return false;
			}
		} else {

			return false;
		}

	}
	
	
	/**
	 * 给用户发送一个模板消息
	 * 
	 * @param url
	 *            点击链接跳转URL
	 * @param openid
	 *            用户id
	 * @param fontColor
	 *            字体颜色
	 * @param tempID
	 *            模板ID
	 * @param m
	 *            发送数据封装
	 * @param token
	 *           传入一个token 
	 * @return
	 */
	public static Boolean postTemplateMessageToOpenid(String data,String token) {

		// 拼装创建菜单的url
		String postUrl = WXConstant.TEMPLATE_MESSAGE_URL.replace("ACCESS_TOKEN",token);
		JSONObject jsonObject = HttpClientUtil.httpRequest(postUrl, "POST", data);

		System.out.println(JsonUtils.objectToJson(jsonObject));

		if (null != jsonObject) {
			try {

				return true;

			} catch (Exception e) {

				log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
				return false;
			}
		} else {

			return false;
		}

	}

}