/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
StringTokenizer Ŭ���� (���丸 ����)
================================*/

/*
collection FrameWork���������� �Ǳ⿡ ¤��ѰŰ���

	StringTokenizer Ŭ������

	���ڿ� �Ľ�(parsing)�� ���� ������ �����ϴ� Ŭ������
	�Ľ�(parsing)�ϰ��� �ϴ� ���ڿ��� ���ڷ� �޾� �����ϴµ�,
	���⿡�� �Ľ�(parsing)�̶� �ϳ��� ���ڿ��� ���� ���ڿ���
	������ �۾��� �ǹ��ϰ� �Ǹ�, �� �� ������ ������ �Ǵ� ���ڿ���
	��ū(token)�̶�� �Ѵ�.

	StringTokenizer Ŭ������ ����ϱ� ���ؼ���
	java.util ��Ű���� StringTokenizer �� import �ؾ� �Ѵ�.

	StringTokenizer Ŭ������ ȣȯ���� �����ϴ� ��������
	���� �����ǰ� ������, ���ڿ��� �Ľ�(parsing)�ϱ� ���ؼ���
	String Ŭ������ split() �޼ҵ峪 java.util.regex ��Ű����
	����� ���� �����ϰ� �ִ�.

	������

	-����
	StringTokenizer(String str)
	StringTokenizer(String str, String delim)
	StringTokenizer(String str, String delim, boolean returnDelims)
	: �־��� ���ڿ� str �� �ܾ�� �и��ϴ� ��ü�� �����ϸ�
	   ����(����) ���ڴ� delim�� ���Ե� ���ڷ� ó���ϰ� �ȴ�.
	   ���� returnDelims �� true�̸�
	   ���� ���ڵ� �и��� �����ͷ� ó���ϰ� �ȴ�.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Test140
{
	public static void main(String[] args)throws IOException
	{
		String strTemp;
		String[] strArr;
		int n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�Ľ��� ���ڿ� �Է�(�ĸ� ����) : ");
		strTemp = br.readLine();
		//���,����,�ٳ���,����
		
		//StringTokenizer Ŭ���� �ν��Ͻ� ����
		StringTokenizer st = new StringTokenizer(strTemp, ",");
		//strTemp �� ��� ���ڿ���..(���,����,�ٳ���,����)
		//,�� �����ڷ�

		//st �� countTokens()
		//int countTokens()
		//�Ľ̵� ���ڿ��� ������ ��ȯ(����)�Ѵ�.
		strArr = new String[st.countTokens()];
							//------------ =4
		//strArr = new String[4];
		
		n=0;
		while(st.hasMoreTokens()) //ó�� ����� ���� true 2.���⸦ ���� true 3.4���� 5.�������������� �ڿ� �����Ƿ� false
		{
			strArr[n++] = st.nextToken(); //true�� ���� ����� ������ 2.true�� ���� ���Ⱑ���� 3,4���� 
		}
		//hasMoreTokens 
		//����� �� �ִ� ��ū�� ���� �椷�� true�� ��ȯ
		//���̻� ����� ��ū�� ���°�� false�� ��ȯ
		//Ȯ�� ����� ��ȯ�� ��..
		//���� ������ �о�������� �ʰ�
		//������ �о���̴� ��带 �̵���Ű���� �ʴ´�.

		//nextToken()
		//������ū�� ���´�.
		//������ū�� ������ ��带 �̵���Ű�� �ȴ�.
		//�����ڸ� �ٲپ��� ��� ���� ȣ�⿡��
		//�ٲ� �����ڸ� �̿��Ͽ� ��ū�� �и��Ѵ�.

	//	>
//			>
//				 >
//						>
//		-------------------
//		��� ���� �ٳ��� ����
//		---------------------
// hasMoreTokens�� ������ ���� true�� ��ȯ�ϸ�
//nextToken()�� ��带 �̵���Ű�鼭 ��ū�� �����´�.

		for(String str : strArr)
			System.out.print(str + " ");
		System.out.println();

	}
}