package com.test.tools.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName: RedisUtil
 * @Description: redis缓存工具类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年4月12日 上午11:06:53
 *
 */
public class RedisUtil {
	private static Logger log = LoggerFactory.getLogger(RedisUtil.class);

	public static final String REDIS_URL = "127.0.0.1";
	public static final Integer REDIS_PORT = 6379;
	public static final String REDIS_SESSION_KEY = "USER_SESSION_KEY";
	public static final Integer REDIS_SESSION_EXPIRE = 1800;

	public static String getkeyToValve(String key) {

		String result = "";

		Jedis jedis = new Jedis(REDIS_URL, REDIS_PORT);
		try {

			result = jedis.get(REDIS_SESSION_KEY + ":" + key);

			if (StringUtil.isEmptyNo(result)) {// 不为空
				jedis.expire(REDIS_SESSION_KEY + ":" + key, REDIS_SESSION_EXPIRE);

			}

		} catch (Exception e) {
			log.info("Base转码失败" + ExceptionUtil.getStackTrace(e));
		} finally {
			jedis.close();

		}

		return result;

	}

	public static String getUser(HttpServletRequest request) throws Exception {
		String key = request.getHeader("Authorization");
		log.info("key===" + key);

		String result = "";
		// byte[] encodedData;

		Jedis jedis = new Jedis(REDIS_URL, REDIS_PORT);
		try {
			/*
			 * encodedData = Base64Utils.decode(key); byte[] decodedData =
			 * RSAUtils.decryptByPrivateKey(encodedData,
			 * FrontTokenUtil.privateKey); key = new String(decodedData);
			 */

			result = jedis.get(REDIS_SESSION_KEY + ":" + key);
			log.info("result===" + result);

		} catch (Exception e) {
			log.info("Base转码失败" + ExceptionUtil.getStackTrace(e));
		} finally {
			jedis.close();

		}
		return result;

	}

}
