/* Test064

����for���� Ȱ���� ����� �ǽ�

������ ���� ������ ��µɼ� �ֵ��� �ݺ����� ��ø ������ �ۼ��Ͽ� ���α׷�����
     *    1
    ***   3
   *****   5
  *******  7
 ********* 9
  *******  7
   *****  5
    ***   3
     *    1
*/


public class Test064
{
	public static void main(String[] args)
	{
		int moondan,i,j,k; //i=�� = 9�� j=��ĭ k=*

		int halfline;
		
		

		for(i=1;i<=5;i++) //���� 9���̴�. 1~5��
		{
			for(j=4;j>=i;j--){
				
				System.out.print(" ");
			}
			for(k=1;k<=i*2-1;k++){
				System.out.print("*");
			}

			System.out.println("");
		}


		for(i=1;i<=4;i++) //���� 9���̴�. 6�ٿ��� 9���� ����Ѵ�.
		{
			for(j=1;j<=i;j++){  //6
				
				System.out.print(" ");
			}
			for(k=7;k>=2*i-1;k--){  //*�� 7������ ��´�.
				System.out.print("*");
			}

			System.out.println("");
		}

/* ������
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/


/*
		for(moondan=1;moondan<=2;moondan++)
		{

			for(i=1;i<=9;i++)
			{
				halfline = (i==5)? 1 : (i>5)? 2 : 0; //i �� 5�� 1��  i�� 5���� ũ�� 2�� 5���� ������ 0��

				switch(halfline){

				case 0: for(j){
					
					
					}

				for(k){
				}

				break;

				case 1: for(k=1;k<=9;k++) System.out.print("*"); break;


				
				case 2: for() break;


				
				
			}


			System.out.println("");


*/




	}


}