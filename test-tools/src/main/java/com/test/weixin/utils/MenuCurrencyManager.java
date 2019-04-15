package com.test.weixin.utils;

import com.currency.config.CurrencyConfig;
import com.test.smallApp.utils.SmallAppConstant;
import com.test.weixin.pojo.Button;
import com.test.weixin.pojo.Matchrule;
import com.test.weixin.pojo.Menu;
import com.test.weixin.pojo.MiniprogramButton;
import com.test.weixin.pojo.PersonMenu;
import com.test.weixin.pojo.ViewButton;

/**
 * @ClassName: MenuManager
 * @Description: 自定义通用菜单管理器类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月16日 上午9:26:32
 * @version V1.0
 */
public class MenuCurrencyManager {
	public static void main(String[] args) {
String token = "15_aTU8LQORteaX82GOontJWg696aqsMoww7a963SC-hnnYFUG-gMp7UstG8s-93S9yrZO4obiLDTXorsYOJLz4libbIBYlS7cdMpdq5AEEmCGcdTPdz86N9AHfdmvwB_sflc-VwchIklk_3Ch0AEOgAJAVZJ";
	///	System.out.println(WXCustomMenuUtil.delCurrencyMenu(token));
		 System.out.println(WXCustomMenuUtil.createCurrencyMenu(getMenu(),token));
	//	 System.out.println(WXCustomMenuUtil.delPersonMenu(token));
	//	System.out.println(WXCustomMenuUtil.createPersonMenu(getPersonMenu(),
	//	 token));
		
		 System.out.println(WXCustomMenuUtil.selectCurrencyMenu(token));
	}

	/**
	 * 测试菜单
	 */

	public static Menu testMenu() {

		Menu menu = new Menu();
		// 第三个菜单1
		Button button1 = new Button();
		button1.setName("服务员"); // 将31/32两个button作为二级菜单封装第一个一级菜单

		// 第一个菜单
		ViewButton viewButton11 = new ViewButton();
		viewButton11.setName(WXConstant.SERVER_URL + "今日菜品");
		viewButton11.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton11.setUrl(WXConstant.SERVER_URL + "dishesList");

		// 第二个菜单
		ViewButton viewButton21 = new ViewButton();
		viewButton21.setName("订单列表");
		viewButton21.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton21.setUrl(WXConstant.SERVER_URL + "orderListAll");
		button1.setSub_button(new Button[] { viewButton11, viewButton21 });

		// 第二个菜单
		ViewButton viewButton2 = new ViewButton();
		viewButton2.setName("今日菜品");
		viewButton2.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton2.setUrl(WXConstant.SERVER_URL + "todayDishes");

		// 第三个菜单1
		Button button3 = new Button();
		button3.setName("我的"); // 将31/32两个button作为二级菜单封装第一个一级菜单

		ViewButton viewButton31 = new ViewButton();
		viewButton31.setName("我的预定");
		viewButton31.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton31.setUrl(WXConstant.SERVER_URL + "personalmyorder");

		// 第三个菜单2
		ViewButton viewButton32 = new ViewButton();
		viewButton32.setName("我的评价");
		viewButton32.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton32.setUrl(WXConstant.SERVER_URL + "personalmycomment");

		// 第三个菜单3
		ViewButton viewButton33 = new ViewButton();
		viewButton33.setName("主页");
		viewButton33.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton33.setUrl("http://www.test-sh.com");

		button3.setSub_button(new Button[] { viewButton31, viewButton32, viewButton33 });

		menu.setButton(new Button[] { button1, viewButton2, button3 });// 将31Button直接作为一级菜单

		return menu;

	}

