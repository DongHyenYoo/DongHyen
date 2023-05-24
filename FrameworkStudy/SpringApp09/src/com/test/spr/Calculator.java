/*======================

 Calculator.java
 - 인터페이스
 ===========================*/

// ※ 스프링에서 AOP 기법을 적용하기 위해서는
//  대상 객체가 인터페이스를 구현하고 있어야 한다.
package com.test.spr;

public interface Calculator
{
	
	//주 업무(core concern) 진행을 위한 메소드 선언
	// --- 덧셈 , 뺄셈, 곱셈 나눗셈 연산 수행
	
	public int add(int x,int y);
	public int sub(int x,int y);
	public int mul(int x,int y);
	public int div(int x,int y);
	

}
