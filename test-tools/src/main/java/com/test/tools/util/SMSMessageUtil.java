package com.test.tools.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: SMSMessageUtil
 * @Description: 发送短信验证码工具类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月30日 下午3:15:29
 *
 */
public class SMSMessageUtil {
	private static Logger log = LoggerFactory.getLogger(SMSMessageUtil.class);

	private static final String AC = "send";// 接口功能
	private static final String USERNAME = "edenidol";// 用户名
//	private static final String PASSWORD = "04ab644f9c1a982c2d5c7632c1f6bcd7";// 接口验证密码
	private static final String PASSWORD = "111ba6b336c44370aa18281afe6dd448";// 接口验证密码
	private static final String encode = "utf-8"; // 默认编码格式
	private static final String SEND_URL = "http://api.sms.cn/sms/?";
	private static final String TEMPLATE = "431311";// 模板ID
	private static final String TEMPLATEFORPEOPLE = "484566";// 模板ID
	private static final String TEMPLATEFORPEOPLENONE = "484584";// 模板ID

	public static void main(String[] args) throws UnsupportedEncodingException {
		int sendMessage = sendMessageForValidateNone("17317131813", "张先生");
		System.out.println(sendMessage);
	}

	/**
	 * 
	 * 给用户发送短信验证码主方法
	 * 
	 * @param mobile
	 *            用户电话号码
	 * @param code
	 *            用户验证码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static int sendMessage(String mobile, String code) throws UnsupportedEncodingException {

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(SEND_URL);
		sb.append("ac=").append(AC);
		// 向StringBuffer追加用户名
		sb.append("&uid=").append(USERNAME);
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=").append(PASSWORD);
		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(mobile);
		// 追加模板信息

		sb.append("&template=").append(TEMPLATE);
		// 向StringBuffer追加消息内容转URL标准码

		Map<String, String> contentMap = new HashMap<>();

		contentMap.put("code", code);
		sb.append("&content=").append(URLEncoder.encode(JsonUtils.objectToJson(contentMap), "UTF-8"));
		sb.append("&encode=").append(encode);
		try {
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");

			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			// 返回发送结果
			String result = in.readLine().toString();
          
			if (result.indexOf("100") != -1) {// 短信发送成功

				return 0;

			} else if (result.indexOf("112") != -1) {// 手机号码不正确
				return 1;
			} else {
				log.info("result==" + result);
				return 2;
			}

		} catch (IOException e) {
			log.info(ExceptionUtil.getStackTrace(e));

			return 3;
		}

	}

	/**
	 * 
	 * 给用户推销
	 * 
	 * @param mobile
	 *            用户电话号码
	 * @param code
	 *            用户验证码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static int sendMessageNew(String mobile, String code) throws UnsupportedEncodingException {

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(SEND_URL);
		sb.append("ac=").append(AC);
		// 向StringBuffer追加用户名
		sb.append("&uid=").append(USERNAME);
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=").append(PASSWORD);
		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(mobile);
		// 向StringBuffer追加消息内容
		sb.append("&content=").append(URLEncoder.encode(code, "UTF-8"));
		sb.append("&encode=").append(encode);
		sb.append("ignore=1");// 防止号码出错报112提交失败错误
		try {
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");

			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			// 返回发送结果
			String result = in.readLine().toString();

			if (result.indexOf("100") != -1) {// 短信发送成功

				return 0;

			} else if (result.indexOf("112") != -1) {// 手机号码不正确
				return 1;
			} else {
				log.info("result==" + result);
				return 2;
			}

		} catch (IOException e) {
			log.info(ExceptionUtil.getStackTrace(e));

			return 3;
		}

	}
	
	//身份验证成功
	public static int sendMessageForValidate(String mobile, String code) throws UnsupportedEncodingException {


		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(SEND_URL);
		sb.append("ac=").append(AC);
		// 向StringBuffer追加用户名
		sb.append("&uid=").append(USERNAME);
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=").append(PASSWORD);
		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(mobile);
		// 追加模板信息

		sb.append("&template=").append(TEMPLATEFORPEOPLE);
		// 向StringBuffer追加消息内容转URL标准码

		Map<String, String> contentMap = new HashMap<>();

		contentMap.put("name", code);
		sb.append("&content=").append(URLEncoder.encode(JsonUtils.objectToJson(contentMap), "UTF-8"));
		sb.append("&encode=").append(encode);
		try {
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");

			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			// 返回发送结果
			String result = in.readLine().toString();
          
			if (result.indexOf("100") != -1) {// 短信发送成功

				return 0;

			} else if (result.indexOf("112") != -1) {// 手机号码不正确
				return 1;
			} else {
				log.info("result==" + result);
				return 2;
			}

		} catch (IOException e) {
			log.info(ExceptionUtil.getStackTrace(e));

			return 3;
		}

	}
	
	//身份验证成功
	public static int sendMessageForValidateNone(String mobile, String code) throws UnsupportedEncodingException {
		
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(SEND_URL);
		sb.append("ac=").append(AC);
		// 向StringBuffer追加用户名
		sb.append("&uid=").append(USERNAME);
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=").append(PASSWORD);
		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(mobile);
		// 追加模板信息
		
		sb.append("&template=").append(TEMPLATEFORPEOPLENONE);
		// 向StringBuffer追加消息内容转URL标准码
		
		Map<String, String> contentMap = new HashMap<>();
		
		contentMap.put("name", code);
		sb.append("&content=").append(URLEncoder.encode(JsonUtils.objectToJson(contentMap), "UTF-8"));
		sb.append("&encode=").append(encode);
		try {
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
			
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// 返回发送结果
			String result = in.readLine().toString();
			System.out.println("返回的验证码是:"+result);
			if (result.indexOf("100") != -1) {// 短信发送成功
				
				return 0;
				
			} else if (result.indexOf("112") != -1) {// 手机号码不正确
				return 1;
			} else {
				log.info("result==" + result);
				return 2;
			}
			
		} catch (IOException e) {
			log.info(ExceptionUtil.getStackTrace(e));
			
			return 3;
		}
		
	}
	
	
	//支付购买认证
	public static int sendMessageForPay(String mobile, String code) throws UnsupportedEncodingException {

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(SEND_URL);
		sb.append("ac=").append(AC);
		// 向StringBuffer追加用户名
		sb.append("&uid=").append(USERNAME);
		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=").append(PASSWORD);
		// 向StringBuffer追加手机号码
		sb.append("&mobile=").append(mobile);
		// 向StringBuffer追加消息内容
		sb.append("&content=").append(URLEncoder.encode(code, "UTF-8"));
		sb.append("&encode=").append(encode);
		sb.append("ignore=1");// 防止号码出错报112提交失败错误
		try {
			// 创建url对象
			URL url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");

			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			// 返回发送结果
			String result = in.readLine().toString();

			if (result.indexOf("100") != -1) {// 短信发送成功

				return 0;

			} else if (result.indexOf("112") != -1) {// 手机号码不正确
				return 1;
			} else {
				log.info("result==" + result);
				return 2;
			}

		} catch (IOException e) {
			log.info(ExceptionUtil.getStackTrace(e));

			return 3;
		}

	}

}
