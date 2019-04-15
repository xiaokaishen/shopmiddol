package com.test.tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.test.tools.pojo.PictureResult;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @ClassName: QiNiuUtil
 * @Description: 七牛上传工具类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年9月26日 上午10:33:58
 * @version V1.0
 */
public class QiNiuUtil {

	private static Logger log = LoggerFactory.getLogger(QiNiuUtil.class);

	// 初始化七牛相关参数

	private static final String ACCESS_KEY = "Q9wG1UHB9TTif28g4QOTuebxxU-bIrZcuLYROuFE";
	private static final String SECRET_KEY = "W36tLZLW2BlKML6KijPt5WqtmmWuBu-4WcrO2XFS";
	private static final String URL = "http://qiniu.test-sh.com/";// 图片访问URL
	// 要上传的空间--
	private static final String BUCKETNAME = "test";// 存储空间

	/**
	 * 上传base64编码的图片
	 * 
	 * @param str
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static PictureResult put64image(String str, String key) throws Exception {
		byte[] base64 = Base64Utils.decodeFromString(str);
		Configuration cfg = new Configuration(Zone.zone0());
		UploadManager uploadManager = new UploadManager(cfg);
		Response response = uploadManager.put(base64, key, getupToken());
		// 解析上传成功的结果
		DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

		return PictureResult.ok(URL + putRet.key);
	}

	/**
	 * 通过文件路径上传
	 * 
	 * @param localFilePath
	 *            文件路径地址
	 * @param newName
	 *            重命名文件名
	 * @return
	 */
	public static PictureResult uploadFile(String localFilePath, String newName) {

		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());

		UploadManager uploadManager = new UploadManager(cfg);
		// 生成上传凭证，然后准备上传
		String upToken = QiNiuUtil.getupToken();

		try {
			Response response = uploadManager.put(localFilePath, newName, upToken);
			String bodyString = response.bodyString();
			System.out.println(bodyString);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(bodyString, DefaultPutRet.class);

			return PictureResult.ok(URL + putRet.key);
		} catch (QiniuException ex) {

			return PictureResult.error(ExceptionUtil.getStackTrace(ex));
		}

	}

	/**
	 * 文件上传
	 */
	public static PictureResult uploadFile(MultipartFile file, String newName) {

		InputStream stream = null;

		if (file != null) {
			try {

				File myfile = CommonUtil.multipartToFile(file);

				if (myfile != null) {

					stream = file.getInputStream();
					// 构造一个带指定Zone对象的配置类
					Configuration cfg = new Configuration(Zone.zone0());

					UploadManager uploadManager = new UploadManager(cfg);
					String upToken = QiNiuUtil.getupToken();
					Response response = uploadManager.put(stream, newName, upToken, null, null);
					// 解析上传成功的结果
					DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
					return PictureResult.ok(URL + putRet.key);

				}

			} catch (IOException e) {
				return PictureResult.error(ExceptionUtil.getStackTrace(e));
			}

		}
		return PictureResult.error("图片为空");

	}

	/**
	 * 文件上传
	 */
	public static PictureResult uploadFile(File file, String newName) {

		if (file != null) {
			try {

				InputStream stream = new FileInputStream(file);
				// 构造一个带指定Zone对象的配置类
				Configuration cfg = new Configuration(Zone.zone0());

				UploadManager uploadManager = new UploadManager(cfg);
				String upToken = QiNiuUtil.getupToken();
				Response response = uploadManager.put(stream, newName, upToken, null, null);
				// 解析上传成功的结果
				DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
				return PictureResult.ok(URL + putRet.key);

			} catch (IOException e) {
				return PictureResult.error(ExceptionUtil.getStackTrace(e));
			}

		}
		return PictureResult.error("图片为空");

	}

	/**
	 * 文件上传
	 */
	public static PictureResult uploadFile(InputStream stream, String newName) {

		try {

			// 构造一个带指定Zone对象的配置类
			Configuration cfg = new Configuration(Zone.zone0());

			UploadManager uploadManager = new UploadManager(cfg);
			String upToken = QiNiuUtil.getupToken();
			Response response = uploadManager.put(stream, newName, upToken, null, null);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			log.debug(JsonUtils.objectToJson(putRet));
			return PictureResult.ok(URL + putRet.key);

		} catch (IOException e) {
			return PictureResult.error(ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 获取简单上传的凭证
	 */

	private static String getupToken() {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

		String upToken = auth.uploadToken(BUCKETNAME);

		return upToken;

	}

}
