/* Test063

����for���� Ȱ���� ����� �ǽ�

������ ���� ������ ��µɼ� �ֵ��� �ݺ����� ��ø ������ �ۼ��Ͽ� ���α׷�����

********** *�� ����� 2������
 ********   ������ ����� 1������
  *****
   ***
    *
*/

public class Test0630
{

	public static void main(String[] args)
	{
		int i,j,lineNum;
		lineNum = 5;

		for(i=0;i<lineNum;i++)
		{

			for(j=0;j<i;j++){
				System.out.print(" ");
			}

			for(j=0;j<2*(lineNum-i)-1;j++){
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