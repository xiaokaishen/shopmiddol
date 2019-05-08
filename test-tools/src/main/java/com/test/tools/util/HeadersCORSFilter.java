package com.test.tools.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.currency.config.CurrencyConfig;

public class HeadersCORSFilter implements Filter {

	Logger log = LoggerFactory.getLogger(HeadersCORSFilter.class);

	// 跨域请求的地址

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest res = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		resp.setContentType("application/x-www-form-urlencoded; charset=UTF-8");

		// 设置多个跨域访问

		String curOrigin = res.getHeader("Origin");
		System.out.println("curOrigin===="+curOrigin);
		// 如果当前访问来源在application.properties的Access-Control-Allow-Origin配置范围内，则允许访问，否则不允许

		if (curOrigin != null) {
			for (int i = 0; i < CurrencyConfig.originProperties.length; i++) {
				// System.out.println("允许跨域访问的来源是："+originProperties[i]);
				if (curOrigin.equals(CurrencyConfig.originProperties[i])) {
					resp.setHeader("Access-Control-Allow-Origin", curOrigin);
				}
			}
		} else { // 对于无来源的请求(比如在浏览器地址栏直接输入请求的)，那就只允许我们自己的机器可以吧
			resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1");
		}

		String method = res.getMethod();
		log.debug("method===" + method);

		if ("OPTIONS".equals(method)) {// 如果请求方法为OPTIONS
			resp.setStatus(200);

		}
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Authorization, X-Requested-With,X_Requested_With");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setHeader("XDomainRequestAllowed", "1");

		chain.doFilter(res, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
