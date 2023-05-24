package com.test.spr;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class CalculatorBeforeAdvice implements MethodBeforeAdvice  //이걸 상속받았으므로 xml에 등록하면 알아서 주업무시행전에 수행되도록 약속되어있다.
{
	
	

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable
	{
		
		Log log = LogFactory.getLog(this.getClass());
		log.info("Before Advice 실행 ----------------");
		log.info("주 업무 실행 전에 수행되어야 하는 업무");
		log.info("Before Advice 실행 ---------------");
		
		
		
		
	}
	
	
	

}
