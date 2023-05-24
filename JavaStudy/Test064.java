/* Test064

다중for문을 활용한 별찍기 실습

다음과 같은 내용이 출력될수 있도록 반복문의 중첩 구문을 작성하여 프로그램구현
     *    1
    ***   3
   *****   5
  *******  7
 ********* 9
  *******  7
   *****  5
    ***   3
     *    1
*/


public class Test064
{
	public static void main(String[] args)
	{
		int moondan,i,j,k; //i=열 = 9줄 j=빈칸 k=*

		int halfline;
		
		

		for(i=1;i<=5;i++) //열은 9줄이다. 1~5줄
		{
			for(j=4;j>=i;j--){
				
				System.out.print(" ");
			}
			for(k=1;k<=i*2-1;k++){
				System.out.print("*");
			}

			System.out.println("");
		}


		for(i=1;i<=4;i++) //열은 9줄이다. 6줄에서 9줄을 출력한다.
		{
			for(j=1;j<=i;j++){  //6
				
				System.out.print(" ");
			}
			for(k=7;k>=2*i-1;k--){  //*을 7개부터 찍는다.
				System.out.print("*");
			}

			System.out.println("");
		}

/* 실행결과
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
계속하려면 아무 키나 누르십시오 . . .
*/


/*
		for(moondan=1;moondan<=2;moondan++)
		{

			for(i=1;i<=9;i++)
			{
				halfline = (i==5)? 1 : (i>5)? 2 : 0; //i 가 5면 1을  i가 5보다 크면 2를 5보다 작으면 0을

				switch(halfline){

				case 0: for(j){
					
					
					}

				for(k){
				}

				break;

				case 1: for(k=1;k<=9;k++) System.out.print("*"); break;


				
				case 2: for() break;


				
				
			}


			System.out.println("");


*/




	}


}