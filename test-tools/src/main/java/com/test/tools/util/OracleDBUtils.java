package com.test.tools.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @ClassName: DBUtil
 * @Description: 数据库连接工具类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月15日 下午1:42:21
 * @version V1.0
 */
public class OracleDBUtils {

	private static BasicDataSource dataSource = null;
	private static final String driveClassName = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@10.10.1.192:1521:XE";
	private static final String username = "HTLPRACTICE";
	private static final String password = "SUPERVISOR";

	public OracleDBUtils() {
	}

	public static void init() {

		try {

			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driveClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建连接池失败!请检查设置!!!");
		}
	}

	/**
	 * 数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException {
		if (dataSource == null) {
			init();
		}
		Connection conn = null;
		if (dataSource != null) {
			conn = dataSource.getConnection();
		}
		return conn;
	}

	/**
	 * 关闭数据库
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭资源失败");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {

		OracleDBUtils util = new OracleDBUtils();
		System.out.println(util.getConnection());

	}

}
