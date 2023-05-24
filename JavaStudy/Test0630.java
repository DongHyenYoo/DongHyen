/* Test063

다중for문을 활용한 별찍기 실습

다음과 같은 내용이 출력될수 있도록 반복문의 중첩 구문을 작성하여 프로그램구현

********** *의 출력은 2씩감소
 ********   공백의 출력은 1씩증가
  *****
   ***
    *
*/

public class Test0630
{

	public static void main(String[] args)
	{
		int i,j,lineNum;
		lineNum = 5;

		for(i=0;i<lineNum;i++)
		{

			for(j=0;j<i;j++){
				System.out.print(" ");
			}

			for(j=0;j<2*(lineNum-i)-1;j++){
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