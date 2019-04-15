package com.test.tools.util;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Random;

/** 
 * @author  		yirenjie   
 * @version 		V1.0
 * @Description: 	
 * 砍价列表生成砍一刀 随机数规则
 */
public class RandomUtil {
	
	private static final Random random = new Random();
	
   	 /**
	 * 该随机数策略 是默认 生成一个到最小值到最大值的一个随机数 
	 * 最普通的生成随机数的规则  
	 */
	 public static Double  ordinaryGenerate(Double minPrice,Double maxPrice){
		//每一次分配范围
		 double everyAllot=maxPrice-minPrice;
		 //这个是0-1之间的小数 不包括1
		 double nextDouble = random.nextDouble();
		 while(nextDouble==0){
			 nextDouble = random.nextDouble();
		 }
		 double value = minPrice+nextDouble*everyAllot;
		 //保留两位小数
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 nf.setRoundingMode(RoundingMode.DOWN);
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2);
		 return Double.parseDouble(nf.format(value));
	 }
	
	 
	 public static void main(String[] args) {
		  String now = DateUtils.getNow();
		  
		  System.out.println(now);
	}
	
	
	
	
	
	
	
	
	
	

}
 
