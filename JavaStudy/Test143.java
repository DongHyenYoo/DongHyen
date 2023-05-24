/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
-Calendar Ŭ����
================================*/

/*
java.util.Calendar Ŭ������
��¥�� �ð��� ��ü �𵨸�ȭ �� Ŭ������
������ ���� �� �� �� ������
�ð��� ��¥�� ���õ� ������ �����Ѵ�.
�׸���, Calendar Ŭ������ �߻�Ŭ���� �̹Ƿ� ���� ��ü�� ������ �� ������
�������� �޼ҵ� ������ Calendar Ŭ������ ���� Ŭ������
GregorianCalendar Ŭ������ ���ǵǾ� �ִ�.

�ý������κ��� ���� �ý��� �ð� ������ ���� ��
getInstance() ��� ����(static) �޼ҵ带 �̿��Ͽ� ��ü�� ������ �� �ֵ�.
������ Calendar Ŭ���� ��ü�� �ý����� ���� ��¥�� �ð� ������ ������,
�� ��ü�� �����Ǹ� �����ִ� �ð� ��������
get() �޼ҵ带 �̿��Ͽ� ���� ������(�����) �� �ִ�.

getInstance() �޼ҵ�� ���������� GregorianCalendar ��ü�� �����Ͽ�
�����ֱ� ������ GregorianCalendar ��ü�� ���� �����Ͽ� �ð� ������ 
���� ���� �ִ�.


*/

/*�ǽ� ����
 ����ڷκ��� ��, ���� �Է¹޾�
 �޷��� �׷��ִ� ���α׷��� �����Ѵ�.
 ��, Calendar Ŭ������ Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.
 API DOC �����Ͽ� getActualMaximum() �޼ҵ��� Ȱ�� ����� �����ض�.

 ���� ��
 �����Է� : 2022
 �� �Է� : 2
 
 [2022�� 7��]

 �Ͽ�ȭ�������
 =============
            1 2
 3 4 5 6 7 8 9

 =============
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test143
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int month,year;
		String[] weekArr = {"��","��","ȭ","��","��","��","��"};
		Calendar ob = new GregorianCalendar();


		do
		{
		System.out.print("���� �Է� : ");
		year = Integer.parseInt(br.readLine());
		}
		while (year<1);
		
		do
		{
		System.out.print("�� �Է� : ");
		month = Integer.parseInt(br.readLine());
		}
		while (month <0 || month>12);

		ob.set(year,month-1,1); 
		
		int w = ob.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("         [%d�� %d��]\n",year,month);
		
		for(String i : weekArr)
			System.out.printf(" %s",i);
		System.out.println();

		System.out.print("==========================");
		System.out.println();
	


		for(int i=1;i<w;i++)
			System.out.print("   ");

		
		for(int i=1;i<=ob.getActualMaximum(Calendar.DATE);i++,w++)
		{

			System.out.printf("%3d",i);
			
			if (i != ob.getActualMaximum(Calendar.DATE))
			{
			if(w%7==0)
			System.out.println();
			}
			
		}
		System.out.println();
		System.out.print("==========================");
		System.out.println();

	
		
		

	}
}