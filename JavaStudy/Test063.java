/* Test063

����for���� Ȱ���� ����� �ǽ�

������ ���� ������ ��µɼ� �ֵ��� �ݺ����� ��ø ������ �ۼ��Ͽ� ���α׷�����

**********
 ********
  *****
   ***
    *
*/

public class Test063
{

	public static void main(String[] args)
	{
		int i,j,k; //i=�� j=��ĭ k=*

		for(i=1;i<=5;i++){

			for(j=1;j<i;j++){

				System.out.print(" ");
			}

			for(k=9;k>=2*i-1;k--)
				{
				System.out.print("*");
				}

			System.out.println("");


		}



	}


}
/*
*********
 *******
  *****
   ***
    *
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/