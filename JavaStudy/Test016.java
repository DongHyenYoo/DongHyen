//�ڹ��� �⺻ ����� ���α׷� : println

public class Test016{

	public static void main(String[] args)
	{


		System.out.print("AAA");
		System.out.print("BBB");
		System.out.print("CCC\n");


		//System.out.println();
		//System.out.print(); //�����߻� �����Ͽ���

		//System.out.prinnt(\n); �����߻� ������ ���� 
		System.out.print("\n");

		System.out.printf("123455");
		System.out.printf("123455\n"); // \n ����
		System.out.printf("123455%n"); // %n ����

		//System.out.printf(); ���� ������ ������ �߻�

		System.out.printf("%d + %d = %d%n", 10,20,30);
		
		System.out.printf("%d\n", 123);
		System.out.printf("%10d\n", 123); //�� ������ ���� 10ĭ�� �Ҵ��ϰ� �ڿ� 3ĭ������.
		System.out.printf("%8d\n", 123);
		System.out.printf("%010d\n", 123); //���� ������� 0���� ä���.

		System.out.printf("%+d\n", 365); //  +365�� ���·� ���´�.
		System.out.printf("+%d\n", 365); // ���� ���·� ����

		System.out.printf("%d\n" , +365); // �׳� 365�� ����

		System.out.printf("-%d\n", 365);
		System.out.printf("%d\n", -365); //�Ѵ� -365

		//System.out.printf("%d\n" , 'a'); ��Ÿ�ӿ���
	    System.out.printf("%c\n", 'A');

		//System.out.printf("-%d\n", "365"); ��Ÿ�ӿ���

		System.out.printf("%s\n", "365");

		System.out.printf("%h\n", 365); //16������ ��ȯ
		
		System.out.printf("%o\n", 365); 

		System.out.printf("%b\n", true); //boolean �� �������� b��


		System.out.printf("%8.2f\n", 123.236); //  123.24

		System.out.printf("%2.2f\n", 123.24); // �ڸ����� �ȸ����� ���� �����Ѵ�.






	}





}