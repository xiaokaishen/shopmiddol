package com.test.smallApp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.weixin.pojo.Token;
import com.test.weixin.utils.TokenUtil;

public class SmallTokenThread implements Runnable {
	private Logger log = LoggerFactory.getLogger(SmallTokenThread.class);
	@Override
	public void run() {
		while (true) {

			try {

				Token accessToken = TokenUtil.getAccess_Token(SmallAppConstant.Access_Token_Url, SmallAppConstant.AppID,
						SmallAppConstant.AppSecret);

				if (null != accessToken) {

					TokenUtil.saveSmallAppToken(accessToken);
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
