//������ �ڷ���
//�ڹ� �⺻ ����� : BuffteredReaderŬ����
//����ڷκ��� �̸� �������� �������� ���������� �Է¹޾�
//�̸��� ������ ����ϴ� ���α׷� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Test014{

	public static void main(String[] args)throws IOException{

		String name;

		int strTemp;
		int korean, english, math, sum;
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader isr = new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(isr);
		//���� ù�ٰ� ���� ������ ���� BufferedReader �ν��Ͻ��� �����Ը� ������.


		System.out.print("�̸��� �ӷ��ϼ��� : ");
		
		name = br.readLine();
		
		System.out.print("\n���� ���� �Է� : ");
		
		korean = Integer.parseInt(br.readLine());

		//strTemp = br.readLine();
		//korean = Integer.parseInt(strTemp);



		System.out.print("\n���� ���� �Է� :");
		
		math = Integer.parseInt(br.readLine());

		//strTemp = br.readLine();
		//math = Integer.parseInt(strTemp); strTemp�� �߰������������ ���� ������ �����ߴٰ� ���ο� ������ ������ ������Ѵ�.

		System.out.print("\n���� ���� �Է� :");
		
		english = Integer.parseInt(br.readLine());

		sum = korean+english+math;

		System.out.printf("�̸� :  %s \n",name );
		System.out.printf("���� : %d\n", sum);

/*
�̸��� �ӷ��ϼ��� : ������

���� ���� �Է� : 40

���� ���� �Է� :40

���� ���� �Է� :40
�̸� :  ������
���� : 120
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/





	}




}


