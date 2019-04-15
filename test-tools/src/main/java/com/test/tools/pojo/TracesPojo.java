package com.test.tools.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 物流轨迹信息
 * 
 * @ClassName: TracesPojo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月21日 下午5:19:34
 *
 */
public class TracesPojo {
	private Logger log = LoggerFactory.getLogger(TracesPojo.class);
	/**
	 * 时间
	 */
	private String AcceptTime;
	/**
	 * 描述
	 */
	private String AcceptStation;
	/**
	 * 备注
	 */
	private String Remark;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getAcceptTime() {
		return AcceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		AcceptTime = acceptTime;
	}

	public String getAcceptStation() {
		return AcceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		AcceptStation = acceptStation;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	@Override
	public String toString() {
		return "TracesPojo [log=" + log + ", AcceptTime=" + AcceptTime + ", AcceptStation=" + AcceptStation
				+ ", Remark=" + Remark + "]";
	}

}
