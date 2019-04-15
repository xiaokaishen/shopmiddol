package com.test.tools.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.config.AlipayConfig;

/**
 * 
 * @ClassName: AliPayUtil
 * @Description: 支付宝支付通用工具类(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年3月27日 下午4:18:02
 *
 */
public class AliPayUtil {
	private static Logger log = LoggerFactory.getLogger(AliPayUtil.class);

	/**
	 * 统一收单交易退款接口
	 * 
	 * @param out_trade_no
	 *            商户订单号，和支付宝交易号二选一
	 * @param trade_no
	 *            支付宝交易号和商户订单号二选一
	 * @param refund_amount
	 *            退款金额，不能大于订单总金额
	 * @param refund_reason
	 *            退款的原因说明
	 * @param out_request_no
	 *            标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
	 * @return
	 * @throws AlipayApiException
	 */
	public static AlipayTradeRefundResponse refund(AlipayTradeRefundModel model) throws AlipayApiException {

		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

		request.setBizModel(model);

		request.setNotifyUrl(AlipayConfig.notify_url);
		// 设置同步地址
		request.setReturnUrl(AlipayConfig.return_url);
		AlipayTradeRefundResponse response = AlipayConfig.getInstance().execute(request);
		return response;
	}

	/**
	 * 阿里跳转支付方法
	 * 
	 * @param out_trade_no
	 *            商户订单号，商户网站订单系统中唯一订单号，必填
	 * @param subject
	 *            订单名称，必填
	 * @param total_amount
	 *            付款金额，必填
	 * @param body
	 *            商品描述，可空
	 * @param timeout_express
	 *            超时时间 可空
	 * @return
	 * @throws AlipayApiException
	 * @throws IOException
	 */
	public static String pay(AlipayTradeWapPayModel alipayTradeWapPayModel) throws AlipayApiException, IOException {

		String form = "";

		if (!alipayTradeWapPayModel.getOutTradeNo().isEmpty()) {// 商户订单号不为空
			/**********************/
			AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
			// 封装请求支付信息
			alipayRequest.setBizModel(alipayTradeWapPayModel);
			// 设置异步通知地址
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
			// 设置同步地址
			alipayRequest.setReturnUrl(AlipayConfig.return_url);

			try {
				form = AlipayConfig.getInstance().pageExecute(alipayRequest).getBody();
			} catch (AlipayApiException e) {
				log.error("支付宝构造表单失败", e);
			}
			log.debug("支付宝支付表单构造:" + form);
		}

		return form;
	}

}
