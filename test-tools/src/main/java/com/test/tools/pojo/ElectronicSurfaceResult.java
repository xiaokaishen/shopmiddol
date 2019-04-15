package com.test.tools.pojo;

/**
 * 
 * @ClassName: ElectronicSurfaceResult
 * @Description: 快递鸟电子面单返回结果(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月13日 下午1:04:22
 *
 */
public class ElectronicSurfaceResult {

	private String EBusinessID;// 用户ID
	private ResultOrder Order;// 订单信息

	private boolean Success;// 成功与否

	private String ResultCode;// 错误编码

	private String Reason;// 失败原因

	private String UniquerRequestNumber;// 唯一标识

	private String PrintTemplate;// 面单打印模板

	private String EstimatedDeliveryTime;// 订单预计到货时间yyyy-mm-dd

	private String Callback;// 用户自定义回调信息

	private Integer SubCount;// 子单数量

	private String SubOrders;// 子单号

	private String SubPrintTemplates;// 子单模板

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}

	public ResultOrder getOrder() {
		return Order;
	}

	public void setOrder(ResultOrder order) {
		Order = order;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public String getResultCode() {
		return ResultCode;
	}

	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getUniquerRequestNumber() {
		return UniquerRequestNumber;
	}

	public void setUniquerRequestNumber(String uniquerRequestNumber) {
		UniquerRequestNumber = uniquerRequestNumber;
	}

	public String getPrintTemplate() {
		return PrintTemplate;
	}

	public void setPrintTemplate(String printTemplate) {
		PrintTemplate = printTemplate;
	}

	public String getEstimatedDeliveryTime() {
		return EstimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		EstimatedDeliveryTime = estimatedDeliveryTime;
	}

	public String getCallback() {
		return Callback;
	}

	public void setCallback(String callback) {
		Callback = callback;
	}

	public Integer getSubCount() {
		return SubCount;
	}

	public void setSubCount(Integer subCount) {
		SubCount = subCount;
	}

	public String getSubOrders() {
		return SubOrders;
	}

	public void setSubOrders(String subOrders) {
		SubOrders = subOrders;
	}

	public String getSubPrintTemplates() {
		return SubPrintTemplates;
	}

	public void setSubPrintTemplates(String subPrintTemplates) {
		SubPrintTemplates = subPrintTemplates;
	}

	@Override
	public String toString() {
		return "ElectronicSurfaceResult [EBusinessID=" + EBusinessID + ", Order=" + Order + ", Success=" + Success
				+ ", ResultCode=" + ResultCode + ", Reason=" + Reason + ", UniquerRequestNumber=" + UniquerRequestNumber
				+ ", PrintTemplate=" + PrintTemplate + ", EstimatedDeliveryTime=" + EstimatedDeliveryTime
				+ ", Callback=" + Callback + ", SubCount=" + SubCount + ", SubOrders=" + SubOrders
				+ ", SubPrintTemplates=" + SubPrintTemplates + "]";
	}

}
