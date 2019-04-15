package com.test.weixin.pojo.send;

import java.util.TreeMap;

/**
 * 
 * @ClassName: WechatTemplateMsg
 * @Description: 微信模板消息封装实体类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月4日 下午5:02:55
 *
 */
public class WxTemplate {

	private String touser; // 接收者openid
	private String template_id; // 模板ID
	private String url; // 模板跳转链接
	private TreeMap<String, TreeMap<String, String>> data; // data数据

	/**
	 * 参数
	 * 
	 * @param value
	 * @param color
	 *            可不填
	 * @return
	 */
	public static TreeMap<String, String> item(String value, String color) {
		TreeMap<String, String> params = new TreeMap<String, String>();
		value = value.replace("，点击查看详情", "");

		params.put("value", value);
		params.put("color", color);
		return params;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TreeMap<String, TreeMap<String, String>> getData() {
		return data;
	}

	public void setData(TreeMap<String, TreeMap<String, String>> data) {
		this.data = data;
	}

}
