package com.test.tools.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串操作工具类
 * @author acai
 * @date 2017年8月28日 下午1:50:27
 *
 */
public class StringUtil {

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 *            字符串de长度
	 * @return
	 */
	protected static String randomInt(int length) {
		String randomNum = String.valueOf(Math.random());
		randomNum = randomNum.replace(".", "");
		randomNum = randomNum.substring(0, length);
		return randomNum;
	}

	/**
	 * 判断一个字符串为空
	 */

	public static Boolean isEmpty(String str) {
		if (str == null || str.length() <= 0) {

			return true;
		} else {

			return false;
		}

	}

	/**
	 * 判断一个字符串不为空
	 */

	public static Boolean isEmptyNo(String str) {
		return !isEmpty(str);

	}

	/**
	 *  获取客户端真实的ip地址
	 */
	public static String getClientIpAddress(HttpServletRequest request) {
		String clientIp = request.getHeader("x-forwarded-for");
		String ipAddresses = request.getHeader("X-Forwarded-For");
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("X-Real-IP");
		}
		if (ipAddresses != null && ipAddresses.length() != 0) {
			clientIp = ipAddresses.split(",")[0];
		}
		if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			clientIp = request.getRemoteAddr();
		}

		return clientIp;
	}

	/**
	 * int 转汉字
	 * 
	 * @param string
	 * @return
	 */
	public static String toChinese(int string) {
		String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

		String result = "";

		int n = IdolUtils.toString(string).length();
		for (int i = 0; i < n; i++) {

			int num = IdolUtils.toString(string).charAt(i) - '0';

			if (i != n - 1 && num != 0) {
				result += s1[num] + s2[n - 2 - i];
			} else {
				result += s1[num];
			}
		}

		return result;

	}
	
	
	/**
	 * 将物流公司编码转换为物流公司
	 * 暂只支持常用的物流公司 返回物流编码 请顾客自行根据编码查找对应的物流公司
	 * @param logisticsCode
	 * @return
	 */
	public static String code2LogisticsCompany(String logisticsCode){
		  if("SF".equals(logisticsCode)){
			  return "顺丰速运";
		  }else if("HTKY".equals(logisticsCode)){
			  return "百世快递";
		  }else if("ZTO".equals(logisticsCode)){
			  return "中通快递";
		  }else if("STO".equals(logisticsCode)){
			  return "申通快递";
		  }else if("YTO".equals(logisticsCode)){
			  return "圆通快递";
		  }else if("YD".equals(logisticsCode)){
			  return "韵达速递";
		  }else if("YZPY".equals(logisticsCode)){
			  return "邮政快递包裹";
		  }else if("EMS".equals(logisticsCode)){
			  return "EMS";
		  }else if("HHTT".equals(logisticsCode)){
			  return "天天快递";
		  }else if("JD".equals(logisticsCode)){
			  return "京东快递";
		  }else if("UC".equals(logisticsCode)){
			  return "优速快递";
		  }else if("DBL".equals(logisticsCode)){
			  return "德邦快递";
		  }else if("ZJS".equals(logisticsCode)){
			  return "宅急送";
		  }else if("TNT".equals(logisticsCode)){
			  return "TNT快递";
		  }else if("UPS".equals(logisticsCode)){
			 return "UPS";  
		  }else if("DHL".equals(logisticsCode)){
			  return "DHL";
		  }else if("FEDEX".equals(logisticsCode)){
			  return "FEDEX联邦(国内件）";
		  }else if("FEDEX_GJ".equals(logisticsCode)){
			  return "FEDEX联邦(国际件）";
		  }
   		  return logisticsCode+",本公司暂不支持该物流公司,如要知道对应的物流公司，请持对应的物流编码到快递鸟查询,给你造成的不便我们深感遗憾(┬＿┬)";
	}
	
	
	
	
	
	

}
