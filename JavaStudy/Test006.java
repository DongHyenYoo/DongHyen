public class Test006{

	public static void main(String[] args){


		int a;
		a = 10;
		System.out.println("a�� ��� =" + a);
		int b;
		b= 20;
		System.out.println("b�� ��� =" + b);
		
		short c;
		//���� �� ó��(���� ����)
		c =(short)a; //(short)�� ���������� int -> short �ڵ�����ȯ ��Ģ ���������� �����Ͽ���
 // 0000000 000000 0000000 00001010 -> int �� a ���� 10
 // 00000000 00001010 short������ ��ȯ
		//��� ���
		System.out.println("c �� ��� : " + c);

		long d = 1000000000L; //���
      //21���� �Ѵ� ���ڴ� long���� ���ڵڿ� L�� �ٿ� ����� ǥ���ؾ��Ѵ�. �����Ϸ��� �����ʺ��� ���Ƿ�
	  
	    System.out.println("d��� = " + d);
		//System.out.println(" %d",d);
        //System.out.println("%d",d);
		//���� ���� �� �ʱ�ȭ
		int e = 030;

		//���
		System.out.println("e �� ��� : " + e); 
		//���� 0�� ������°��� ���� ���� 0�� ���� 8������ �νĵǾ� 24��� ���

		//���� ���� �� �ʱ�ȭ
		int f = 0xa6;

		//���
		System.out.println("f�� ��� : " + f);
		//f�� ��� : 166
		//���λ� 0x�� ������ 16������ �ν�

		//��������
		//float g = 0.0; double�� �⺻�ε� float�� ���ͼ� �ڵ�����ȯ�� �Ұ��Ͽ� �����Ͽ���
       // float g = 0.0;
		//���
		//System.out.println("g�� ��� : " + g);

  










	}









}