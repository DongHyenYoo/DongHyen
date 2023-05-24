/*===================================
배열의 배열(2차원 배열)
================================*/

//다차원 배열을 활용하여
//다음과 같은 데이터를 요소로 취하는 배열을 구
//성하고
//그 결과를 출력하는 프로그램을 구현한다.
//배열을 아래로 찍기 즉 배열을 2차원데이터에 밑으로 저장하기

//실행 예
/*
E J O T Y
D I N S X
C H M R W
B G L Q V
A F K P U

 첫째 줄은 역순 

*/
public class Test090
{
	public static void main(String[] args)
	{

	char arr[][] = new char[5][5];

		char n ='A';
		
		for(int i=0;i<5;i++)
		{
			for(int j=4;j>=0;j--)
		{
			arr[j][i] = n;
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

}

}