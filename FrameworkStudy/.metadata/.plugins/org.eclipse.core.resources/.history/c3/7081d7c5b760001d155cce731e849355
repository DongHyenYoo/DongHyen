/*================================
 
 CalculatorAfterThrowing.java
 - After Throwing Advice 구성
 ===============================*/

package com.test.spr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class CalculatorAfterThrowing implements ThrowsAdvice
{
	
	public void afterThrowing(IllegalArgumentException e)throws Throwable
	{
		System.out.println(e.toString()); //과 같은 처리가 가능
		
		Log log = LogFactory.getLog(this.getClass());
		log.info("After Throwing Advice 실행==========================");
		log.info("주 업무 실행 과정에서 예외 발생 시 처리되는 사후 업무");
		log.info("After Throwing Advice 실행==========================");
		
		
	}
	
	

}
