package com.test.weixin.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.IdolUtils;
import com.test.tools.util.WXPayUtil;

/**
 * 
 * 
 * @ClassName: WeChatUtil
 * @Description: 微信统一接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月8日 下午3:31:28
 *
 */
public class WeChatUtil {
	private static Logger log = LoggerFactory.getLogger(WeChatUtil.class);

	// HTTP请求器
	private static CloseableHttpClient httpClient;

	/**
	 * 统一下单 获得PrePayId
	 * 
	 * @param body
	 *            商品或支付单简要描述
	 * @param out_trade_no
	 *            商户系统内部的订单号,32个字符内、可包含字母
	 * @param total_fee
	 *            订单总金额，单位为分
	 * @param IP
	 *            APP和网页支付提交用户端ip
	 * @param notify_url
	 *            接收微信支付异步通知回调地址
	 * @param openid
	 *            用户openId
	 * @throws Exception
	 */
	public static String unifiedorder(String body, String out_trade_no, Integer total_fee, String ip, String notify_url,
			String openId) throws Exception {
		log.debug(">>>>>>>>>>>>>>>>>开始准备统一下单流程....");

		/**
		 * 组装请求参数 按照ASCII排序
		 */
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		String nonce_str = getNonceStr();// 随机数据
		parameters.put("appid", WXConstant.AppID);
		parameters.put("body", body);
		parameters.put("mch_id", WXConstant.MCH_ID);
		parameters.put("nonce_str", nonce_str);
		parameters.put("notify_url", notify_url);
		parameters.put("openid", openId);
		parameters.put("out_trade_no", out_trade_no);
		parameters.put("spbill_create_ip", ip);
		parameters.put("total_fee", total_fee.toString());
		parameters.put("trade_type", WXConstant.Trade_Type);
		String sign = WxSign.createSign(parameters, WXConstant.API_KEY);

		/**
		 * 组装XML
		 */
		log.debug(">>>>>>>>>>>>>>>>>统一下单数据准备完成，准备组装....{}", parameters.toString());
		StringBuilder sb = new StringBuilder("");
		sb.append("<xml>");
		setXmlKV(sb, "appid", WXConstant.AppID);
		setXmlKV(sb, "body", body);
		setXmlKV(sb, "mch_id", WXConstant.MCH_ID);
		setXmlKV(sb, "nonce_str", nonce_str);
		setXmlKV(sb, "notify_url", notify_url);
		setXmlKV(sb, "openid", openId);
		setXmlKV(sb, "out_trade_no", out_trade_no);
		setXmlKV(sb, "spbill_create_ip", ip);
		setXmlKV(sb, "total_fee", total_fee.toString());
		setXmlKV(sb, "trade_type", WXConstant.Trade_Type);
		setXmlKV(sb, "sign", sign);
		sb.append("</xml>");
		// 这个处理是为了防止传中文的时候出现签名错误
		StringEntity reqEntity = new StringEntity(new String(sb.toString().getBytes("UTF-8"), "ISO8859-1"));
		log.debug(">>>>>>>>>>>>>>>>>统一下单数据组装完成，准备下单。");

		HttpPost httppost = new HttpPost(WXConstant.Unified_Order_URL);
		httppost.setEntity(reqEntity);
		log.debug(">>>>>>>>>>>>>>>>>请求地址、请求数据封装完成。开始下单。");

		@SuppressWarnings("resource")
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = httpclient.execute(httppost);

		log.debug(">>>>>>>>>>>>>>>>>下单请求结束。获取返回值。");
		String strResult = EntityUtils.toString(response.getEntity(), Charset.forName("utf-8"));
		log.debug(">>>>>>>>>>>>>>>>>下单请求结束。转换字符串返回值结束。");

		return strResult;

	}

	/**
	 * 微信退款统一接口
	 * 
	 * @param transaction_id
	 * @param total_fee
	 * @param refund_fee
	 * @return
	 * @throws Exception
	 */
	public static String refundorder(String transaction_id, int total_fee, int refund_fee, FileInputStream instream)
			throws Exception {
		log.debug(">>>>>>>>>>>>>>>>>开始准备退款流程....");

		// 创建一个新的HashMap集合
		Map<String, String> parameters = new HashMap<String, String>();
		/** 退单的请求参数 **/
		KeyStore keyStore = KeyStore.getInstance("PKCS12");

		try {
			keyStore.load(instream, WXConstant.MCH_ID.toCharArray());
		} finally {
			instream.close();
		}

		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WXConstant.MCH_ID.toCharArray()) // 加载证书密码，默认为商户ID
				.build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		// 公众账号ID
		parameters.put("appid", WXConstant.AppID);
		// 商户号
		parameters.put("mch_id", WXConstant.MCH_ID);
		// 随机字符串
		parameters.put("nonce_str", WXPayUtil.generateNonceStr());
		// 商户订单号
		parameters.put("transaction_id", transaction_id);
		// 商户退款单号
		String out_refund_no = transaction_id;
		parameters.put("out_refund_no", out_refund_no);
		// 订单金额
		parameters.put("total_fee", IdolUtils.toString(total_fee));
		// 退款金额
		parameters.put("refund_fee", IdolUtils.toString(refund_fee));

		// 设置签名
		String sign = WXPayUtil.generateSignature(parameters, WXConstant.API_KEY);
		parameters.put("sign", sign);

		// 将请求参数转换为xml格式的string
		String requestXML = WXPayUtil.mapToXml(parameters);

		/*----5.发送数据到微信的退款接口---- */
		HttpPost httpost = HttpClientConnectionManager.getPostMethod(WXConstant.refund_URL);
		httpost.setEntity(new StringEntity(requestXML, "UTF-8"));
		HttpResponse weixinResponse = httpClient.execute(httpost);

		log.info(weixinResponse.toString());

		String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
		log.info(">>>>>>>>>>>>>>>>>退款请求结束。转换字符串返回值结束。");

		return jsonStr;

	}

	// 获得随机字符串
	public static String getNonceStr() {
		String str = "";
		Random random = new Random();
		try {
			str = MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	// 插入XML标签
	public static StringBuilder setXmlKV(StringBuilder sb, String Key, String value) {
		sb.append("<");
		sb.append(Key);
		sb.append(">");

		sb.append(value);

		sb.append("</");
		sb.append(Key);
		sb.append(">");

		return sb;
	}

	// 解析XML 获得 PrePayId
	public static String getPrePayId(String xml) {
		int start = xml.indexOf("<prepay_id>");
		int end = xml.indexOf("</prepay_id>");
		if (start < 0 && end < 0) {
			return null;
		}
		return xml.substring(start + "<prepay_id>".length(), end).replace("<![CDATA[", "").replace("]]>", "");
	}

	// 商户订单号
	public static String getOut_trade_no() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date()) + buildRandom(7);
	}

	// 时间戳
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	// 随机4位数字
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	public static String inputStream2String(InputStream inStream, String encoding) {
		String result = null;
		try {
			if (inStream != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] tempBytes = new byte[1024];
				int count = -1;
				while ((count = inStream.read(tempBytes, 0, 1024)) != -1) {
					outStream.write(tempBytes, 0, count);
				}
				tempBytes = null;
				outStream.flush();
				result = new String(outStream.toByteArray(), encoding);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

}
