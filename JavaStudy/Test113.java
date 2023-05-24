/*===================================
Ŭ���� ���
-���
================================*/
//����� ������ �����ؼ� �ۼ��Ѵ�.

//���� ��
//������ �� ���� �Է� (���鱸��)
//������ �Է�
// 20-15 = 5
//����Ϸ��� �ƹ�Ű�� ��������

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class Aclass
{
	protected int x,y;
	protected char op;

	Aclass()
	{
	}

	void write(double result)
	{
		System.out.printf(">> %d %c %d = %.2f\n",x,op,y,result);
	}
}

class Bclass extends Aclass
{

     boolean input()throws IOException //�������� true�� false�� ��ȯ�ϹǷ� �Ҹ���
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 System.out.print("������ �� ���� �Է� (���鱸��) : ");
		 String temp = br.readLine();
		 //���ڿ�.split("������");
		 //���ڿ�.split("\\s");  �����ڰ� �����̶�� ���̴�.

		 //"10 20 30 40 50".split("\\s");
		 //-> ��ȯ -> {"10","20","30","40","50"};������ ���ڿ� �迭�� ��ȯ

		 //ex) "010-3578-3912".split("-");
		 //->��ȯ->{"010","3578","3912"};

		 String[] strArr = temp.split("\\s");
		 
		 if(strArr.length!=2) //�迭.length = �Ӽ��̴�./���ڿ�.length();�ʹ� ���� �ٸ�
		{
			return false;
		}

		 //���⼭ ������ ���µ�?? return true�� ������ �翬�� �������....

		//false�� ��ȯ �ϸ� input()�޼ҵ� ����
		//if�ڵ尡 ����ɰ�� false�� ��ȯ�ϰ�
		//�Ʒ� �����ؾߵ� �ڵ尡 �����ִ���
		//false�� ��ȯ�ϸ� �޼ҵ尡 ����ȴ�.

		x = Integer.parseInt(strArr[0]);
		y = Integer.parseInt(strArr[1]);


		 System.out.print("������ �Է��ϼ���(+ - * /) : ");
		 op = (char)System.in.read();

		 
		 if(op !='*' && op !='-' && op!='/' && op!='+')
			 return false;

		 //if(op =='*' || op =='-' || op=='/' || op=='+')
			// return true; //�������� �������� 
 
		 return true;


	}

	double calc()
	{
		double result=0;;
		switch(op)
		{
			case '*' : result = x*y;break;
			case '+' : result = x+y;break;
			case '-' : result = x-y;break;
			case '/' : result = (double)x/y;break;
		}

		return result;
	}

    

}

public class Test113
{
	public static void main(String[] args)throws IOException
	{
		Bclass ob = new Bclass();


		if(!ob.input()) //false->true
		{
			System.out.println("����...");
			return;

		}
		double result = ob.calc();
		ob.write(result);

	}

}