/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
-Calendar Ŭ����
================================*/

/*

	Calendar Ŭ������ �߻�Ŭ�����̱⿡ ��ü�� ������ �� ����.
	(�߻� Ŭ���� : �̿ϼ��� Ŭ����)
	
	Calendar ob = new Calendar(); �� �ȵȴ�.

	
	Calendar Ŭ���� ��ü�� ������ �� �ִ� ���

	1.Calendar ob1 = Calendar.getInstance();

	2.Calendar ob2 = new GregorianCalendar(); ��ĳ�����̶�� �� �ڿ��� �ڽ�Ŭ���� ��ü �տ��� ����Ŭ���� ��ü�� �����ϰڴٴ°�

	3.GregorianCalendar ob3 = new GregorianCalendar();

	//�׷�������Ķ���� : Calendar Ŭ������ ���� Ŭ����

	


*/

//�� �� �� ������ Calendar ��ü�κ��� ������ ���
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test142
{
	public static void main(String[] args)
	{
		Calendar rightNow = Calendar.getInstance();
		//�̷��� ���� �ý���ȯ���� �������� �����ͼ� ������
		
		//������ Calendar �ν��Ͻ��� ����
		//��¥ ���� ������ �� �� �ִ� �޼ҵ� -> get()

		int y = rightNow.get(Calendar.YEAR);
		System.out.println(y);
		//2022 ������

		int m = rightNow.get(Calendar.MONTH)+1; //���� ������ +1�ؼ� ������Ѵ�. ���� �����Ҷ��� -1�ؾ��Ѵ�. ���������� �迭�� �����Ǿ��ֱ⶧��
		System.out.println(m);

		int d = rightNow.get(Calendar.DATE);
		System.out.println("d : "+d);

		int w = rightNow.get(Calendar.DAY_OF_WEEK);
		System.out.println("w : "+w);
		//w : 2
/*
		System.out.println(Calendar.SUNDAY); // 1 -> �Ͽ���
		System.out.println(Calendar.MONDAY); // 2 -> ������
		System.out.println(Calendar.TUESDAY); // 3 -> ȭ����
		System.out.println(Calendar.WEDNESDAY); // 4 -> ������
		System.out.println(Calendar.THURSDAY); // 5 -> �����
		System.out.println(Calendar.FRIDAY); // 6 -> �ݿ���
		System.out.println(Calendar.SATURDAY); // 7 -> �����
*/

		System.out.println(y+"-"+m+"-"+d+" "+w);
		//2022-7-25 2
		
		String week = "";
		switch (w)
		{
			/*
			case Calender.SUNDAY: week = "�Ͽ���"; break;
			case Calender.MONDAY: week = "������"; break;
			case Calender.TUESDAY: week = "ȭ����"; break;
			case Calender.WEDNESDAY: week = "������"; break;
			case Calender.THURSDAY: week = "�����"; break;
			case Calender.FRIDAY: week = "�ݿ���"; break;
			case Calender.SATURDAY: week = "�����"; break;
		*/

			case 1: week = "�Ͽ���"; break;
			case 2: week = "������"; break;
			case 3: week = "ȭ����"; break;
			case 4: week = "������"; break;
			case 5: week = "�����"; break;
			case 6: week = "�ݿ���"; break;
			case 7: week = "�����"; break;

		}

		System.out.println(y+"-"+m+"-"+d+" "+week);
		//2022-7-25 ������
		

		Calendar rightNow2 = new GregorianCalendar();

		String[] week2 = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};

		//�޷��� ��¥ ���� -> set() �޼ҵ� Ȱ��
		rightNow2.set(2023,0,16); //2023�� 1�� 16�Ϸ� �Ѱ� �����Ҷ��� -1�ؾ���

		System.out.println(rightNow2.get(Calendar.DAY_OF_WEEK));
		System.out.println(rightNow2.get(Calendar.MONTH));
		//5

		System.out.println(week2[rightNow2.get(Calendar.DAY_OF_WEEK)-1]);
		//�迭�̹Ƿ� -1 ������ 




	
	}
}