package com.test.tools.util;

import java.util.Random;

public class GiftGeneratingTool {
	private static String[] LettersAndNums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
			"z" };
	private static String[] Nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	
	synchronized public static  String getGiftAccounts() {
		StringBuffer sb = null;
			int accountLenght = 8;
			sb = new StringBuffer();
			try {
				for (int i = 0; i < accountLenght; i++) {
					Random ram = new Random();
					sb.append(LettersAndNums[ram.nextInt(LettersAndNums.length)]);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		return sb.toString();
	}

	synchronized public static String getGiftPassword() {
			int secretLenght = 6;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < secretLenght; i++) {
				Random ram = new Random();
				sb.append(Nums[ram.nextInt(Nums.length)]);
			}
			return sb.toString();
	}
}
