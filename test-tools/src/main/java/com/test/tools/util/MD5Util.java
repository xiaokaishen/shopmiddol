package com.test.tools.util;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @ClassName: MD5Util
 * @Description: 对一个数字进行MD5加密和解密
 * @author acai
 * @date 2017年8月28日 下午1:38:28
 *
 */
public class MD5Util {

	/**
	 * MD5加密
	 * 
	 * @param str
	 *            内容
	 * @param charset
	 *            编码方式
	 * @throws Exception
	 */
	public static String MD5(String str, String charset) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes(charset));
		byte[] result = md.digest();
		StringBuffer sb = new StringBuffer(32);
		for (int i = 0; i < result.length; i++) {
			int val = result[i] & 0xff;
			if (val <= 0xf) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(val));
		}
		return sb.toString().toLowerCase();
	}

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("∩");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/***
	 * MD5加密 生成32位md5码
	 */
	public static String stringMD5(String inStr) {
		return string2MD5(string2MD5(inStr));

	}

	/**
	 * 加密解密算法
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}

	public static void main(String[] args) {
		UUID randomUUID = UUID.randomUUID();

		System.out.println(randomUUID);
	}

}
