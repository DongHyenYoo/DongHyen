/*===================================
배열의 배열(2차원 배열)
================================*/

//다차원 배열을 활용하여
//다음과 같은 데이터를 요소로 취하는 배열을 구성하고
//그 결과를 출력하는 프로그램을 구현한다.

//실행 예
/*
1 2 3 4 5
5 1 2 3 4
4 5 1 2 3
3 4 5 1 2
2 3 4 5 1
*/

public class Test088
{
	public static void main(String[] args)
	{

		int arr[][] = new int[5][5];
		
		
		/*for(int i=0;i<arr.length;i++)
		{

			int a = 1;
			int b = 6-i;

			for(int j=0;j<arr[i].length;j++)
			{
				if(i <= j)
					arr[i][j] = a++;
				else
					arr[i][j] = b++;


				}
				
			}*/
			
			for(int i=0;i<arr.length;i++)
			{
			for(int n=1,j=i;n<=5;n++)
			{
				arr[i][j] = n;
				System.out.printf("\t%d %d = %d\t",i,j,n);
				j++;

				if(j==5){
					j=0;
				}
				
				

				}
				System.out.println();
		
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