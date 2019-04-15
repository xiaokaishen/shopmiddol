package com.test.tools.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.tools.pojo.Commodity;
import com.test.tools.pojo.ElectronicSurface;
import com.test.tools.pojo.Receiver;
import com.test.tools.pojo.Sender;

/**
 * 
 * @ClassName: KdniaoTrackQueryAPI
 * @Description: 快递鸟物流轨迹查询接口(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年6月21日 下午5:06:57
 *
 */
public class KdniaoTrackQueryUtil {

	// 电商ID
	private static final String EBusinessID = "1354506";
	// 电商加密私钥，快递鸟提供，注意保管，不要泄漏
	private static final String AppKey = "12c4ca91-76ae-47f0-8f33-bc07d3962a75";
	// 物流轨迹实时查询url
	private static final String ReqURL = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";

	// 请求url, 正式环境地址：http://api.kdniao.cc/api/Eorderservice
	// 测试环境地址：http://testapi.kdniao.cc:8081/api/EOrderService
	private static String electronicSurfaceUrl = "http://testapi.kdniao.cc:8081/api/Eorderservice";

	/**
	 * test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ElectronicSurface electronicSurface = new ElectronicSurface();

		electronicSurface.setOrderCode("012657700387");
		electronicSurface.setShipperCode("SF");
		electronicSurface.setPayType(1);
		electronicSurface.setExpType(1);
		electronicSurface.setCost(55.55);
		electronicSurface.setOtherCost(0.0);

		Sender sender = new Sender();// 发货人信息
		sender.setCompany("LV");
		sender.setName("Taylor");
		sender.setMobile("15018442396");
		sender.setProvinceName("上海");
		sender.setCityName("上海市");
		sender.setExpAreaName("青浦区");
		sender.setAddress("明珠路73号");

		electronicSurface.setSender(sender);// 收货人信息
		Receiver receiver = new Receiver();
		receiver.setCompany("GCCUI");
		receiver.setName("Yann");
		receiver.setMobile("15018442396");
		receiver.setProvinceName("北京");
		receiver.setCityName("北京市");
		receiver.setExpAreaName("朝阳区");
		receiver.setAddress("三里屯街道雅秀大厦");
		electronicSurface.setReceiver(receiver);

		// 封装货物信息

		List<Commodity> list = new ArrayList<Commodity>();

		Commodity commodity = new Commodity();

		commodity.setGoodsName("鞋子");
		commodity.setGoodsWeight(1.0);
		commodity.setGoodsquantity(1);

		list.add(commodity);

		electronicSurface.setCommodity(list);

		electronicSurface.setWeight(5.0);
		electronicSurface.setQuantity(1);
		electronicSurface.setVolume(0.0);
		electronicSurface.setRemark("这是一个测试下单");
		electronicSurface.setIsReturnPrintTemplate("1");

		String result;
		try {
			result = KdniaoTrackQueryUtil.getOrderTracesByJson("ZTO", "221456718538");
			System.out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 快递鸟电子面单
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String electronicSurface(ElectronicSurface electronicSurface) throws Exception {

		Map<String, String> params = new HashMap<String, String>();
		params.put("RequestData", URLEncoder.encode(JsonUtils.objectToJson(electronicSurface), "UTF-8"));
		params.put("EBusinessID", EBusinessID);
		params.put("RequestType", "1007");
		String dataSign = encrypt(JsonUtils.objectToJson(electronicSurface), AppKey, "UTF-8");
		params.put("DataSign", URLEncoder.encode(dataSign, "UTF-8"));
		params.put("DataType", "2");
		String result = HttpClientUtil.sendPost(electronicSurfaceUrl, params);
		return result;

	}

	/**
	 * 查询订单物流轨迹
	 * 
	 * @param expCode
	 *            快递公司编码
	 * @param expNo
	 *            物流单号
	 * @return
	 * @throws Exception
	 */
	public static String getOrderTracesByJson(String expCode, String expNo) throws Exception {
		String requestData = "{'ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

		Map<String, String> params = new HashMap<String, String>();

		params.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
		params.put("EBusinessID", EBusinessID);
		params.put("RequestType", "1002");
		String dataSign = encrypt(requestData, AppKey, "UTF-8");
		params.put("DataSign", URLEncoder.encode(dataSign, "UTF-8"));
		params.put("DataType", "2");
		String result = HttpClientUtil.sendPost(ReqURL, params);

		return result;
	}

	/**
	 * 电商Sign签名生成
	 * 
	 * @param content
	 *            内容
	 * @param keyValue
	 *            Appkey
	 * @param charset
	 *            编码方式
	 * @throws UnsupportedEncodingException
	 *             ,Exception
	 * @return DataSign签名
	 */
	private static String encrypt(String content, String keyValue, String charset)
			throws UnsupportedEncodingException, Exception {
		if (keyValue != null) {
			return Base64Utils.base64(MD5Util.MD5(content + keyValue, charset), charset);

		}
		return Base64Utils.base64(MD5Util.MD5(content, charset), charset);
	}

}
