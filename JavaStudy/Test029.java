//���� ������ == ���ǿ�����

//����ڷκ��� ������ ���� �ϳ� �Է¹޾Ƽ�
//�빮���̸� �ҹ��ڷ�, �ҹ����̸� �빮�ڷ�
//���ĺ��� �ƴ� ��Ÿ���ڶ�� �� ���� �״�� ����ϴ� 
// ���α׷� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Test029
{
	public static void main(String[] args)throws IOException
		
	{
		
		
/*
		int temp;

		char strResult;
	    

		int stemp = System.in.read(); //������ int������ �޾ƿ´�.

		System.out.println("��ȭ��" + stemp);

		temp = stemp;


		strResult = ((97 <= temp) && (temp<= 122)) ? (char)(temp-=32) : ((65<=temp) &&  (temp<=90)) ?  (char)(temp+=32) : (char)temp; 
		
		System.out.println("���" + strResult);
*/

		char temp;
		temp = (char)System.in.read();
		// �ΰ��̻��� ������ �����Ѵٸ� �������� // �������� �ʿ��ϸ� && �������� �ʿ��ϸ� ||
		  // 'A' >=  temp &&  temp <= 'Z' ? "�빮��" : "�ҹ���";  //'A' >= 65 ������ char�� A�� int�� �ٲ� ����ȴ�.
              // ture && true ���·� �� �������� �ٲ��.

	    result = (temp >= 'A' && temp <='Z')? ((char)(temp+32)) : ((temp>='a' && temp <= 'z' ? ((char)(temp-32)) : ((char)temp));




/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//readLine�� ��ĳ���� scnext() ���ڿ��� ���·� �о�´�.
		//�ѱ��ڸ� �Ѱܵ� ���ڸ��Ѱܵ�  �ؼ� buffer�� scanner�� ���� �ʴ°�

		String strResult1;
		
		temp = Integer.parseInt(br.readLine());

		System.out.println("��ȯ��" + temp);

		

		Scanner sc = new Scanner(System.in);

		temp = sc.nextInt();

		System.out.println("��ȯ��"+temp);

		*/

		//Integer.parInt = ���ڸ���� ���ڿ��� �ٲٴ� ���ϻ� ���ڸ� ���ڷ� �ٲ��ִ°��� �ƴϴ�.
		//sc.nextInt = ���� ����


		
 
 
		

		





	}







}