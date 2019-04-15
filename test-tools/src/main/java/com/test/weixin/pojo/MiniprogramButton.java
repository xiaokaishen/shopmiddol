package com.test.weixin.pojo;

/**
 * 小程序菜单按钮
 * @author EvenChen
 *
 */
public class MiniprogramButton extends Button{
	
	//小程序APPID
	String appid;
	
	String url;
	
	//小程序跳转路径
	String pagePath;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	
	
}
