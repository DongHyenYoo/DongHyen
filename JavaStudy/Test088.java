/*===================================
�迭�� �迭(2���� �迭)
================================*/

//������ �迭�� Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭�� �����ϰ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.

//���� ��
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