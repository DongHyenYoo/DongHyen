/*===================================
�迭�� �迭(2���� �迭)
================================*/

//������ �迭�� Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭�� �����ϰ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.

//���� ��
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

	int finalnum=0;//������ �������� ���� ������ ��
	int n=1;

	int arr[][] = new int[5][5];

	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
			//n=0 �̰�n++  �̶�� ++n �� ����� �Ȱ��� �� -4�� �ؾ��ϴ°ɱ�?
			arr[i][j] = n;
			//n++ �� -=4 �� �Ⱦ��� arr[i][j] = i+j+1;�� �ص� �ȴ�.
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




