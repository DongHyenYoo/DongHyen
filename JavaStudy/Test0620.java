/* Test062

����for���� Ȱ���� ����� �ǽ�

������ ���� ������ ��µɼ� �ֵ��� �ݺ����� ��ø ������ �ۼ��Ͽ� ���α׷�����

     *    1
    ***   3
   *****   5
  *******  7
 ********* 9

*/

//������ ������ 4->1������
//���� ������ 1->9 ���� ���������� 2�� �����Ѵ�.




public class Test0620
{

	public static void main(String[] args)
		
	{
		int lineNum = 5;   //���� 5��
		int i,j;

		for(i=0;i<lineNum;i++){

			for(j=0;j<lineNum-1-i;j++)
			{
				System.out.print(" ");
			}
			for(j=0;j<2*i+1;j++)
			{
				System.out.print("*");
			}





			System.out.println("");

		}
		



	}


}

/*
    *
   ***
  *****
 *******
*********
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/