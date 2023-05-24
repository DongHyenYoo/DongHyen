//반복문 실습

/*반복문의 개요

주어진 조건이 참 인 경우
일정한 영역의 문장을 반복 수행하다가
조건식이 거짓이 되는 순간이 오면
반복 수행을 중단하는 문장이다.
이러한 반복문에는 while , do while, for 가 있다
반복의 제어를 위해 break, continue문을 사용하는 경우가있다.




while문
 조건식을 먼저 이교하여
 조건식의 처리결과가 참인경우, 특정 영역을 반복 수행하는 문장으로
 반복 횟수가 정해져 있지 않은 경우나
 반복 횟수가 많은 경우 주로 사용한다.
 while 문은 조건이 맞지 않은경우 실행되지 않는다.

 while문의 형식

 while(조건식)
 {
	 실행문;
}

*/

public class Test044
{
	public static void main(String[] args)
		{

/*
		int n = 0;


		while(n<=10)
			{
			
			System.out.println("n = "+n);
			n++;
			   //postfix로 다음구분에서 +된다.
			

			}

*/			

			/*

		int n = 0;
		
		while(n++<=10){

			System.out.println("n = " + ++n);


		}
		*/

		/*

		int n = 0;
		
		while(n<10){ //반복문에서 가장 중요한건  조건

			System.out.println("n = " + n);
			n++;
		}
		*/

		//1 부터 100까지 합
		
		int n = 0,sum = 0;


	    while(++n<=100){  //n++이 아닌이유와(postfix는 n이 다음에 처리될때 더해진다. 즉다음 등장전까지는 영향이 없는것(다음에 등장시 +1 해라)				++n이어야하는 이유
						  //시작은 똑같이 1이나 해당 구문이 끝난후 더해지기에 100이되었을때 조건문에서 나가면서 101이 된다. 단 조건이<라면 postfix여야한다.   시작이 1 이고 n이 99일때 조건문으로 가면서 +1이되어 100까지만 더해지고 끝남
			
			sum += n;

		}
		
		System.out.println("1부터 100까지의 합 : "+sum);



		}

}