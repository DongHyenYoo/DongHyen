//����

//����ڷκ��� ������ ���ĺ� �ѹ��ڸ� �Է¹޾�
//�̸� �Ǻ��Ͽ� �Է¹��� ���ĺ��� ������ ���
//����� ����ϴ� ���α׷��� �����Ѵ�.
//��, ��ҹ��ڸ� ��� ������  �� �ֵ��� ó���Ѵ�.
//���� ���ĺ� �̿��� ���ڰ� �ԷµǾ��� ���
//�Է� ������ ���� ������ ����ڿ��� �ȳ��� �� �� �ֵ��� �Ѵ�.

//���� ��)
//������ ���ĺ� �� ���� �Է� :'A' <- �빮�� ����

//������ ���ĺ� �� ���� �Է� :'e' <- �ҹ��� ����
//������ ���ĺ� �� ���� �Է� :'B' <- �빮�� ����

// ���� ok
// �����Է½� �Է¿���

//������ A E I O U				a e i o u
 //        65 69 73 79 85         97 101 105 111 117
//������ ������

import java.io.IOException;

public class Test039
{

	public static void main(String[] args)throws IOException
	{
		System.out.print("������ ���ĺ� �� ���� �Է� : ");
		
		
		char a = (char)System.in.read();                        //������ �������� ���� switch�� char���� ������ �ִٰ� �ߴ�.

 /*
 		int a = System.in.read();

		if(a == 65 || a == 69 || a == 73 || a == 79 || a == 85)    //�ϳ��� ������ ����Ǵ� �빮�� ����
			System.out.printf("%c �� �빮�� �����Դϴ�.\n",a);

		else if(a == 97 || a == 101 || a == 105 || a == 111 || a == 117)    //�ϳ��� ������ ����Ǵ� �ҹ��� ����
			System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a);

		else if(a >= 65 && a<= 90)
			System.out.printf("%c �� �빮�� �����Դϴ�.\n",a);     //������ ������ �빮�� 

		else if(a >= 97 && a<= 122)
			System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a);     //������ ������ �ҹ���
		
		else
			System.out.printf("�Է� �����Դϴ�.\n");              //���ĺ��� ��� �ɷ����� ������ ���ڿ� ��ȣ���̴�. �̵��� ��� �Է� ������� �����ش�.

	*/ 
	  
	  
		boolean strExp =  a >= 65 && a<= 90;       //������ boolean�� a�� �빮���϶� true �� �ƴҶ� false�� ��´�.

		int strResult = strExp ? 2 : 0;           //switch���� boolean���� �ȵ��Ƿ� �빮���϶� 2�� ���� �ƴҶ� 0�� ���� strResult�� ��� ������ �����ϰ� ���� �Է¿����� ��/�� ������ �����Ҷ� ����.

		strExp = (a >= 97 && a<= 122);           //boolean�� a �� �ҹ����϶� true�� �ƴҶ� false�� ��´�.

		strResult = strExp ? 1 : strResult;      //�ҹ����϶� 1�� ���� �ƴҶ��� 58��° �ٿ��� ���� ���� �״�� ���󰡰� �����.  1 : 0 ���� ������ �ҹ��ڰ� �ƴѰ�� ������ 0�� ���Դ�.

		switch(a)
		{
		  case 'A' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;
		  case 'E' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;
		  case 'I' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;
		  case 'O' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;
		  case 'U' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;
		  default : switch(a){                                                             //ù��° switch������ �빮�� ������ �Ÿ��� [���ҹ����� ��� ����/�� ���� ���Է¿���] 3������ ��Ÿ���� ���� 
		  case 'a' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;             // default�� ����κп� switch�� ���θ���� �ҹ��� ������ �Ÿ���.
		  case 'e' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;
		  case 'i' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;
		  case 'o' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;
		  case 'u' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;
		  default : switch(strResult){                                                      //�߿��� ��/�� ������ �ɷ����� �� 56~62�ٿ��� ������ strResult ���� �̿��� ��/�� ������ �Է¿����� ��Ÿ����.
			  case 2 : System.out.printf("%c�� �빮�� �����Դϴ�\n",a); break;
			  case 1 : System.out.printf("%c�� �ҹ��� �����Դϴ�\n",a); break;
			  case 0 : System.out.print("�Է� ����\n"); break;
			  default : return;

		}

	 }
  }

	/* switch(a){
			case 3 : System.out.print("��"); 
			case 2 : System.out.print("��"); 
			case 1 : System.out.print("��\n"); break;
			default : System.out.println("�Է¿���"); 
			 
			 

		} */ 


/*

		boolean strExp =  a >= 65 && a<= 90;

		int strResult = strExp ? 2 : 0;             //���� ����.

		strExp = (a >= 97 && a<= 122);

		strResult = strExp ? 1 : strResult;



		switch(a)
		{
		  case 'A' : case 'E' : case 'I' : case 'O' : case 'U' : System.out.printf("%c �� �빮�� �����Դϴ�.\n",a); break;     //Test042�� ������ case�� break�� ������ case�������� default���� �����ߴ�.  
																															   //�ؼ� case�ȿ� case�� ������ case�� �������Ͱ� ���Ҵ�. �̸� �̿��� �빮�� ������ �Ÿ���.
		  default : switch(a){
		 
		  case 'a' : case 'e' : case 'i' : case 'o' : case 'u' : System.out.printf("%c �� �ҹ��� �����Դϴ�.\n",a); break;     //���� ���� �ҹ��� ������ �Ÿ���.
		 
		  default : switch(strResult){
			  case 2 : System.out.printf("%c�� �빮�� �����Դϴ�\n",a); break;
			  case 1 : System.out.printf("%c�� �ҹ��� �����Դϴ�\n",a); break;
			  case 0 : System.out.print("�Է� ����\n"); break;
			  default : return;

			}


		 }

		}
		
*/		
		
	}

}
/*
������

������ ���ĺ� �� ���� �Է� : A
A �� �빮�� �����Դϴ�.
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���ĺ� �� ���� �Է� : a
a �� �ҹ��� �����Դϴ�.
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���ĺ� �� ���� �Է� : b
b�� �ҹ��� �����Դϴ�
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

������ ���ĺ� �� ���� �Է� : 3
�Է� ����
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


*/

