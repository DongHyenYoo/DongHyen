/*=========================================
 * Main.java
 * -클래스
 * -main() 메소드가 포함된 테스트 클래스.
===========================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	
	public static void main(String[] args)
	{
		
		//주 업무 실행에 대한 테스트(Spring AOP 기법 적용 후)
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		//Spring 에서 제공하는 proxy를 활용하여
		//보조 업무와 결합된 형태로 업무 처리~~!!!
		//인터페이스 형태의 변수명에 = new 인터페이스를 구현한 객체();
		Calculator cal = context.getBean("proxy", Calculator.class);
		
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int mul = cal.mul(20, 30);
		System.out.println(mul);
		
		int div = cal.div(30, 15);
		System.out.println(div);
		
		
		//예외 상황이 발생할 수 있도록 값을 구성하는 처리 추가
		int add2 = cal.add(100, 200);
		System.out.println(add2);
		
		
	}

}
