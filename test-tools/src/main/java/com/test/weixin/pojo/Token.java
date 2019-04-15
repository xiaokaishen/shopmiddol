package com.test.weixin.pojo;

/**
 * @ClassName: Token
 * @Description: TODO
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月15日 下午2:12:43
 * @version V1.0
 */
public class Token {

	private String access_token;//// 接口访问凭证

	private Double expires_in;// 凭证有效期，单位：秒

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Double getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Double expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}
	
	

}
