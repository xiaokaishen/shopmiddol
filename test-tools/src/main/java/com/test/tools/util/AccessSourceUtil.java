package com.test.tools.util;

/**
 * 访问来源判断Util
 * 
 * @ClassName: AccessSourceUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月17日 下午5:00:04
 *
 */
public class AccessSourceUtil {

	private final static String[] agent = { "Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser" }; // 定义移动端请求的所有可能类型
	/**
	 * 判断User-Agent 是不是来自于手机
	 * 
	 * @param ua
	 * @return
	 */
	public static boolean checkAgentIsMobile(String ua) {
		boolean flag = false;
		if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
			// 排除 苹果桌面系统
			if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
				for (String item : agent) {
					if (ua.contains(item)) {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}
}
