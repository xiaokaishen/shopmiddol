package com.test.weixin.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WxSign {
	private static Logger log = LoggerFactory.getLogger(WxSign.class);

	/**
	 * 签名封装类。创建签名。
	 * 
	 * @param parameters
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(SortedMap<Object, Object> parameters, String key) throws Exception {
		log.info(">>>>>>>>>>>>>>>>>开始封装数据，创建签名....");
		StringBuffer sb = new StringBuffer();
		// 所有参与传参的参数按照accsii排序（升序）
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		log.info(">>>>>>>>>>>>>>>>>封装数据{}", sb.toString());
		String str = sb.toString();
		log.info(str);
		String sign = MD5Util.MD5Encode(str).toUpperCase();
		log.info(">>>>>>>>>>>>>>>>>封装数据完成，签名为:{}", sign);
		return sign;
	}

	public static Map<String, Object> sign(String jsapi_ticket, String url) {
		Map<String, Object> ret = new HashMap<String, Object>();

		String timestamp = WeChatUtil.getTimeStamp();
		String nonce_str = WeChatUtil.getNonceStr();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
}
