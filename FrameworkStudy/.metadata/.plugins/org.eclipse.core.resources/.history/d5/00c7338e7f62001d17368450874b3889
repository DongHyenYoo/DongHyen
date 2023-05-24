/*
 CalculatorAspect.java
 -보조 엄무 수행 클래스.
 - 보조 업무 적용 및 주 업무 호출 구조
 */

package com.test.spr;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Spring AOP Proxy 클래스를 설계하기 위해
// MethodInterceptor 인터페이스를 구현하는 클래스로 만든다.


public class CalculatorAspect implements MethodInterceptor
{

	//MethodInterceptor 인터페이스의 invoke() 메소드 재정의
	@Override
	public Object invoke(MethodInvocation method) throws Throwable
	{
		
		Object result = null;
		
		//보조 업무(cross-cutting-concern)설정
		Log log= LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		
		sw.start();
		log.info("처리시간 측정 시간 ============================");
		
		//주 업무 실행 내용 호출~!
		result = method.proceed();
		
		//보조 업무(cross-cutting-concern)처리
		sw.stop();
		log.info("처리시간 측정 종료=============================");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));
		
		return result;

	}
	
	

}
