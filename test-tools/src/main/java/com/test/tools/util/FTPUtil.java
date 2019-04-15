package com.test.tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.currency.config.CurrencyConfig;

/**
 * FTP上传工具类
 * 
 * @author
 * 
 * @version v1.0
 */

public class FTPUtil {
	/**
	 * Description: 向FTP服务器上传文件
	 * 
	 * @param type
	 *            上传的文件类型
	 * @param filePath
	 *            FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(int type, String filePath, String filename, InputStream input) {
		boolean result = false;
		FTPClient ftp = new FTPClient();

		try {
			int reply;
			ftp.connect(CurrencyConfig.FTP_URL, CurrencyConfig.FTP_PORT);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(CurrencyConfig.FTP_USER[type], CurrencyConfig.FTP_PASS[type]);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return result;
			}
			// 切换到上传目录
			if (!ftp.changeWorkingDirectory(CurrencyConfig.FTP_REMOTE_FILE_PATH[type] + filePath)) {
				// 如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				String tempPath = CurrencyConfig.FTP_REMOTE_FILE_PATH[type];
				for (String dir : dirs) {
					if (null == dir || "".equals(dir))
						continue;
					tempPath += "/" + dir;
					if (!ftp.changeWorkingDirectory(tempPath)) {
						if (!ftp.makeDirectory(tempPath)) {
							return result;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			// 设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			// 上传文件
			if (!ftp.storeFile(filename, input)) {
				return result;
			}
			input.close();
			ftp.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:\\Users\\Administrator\\Desktop\\订单详情1.jpg");

		String id = "201809040000";
		String filePath = id + "/";
		String fileName = "zhengmian";
		String type = file.getName();
		type = type.substring(type.lastIndexOf("."), type.length());
		fileName = fileName + type;
		InputStream input = new FileInputStream(file);

		boolean uploadFile = FTPUtil.uploadFile(0, filePath, fileName, input);

		System.out.println(uploadFile);
		/*
		 * boolean upload = FTPUtil.upload(0, input, filePath, fileName);
		 * boolean deleteFileFtp = FTPUtil.deleteFileFtp(0, filePath, "a.png");
		 * System.out.println(upload); System.out.println(deleteFileFtp);
		 */

	}

}