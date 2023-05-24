/*===================================
배열의 배열(2차원 배열)
================================*/

//다차원 배열 활용하여
//다음과 같은 데이터를 요소로 취하는 배열(5*5)를 구성하고
//그 결과를 출력하는 프로그램 구현


public class Test086
{
	public static void main(String[] args)
	{
		int n=1;

		int arr[][] = new int[5][5]; //5까지 생성이 아니라 5칸의 배열을 생성하겠다는것

			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					arr[i][j] = n;
					//System.out.println(arr[i][j]);
					n++;
					


			}
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

