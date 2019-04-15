package com.test.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: FrontTokenUtil
 * @Description: 前端验证核心类(这里用一句话描述这个类的作用) 本实例采用公匙加密输出，返回私匙解密
 * @author acai
 * @date 2018年4月11日 上午9:32:16
 *
 */
public class QingyinConfig {
	private Logger log = LoggerFactory.getLogger(QingyinConfig.class);

	public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9JOVZ6K/77cAamlVasCdePPQQC7w6d+AwIfylVgRC0BoKmRuBfllsaVT/CSxKH1QKEz+jhcY3hmTqGLdaQf/UdgfSYiQcA7s/cnHk1Xw5Gc/6L8zJ3sJOqswcn/WV1/tvzzFOqlfXzbKC6OFuKwlp1IX1szK8Ug0dM2hwKVd2RQIDAQAB";
	public static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL0k5Vnor/vtwBqaVVqwJ1489BALvDp34DAh/KVWBELQGgqZG4F+WWxpVP8JLEofVAoTP6OFxjeGZOoYt1pB/9R2B9JiJBwDuz9yceTVfDkZz/ovzMnewk6qzByf9ZXX+2/PMU6qV9fNsoLo4W4rCWnUhfWzMrxSDR0zaHApV3ZFAgMBAAECgYASUhyVFODW+jR9Xy2dVyq5ChZp53kYALyKbQBX03keL6IWHLZ5WI+43IsLGQxdMaOmRi8H29FTV4U216YK7BGni/zqhorYYSMjeof3Cw6nVC1qMGKtwrH2AJBMIGUCxU3ZG73yfBx/kisz07O9rVvbzJJOvZ0E34r3dUc6mruXEQJBAOuQiYhQqeYNE0ch8O/i5FhuYHOWh7VuQPblTHjPp5yNh/o2CGAwfHk/WFGIjADjxMSz1p5xPfVWK0F4M1CFydcCQQDNjXGvL0ZmxgWMcZporRN4wu/Nb+vOCalEBUXhvRzB7/xqZK6TG269rIMx5nVlm9a6Zwnz26/co/NjEfTSwxVDAkAM8X8tF0mOk29YvDux4qSrWz0/fKjuRiWZq1W9WaObDYfILsndByz/uIRQzpDqx5kbOcp0IELIRTjROxqOtRs3AkBtIqg1hzgt4P2ZL8f3w80O1RFVVhMw9dg1EUelLy9RmQW/x20ZFfuaIToXCHFUXYWIuqSCISYiU7op46LFNGbZAkEAjC9aVOkFP3Pp4rdgX6TTTSduB5vO9pZ2ETqrnpt/4HGmk1F6zCGLhbNnzRe1tklkLTL4sQhj+3aXeI10p4JRig==";
	public final static Map<Long, String> HOUSE_MAP = new HashMap<Long, String>();
	static {
		HOUSE_MAP.put((long) 1, "STS");// 大床房
		HOUSE_MAP.put((long) 2, "STD");// 标间
		HOUSE_MAP.put((long) 6, "LXU");// 豪华大床房
		HOUSE_MAP.put((long) 10013, "DLX");
	}
	public final static Map<Integer, String> DISCOUNT_TYPE = new HashMap<Integer, String>();
	static {
		DISCOUNT_TYPE.put(1, "青隐商城");
		DISCOUNT_TYPE.put(2, "隐艺会会所");
		DISCOUNT_TYPE.put(3, "隐艺会私房菜");
		DISCOUNT_TYPE.put(5, "隐艺会酒店适用");
		DISCOUNT_TYPE.put(6, "隐艺会餐饮适用");
		DISCOUNT_TYPE.put(7, "隐艺会通用卷");

	}

	/**
	 * S预订 I在住 C取消和失效 O离店
	 */
	public static final String[] HOUSE_ORDER_STATUS = { "S", "", "I", "C", "O" };

	/**
	 * 根据元素获取下标
	 */

	public static int getStatusIndex(String str) {
		int k = -1;// 定义变量保存指定元素的下标
		for (int i = 0; i < HOUSE_ORDER_STATUS.length; i++) {
			if (HOUSE_ORDER_STATUS[i].equals(str)) {
				k = i;
			}
		}
		return k;
	}

}
