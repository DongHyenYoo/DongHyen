/*===================================
�迭�� �迭(2���� �迭)
================================*/

//������ �迭 Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭(5*5)�� �����ϰ�
//�� ����� ����ϴ� ���α׷� ����


public class Test086
{
	public static void main(String[] args)
	{
		int n=1;

		int arr[][] = new int[5][5]; //5���� ������ �ƴ϶� 5ĭ�� �迭�� �����ϰڴٴ°�

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

