/*===================================
�迭�� �迭(2���� �迭)
================================*/

//������ �迭�� Ȱ���Ͽ�
//������ ���� �����͸� ��ҷ� ���ϴ� �迭�� ��
//���ϰ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.
//�迭�� �Ʒ��� ��� �� �迭�� 2���������Ϳ� ������ �����ϱ�

//���� ��
/*
E J O T Y
D I N S X
C H M R W
B G L Q V
A F K P U

 ù° ���� ���� 

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