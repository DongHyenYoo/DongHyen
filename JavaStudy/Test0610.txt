/* Test061

다중for문을 활용한 별찍기 실습

다음과 같은 내용이 출력될수 있도록 반복문의 중첩 구문을 작성하여 프로그램구현

     *    
    **   
   ***  
  ****
 *****

*/
public class Test061
{

	public static void main(String[] args)
	{

		int i,j,z; //i =는 열  j = ""행 z 는 *행



		for(i=1;i<=5;i++){
			
			for(j=4;j>=i;j--){

				System.out.print(" ");


			}

			for(z=1;z<=i;z++){

				System.out.print("*");


			}


			System.out.println("");

		}

	}
}
/*
    *
   **
  ***
 ****
*****
계속하려면 아무 키나 누르십시오 . . .
*/