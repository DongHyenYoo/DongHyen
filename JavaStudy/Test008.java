//�ڹ��� ���� �� Ư¡
//������ �ڷ��� - 5����
//������ �ڷ��� �ǽ� �� �׽�Ʈ : char
public class Test008{

	public static void main(String[] args){

		//�ֿ� ���� ����
		char ch1, ch2, ch3;
		int a;


		//���� �� ó��
		ch1 = 'A';
		ch2 = '\n';//���� ���ڷ� �ϳ��� ��޵ȴ�.
		ch3 = '��'; // �� + �� �� ���°��� �ƴ� ���� �ϳ��� ���ڷ� �ν�
		
		a = (int)ch1; // ������ ������ �����ʴ°� �ڵ��� ��ȯ char -> int ��Ģ�� �����ϱ⶧��
		              //��������ȯ 2��° (�ǵ������� �Ǽ����� �ʾ����� �����ϱ����� ��������ȯ

		// ��� ���

		System.out.println("ch1 : " + ch1);

		System.out.println("ch2 : " + ch2);

		System.out.println("ch3 : " + ch3);
		
		System.out.println("a : " + a); //�ƽ�Ű �ڵ�� ��ȯ�Ǽ� ���

		System.out.printf("%c %c %c %d\n", ch1 , ch2, ch3, a);






	}

}