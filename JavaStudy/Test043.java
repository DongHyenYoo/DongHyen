//�������� �����ڸ� �Է¹޾�
//�ش� �������� ���� ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
//�� , switch ���� Ȱ���Ͽ� ó���� �� �ֵ����ϸ�
//���� ����� ���ǻ� ���� ���·� ó���� �� �ֵ��� �Ѵ�.

import java.util.*;
import java.io.*;


public class Test043
{
	public static void main(String[] args)throws IOException
	{
	/*	
		Scanner sc = new Scanner(System.in);


		System.out.print("ù��° ���� �Է� : ");
		int strNum1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int strNum2 = sc.nextInt();
		System.out.print("������ �Է� : ");
		int signMat = System.in.read();
		
		//char sign = (char)signMat;

		int result;
		*/
/*
		switch(signMat)
		{   
			
			case 42 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1*strNum2)); break;
			case 43 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1+strNum2)); break;
			case 47 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1/strNum2)); break;
			case 45 : System.out.printf("%d %c %d = %d\n",strNum1,sign,strNum2,(strNum1-strNum2));break;
			case 37 : System.out.printf("%d %c %d = %.2f\n",strNum1,sign,strNum2,(float)(strNum1%strNum2));break;
			


		}
*/
/*
		switch(signMat)
		{   
			
			case 42 : result = strNum1*strNum2; break;
			case 43 : result = strNum1+strNum2; break;
			case 47 : result = strNum1/strNum2; break;
			case 45 : result = strNum1-strNum2;break;
			case 37 : result = strNum1%strNum2;break;
			default: return; //return �� 1.���� ��ȯ
			                 //return 2.~���� ��ȯ�Ѵٶ�� �ǹ̰� �⺻�̳� �޼ҵ带 �����Ű�� ��� �� �ΰ��� ����� ��ΰ������ִ�.
							//return�ڿ� ���� ��õǾ��ִٸ� 1�������� �ƹ��͵� ���ٸ� 2��
							//return�� �����Ű�� �޼ҵ�� return�� �����ϰ��ִ� �޼ҵ带 �ǹ��ϰ� �̰������� main�޼ҵ带 �����ϴ� ���̴�.
							//main�� �����Ų�ٴ� �ǹ̴� ���α׷��� �����Ų�ٴ� �ǹ��̴�.
		}
		System.out.printf("%d %c %d = %d\n",strNum1,signMat,strNum2,result);
		//int�� �������� %c�� ����ϸ� %c�� ����̰���

		//switch�� �������� �Ǹ鼭
		//���� Ÿ��(char) �� ���ڿ�(Strign)�� switch ���İ� case ����� ���ϼ� �ְԵǾ���.

		*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b, result;
		char op;
		//String op;

		System.out.print("ù��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());
		System.out.print("������ �Է� : ");
		op = (char)System.in.read();

		switch(op)
		{
			case '+' : result = a+b; break;
			case '-' : result = a-b; break;
				case '*' : result = a*b; break;
				case '/' : result = a/b; break;
				default : return;
		}
		System.out.printf("\n %d %c %d = %d\n",a,op,b,result);




		

	}



}