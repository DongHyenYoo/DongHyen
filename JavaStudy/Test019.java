//�ڹ� �⺻ ����� : System.util.Scanner
/*
java.util.Scanner
�ܶ� ���� ������ ����Ͽ� �Է��� ��ū�� ���� �����ϸ�
����Ʈ�� ���Ǵ� �ܶ����ڴ� ����
�ۼ��� ���� ��ū�� next() �޼ҵ带 ���
�ٸ�����(�ڷ���)�� ������ ��ȯ�Ҽ� �ִ�.
*/
//csv ������ Ÿ��
//������1,������2,������3 �Ͱ��� 

import java.util.Scanner;

public class Test019{

	public static void main(String[] args){

		//�ֿ亯�� ����

		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, mat, tot;

		

		//���� �� ó��
		System.out.print("�̸� ���� ���� ���� �Է� ,�� �����ϰ� �����Է±���");


		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");

		//               ----------   -----------------------
		//               1            2
		//�� ������� java���� ����. 
		// 1���� �Է��� ���� ������
		//sc = new Scanner(������,40,40,40).useDelimiter("\\s*,\\s*"); Delimiter�� �����ڷ� �����ڸ� ����ϰڴٴ� �ǹ�
		// .useDelimiter = .�����ڻ���ؼ� �Էµ� ���� �ڸ��ڴٴ� �ǹ��̴�. 
		//�Էµ� ������ ��ĳ��Ÿ���̶�� �Ҽ��ְ�  ��ĳ����Ű�� �ȿ� �ִ� �޼ҵ� ����  �����ִ�.
		
		// \\ = \�ϳ��� ǥ���ϱ����Ѱ� �� \s*,\s*�� ������ ���̰�
		//								 �����Ǹ�繮�ڿ�,�����Ǹ�繮�ڿ�
		//							�� �����̵��� ,�� �����ش޶�� �ǹ�

		//�� 
		//String temp = sc.next();
		// sc = new Scanner(temp).useDelimiter("\\s*,\\s*"); �� ���ٰ� ����.
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		tot = kor + eng + mat;


		//��� ���
		
		System.out.println("\n �̸� : " + name);
		System.out.println(" ���� : " + tot);


	}






}