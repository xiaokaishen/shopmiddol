package com.test.tools.pojo;

/**
 * 
 * @ClassName: ResultOrder
 * @Description: 电子面单返回结果订单信息(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月13日 下午1:07:01
 *
 */
public class ResultOrder {

	private String OrderCode;// 订单编号

	private String ShipperCode;// 快递公司编码

	private String LogisticCode;// 快递单号

	private String MarkDestination;// 大头笔

	private String OriginCode;// 始发地区域编码

	private String OriginName;// 始发地/始发网点

	private String DestinatioCode;// 目的地区域编码

	private String DestinatioName;// 目的地/到达网点

	private String SortingCode;// 分拣编码

	private String PackageCode;// 集包编码

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

	public String getMarkDestination() {
		return MarkDestination;
	}

	public void setMarkDestination(String markDestination) {
		MarkDestination = markDestination;
	}

	public String getOriginCode() {
		return OriginCode;
	}

	public void setOriginCode(String originCode) {
		OriginCode = originCode;
	}

	public String getOriginName() {
		return OriginName;
	}

	public void setOriginName(String originName) {
		OriginName = originName;
	}

	public String getDestinatioCode() {
		return DestinatioCode;
	}

	public void setDestinatioCode(String destinatioCode) {
		DestinatioCode = destinatioCode;
	}

	public String getDestinatioName() {
		return DestinatioName;
	}

	public void setDestinatioName(String destinatioName) {
		DestinatioName = destinatioName;
	}

	public String getSortingCode() {
		return SortingCode;
	}

	public void setSortingCode(String sortingCode) {
		SortingCode = sortingCode;
	}

	public String getPackageCode() {
		return PackageCode;
	}

	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}

	@Override
	public String toString() {
		return "ResultOrder [OrderCode=" + OrderCode + ", ShipperCode=" + ShipperCode + ", LogisticCode=" + LogisticCode
				+ ", MarkDestination=" + MarkDestination + ", OriginCode=" + OriginCode + ", OriginName=" + OriginName
				+ ", DestinatioCode=" + DestinatioCode + ", DestinatioName=" + DestinatioName + ", SortingCode="
				+ SortingCode + ", PackageCode=" + PackageCode + "]";
	}

}
