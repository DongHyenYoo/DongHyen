/*===================================
배열의 배열(2차원 배열)
================================*/

//다차원 배열을 활용하여
//다음과 같은 데이터를 요소로 취하는 배열을 구성하고
//그 결과를 출력하는 프로그램을 구현한다.

//실행 예
/*
12345
23456
34567
56789
*/


public class Test087
{
	public static void main(String[] args)
	{

	int finalnum=0;//한줄이 끝난후의 값을 저장할 값
	int n=1;

	int arr[][] = new int[5][5];

	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
			//n=0 이고n++  이라면 ++n 도 결과가 똑같다 왜 -4를 해야하는걸까?
			arr[i][j] = n;
			//n++ 나 -=4 을 안쓰고 arr[i][j] = i+j+1;을 해도 된다.
			n++;
			

		}
		n-=4;
	}

	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
			System.out.printf("%3d",arr[i][j]);

		}
		System.out.println();
	}
	}

}




