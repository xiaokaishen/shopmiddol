package com.test.tools.pojo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: KdniaoTrackPojo
 * @Description: 查詢物流信息返回 pojo(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月21日 下午5:19:54
 *
 */
public class KdniaoTrackPojo {
	private Logger log = LoggerFactory.getLogger(KdniaoTrackPojo.class);

	/**
	 * 用户ID
	 */
	private String EBusinessID;
	/**
	 * 订单编号
	 */
	private String OrderCode;
	/**
	 * 快递公司编码
	 */
	private String ShipperCode;
	/**
	 * 物流运单号
	 */
	private String LogisticCode;
	/**
	 * 成功与否
	 */
	private boolean Success;
	/**
	 * 失败原因
	 */
	private String Reason;

	/**
	 * 物流状态：2-在途中,3-签收,4-问题件
	 */
	private String State;

	/**
	 * 物流轨迹信息
	 */
	private List<TracesPojo> Traces;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}

	public String getOrderCode() {
		return OrderCode;
	}

	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}

	public String getShipperCode() {
		return ShipperCode;
	}

	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return LogisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public List<TracesPojo> getTraces() {
		return Traces;
	}

	public void setTraces(List<TracesPojo> traces) {
		Traces = traces;
	}

	@Override
	public String toString() {
		return "KdniaoTrackPojo [log=" + log + ", EBusinessID=" + EBusinessID + ", OrderCode=" + OrderCode
				+ ", ShipperCode=" + ShipperCode + ", LogisticCode=" + LogisticCode + ", Success=" + Success
				+ ", Reason=" + Reason + ", State=" + State + ", Traces=" + Traces + "]";
	}

}
