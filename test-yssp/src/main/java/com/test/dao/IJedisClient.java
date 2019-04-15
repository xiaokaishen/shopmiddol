package com.test.dao;

public interface IJedisClient {

	/**
	 * 根据key获取redis值
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 给某个key赋值
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);

	/**
	 * 
	 * @param key
	 * @return
	 */
	long incr(String key);

	Long hset(String hkey, String key, String value);

	String hget(String hkey, String key);

	Long del(String key);

	Long hdel(String hkey, String key);

	Long expire(String key, int second);

}
