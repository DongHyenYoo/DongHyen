/*===================================
Ŭ������ �ν��Ͻ�
================================*/


//����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
//�ش� ������ �����ϴ� ���α׷��� �����Ѵ�.
//�� Ŭ������ �ν��Ͻ��� ������ Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.
//Calculate Ŭ���� ����

//���� ��
// ������ �� ���� �Է�(���� ����)Scanner�� ��� : 10 5
//������ ������(+ = * /) : + (System.in.read)
//10 + 5 = 15 �����

import java.util.Scanner;
import java.io.IOException; //System.in.read

class Calculate
{

	int a,b; //�Է¹��� �μ��� ������ ����
	char c; //�Է¹��� �����ڸ� ������ ����
	int max,min;

	//������ �������� ������ �������� ��� �������ϴ°�
	//���꿡 ���� ������� �� ������ ���� �ʴ°� = �ʿ����� �ʾƼ�
	//�׷� �Է¹޴¼��� �� �ʿ��Ѱ�? = ��� �ʿ��ؼ� �޸𸮿� �����־�ߵ�
	//

	void inputNum(){

		Scanner sc = new Scanner(System.in);

		System.out.print("������ �� ������ �Է�(���� ����)");
		a = sc.nextInt();
		b = sc.nextInt();
	}

	void inputSign()throws IOException{ //System.in.read�� ����ó�� ��ĳ�ʸ� ����ó�� ����

		System.out.print("������ ������(+ - * /)�Է�");
		
		c = (char)System.in.read();


	}

	void sum(int result){

		//int result=0; //return���� ������ �ʱ�ȭ �Ǿ��־���Ѵٴ°� ���������

		
		
		if(a>b){ 
			max = a; min = b;}
			else{ 
				max = b; min =a;}

		switch(c){
			case '*' : result = max*min; break;
			case '/' : result = max/min; break;
			case '-' : result = max-min; break;
			case '+' : result = max+min; break;
			default : System.out.print("��Ģ�����ڸ� ���ּ���");
		} //else ������ ���� �� �ʱ�ȭ

		//return result;
	}

	void print(int result){
		
		System.out.printf("%d %c %d = %d",max,c,min,result);
	}


}



public class Test073
{

	public static void main(String[] args)throws IOException{

		Calculate ob = new Calculate();
		
		ob.inputNum();
		ob.inputSign();
		int result=0;
		ob.sum(result);
		ob.print(result);

	}


}