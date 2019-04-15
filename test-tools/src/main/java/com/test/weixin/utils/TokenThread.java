package com.test.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.weixin.pojo.Token;

/**
 * @ClassName: TokenThread
 * @Description: 获取access_token线程
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月14日 下午4:35:05
 * @version V1.0
 */
public class TokenThread implements Runnable {
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);

	@Override
	public void run() {
		while (true) {

			try {

				Token accessToken = TokenUtil.getAccess_Token(WXConstant.GET_ACCESS_TOKEN_URL, WXConstant.AppID,
						WXConstant.AppSecret);

				if (null != accessToken) {

					TokenUtil.saveToken(accessToken);
					log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpires_in(),
							accessToken.getAccess_token());
					// 7000秒之后重新进行获取
					Thread.sleep((7000 - 200) * 1000);

				} else {
					// 获取失败时，60秒之后尝试重新获取
					Thread.sleep(60 * 1000);

				}

			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}

		}
	}

}
