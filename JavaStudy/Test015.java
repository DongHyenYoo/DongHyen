//�ڹ��� �⺻ ����� : System.in.read()
//System.in.read() �޼ҵ�� (�Է� ��⿭�κ���) �ѹ��ڸ� �����´�.
//�� �Է¹��� �ϳ��� ���ڸ� �״�� �������°��� �ƴ϶�
//�ƽ�Ű�ڵ� ������ ��ȯ�Ѵ�.

import java.io.IOException;


public class Test015{

	public static void main(String[] args)throws IOException
		{
/*
		char ch; //����

		//���� �� ó��

		System.out.println("�����Է�:"); //A
		ch = (char)System.in.read(); //65�̾ char�� ��ȯ
		
		System.out.println(ch);
*/
		char ch1;
		int strNum;

		//char temp; // �ӽ÷� �߰� ������ ����


		

		System.out.print("�ѹ��� �Է� :");

		ch1 = (char)System.in.read();

		
		System.out.print("�Է��� ���� :");  // ���� �̻� �Է��� �ȵǼ� �ϳ��� �Է��ص� �ٷ� ����� ���͹���
/*
		System.in.read(); //Enter�� �ܼ��� ���Ͱ� �ƴ϶� \r, \n�� ��������
		System.in.read(); // -----------------------------------------
		                  //   A + ����(\r+\n) �� �����Ƿ�
						  //----------------------------------------
						  //  1    2   3
						  // -----------------------------------------
		                  //   A + \r+\n
						  //-----------------------------------------
						  //�̷��ԵǼ� 1���� �Է¹޾Ƶ��̰� strNum���� �޴°ʹ�� \r�� �ٷ� �޾Ƶ鿩������
*/
        System.in.skip(2); // ������ ���� \r + \n�α��ڸ� �о�� �ʰ� �ǳʶڴ�.
		//strNum = System.in.read();
		//temp = (char)System.in.read();

		strNum = System.in.read();

		//read�� ���ڷν� �������Ƿ�
		//���ڿ� + 48�� �Ͽ� �ƽ�Ű�ڵ尪���� ������
		//�׷��� '0'�� 48�̹Ƿ�  -48�� ������Ѵ�.

		//strNum -= 48;

		

		System.out.printf("\n�Է��� ���� %c\n",ch1);
		//System.out.printf("\n�Է��� ���� %d\n",strNum);
		// System.out.println("\n�Է��� ���� "+temp);
		System.out.println("\n �Է��� ����" + strNum);








	}




}
