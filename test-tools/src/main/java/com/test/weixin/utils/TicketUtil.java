package com.test.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.HttpClientUtil;
import com.test.tools.util.JsonUtils;
import com.test.weixin.pojo.Ticket;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @ClassName: TicketUtil
 * @Description: 微信获取调取js-jdk的临时票据(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年7月23日 下午4:13:18
 *
 */
public class TicketUtil {
	private static Logger log = LoggerFactory.getLogger(TicketUtil.class);

	public static Ticket getTicket(String url, String accessToken) {
		Ticket ticket = null;
		String requestUrl = url.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = HttpClientUtil.httpRequest(requestUrl, "GET", null);
		
		log.debug("jsonObject==="+JsonUtils.objectToJson(jsonObject));
		// 如果请求成功
		if (null != jsonObject) {
			try {
				ticket = new Ticket();
				ticket.setExpires_in(jsonObject.getInt("expires_in"));
				ticket.setTicket(jsonObject.getString("ticket"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取ticket失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return ticket;
	}

}
