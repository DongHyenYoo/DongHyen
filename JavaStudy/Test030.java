//���� ������ == ���� ������

//����ڷκ��� ������ ������ �Է¹޾�
//�Է¹��� ������ �������� ������� �Ǻ��Ͽ�
//�� ����� ����ϴ� ���α׷����� 
//�Է¹��۸���
//���ǿ�����

//400�� ����̰ų� 4�� ����̸鼭 100�� ����� �ƴϰų�

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test030
{

	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int year;
		String strResult;

		year = Integer.parseInt(br.readLine());

		strResult = (( year % 4 == 0 && year%100 != 0) || year % 400 == 0) ? "����" : "���";

		//strResult = (year % 4 ==0 && year % 100 !=0) ? "����" : (year % 400 == 0) ? "����" : "���;
		//

		System.out.println(strResult);

		





	}







}