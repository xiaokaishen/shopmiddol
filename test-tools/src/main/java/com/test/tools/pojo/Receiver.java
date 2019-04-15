package com.test.tools.pojo;

/**
 * 
 * @ClassName: Receiver
 * @Description: 快递鸟电子面单收件人信息pojo(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月13日 上午11:15:36
 *
 */
public class Receiver {

	private String Company;// 收件人公司

	private String Name;// 收件人

	private String Tel;// 电话与手机，必填一个

	private String Mobile;// 电话与手机，必填一个

	private String PostCode;// 收件人邮编

	private String ProvinceName;// 收件省（如广东省，不要缺少“省”

	private String CityName;// 收件市（如深圳市，不要缺少“市”）

	private String ExpAreaName;// 收件区（如福田区，不要缺少“区”或“县”）

	private String Address;

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getExpAreaName() {
		return ExpAreaName;
	}

	public void setExpAreaName(String expAreaName) {
		ExpAreaName = expAreaName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}// 收件人详细地址

	@Override
	public String toString() {
		return "Receiver [Company=" + Company + ", Name=" + Name + ", Tel=" + Tel + ", Mobile=" + Mobile + ", PostCode="
				+ PostCode + ", ProvinceName=" + ProvinceName + ", CityName=" + CityName + ", ExpAreaName="
				+ ExpAreaName + ", Address=" + Address + "]";
	}

}
