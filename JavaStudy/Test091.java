/*===================================
�迭�� �迭(2���� �迭)
================================*/

//������ �迭�� Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭�� ��
//���ϰ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.
//�迭�� �Ʒ��� ��� �� �迭�� 2���������Ϳ� ������ �����ϱ�

//���� ��
/*                       +
		1   2   3   4    10
		5   6   7   8    26
		9   10  11  12   42
		13  14  15  16   58
	+	28  32  36  40   136

 ù° ���� ���� 

*/
public class Test091
{
	public static void main(String[] args){

	//���� �����غ��� �ϴ� �迭�� 5 5�̳�
	//�츮�� ������ �Է��ؾ��� ���� 4*4 �̴�.
	//���� for���� ���� �����ڸ��� ���� ����

	int arr[][] = new int[5][5];
	int n=1;
	
	
		for(int i=0;i<4;i++)
	{
			for(int j=0;j<4;j++)
		{
				arr[i][j] = n;
				arr[i][arr[i].length-1]+=arr[i][j];
				//arr[0][4] += [0][0]+[0][1] �ַ��

				//arr[arr.length-1][i]+=arr[j][i];
				arr[arr.length-1][j] += arr[i][j];
				//arr[4][0] += [0][0] �ַ�� �ȴ�.
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
	
	for(int i=0;i<5;i++)          //4�� �ϸ� ���� �ȳ����� 5�� �ϸ�ȴ�.
		{
		for(int j=0;j<4;j++)    //j�� �� 0���� �����ϸ� �ȵɱ�? �ѹ� �˾ƺ���.int j=0;j<4;j++   int j=3;j>=0;j-- �ƹ������� �׳� j i ��ġ�� �߸�������
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