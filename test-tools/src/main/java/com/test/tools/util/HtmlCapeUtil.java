package com.test.tools.util;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @ClassName: HtmlCapeUtil
 * @Description: HTML转义和反转义
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年9月22日 上午11:12:18
 * @version V1.0
 */
public final class HtmlCapeUtil {
	/**
	 * 对HTML进行转义
	 * 
	 * @param html未转义HTML
	 * @return 转义后的字符串
	 */
	public static String escapeHtml(String html) {

		String result = StringEscapeUtils.escapeHtml4(html);

		return result;

	}

	/**
	 * 对HTML进行反转义
	 * 
	 * @param 转义字符串
	 * @return 转义后HTML
	 */
	public static String unescapeHtml(String str) {

		String result = StringEscapeUtils.unescapeHtml4(str);

		return result;

	}

}
