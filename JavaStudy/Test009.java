//자바의 개요 및 특징
//변수와 자료형 - 5일차
//변수와 자료형 실습 및 테스트 : double
//나눗셈 연산 실습

public class Test009{

	public static void main(String[] args){

		//정수와 정수의 나눗셈
		double a = 1/2;
		//double a = 0;
		System.out.println("double a : " +a);
		//--==>> double a : 0.0

		double b = (double)1/2; // 1이 double로 변함 연산중 수가 하나라도 실수라면 실수기반의 연산을 수행한다.
		                        //1.0 /2 가 되어 실수 연산을 수행하는것이 맞고
								//(double)0 이 되는 것이 아니다.
		//double a = (double)0;
		System.out.println("double b : " + b);
		//--==>>double b : 0.5

		// double c = 1/2 + 1/2;  결과는 0.0이 나옴
		
		double c = 1/2 + 1/2;
		System.out.println("double c : " + c); // 0.0

		double d = 1 / 2.0; //피 연산자로 실수가 포함되어 있는 나눗셈 연산
		System.out.println("double d : " + d);
		//결과는 0.5
		//나눗셈 연산과 관련하여 
		//피연산자 중 실수가 하나라도 포함되어 있다면
		// 연산은 실수 기반의 연산이 수행되며
		//결과 값 또한 실수 형태로 반환

		double e = 3/2 + 1/2;
		//double e = 1 + 1/2;
		//double e  = 1 + 0;
		//double e = 1;
		System.out.println("double e : " + e);
	    // 결과는 실수형으로 변환되어 1.0
		
		double f = 3/2 + 1/2.0;
		//f = 1 + 1/2.0
		//f = 1 + 0.5;
		//f = 1.5;
		System.out.println("double f : " + f);
		//double f : 1.5




	}




}