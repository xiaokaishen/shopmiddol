package com.test.tools.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @ClassName: CommonUtil
 * @Description: 公共工具类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年9月26日 上午10:46:19
 * @version V1.0
 */
public class CommonUtil {

	/**
	 * MultipartFile 转换成File
	 *
	 * @param multfile
	 *            原文件类型
	 * @return File
	 * @throws IOException
	 */
	public static File multipartToFile(MultipartFile multfile) {

		CommonsMultipartFile cf = (CommonsMultipartFile) multfile;
		// 这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File file = fi.getStoreLocation();
		return file;
	}

}
