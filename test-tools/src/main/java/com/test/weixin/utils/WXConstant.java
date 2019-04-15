package com.test.weixin.utils;

import com.currency.config.CurrencyConfig;

/**
 * @ClassName: WXConstant
 * @Description: TODO
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月15日 下午3:06:05
 * @version V1.0
 */
public interface WXConstant {

	public static final String AppID = "wx8ab7033099cbb508";// appid
	public static final String AppSecret ="42b1a3323903f39e9a769e40d59c1e28";

	// 测试
//	public static final String AppID = "wx269e6629c1535b5f";// appid
//	public static final String AppSecret = "e130fa21d89b0684a87fa51daf2238ec";
	// 测试结束

	public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";// 获取基础支持acces_token
	public static final String PERSONALIZED_MENU_ADD = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";// 创建个性化菜单请求URL
	public static final String PERSONALIZED_MENU_DEL = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";// 删除个性化菜单请求URL
	public static final String CURRENCY_MENU_URL_ADD = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";// 创建通用自定义菜单请求URL
	public static final String CURRENCY_MENU_URL_SEL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";// 创建通用自定义菜单请求URL
	public static final String CURRENCY_MENU_URL_DEL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";// 创建通用自定义菜单请求URL
	public static final String WEB_AUTH_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";// 网页授权URL
	public static final String WEB_AUTH_CALLBACK_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";// 网页授权回调URL
	public static final String GROUP_MESSAGE_TO_GROUP = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN"; // 这个地址是根据分组id来群发消息
	public static final String GROUP_MESSAGE_TO_OPENID = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN"; // 这个地址是根据openid来群发消息
	public static final String TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";// 模板消息发送类

	public static final String GET_UnionID_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";// 根据用户openid获取用户UnionID

	public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";// 公众号用于调用微信JS接口的临时票据URL
	public static final String FOLLOW_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	public static final String WECHAT_MENU_TYPE_CLICK = "click";
	public static final String WECHAT_MENU_TYPE_VIEW = "view";

	public static final String GET_TAG = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";// 获取公众号已经创建的标签

	public static final String LS_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";// 生成二维码的URL
	public static final String GET_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";// 获得二维码链接的URL

	public static final String S_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";// 长连接转端链接

	public static final String GET_TAG_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";// 获取标签下粉丝列表

	// 服务器访问URL
	public static final String SERVER_URL = CurrencyConfig.Front_Url + "/";

	public static String JSAPILIST[] = { "onMenuShareTimeline", "onMenuShareAppMessage" };

	/**
	 * 微信支付相关信息
	 */

	// 商户server调用统一下单接口请求订单URL
	public static final String Unified_Order_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 商户server接收支付通知
	public static String notify_url = CurrencyConfig.Front_Url + "/wxPay/notify";
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
	/**
	 * 微信模板消息ID
	 */
	public final static String Booking_Success = "lFsLZtb2ZlfmCGTFCHFJj1nQ8wxIBOm12Mv0074j5v0";// 预订成功
	public final static String Pay_Success = "YZ84qAaM0SDmm4koeSKTa3_Fl_DAP9ob1HqsN0VxdaA";// 支付成功
	public final static String Pay_Fail = "SsvgBIzK0WBz8H4yKaE7ahm6VryaVCSW8b-4lEMsh9k";// 支付失败
	public final static String Check_Success = "aIyFIbeyAngqkhMPDmOtktj3zIJc9gGDSxDzMXWcxc0";// 入住
	public final static String Leave_Shop = "A1bYsXgN8IT_o7prZdn5q3gAa77mVuKeN8J7xZ49kTE";// 办理离店提醒
	public final static String Invalid_Order = "3m44Zoh2XmwMUHiDk1huq_aC8RfzV1EpKejwvATMBLQ";// 订单失效
	public final static String Cancel_Order = "RIHQjEQh728Pq6c7mZeEGgG6F8yRUosjTrOLL2RKgqk";// 取消订单
	public final static String Refund_Pay = "LvOHc3MD3zLIjLR58KDIC-5_ORBKfgJAMCrnM39m7Ug";// 退款
	public final static String Order_Success = "IP85jf97HoaJcKy_e8Tt7tZ35OLEIeHRWAvWv7vw15M";// 会所预订成功
	public final static String Club_Booking = "0TiW5wmM4zDsjuFNLJaAS_h9pdqSBuSsk4c-gR33jVw";// 会所支付成功
	public final static String Club_Cancel = "psYKx-gFrMAhu4qFvUpTtsFs4gkVZ45dNob-T07gaD4";// 取消会所订单
	public final static String Good_OrderSubmit = "1I1rDU-HXcGQ1eiWbtJBXDjn7vhknr2TsBbXmbkxHRw"; // 商品订单下单
	public final static String Good_Service = "-381CjsGJoMj75kOWdJXUyJhQzxYpRpZppgwpMG0c1I";// 商品服务通知
	public final static String Discount_Service = "yE3KRmaKWkHswi7GpaJ8XuWJfkCHILRdMdQPpxGdXFA";// 优惠卷发送通知
	public final static String Good_Order_Cancel = "cnOXDTjRfjioJiOn2tW4PhOueFcDA1SwL25HLGIJhJw";// 商品订单取消通知
	public final static String Good_Order_Confirm = "vb_ddN0o4VBiBYK8owhX6z4Iy7rPohK9KFTBtK3zr3g";// 商品订单确认通知
	public final static String Good_Add_Logistic = "ScpMeGRaig_08qd36YL5QXY2Mi_VaWAZP4QcjyRi8yo";// 添加物流信息
	public final static String Good_Order_UnPay = "1sDgClVwQfWtrzf6S6hHPAybQjdT3KiSWSjpzu2C5NY"; // 商品订单收款
	public final static String Good_Order_Pay = "4mY5xLiPDZ7pTXqZgItGFBrrPTBAdg1sihIHY5_qTjE"; // 商品订单支付
	public final static String Good_Order_Evaluate = "uxn81cbUDoGlbzlZsiWS-A4963bow5lX_O96wQbAg_U"; // 订单评价接口
	public final static String Discount_Service_User = "6decUUFVOwuVoIrn0VmzsMa_xwlcJjJOGZAnrP2ply0";// 发送优惠卷通知,会员权益到账

}