	/**
	 * 
	 * 组装个性化菜单
	 * 
	 * @return
	 * 
	 */
	public static PersonMenu getPersonMenu() {

		PersonMenu menu = new PersonMenu();

		// 第一个菜单
		ViewButton viewButton1 = new ViewButton();
		viewButton1.setName("今日菜品");
		viewButton1.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton1.setUrl(CurrencyConfig.Front_Url + "/dishesList");

		// 第二个菜单
		ViewButton viewButton2 = new ViewButton();
		viewButton2.setName("订单列表");
		viewButton2.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton2.setUrl(CurrencyConfig.Front_Url + "/orderListAll");
		// 创建权限
		Matchrule matchruleButton = new Matchrule();

		matchruleButton.setTag_id("101");
		menu.setButton(new Button[] { viewButton1, viewButton2 });
		menu.setMatchrule(matchruleButton);

		return menu;
	}

	/**
	 * 
	 * 组装通用菜单
	 * 
	 * @return
	 * 
	 */

	public static Menu getMenu() {
		Menu menu = new Menu();

		// 第一个菜单
		Button button1 = new Button();
		button1.setName("隐艺汇");

		// 第一个的第一个菜单
		ViewButton viewButton11 = new ViewButton();
		viewButton11.setName("首页");
		viewButton11.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton11.setUrl(CurrencyConfig.Front_WX_Url);

		// 第一个的第二个菜单
		ViewButton viewButton12 = new ViewButton();
		viewButton12.setName("青隐商城");
		viewButton12.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton12.setUrl(CurrencyConfig.Front_WX_Url + "/shoppingHome");

		button1.setSub_button(new Button[] { viewButton11, viewButton12 });

		// 第二个菜单
		Button button2 = new Button();
		button2.setName("预订中心"); // 将31/32两个button作为二级菜单封装第一个一级菜单

		// 第二个菜单1
		ViewButton viewButton21 = new ViewButton();
		viewButton21.setName("酒店预订");
		viewButton21.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton21.setUrl(CurrencyConfig.Front_WX_Url + "/hotelBook");
		// 第二个菜单2
		ViewButton viewButton22 = new ViewButton();
		viewButton22.setName("会所预定");
		viewButton22.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton22.setUrl(CurrencyConfig.Front_WX_Url + "/clubBook");

		// 第二个菜单3
		ViewButton viewButton23 = new ViewButton();
		viewButton23.setName("私房菜预订");
		viewButton23.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton23.setUrl(CurrencyConfig.Front_Url + "/todayDishes");

		button2.setSub_button(new Button[] { viewButton21, viewButton22, viewButton23 });

		// 第三个菜单1
		Button button3 = new Button();
		button3.setName("我的"); // 将31/32两个button作为二级菜单封装第一个一级菜单

		// 第三个菜单1
		ViewButton viewButton31 = new ViewButton();
		viewButton31.setName("个人中心");
		viewButton31.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton31.setUrl(CurrencyConfig.Front_WX_Url + "/personal");

		// 第三个菜单2

		ViewButton viewButton32 = new ViewButton();
		viewButton32.setName("青隐订单");
		viewButton32.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton32.setUrl(CurrencyConfig.Front_WX_Url + "/order/myHotelOrder/allHotel?type=hotel&status=1");

		// 第三个菜单3

		ViewButton viewButton33 = new ViewButton();
		viewButton33.setName("商城订单");
		viewButton33.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton33.setUrl(CurrencyConfig.Front_WX_Url + "/myAllOrders");
		
		ViewButton viewButton34 = new ViewButton();
		viewButton34.setName("礼券订单");
		viewButton34.setType(WXConstant.WECHAT_MENU_TYPE_VIEW);
		viewButton34.setUrl(CurrencyConfig.Front_WX_Url + "/exchangeGift");


		button3.setSub_button(new Button[] { viewButton31, viewButton32, viewButton33,viewButton34});

		// 第三个菜单4
		MiniprogramButton miniprogram1 =new MiniprogramButton();
		miniprogram1.setName("艺术私品小程序");
		miniprogram1.setType("miniprogram");
		miniprogram1.setAppid(SmallAppConstant.AppID);
		miniprogram1.setPagePath("pages/index/index");
		
		button3.setSub_button(new Button[] { viewButton31, viewButton32, viewButton33,viewButton34,miniprogram1});


		menu.setButton(new Button[] { button1, button2, button3 });// 将31Button直接作为一级菜单

		return menu;
	}

}
