/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
-Calendar Ŭ����
================================*/

//�ǽ� ����
//������ �������� �Է¹޴� ��¥��ŭ ���� �� �� �� ������
//Ȯ���Ͽ� ����� ����ϴ� ���α׷��� ����

//��
//���� ��¥ : 2022-07-26 ghkdydlf
//�������� ��¥�� Ȯ���ϰ��� �Ͻʴϱ� : 200

//200���� : xxxx-xx-xx x����

import java.util.Calendar;
import java.util.Scanner;
public class Test144
{
	public static void main(String[] args)
	{
		//���� ��¥ get�� �̿��ؼ� �޾ƿ���


		Scanner sc = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance();

		String[] weekArr = {"��","��","ȭ","��","��","��","��"};

		//�ִٰ� String+= �ؼ� �տ� 0������

		System.out.printf("���� ��¥ : %d-%d-%d  %s����",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),weekArr[cal.get(Calendar.DAY_OF_WEEK)-1]);
		
		

		//add(�ʵ�,���Ҽ�) �̴�.

		System.out.print("���� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ� : ");
		
		int addDate = sc.nextInt();

		cal.add(Calendar.DATE,addDate);

		
		
		System.out.printf("%d�� �� : %tF %tA\n����",addDate,cal,cal);

	
	/*
		printf �߰����� %tF : �ϸ�  ������ Ķ���� ��ü�� �־����� ��-��-�� ������ ���ڿ��� ��ȯ
		                %tA : �ϸ�  ������ Ķ���� ��ü�� �־����� ���ڿ������� ������ ��ȯ 
		
		String.format("%tF",�޷°�ü); �ؼ��� ���� �ִ�.

	*/
	
	
	}
}