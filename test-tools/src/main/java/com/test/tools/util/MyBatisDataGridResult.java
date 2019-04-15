package com.test.tools.util;

import java.util.List;

/**
 * 分页参数工具类
 * 
 * @author acai
 *
 */
public class MyBatisDataGridResult {

	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "MyBatisDataGridResult [total=" + total + ", rows=" + rows + "]";
	}
	
	
	
	

}
