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
1 8 9 16 17
2 7 10 15 18
3 6 11 14 19
4 5 12 13 20

�Է¼���
 i =0			i=1Ȧ��			i=2¦��			i=3Ȧ��			i=4¦��			
00 10 20 30		31 21 11 01		02 12 22 32		33 23 13 03		04 14 24 34
j = 0123       j=3210			j=0123			j=3210			j=0123

1  2  3  4      8  7  6   5     9  10 11 12		16 15 14 13     17 18 19 20

 i =0			i=1Ȧ��			i=2¦��			i=3Ȧ��			i=4¦��			
00 01 02 03		13 12 11 10		20 21 22 23		33 32 31 30		40 41 42 43
j = 0123       j=3210			j=0123			j=3210			j=0123

1  2  3  4      8  7  6   5     9  10 11 12		16 15 14 13     17 18 19 20
*/

public class Test089
{
	public static void main(String[] args)
	{
		int arr[][] = new int[4][5];


		//������ �غ���
		//0��° ������ �������� i=0 0123
		//1��° ������ ����     i=1 3210
		//2��° ��				i=2	0123
		//3��° ����			i=3 3210
		//4��° �ٽ� ����		i=4 0123
/*
		i=0		i=1		i=2		i=3		i=4
		0		3		0		3		0
		1		2		1		2		1
		2		1		2		1		2
		3		0		3		0		3




*/




/*
		int n=0;
		for(int i=0;i<5;i++){ // 0 1 2 3 4
		
			for(int j=0;j<4;j++) // 0 1 2 3
		{
			n++;
			if(i%2==0) // 0 2 4
			{
				arr[j][i] = n; //j�� 0123 ���� ��
			}
			else //i = 1 3
			{
				arr[3-j][i] = n; //j�� 3210 ���� �ٲٰڴٴ��� 31 21 11 01  33 23 13 03
			}

		}

	}
			for(int i=0; i<arr.length;i++)
			{
				for(int j=0; j<arr[i].length;j++)
			{
					System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
			

	}
}


*/

/*		
			int temp=1;
		

			for(int i=0;i<5;i++)
				{
				if(i%2 ==0)
					for(int j=0;j<arr.length;j++)
					{
					arr[j][i] = temp++;
					
					}
					else if(i%2 != 0)
					{
						for(int j = arr.length-1;j>=0;j--)
							arr[j][i] = temp++;
						
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
*/
/*
			int arr[][] = new int[4][5];
		
			int temp=1;
		

			for(int i=0;i<5;i++)
				{
				if(i%2 ==0)
					for(int j=0;j<arr.length;j++)
					{
					arr[j][i] = temp++;
					
					}
					else if(i%2 != 0)
					{
						for(int j = arr.length-1;j>=0;j--)
							arr[j][i] = temp++;
						
					}
				}
				

				for(int i=0;i<arr.length;i++)
				{
				for(int j=0;j<arr[i].length;j++)
					{

					System.out.printf("%3d",arr[i][j]);
					}
					Syst


	
					if(i%2==0||i==0){
					arr[j][i] = temp;
					System.out.printf("(%d %d) = %2d",j,i,temp);
					temp++;
					j++;
					}

					else {
					arr[i][j] = temp;
					System.out.printf("(%d %d) = %2d",j,i,temp);
					temp++;
					j++;
					}

					if(j==4)
						{
						break;
						}
						n++;
					





			int temp=1;
		

			for(int i=0;i<arr[i].length;i++)
				{
				for(int n=1,j=0;n<=20;n++)
					{
					
					
					arr[j][i] = temp;
					System.out.printf("(%d %d) = %2d",i,j,temp);
					temp++;
					j++;
					if(j==5)
						{
						break;
						}
						n++;
					

					}
					System.out.println();
			
				}
*/