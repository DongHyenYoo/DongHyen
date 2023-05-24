/*===================================
배열의 배열(2차원 배열)
================================*/

//과제

//다차원 배열을 활용하여
//다음과 같은 데이터를 요소로 취하는 배열을 구
//성하고
//그 결과를 출력하는 프로그램을 구현한다.
//배열을 아래로 찍기 즉 배열을 2차원데이터에 밑으로 저장하기

//실행 예
/* 

A				65       i=0j=0       
C B             67 66    i=1j=0  i=1j=1  역방향부터 입력
D E F           68 69 70 i=2     정방향
J I H G         74 73 72 71  i=3   역방향
K L M N O       75 76 77 78 79  i=4 정방향

즉 항상 j는 i와 같거나 더 작아야한다. j<=i


*/
public class Test094
{

	public static void main(String[] args)
	{

		int arr[][] = new int[5][5];

			int n=65;

			for(int i=0;i<5;i++)
			{
				for(int j=0;j<=i;j++)
				{
					if(i%2==0) //짝수 열배열에는 정방향으로 입력되고
					{
						arr[i][j] = n;

					}
					else		//홀수 열배열에는 역방향으로 입력된다.
 						{
						arr[i][i-j] = n;
						}
					
					n++;					
				}
				
			}




			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					System.out.printf("%3c",arr[i][j]);
				}
			
			System.out.println();
			}

			/*
  A
  C  B
  D  E  F
  J  I  H  G
  K  L  M  N  O
계속하려면 아무 키나 누르십시오 . . .
*/




	}

}