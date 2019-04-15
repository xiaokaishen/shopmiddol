package com.test.tools.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @ClassName: QRCodeUtil
 * @Description: 这是一个二维码生成解析工具类
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年11月14日 上午9:05:05
 * @version V1.0
 */
public class QRCodeUtil {

	private static final int QRCOLOR = 0xFF000000; // 默认是黑色
	private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色


	/**
	 * 二维码解析
	 * 
	 * @param file
	 *            二维码图片文件
	 * @return 解析结果
	 */
	public static String parseQRCode(File file) {
		BufferedImage image;
		try {
			image = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			return result.getText();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 生成不带logo的二维码
	 * 
	 * @param qrUrl
	 *            链接地址
	 * @param request
	 *            请求
	 * @param productName
	 *            二维码名称
	 * @param file
	 *            上传路径+文件名
	 * @return
	 */
	public static String getQRCode(String qrUrl, HttpServletRequest request) {
		// String filePath =
		// request.getSession().getServletContext().getRealPath("/") +
		// "resources/images/logoImages/llhlogo.png";
		// filePath是二维码logo的路径，但是实际中我们是放在项目的某个路径下面的，所以路径用上面的，把下面的注释就好

		String content = qrUrl;
		try {
			QRCodeUtil zp = new QRCodeUtil();
			BufferedImage image = zp.getQR_CODEBufferedImage(content, BarcodeFormat.QR_CODE, 400, 400,
					zp.getDecodeHintType());
			image.flush();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.flush();
			ImageIO.write(image, "png", baos);

			@SuppressWarnings("restriction")
			String imageBase64QRCode = new sun.misc.BASE64Encoder().encodeBuffer(baos.toByteArray());
			baos.close();
			return imageBase64QRCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成带logo的二维码图片
	 * 
	 * @param qrUrl
	 *            链接地址
	 * @param request
	 *            请求
	 * 
	 * @return
	 */
	public static String getLogoQRCode(String qrUrl, HttpServletRequest request) {

		// filePath是二维码logo的路径，但是实际中我们是放在项目的某个路径下面的，所以路径用上面的，把下面的注释就好
		String path = request.getSession().getServletContext().getRealPath("") + "\\static\\logo.png";
		String content = qrUrl;
		try {
			QRCodeUtil zp = new QRCodeUtil();
			BufferedImage bim = zp.getQR_CODEBufferedImage(content, BarcodeFormat.QR_CODE, 400, 400,
					zp.getDecodeHintType());
			return zp.addLogo_QRCode(bim, new File(path), new LogoConfig());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成带logo的二维码图片
	 * 
	 * @param qrUrl
	 *            链接地址
	 * @param path
	 *            图片路径
	 * 
	 * @return
	 */
	public static String getLogoQRCode(String qrUrl, String path) {
		String content = qrUrl;
		try {
			QRCodeUtil zp = new QRCodeUtil();
			BufferedImage bim = zp.getQR_CODEBufferedImage(content, BarcodeFormat.QR_CODE, 400, 400,
					zp.getDecodeHintType());
			return zp.addLogo_QRCode(bim, getImageStream(path), new LogoConfig());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** * 给二维码图片添加Logo * * @param qrPic * @param logoPic */
	public String addLogo_QRCode(BufferedImage bim, File logoPic, LogoConfig logoConfig) {
		try {
			/** * 读取二维码图片，并构建绘图对象 */
			BufferedImage image = bim;
			Graphics2D g = image.createGraphics();

			/** * 读取Logo图片 */
			BufferedImage logo = ImageIO.read(logoPic);
			/** * 设置logo的大小,本人设置为二维码图片的20%,因为过大会盖掉二维码 */
			int widthLogo = logo.getWidth(null) > image.getWidth() * 6 / 10 ? (image.getWidth() * 6 / 10)
					: logo.getWidth(null),
					heightLogo = logo.getHeight(null) > image.getHeight() * 6 / 10 ? (image.getHeight() * 6 / 10)
							: logo.getWidth(null);

			/** * logo放在中心 */
			int x = (image.getWidth() - widthLogo) / 2;
			int y = (image.getHeight() - heightLogo) / 2;
			/**
			 * * logo放在右下角 * int x = (image.getWidth() - widthLogo); * int y =
			 * (image.getHeight() - heightLogo);
			 */

			// 开始绘制图片
			g.drawImage(logo, x, y, widthLogo, heightLogo, null);
			// g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
			// g.setStroke(new BasicStroke(logoConfig.getBorder()));
			// g.setColor(logoConfig.getBorderColor());
			// g.drawRect(x, y, widthLogo, heightLogo);
			g.dispose();

			logo.flush();
			image.flush();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.flush();
			ImageIO.write(image, "png", baos);

			String imageBase64QRCode = new sun.misc.BASE64Encoder().encodeBuffer(baos.toByteArray());
			baos.close();
			return imageBase64QRCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** * 给二维码图片添加Logo * * @param qrPic * @param logoPic */
	public String addLogo_QRCode(BufferedImage bim, InputStream logoPic, LogoConfig logoConfig) {
		try {
			/** * 读取二维码图片，并构建绘图对象 */
			BufferedImage image = bim;
			Graphics2D g = image.createGraphics();

			/** * 读取Logo图片 */
			BufferedImage logo = ImageIO.read(logoPic);
			/** * 设置logo的大小,本人设置为二维码图片的20%,因为过大会盖掉二维码 */
			int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ? (image.getWidth() * 2 / 10)
					: logo.getWidth(null),
					heightLogo = logo.getHeight(null) > image.getHeight() *  2/ 10 ? (image.getHeight() * 2 / 10)
							: logo.getWidth(null);

			/** * logo放在中心 */
			int x = (image.getWidth() - widthLogo) / 2;
			int y = (image.getHeight() - heightLogo) / 2;
			/**
			 * * logo放在右下角 * int x = (image.getWidth() - widthLogo); * int y =
			 * (image.getHeight() - heightLogo);
			 */

			// 开始绘制图片
			g.drawImage(logo, x, y, widthLogo, heightLogo, null);
			// g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
			// g.setStroke(new BasicStroke(logoConfig.getBorder()));
			// g.setColor(logoConfig.getBorderColor());
			// g.drawRect(x, y, widthLogo, heightLogo);
			g.dispose();

			logo.flush();
			image.flush();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.flush();
			ImageIO.write(image, "png", baos);

			String imageBase64QRCode = new sun.misc.BASE64Encoder().encodeBuffer(baos.toByteArray());
			baos.close();
			return imageBase64QRCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** * 构建初始化二维码 * * @param bm * @return */
	public BufferedImage fileToBufferedImage(BitMatrix bm) {
		BufferedImage image = null;
		try {
			int w = bm.getWidth(), h = bm.getHeight();
			image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					image.setRGB(x, y, bm.get(x, y) ? 0xFF000000 : 0xFFCCDDEE);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * * 生成二维码bufferedImage图片 * * @param content * 编码内容 * @param barcodeFormat *
	 * 编码类型 * @param width * 图片宽度 * @param height * 图片高度 * @param hints * 设置参数
	 * * @return
	 */
	public BufferedImage getQR_CODEBufferedImage(String content, BarcodeFormat barcodeFormat, int width, int height,
			Map<EncodeHintType, ?> hints) {
		MultiFormatWriter multiFormatWriter = null;
		BitMatrix bm = null;
		BufferedImage image = null;
		try {
			multiFormatWriter = new MultiFormatWriter();
			// 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
			bm = multiFormatWriter.encode(content, barcodeFormat, width, height, hints);
			int w = bm.getWidth();
			int h = bm.getHeight();
			image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

			// 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
				}
			}
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return image;
	}

	/** * 设置二维码的格式参数 * * @return */
	public Map<EncodeHintType, Object> getDecodeHintType() {
		// 用于设置QR二维码参数
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 设置编码方式
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 0);
		hints.put(EncodeHintType.MAX_SIZE, 350);
		hints.put(EncodeHintType.MIN_SIZE, 100);

		return hints;
	}

	/**
	 * 获取网络图片流
	 * 
	 * @param url
	 * @return
	 */
	public static InputStream getImageStream(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			connection.setRequestMethod("GET");
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				return inputStream;
			}
		} catch (IOException e) {
			System.out.println("获取网络图片出现异常，图片路径为：" + url);
			e.printStackTrace();
		}
		return null;
	}

}

class LogoConfig {
	// logo默认边框颜色
	public static final Color DEFAULT_BORDERCOLOR = Color.WHITE;
	// logo默认边框宽度
	public static final int DEFAULT_BORDER = 0;
	// logo大小默认为照片的1/5
	public static final int DEFAULT_LOGOPART = 5;

	private final int border = DEFAULT_BORDER;
	private final Color borderColor;
	private final int logoPart;

	/**
	 * * Creates a default config with on color {@link #BLACK} and off color *
	 * {@link #WHITE}, generating normal black-on-white barcodes.
	 */
	public LogoConfig() {
		this(DEFAULT_BORDERCOLOR, DEFAULT_LOGOPART);
	}

	public LogoConfig(Color borderColor, int logoPart) {
		this.borderColor = borderColor;
		this.logoPart = logoPart;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public int getBorder() {
		return border;
	}

	public int getLogoPart() {
		return logoPart;
	}
}
