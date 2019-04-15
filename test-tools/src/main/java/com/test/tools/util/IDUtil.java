package com.test.tools.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * 生成唯一订单号
 * 
 * @author acai
 *
 */
public class IDUtil {

	/**
	 * 生成一个32位的短UUID
	 */

	public static String generateShortUuid() {

		String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 32; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString().toLowerCase();

	}

	/**
	 * 获取随机四位数验证码
	 */

	public static int getContentID() {
		int radomInt = new Random().nextInt(9000)+1000;
		return radomInt;
	}

	/**
	 * 订单id生成
	 */
	public static long getOrderId() {
		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上两位随机数
		Random random = new Random();
		int end5 = random.nextInt(99999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end5);
		long id = new Long(str);
		return id;
	}

	/**
	 * 商品销售id生成
	 */
	public static long getWineId() {
		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上两位随机数
		Random random = new Random();
		int end5 = random.nextInt(99999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end5);
		long id = new Long(str);
		return id;
	}

	/**
	 * 会所id生成
	 */
	public static long getClubId() {
		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上两位随机数
		Random random = new Random();
		int end5 = random.nextInt(99999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end5);
		long id = new Long(str);
		return id;
	}

	/**
	 * 会所图片id生成
	 */
	public static long getClubImagesId() {
		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上两位随机数
		Random random = new Random();
		int end5 = random.nextInt(99999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end5);
		long id = new Long(str);
		return id;
	}

	/**
	 * 服务评价id生成
	 */
	public static long getWaiterId() {
		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上两位随机数
		Random random = new Random();
		int end5 = random.nextInt(99999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end5);
		long id = new Long(str);
		return id;
	}

	/**
	 * 管理员ID
	 * 
	 * @param args
	 */

	public static long getAdminId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		return Long.parseLong(str);

	}

	/**
	 * 随机生成广告位ID
	 */

	public static long getAdvertisementId() {
		// 取当前时间的长整形值包含毫秒
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		// 如果不足两位前面补0
		String str = format + String.format("%04d", end4);
		long id = new Long(str);

		return id;
	}

	/**
	 * 随机生成菜品ID
	 */

	public static long getDishesId() {
		// 取当前时间的长整形值包含毫秒
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end4);
		long id = new Long(str);

		return id;
	}

	/**
	 * 随机生成菜品订单ID
	 */

	public static long getDishesListId() {
		// 取当前时间的长整形值包含毫秒
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		// 如果不足两位前面补0
		String str = format + String.format("%05d", end4);
		long id = new Long(str);

		return id;
	}

	/**
	 * 随机生成房型ID
	 */

	public static long getHouseID() {
		Random random = new Random();
		int end5 = random.nextInt(99999);

		String res = "1" + String.format("%05d", end5);

		long houseID = new Long(res);
		return houseID;

	}

	/**
	 * 随机生成会员ID
	 */

	public static long getUserId() {

		// 取当前时间的长整形值包含毫秒

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

		String format = df.format(LocalDateTime.now());
		// 加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		// 如果不足两位前面补0
		String str = format + String.format("%04d", end4);
		long id = new Long(str);

		return id;
	}

	/**
	 * 随机生成商品唯一id
	 * 
	 * @return
	 */
	public static String getGoodsId() {

		String goodsId = "SHOP_" + DateUtils.getNow("yyyyMMdd") + String.format("%07d", new Random().nextInt(9999999));

		return goodsId;

	}

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10000; i++) {
			System.out.println(getGoodsId());
		}

	}
}
