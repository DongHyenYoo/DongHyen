//���� ������ == ���׿�����
//����ڷκ��� ������ ������ �Է¹޾�
//�Է¹��� ������ �������. ��������, 0���� �����Ͽ�
//�� ����� ����ϴ� ���α׷��� �����Ѵ�.
// ��, �Էµ����ʹ� BufferedReader�̿�
//���ǿ����� Ȱ���Ͽ� ��ɱ���
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test028
{

	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;
		String strResult;

		n = Integer.parseInt(br.readLine());

		strResult = ( n > 0 ) ? "���" : (n < 0 ) ? "����" : "��";
		//strResult = ( n > 0 ) ? "���" : (n < 0 ) ? "����" : (n ==0) ? "��" : "����";

		System.out.printf("%d -> %s\n",n,strResult);

0







	}








}