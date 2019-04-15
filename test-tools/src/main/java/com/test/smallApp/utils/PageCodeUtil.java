package com.test.smallApp.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.test.tools.pojo.PictureResult;
import com.test.tools.util.Base64Utils;
import com.test.tools.util.IdolUtils;
import com.test.tools.util.QiNiuUtil;
import com.test.weixin.utils.TokenUtil;

/**
 * 小程序生成頁面二维码
 * 
 * @ClassName: PageCodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author acai
 * @date 2018年9月10日 下午5:56:31
 *
 */
public class PageCodeUtil {
	private static Logger log = LoggerFactory.getLogger(PageCodeUtil.class);

	/**
	 * 生成极多二维码
	 * 
	 * @param scene最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
	 *            其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
	 * @param page必须是已经发布的小程序存在的页面（否则报错），例如
	 *            "pages/index/index"
	 *            ,根路径前不要填加'/',不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
	 * @param width二维码的宽度
	 * @param auto_color
	 *            自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调 is_hyaline 为true时，生成透明底色的小程序码
	 * @return
	 * @throws Exception
	 */
	public static String moreCode(String scene, String page) throws Exception {
		RestTemplate rest = new RestTemplate();
		InputStream inputStream = null;
		String url = SmallAppConstant.Get_WX_Acode_Unlimit.replace("ACCESS_TOKEN", TokenUtil.getSmallAppToken());

		Map<String, Object> param = new HashMap<>();
		param.put("scene", scene);
		param.put("page", page);
		param.put("width", 430);
		param.put("auto_color", false);
		Map<String, Object> line_color = new HashMap<>();
		line_color.put("r", 0);
		line_color.put("g", 0);
		line_color.put("b", 0);
		param.put("line_color", line_color);
		log.debug("调用生成微信URL接口传参:" + param);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		HttpEntity requestEntity = new HttpEntity(JSON.toJSONString(param), headers);
		ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
		byte[] result = entity.getBody();

		String base64Encode = Base64Utils.base64Encode(result);
		log.debug("base64Encode===" + base64Encode);

		return base64Encode;

	}

	public static void main(String[] args) throws Exception {
		
		Long customArtworkId = IdolUtils.toLong("1000194");
		long time1 = System.currentTimeMillis();
		String token = "13_b8WiPkorXSW1bcohRrFqqvHVFvO7XYOa71b6x0HmWCnuxaf5v-XLdc7v1B9EnyfwRfL-JJg7H7FwbSamaUTGMWQtrvubcYNuDbvMBD8Eb-HsBoBrcUlhiGN7S9njwcw42YqKj9pKrjx79zCvAFZbAIAHMG";

		String moreCode = PageCodeUtil.moreCode(IdolUtils.toString(customArtworkId),
				"pages/CustomArtworkDetail/CustomArtworkDatail");
		long time2 = System.currentTimeMillis();
		System.out.println("获取微信图片时间：" + (time2 - time1));
		System.out.println("*****************************获取图片成功，开始上传*******************************************");

		String codeImg = "smallAppCode_" + customArtworkId;
		PictureResult uploadFile = QiNiuUtil.put64image(moreCode, codeImg);

		long time3 = System.currentTimeMillis();
		System.out.println("上传到FTP时间：" + (time3 - time2));
		System.out.println("*****************************图片上传成功，结束上传*******************************************");
		System.out.println("uploadFile===" + uploadFile);
		
	}

}
