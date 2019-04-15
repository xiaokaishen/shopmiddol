package com.test.database;

import org.aspectj.lang.ProceedingJoinPoint;

public class ChangeDBInteceptor {


	public Object changeDB(ProceedingJoinPoint pjp) throws Throwable {
		// AOP切点在Service的 包名.类名
		String path = pjp.getTarget().getClass().getName();

		// 如果servcie的 包名.类名 包含 oracle，那说明需要切换为oracle数据源
		if (path.indexOf("oracle") != -1) {
			

			DataSourceContextHolder.setDbType(DataSourceName.ORACLE_SOURCE);
		} else {
			
			DataSourceContextHolder.setDbType(DataSourceName.MYSQL_SOURCE);
		}
		return pjp.proceed();
	}
}
