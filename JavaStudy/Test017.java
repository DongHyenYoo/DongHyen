//�ڹ� �⺻ ����� : System.util.Scanner
/*
java.util.Scanner
�ܶ� ���� ������ ����Ͽ� �Է��� ��ū�� ���� �����ϸ�
����Ʈ�� ���Ǵ� �ܶ����ڴ� ����
�ۼ��� ���� ��ū�� next() �޼ҵ带 ���
�ٸ�����(�ڷ���)�� ������ ��ȯ�Ҽ� �ִ�.
*/

import java.util.Scanner;

public class Test017{

	public static void main(String[] args){

		//Scanner Ŭ���� ����� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in); 

		//                new Scanner + Scanner(); �� ������ �����̴�.
		//new �� �̿��ؼ� scanner�� ���赵�� �����ͼ� ���⿡ �������� sc�� ��������
		//����� ���ٰ� ������ �������� �ƴ� 

		String name;
		int kor, eng, mat;

		//����
		
		System.out.print("�̸��� �Է� : ");
		name = sc.next(); //���ڿ� ���·� ��ȯ�Ѵ�.
		                  //��ĳ�ʴ� ����ó�� (throws IOException �� �ʿ����.

		System.out.println("�Է��� �̸� : " + name);

		System.out.print("�������� �Է� :");
		kor = sc.nextInt();  //���ڿ��� �ƴ� �������·� �޴´�.
		System.out.println("�Է��� ���� " + kor);

		System.out.print("�������� �Է� :");
		mat = sc.nextInt();
		
		System.out.print("�������� �Է� :");
		eng = sc.nextInt();

		System.out.println("���� :" + (kor + eng + mat));

		
		






	}





}
