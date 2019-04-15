package com.test.wxsmallapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.test.smallApp.utils.SmallTokenThread;

/**
 * @ClassName: GetAccessTokenServlet
 * @Description: 编写servlet并在servlet初始化时启动该线程
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月14日 下午4:46:08
 * @version V1.0
 */
public class GetAccessTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		new Thread(new SmallTokenThread()).start();
		// 启动定时获取access_token的线程
	}
}
