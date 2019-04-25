package com.test.pojo;


import java.util.Map;

public class WxMssVo {
	/**
	 * 用户openid
	 */
    private String touser;
	/**
	 * 模版id
	 */
	private String template_id;
//    private String page = "pages/index/index";//默认跳到小程序首页
//    private String page = "pages/modal-test/modal-test";//默认跳到小程序缓存页
	/**
	 * 收集到的用户formid
	 */
    private String form_id;
//    private String emphasis_keyword = "keyword1.DATA";//放大那个推送字段
	/**
	 * 推送文字
	 */
    private Map<String, TemplateData> data;


	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id(String templateId) {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
//	public String getPage() {
//		return page;
//	}
//	public void setPage(String page) {
//		this.page = page;
//	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}

    
}
