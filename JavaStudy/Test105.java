/*===================================
���� �޷�
-������ ���� ����� ���α׷� ����
================================*/

//������ �Է��ϼ��� : 2022
//���� �Է��ϼ��� : 07


/*
[2022�� 7��]

�� �� ȭ �� �� �� ��
====================
				1 2
3  4  5  6  7  8  9
~
31
====================

�̷��� ��µǵ��� �Ѵ�.

���� 4�� ����̸鼭 100�� ����� x ������ 400�� ���
��� ������

���� 1.�Է��ϴ� �⵵ ��� �� �Է¹ޱ�

    2.�Է¹��� �⵵�� ���� ��� Ȯ���ؼ�
	  �� �迭�� 2�� �� �Է��ϱ�
	
	3.�Է��� ���� ���� �������������� �ϼ��� ����ϱ�

	4. 7�� ���� �������� ���������� 

	5.�� �迭�� ���� ������ͼ�
	�� ����ϱ�?


*/
import java.util.Scanner;


public class Test105
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};

		System.out.print("������ �Է��ϼ��� : ");
		int year = sc.nextInt();
		System.out.print("���� �Է��ϼ��� : ");
		int month = sc.nextInt();

		if(((year%4==0 && year%100!=0) || year%400==0))
			monthArr[1] =29;

		int day = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400; //���⵵�� 12�� 31������ �ϼ� ���⿡ ��Ҿ� day

		for(int i=0;i<month-1;i++)  //7���� �Է��Ѵٸ� 6���������� �ϼ���
		{
			day += monthArr[i]; //day
		}

		//System.out.println(day);

		int dayStart = (day%7)+1; //������ �������� +1 �� �������̴�.

		char [] nameDay={'��','��','ȭ','��','��','��','��'}; 

		//System.out.println(nameDay[dayStart]);




		System.out.printf("[%d�� %d��]\n",year,month);
		for(int i=0;i<nameDay.length;i++)
		{
			System.out.printf("%2c",nameDay[i]);
		}
		System.out.println();
	





		

		for(int i=1;i<=dayStart;i++)
			System.out.print("   ");

		//���� ��� ��


		//int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};

		for(int i=1;i<=monthArr[month-1];i++)
		{
			System.out.printf("%3d",i);
				day++;
			if(day%7==6){
			System.out.println();
			}
		}
	//	if((day)%7!=0)
	//	{
		System.out.println();
		}
	
	
/*	
		String[][] calender = new String[5][7]; //�̰� ��� ����
		
		//���� ����
		
		for(int i=0;i<=dayStart;i++)
			calender[0][i] = "   ";
		
		
		for(int i=0
		String[] 



		int n=1;

		for(int i=0;i<calender.length;i++)
		{
			calender[i][dayStart+i+1]= n;
			n++;
		}



		for(int i=0;i<calender.length;i++)
		{
			for(int j=0;j<calender[i].length;j++)
			{
			System.out.print(calender[i][j]);
			}
			System.out.println();
		}
		
*/

	
}

		








