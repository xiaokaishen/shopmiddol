package com.test.weixin.pojo;

/**
 * @ClassName: Button
 * @Description: Button类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月16日 下午2:15:38
 * @version V1.0
 */
public class Button {

	private String type;
	private String name;
	private Button[] sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

}
