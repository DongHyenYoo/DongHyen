/* Test063

다중for문을 활용한 별찍기 실습

다음과 같은 내용이 출력될수 있도록 반복문의 중첩 구문을 작성하여 프로그램구현

**********
 ********
  *****
   ***
    *
*/

public class Test063
{

	public static void main(String[] args)
	{
		int i,j,k; //i=열 j=빈칸 k=*

		for(i=1;i<=5;i++){

			for(j=1;j<i;j++){

				System.out.print(" ");
			}

			for(k=9;k>=2*i-1;k--)
				{
				System.out.print("*");
				}

			System.out.println("");


		}



	}


}
/*
*********
 *******
  *****
   ***
    *
계속하려면 아무 키나 누르십시오 . . .
*/