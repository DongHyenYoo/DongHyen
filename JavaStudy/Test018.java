//�ڹ� �⺻ ����� : System.util.Scanner
/*
java.util.Scanner
�ܶ� ���� ������ ����Ͽ� �Է��� ��ū�� ���� �����ϸ�
����Ʈ�� ���Ǵ� �ܶ����ڴ� ����
�ۼ��� ���� ��ū�� next() �޼ҵ带 ���
�ٸ�����(�ڷ���)�� ������ ��ȯ�Ҽ� �ִ�.
*/

import java.util.Scanner;

public class Test018{
	
	public static void main(String[] args){

		//�ֿ� ���� ���
		Scanner sc= new Scanner(System.in);

		// java.util.Scanner sc = new java.util.Scanner(System.in));
        
		String name;
		int kor, eng, mat, tot;

		System.out.print("�̸� ���� ���� ���� ���� �Է�");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		tot = kor + eng + mat;


		System.out.println();
		System.out.println("�̸� : "+ name);
		System.out.println("���� : "+ tot);

		//���ͳ� �����̽� ���� �κе� �˾Ƽ� �� ������? �Ѵ�.







	}






}