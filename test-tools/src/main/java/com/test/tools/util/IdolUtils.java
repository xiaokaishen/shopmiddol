package com.test.tools.util;

import java.math.BigDecimal;

/**
 * @ClassName: IdolUtils
 * @Description: 数据类型转换工具类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年10月9日 下午3:37:16
 * @version V1.0
 */

final public class IdolUtils {

	/**
	 * <将obj转换为string，如果obj为null则返回defaultVal>
	 * 
	 * @param obj
	 *            需要转换为string的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换为string
	 */
	public static String toString(Object obj, String defaultVal) {
		return (obj != null) ? obj.toString() : defaultVal;
	}

	/**
	 * <将obj转换为string，默认为空>
	 * 
	 * @param obj
	 *            需要转换为string的对象
	 * @return 将对象转换为string的字符串
	 */
	public static String toString(Object obj) {
		return toString(obj, "");
	}

	/**
	 * <将对象转换为int>
	 * 
	 * @param obj
	 *            需要转换为int的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换成的int值
	 */
	public static Integer toInt(Object obj, Integer defaultVal) {
		try {
			return (obj != null) ? Integer.parseInt(toString(obj, "0")) : defaultVal;
		} catch (Exception e) {
		}
		return defaultVal;
	}

	/**
	 * <将对象转换为int>
	 * 
	 * @param obj
	 *            需要转换为int的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换成的int值
	 */
	public static Integer toInt(Object obj) {
		return toInt(obj, 0);
	}

	/**
	 * <将对象转换为int>
	 * 
	 * @param obj
	 *            需要转换为int的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换成的int值
	 */
	public static Byte toByte(Object obj, Byte defaultVal) {
		try {
			return (obj != null) ? Byte.parseByte(toString(obj, "0")) : defaultVal;
		} catch (Exception e) {
		}
		return defaultVal;
	}

	/**
	 * <将对象转换为Byte>
	 * 
	 * @param obj
	 *            需要转换为Byte的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换成的Byte值
	 */
	public static Byte toByte(Object obj) {
		return toByte(obj, (byte) 0);
	}

	/**
	 * <将对象转换为Integer>
	 * 
	 * @param obj
	 *            需要转换为Integer的对象
	 * @return obj转换成的Integer值
	 */
	public static Integer toInteger(Object obj) {
		return toInt(obj, null);
	}

	/**
	 * <将对象转换为float>
	 * 
	 * @param obj
	 *            需要转换为float的对象
	 * @param defaultVal
	 *            默认值
	 * @return obj转换成的float值
	 */
	public static Float toFloat(Object obj, float defaultVal) {
		return (obj != null) ? Float.parseFloat(toString(obj, "0")) : defaultVal;
	}

	/**
	 * <将对象转换为Float>
	 * 
	 * @param obj
	 *            需要转换为Float的对象
	 * @return obj转换成的Float值
	 */
	public static Float toFloat(Object obj) {
		return toFloat(obj, 0);
	}

	/**
	 * <将obj转换为long>
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @param defaultVal
	 *            默认值
	 * @return 如果obj为空则返回默认，不为空则返回转换后的long结果
	 */
	public static Long toLong(Object obj, long defaultVal) {
		return (obj != null) ? Long.parseLong(toString(obj)) : defaultVal;
	}

	/**
	 * <将obj转换为long>
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 如果obj为空则返回默认的0l，不为空则返回转换后的long结果
	 */
	public static Long toLong(Object obj) {
		return toLong(obj, 0l);
	}

	/**
	 * 将object转换为double类型，如果出错则返回 defaultVal
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @param defaultVal
	 *            默认值
	 * @return 转换后的结果
	 */
	public static Double toDouble(Object obj, Double defaultVal) {
		try {
			return Double.parseDouble(obj.toString());
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * 将object转换为double类型，如果出错则返回 0d
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 转换后的结果
	 */
	public static double toDouble(Object obj) {
		return toDouble(obj, 0d);
	}

	/**
	 * 将object转换为BigDecimal类型，如果出错则返回 defaultVal
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @param d
	 *            默认值
	 * @return 转换后的结果
	 */
	public static BigDecimal ToDecimal(Object obj, BigDecimal defaultVal) {

		try {
			return BigDecimal.valueOf(Double.parseDouble(String.valueOf(obj)));
		} catch (Exception e) {
			return defaultVal;
		}

	}

	/**
	 * 将object转换为BigDecimal类型，如果出错则返回 0d
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 转换后的结果
	 */
	public static BigDecimal ToDecimal(Object obj) {
		return ToDecimal(obj, BigDecimal.valueOf(0d));
	}

	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static double getRandom(Object begin, Object end) {
		double random = Math.random();
		double beginDouble = IdolUtils.toDouble(begin);
		double endDouble = IdolUtils.toDouble(end);

		double result = 0;

		if (beginDouble < endDouble) {
			result = random * (endDouble - beginDouble) + beginDouble;
		} else if (beginDouble == endDouble) {
			result = endDouble;
		} else {
			result = random * (beginDouble - endDouble) + endDouble;
		}

		result = (double) Math.round(result * 100) / 100;

		return result;

	}

}
