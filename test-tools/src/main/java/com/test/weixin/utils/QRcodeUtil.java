package com.test.weixin.utils;

import com.test.tools.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * @ClassName: QRcodeUtil
 * @Description: 微信生成临时二维码
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月20日 下午3:21:50
 * @version V1.0
 */
public class QRcodeUtil {

	/* 生成临时二维码 */
	public static JSONObject getTemporaryQR(String accessToken, String scene_id) {

		String url = (WXConstant.LS_QRCODE_URL).replace("ACCESS_TOKEN", accessToken);
		// 发送给微信服务器的数据
		String jsonStr = "{\"expire_seconds\": 600,\"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "
				+ scene_id + "}}}";
		JSONObject result = HttpClientUtil.httpRequest(url, "POST", jsonStr);

		return result;
	}

}
