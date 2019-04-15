package com.test.tools.pojo;

import java.util.List;

/**
 * 
 * @ClassName: ElectronicSurfacePojo
 * @Description: 快递鸟电子面单接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月13日 上午10:59:15
 *
 */
public class ElectronicSurface {

	private String OrderCode;// 订单编号

	private String ShipperCode;// 快递公司编码

	private Integer PayType;// 邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
	private Integer ExpType;// 快递类型：1-标准快件
	private Double Cost;// 寄件费（运费）
	private Double OtherCost;// 其他费用
	private Sender Sender;// 发件人信息
	private Receiver Receiver;// 收件人信息

	private List<Commodity> Commodity;// 商品信息封装

	private Double Weight;// 物品总重量

	private Integer Quantity;// 件数/包裹数

	private Double Volume;// 物品总体积

	private String Remark;// 备注信息

	private String IsReturnPrintTemplate;// 返回电子面单模板：0-不需要；1-需要

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

	public Integer getPayType() {
		return PayType;
	}

	public void setPayType(Integer payType) {
		PayType = payType;
	}

	public Integer getExpType() {
		return ExpType;
	}

	public void setExpType(Integer expType) {
		ExpType = expType;
	}

	public Double getCost() {
		return Cost;
	}

	public void setCost(Double cost) {
		Cost = cost;
	}

	public Double getOtherCost() {
		return OtherCost;
	}

	public void setOtherCost(Double otherCost) {
		OtherCost = otherCost;
	}

	public Sender getSender() {
		return Sender;
	}

	public void setSender(Sender sender) {
		Sender = sender;
	}

	public Receiver getReceiver() {
		return Receiver;
	}

	public void setReceiver(Receiver receiver) {
		Receiver = receiver;
	}

	public List<Commodity> getCommodity() {
		return Commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		Commodity = commodity;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getVolume() {
		return Volume;
	}

	public void setVolume(Double volume) {
		Volume = volume;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getIsReturnPrintTemplate() {
		return IsReturnPrintTemplate;
	}

	public void setIsReturnPrintTemplate(String isReturnPrintTemplate) {
		IsReturnPrintTemplate = isReturnPrintTemplate;
	}

	@Override
	public String toString() {
		return "ElectronicSurface [OrderCode=" + OrderCode + ", ShipperCode=" + ShipperCode + ", PayType=" + PayType
				+ ", ExpType=" + ExpType + ", Cost=" + Cost + ", OtherCost=" + OtherCost + ", Sender=" + Sender
				+ ", Receiver=" + Receiver + ", Commodity=" + Commodity + ", Weight=" + Weight + ", Quantity="
				+ Quantity + ", Volume=" + Volume + ", Remark=" + Remark + ", IsReturnPrintTemplate="
				+ IsReturnPrintTemplate + "]";
	}

}
