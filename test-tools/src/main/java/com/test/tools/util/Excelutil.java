package com.test.tools.util;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * @param("excel标题数组","excel标题对应属性名称",对象集合)
 * @author hxb
 * 
 */
public class Excelutil {
	public <T> void export(String[] titles,String[] propertyNames,List<T> list, OutputStream out) throws Exception {
		try {
			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

			HSSFRow row = hssfSheet.createRow(0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

			// 居中样式
			hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCell hssfCell = null;
			for (int i = 0; i < titles.length; i++) {
				hssfCell = row.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}
			for (int num = 0; num < list.size(); num++) {
				row = hssfSheet.createRow(num+1); 
				Map<String, Object> objectMap = getObjectValue(list.get(num));
				for (String objKey : objectMap.keySet()) {
					Object objVal = objectMap.get(objKey);
					for (int i = 0; i < propertyNames.length; i++) {
						if (propertyNames[i].equals(objKey) && objVal != null) {
							row.createCell(i).setCellValue(objVal.toString());
						}
					}
				}
			}
			// 将文件输出到客户端浏览器
			try {
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			throw new Exception("导出信息失败！");
		}
	}

	public static <T extends Object> Map<String, Object> getObjectValue(T obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			// 拿到该类
			Class<?> clz = obj.getClass();
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = clz.getFields();
			if (fields != null && fields.length > 0) {
				for (Field field : fields) {
					field.setAccessible(true);
					Object value = new Object();
					try {
						value = field.get(obj);
						// 设置键值
						map.put(field.getName(), value);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return map;
	}
}
