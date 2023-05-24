/*===================================
배열의 배열(2차원 배열)
================================*/

//다차원 배열을 활용하여
//다음과 같은 데이터를 요소로 취하는 배열을 구
//성하고
//그 결과를 출력하는 프로그램을 구현한다.
//배열을 아래로 찍기 즉 배열을 2차원데이터에 밑으로 저장하기

//실행 예
/*                       +
		1   2   3   4    10
		5   6   7   8    26
		9   10  11  12   42
		13  14  15  16   58
	+	28  32  36  40   136

 첫째 줄은 역순 

*/
public class Test091
{
	public static void main(String[] args){

	//ㅇㅋ 생각해보자 일단 배열은 5 5이나
	//우리가 실제로 입력해야할 값은 4*4 이다.
	//이후 for문을 통해 각끝자리에 합을 넣자

	int arr[][] = new int[5][5];
	int n=1;
	
	
		for(int i=0;i<4;i++)
	{
			for(int j=0;j<4;j++)
		{
				arr[i][j] = n;
				arr[i][arr[i].length-1]+=arr[i][j];
				//arr[0][4] += [0][0]+[0][1] 주루룩

				//arr[arr.length-1][i]+=arr[j][i];
				arr[arr.length-1][j] += arr[i][j];
				//arr[4][0] += [0][0] 주루룩 된다.
				//arr[4][1] += [0][1]


				arr[arr.length-1][arr.length-1] += arr[i][j];
				//arr[i][4] += arr[i][j]
				//arr[4][j] += arr[i][j]
				//arr[4][4] += arr[i][j]
				

				n++;
		}
	}


/*

		for(int i=0;i<4;i++)
	{
			for(int j=0;j<4;j++)
		{
				arr[i][j] = n;
				arr[i][arr[i].length-1]+=arr[i][j];
				n++;
		}
	}
*/

		for(int i=0;i<4;i++)
	{
			for(int j=0;j<4;j++)
		{
				arr[i][arr[i].length-1]+=arr[i][j];
		}
	
	}

/*
	
	for(int i=0;i<5;i++)          //4를 하면 끝이 안나오고 5를 하면된다.
		{
		for(int j=0;j<4;j++)    //j가 왜 0부터 시작하면 안될까? 한번 알아보자.int j=0;j<4;j++   int j=3;j>=0;j-- 아무리봐도 그냥 j i 위치를 잘못썻던듯
			{
			arr[arr.length-1][i]+=arr[j][i];
			//System.out.printf("%3d",arr[j][i]);
			}
		//System.out.println();
		}
*/
	


	for(int i=0;i<5;i++)
	{
			for(int j=0;j<5;j++)
		{
				System.out.printf("%4d",arr[i][j]);
		}
	
	System.out.println();
	}



}
}