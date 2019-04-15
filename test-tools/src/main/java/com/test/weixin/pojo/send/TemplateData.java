package com.test.weixin.pojo.send;

/**
 * 
 * @ClassName: TemplateData
 * @Description: 模板数据(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年5月4日 下午5:06:51
 *
 */
public class TemplateData {
	private String value;// 模板显示值
	private String color;// 模板显示颜色

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
