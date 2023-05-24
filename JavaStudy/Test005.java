/*변수와 자료형

-키워드 및 식별자

-printf -println -format

================================*/


public class Test005{
	
	public static void main(String[] args){
       
	   //변수 선언(메모리 확보) 및 초기화(메모리에 값 할당)

	  int a=10, b=5;

	  //변수 선언
	  int c, d;

	  //연산 및 처리

	  c = a + b;        // a +b 의 결과값을 변수 c에 대입하라.
	  d = a - b;        // a - b 의 결과값을 변수 d에 대입하라.

 //결과 출력 -> 15
	   System.out.println(a + "+" + b + "=" + c);
	   System.out.println(d);
//자바에서는 서로다른 자료형의 데이터 끼리도 + 연산이 가능하며
// 다른 자료형과 문자열 데이터의 + 결과는 문자열이다. 이때도 문자열 결합 연산자로써의 +이다.



//System.out.printf(" O + O = O" , 10 , 20 ,30); 전달하는 파라미터는 4개다.
      System.out.printf("%d + %d = %d%n", 10 ,20 ,30);
//%d = 10진수 정수형의 서식 지정 옵션이다. 옵션을 전달할때 %로 시작하기에 결과 줄을 띄울때 \n %n이 같은 결과를 가진다.
       System.out.printf("%d + %d = %d\n", 10 ,20 ,30);

//System.out.printf("%d 와 %d\n", 10, 3.14); 이렇게하면 컴파일에러는 없으나 실행하면 런타임에러가 생긴다.
       System.out.printf("%d 와 %f\n", 10, 3.14);
     //%f 는 실수형 서식 지정 옵션

	 System.out.printf("%d 와 %.2f\n", 10, 3.14);
	 //%.2f 는 소수점 이하 두번째 까리 자리까지 표현


	 System.out.printf("%f%n", 3.141592);
// 3.1415192나옴
     System.out.printf("%.4f\n", 3.141592);
	 //.4f소수점 이하 네번째 자리까지 표현을 하나 반올림을 한다.
	 
	}






}