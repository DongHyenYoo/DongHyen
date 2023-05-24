/* Test062

다중for문을 활용한 별찍기 실습

다음과 같은 내용이 출력될수 있도록 반복문의 중첩 구문을 작성하여 프로그램구현

     *    1
    ***   3
   *****   5
  *******  7
 ********* 9

*/

//공백은 여전히 4->1까지고
//별의 개수는 1->9 까지 순차적으로 2씩 증가한다.




public class Test0620
{

	public static void main(String[] args)
		
	{
		int lineNum = 5;   //열은 5개
		int i,j;

		for(i=0;i<lineNum;i++){

			for(j=0;j<lineNum-1-i;j++)
			{
				System.out.print(" ");
			}
			for(j=0;j<2*i+1;j++)
			{
				System.out.print("*");
			}





			System.out.println("");

		}
		



	}


}

/*
    *
   ***
  *****
 *******
*********
계속하려면 아무 키나 누르십시오 . . .
*/