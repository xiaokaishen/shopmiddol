package com.test.weixin.pojo;

/**
 * 票据封装pojo
 * 
 * @ClassName: Ticket
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年7月23日 下午4:14:26
 *
 */
public class Ticket {

	// 临时票据
	private String ticket;
	// 过期时间
	private Integer expires_in;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "Ticket [ticket=" + ticket + ", expires_in=" + expires_in + "]";
	}

}
