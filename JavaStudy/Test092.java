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

A B C D E
F G H I J
K L M N O
P Q R S T
U V W X Y



*/
public class Test092
{

	public static void main(String[] args)
	{

		int arr[][] = new int[5][5];

			int n=65;

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++)
				{
					arr[i][j] = n;
					n++;

				}

			}

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++)
				{
					System.out.printf("%4c",arr[i][j]);

				}
				System.out.println();

			}
/*
   A   B   C   D   E
   F   G   H   I   J
   K   L   M   N   O
   P   Q   R   S   T
   U   V   W   X   Y
계속하려면 아무 키나 누르십시오 . . .
*/




	}

}