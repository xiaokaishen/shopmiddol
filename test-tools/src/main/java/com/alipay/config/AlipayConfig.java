package com.alipay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.currency.config.CurrencyConfig;

/**
 * 
 * @ClassName: AlipayConfig
 * @Description: 支付宝静态模块接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年3月12日 下午2:39:20
 *
 */
public final class AlipayConfig {
	/**
	 * 应用号
	 */
	public static String APPID = "2018031202357840";
	/**
	 * 商户的私钥
	 */
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCY/AqVdulurrjJVuiyrOjvV8TAcd52+XYGDxLeKCqpeGMWAuiiGVlj68oTxopKvqmDcwqI6clYDCp14rM2z0FkfmLr6mqHqDlrs1Sl6qmLp7Swtqpty0+641Oqbr7BOH/RR1sjUu3vQ+AYbBaiYRHm42FYkBnI4rWC0iGsK+sxGp2xxwquv9puFMFOq4jqBtamepAiK5T393CVKv5srnMXSzl1nyaScE3ubzOcGbmvSLMJeLa+lD78gNYhWKKNyYQwGIreArFLVCsgGEOQSLkN1DHweEq3m+juu5jtb7s9oxynW2NMz2XgKXhCJbpAHFB5fkjY4lGtkZNB7Y0ubTUJAgMBAAECggEAaujf4JmsAexaOGHi1lKdqf1VAwPQaqZkg1FvZw782VfHLu+zcOx0Gq8BlhZOOHPLdJAlkY6HZV+DIMTfZvMpiLgGG0XDUrAOCKTXB+fYuj7luAS/T2Egg8MvidBAwDjiofbSyvm+S1HMvmRy4OEjKI5ITiLN0iQUoqqEW5SJlNMnPV84CqiRoud2OKSbrpUj/xWI23TACKFDu3Z5xclEmRNQLgvo5jrqUVqVc87ngigy32Q8LwItShyBO7tkBvr6vCRamJWr5dTn1gEzrDjNKq20P1gV0f6C62YANnVFjEqV6DVLEUWFZie9wPZN368GlI/YJT9+Nhjjph4WhR84AQKBgQDGU/KjxbiWgzNQuVRPHrdhwqoR3fwwQQ/78L2V5NJazcakBlLPa6Rli+3iz1N+XowR0daSt/zXCHKmtCA8yssQd7Dr/2ZkcgAN8IoNQYWrMUX0Nh0t98L2Sbf1KcUBpjVN+4olXFRl8eR2clmzSN09n+8slZORwQHlqTUzDjhhAQKBgQDFeJzZjfPzkcDUQG3vRaKVH8WD98QHykayDTcZGbXFJ/a6dtDWbUncltGzi1h4wxA73kP8T1r5i414fM5rU6/4LtfbQTuRmUW6Zoj3G9q6zWiOYXCKxRaz4nS8snhvV1Zc/XyKYsB2y9kG4hdwH7GPJ5OtxDCkLeucxCAKvCXMCQKBgAj5x6Nt0VrOeUYP/SbPhxEflD7WwxEUALswPARKpNKDOZg2yQymHHyUBqIbK/YuJTyxOHrPZNv+f+HXiRX3P5VxNUqY9nNZTXNUDYtoCbqjsjzJLizkZ6hp0a+Awm++q+7pkWj7cr5iYiqSJkkc5RZi5Jop8tHH4GQaclPrMtYBAoGAAPO/7dydXINLZrqYzRqM2iM5FJXRQChdhuZBacGR+s1ihyujfiUwwfuIL1Fwr8RhA6jiswi+640ctYQEisfwhUXUjJ4X52/RwkBUULy1pUjwRB98J28j2OIypeZGZmMJa5FdVF19iBUbisj0S/obJRGPyLq1cVU3WZ4oeWTG2eECgYEAlIFYIr8lCLNKTJTIXlyKYtKP6X2Un/SOBc7LTA6Fnj+bIaytSbSdjokmq9pj+dmcm7zm6/VJmlQeHZLAPVqyAyES1QKVl2qPqUDu/nZ80Uefe7PwxVtEIqN4VwYPTmA6G8RR9htPg3bNzlDT/fbN+OiT0BeQeJqu6PWiVwa+cyg=";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = CurrencyConfig.Front_Url + "/aliPay/notify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 商户可以自定义同步跳转地址
	public static String return_url = CurrencyConfig.Front_WX_Url + "/pay/return";
	/**
	 * 支付宝网关地址
	 */
	public static String URL = "https://openapi.alipay.com/gateway.do";
	/**
	 * 编码
	 */
	public static String CHARSET = "UTF-8";
	/**
	 * 参数类型
	 */
	public static String FORMAT = "json";
	/**
	 * 支付宝公钥
	 */
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgM0K8QYZkOT/dBGnyCAr5fVoyX85edV2B13RtbkwX/jEBM9z0e2WXCWO0JAxh621rf3RaSefOaE/HWmAUkH7ZQ8O6jiqS9sLTIYDY/IXnAz7g4BfU5NSVlxngfkB0ha+TvdzLFHuT5ScOaq7fILlS7gNoRy9LI/R7KdkYobqY89ye3WIguEvyNuKKOkwVXanp7GnRTuRduowHdBK/tCQNWQEw2KzYwSNM9xFLBlnban1DdST15vJ9fuaJzy1trTJ5uJPZrJNy6ft/V5xpJxLgeY0LsBIRM+L7PkUgyjqYXnBKoQpwdVCVbCMRkfKv22kBEMd7PKRUpV/n+BvaTxGwwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

	/**
	 * 支付宝请求客户端入口
	 */
	private volatile static AlipayClient alipayClient = null;

	/**
	 * 不可实例化
	 */
	private AlipayConfig() {
	};

	/**
	 * 双重锁单例
	 * 
	 * @return 支付宝请求客户端实例
	 */
	public static AlipayClient getInstance() {
		if (alipayClient == null) {
			synchronized (AlipayConfig.class) {
				if (alipayClient == null) {
					alipayClient = new DefaultAlipayClient(URL, APPID, RSA_PRIVATE_KEY, FORMAT, CHARSET,
							ALIPAY_PUBLIC_KEY, SIGNTYPE);
				}
			}
		}
		return alipayClient;
	}

}
