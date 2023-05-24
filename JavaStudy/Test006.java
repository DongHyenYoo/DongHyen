public class Test006{

	public static void main(String[] args){


		int a;
		a = 10;
		System.out.println("a의 결과 =" + a);
		int b;
		b= 20;
		System.out.println("b의 결과 =" + b);
		
		short c;
		//연산 및 처리(대입 연산)
		c =(short)a; //(short)를 쓰지않으면 int -> short 자동형변환 규칙 위반임으로 컴파일에러
 // 0000000 000000 0000000 00001010 -> int 형 a 변수 10
 // 00000000 00001010 short형으로 변환
		//결과 출력
		System.out.println("c 의 결과 : " + c);

		long d = 1000000000L; //백억
      //21억이 넘는 숫자는 long형에 숫자뒤에 L을 붙여 상수를 표현해야한다. 컴파일러는 오른쪽부터 보므로
	  
	    System.out.println("d결과 = " + d);
		//System.out.println(" %d",d);
        //System.out.println("%d",d);
		//변수 선언 및 초기화
		int e = 030;

		//결과
		System.out.println("e 의 결과 : " + e); 
		//앞의 0이 사라지는것은 물론 앞의 0에 의해 8진수로 인식되어 24라는 결과

		//변수 선언 및 초기화
		int f = 0xa6;

		//결과
		System.out.println("f의 결과 : " + f);
		//f의 결과 : 166
		//접두사 0x가 붙으면 16진수로 인식

		//변수선언
		//float g = 0.0; double이 기본인데 float가 나와서 자동형변환이 불가하여 컴파일에러
       // float g = 0.0;
		//결과
		//System.out.println("g의 결과 : " + g);

  










	}









}