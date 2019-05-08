package com.test.smallApp.utils;

import com.yssp.config.YSSPSmallAppConfig;

/**
 * 
 * @ClassName: SmallAppConstant
 * @Description: 艺术私品小程序常量(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年8月21日 下午2:52:57
 *
 */
public interface SmallAppConstant {
	/**
	 *小程序appid
	 */
	public static final String AppID = "wx017e3852c759469b";
	/**
	 * 小程序密钥
	 */
	public static final String AppSecret = "179ee2be17d606565123e9d6a2d22170";
	/**
	 * 模板消息id
	 */
//	public static final String TemplateId = "ZPFCHLg8WW-jNIohKUdUN-QYivFnKtqa5vpcu48Chqc";
	public static final String TemplateId = "wZZIG3R6w2pSVSfn3exSAUSaYQEZ7cdZQ336STSqwnA";
	/**
	 * 登录凭证校验url
	 */
	public static final String Login_Credential_Verification = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

	public static final String Access_Token_Url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 生成页面可扫描二维码URL
	 */
	// 适用于需要的码数量较少的业务场景
	public static final String Get_WX_Acode = "https://api.weixin.qq.com/wxa/getwxacode?access_token=ACCESS_TOKEN";

	// 适用于需要的码数量极多的业务场景
	public static final String Get_WX_Acode_Unlimit = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

	// 适用于需要的码数量较少的业务场景
	public static final String Get_WX_Aqrcode = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=ACCESS_TOKEN";

	/**
	 * 艺术私品商户平台相关参数
	 */
	// 商户server调用统一下单接口请求订单URL
	public static final String Unified_Order_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 商户server接收支付通知
	public static String notify_url = YSSPSmallAppConfig.Front_Url + "/wxPay/notify";
	// 商户server查询支付结果
	public static final String Select_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 商户server申请退单
	public static final String refund_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	// 商户server查询退款
	public static final String refundquery_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	// 商户号
	public final static String MCH_ID = "1501793041";
	// API密钥
	public final static String API_KEY = "vgn8oiw357kae50ww9r154r6w371ikhq";
	// 签名加密方式
	public final static String SIGN_TYPE = "MD5";
	// 默认币种
	public final static String Fee_Type = "CNY";
	// 交易类型
	public final static String Trade_Type = "JSAPI";

}
