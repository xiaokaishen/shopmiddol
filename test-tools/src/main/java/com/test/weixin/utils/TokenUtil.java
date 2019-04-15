package com.test.weixin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.tools.util.DBUtil;
import com.test.tools.util.HttpClientUtil;
import com.test.weixin.pojo.Token;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * @ClassName: TokenUtil
 * @Description: 从数据库读取token和保存token的类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月15日 下午2:04:09
 * @version V1.0
 */
public final class TokenUtil {
	private static Logger log = LoggerFactory.getLogger(TokenUtil.class);

	public static Token getAccess_Token(String url, String appid, String appSecret) {
		Token accessToken = null;
		String requestUrl = url.replace("APPID", appid).replace("APPSECRET", appSecret);
		JSONObject jsonObject = HttpClientUtil.httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new Token();
				accessToken.setAccess_token(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getDouble("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 获取存入出数据的Access_Token
	 * 
	 * @return
	 */
	public static String getToken() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM qy_access_token ORDER BY ID DESC LIMIT 0,1";
		String access_token = "";

		try {
			// 创建数据库链接
			con = DBUtil.getConnection();
			// 创建处理器
			stmt = con.prepareStatement(sql);
			// 查询Token，读取1条记录
			rs = stmt.executeQuery();
			if (rs.next()) {
				access_token = rs.getString("access_token");
			}

		} catch (SQLException ex) {
			System.out.println("数据库操作异常：" + ex.getMessage());
		} finally {
			DBUtil.closeConnection(con);
		}
		return access_token;
	}

	/**
	 * 获取存入出数据的Access_Token
	 * 
	 * @return
	 */
	public static String getSmallAppToken() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM yssp_smallapp_accesstoken ORDER BY ID DESC LIMIT 0,1";
		String access_token = "";

		try {
			// 创建数据库链接
			con = DBUtil.getConnection();
			// 创建处理器
			stmt = con.prepareStatement(sql);
			// 查询Token，读取1条记录
			rs = stmt.executeQuery();
			if (rs.next()) {
				access_token = rs.getString("access_token");
			}

		} catch (SQLException ex) {
			System.out.println("数据库操作异常：" + ex.getMessage());
		} finally {
			DBUtil.closeConnection(con);
		}
		return access_token;
	}

	public static void saveToken(Token token) {
		// 存入数据库中
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// 创建数据库链接
			conn = DBUtil.getConnection();
			// 创建预处理器
			pst = conn.prepareStatement("insert into qy_access_token (access_token,expires_in)values(?,?)");
			pst.setString(1, token.getAccess_token());
			pst.setDouble(2, token.getExpires_in());
			pst.execute();
		} catch (SQLException ex) {
			System.out.println("数据库操作异常：" + ex.getMessage());
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public static void saveSmallAppToken(Token token) {
		// 存入数据库中
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// 创建数据库链接
			conn = DBUtil.getConnection();
			// 创建预处理器
			pst = conn.prepareStatement("insert into yssp_smallapp_accesstoken (access_token,expires_in)values(?,?)");
			pst.setString(1, token.getAccess_token());
			pst.setDouble(2, token.getExpires_in());
			pst.execute();
		} catch (SQLException ex) {
			System.out.println("数据库操作异常：" + ex.getMessage());
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

}
