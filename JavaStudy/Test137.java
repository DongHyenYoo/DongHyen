/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
String Ŭ����
================================*/


public class Test137
{
	public static void main(String[] args)
	{
		String s = "seoul korea";
		System.out.println("s : "+s);
		//s : seoul korea

		//���ڿ� ����

		System.out.println(s.substring(6,9)); //��� kor

		//String.substring(s,e)
		//String ���ڿ��� �������
		//s��°���� e-1��° ���� ����
		// �� (�ε����� 0 ���� ����)
		
		System.out.println(s.substring(7));


		//String.substring(s)
		//String ���ڿ��� �������
		//s��°���� ������ ����
		//�� ���ڿ��� ���� ���̸�ŭ..

		//���ڿ��� ������ (��) ��

		System.out.println(s.equals("seoul korea"));
		System.out.println(s.equals("seoul Korea"));
		//true
		//false
		//��ҹ��� ����..

		System.out.println(s.equalsIgnoreCase("SEOUL KOREA"));
		//true �� �޼ҵ�� string���� ������ �޼ҵ�� ��ҹ��ڸ� �������� �ʴ°�
		

		//ã���� �ϴ� ��� ���ڿ�(s)��
		// kor ���ڿ��� �����ұ�??
		//�����Ѵٸ� ��� ��ġ�� �����ϴ���?
		
		System.out.println(s.indexOf("kor"));
		//6 => 6����ġ�� �����Ѵ�.

		System.out.println(s.indexOf("ea"));
		//9 
		
		System.out.println(s.indexOf("e"));
		//e�� �ΰ��� �ִµ� �տ������� ã�� ���� ����ã������ �˷��ְ� ����

		System.out.println(s.indexOf("z"));
		//ã���� �ϴ°� ���ٸ� ������ ��ȯ�Ѵ�.
	    

		//��� ���ڿ��� rea�� ���������� ���� Ȯ��
		//true false ��ȯ 
		System.out.println(s.endsWith("rea"));
		//rea �� �����Ƿ� true
		System.out.println(s.endsWith("oul"));
		//false



		//ã���� �ϴ� ��� ���ڿ���
		// e ���ڿ��� �����ұ�?
		// �����Ѵٸ� �� ��ġ�� ��ԵǴ°�?
		//indexOf �� �տ������� ã�� ã���� ������. �̰� �ڿ��� ���� �˻�
		
		System.out.println(s.indexOf("s"));
		System.out.println(s.indexOf("o"));

		System.out.println(s.lastIndexOf("e"));
		//9
		System.out.println(s.lastIndexOf("o"));
		//7

		//��� ���ڿ�(s) ��
		// 6��° �ε��� ��ġ�� ���ڴ�?

		System.out.println(s.charAt(6));
		//k 
		//System.out.println(s.charAt(22));
		//��Ÿ�� ���� �߻� java.lang.StringIndexOutOfBoundsException: String index out of range: 22
		//


		//��� ���ڿ�s�� ���ϴ� ���ڿ� seoul corea�� � ���ڿ��� �� ū��? 
		//���ڿ��� ���� ũ�� ��
		//ũ�� ���� = 0
		//ũ�� �ٸ� = ���̸� Ȯ���Ѵ�.

		System.out.println(s.compareTo("seoul korea"));
		//0 =�� ���ڿ��� ����. (s�� "seoul korea"�� ����.)
		System.out.println(s.compareTo("seoul uorea"));
		//8���̰� ���� �̰� k~c�� ���ĺ� ����? �� ��ȯ

		
		//��� ���ڿ�s ��
		// �ش� ���ڿ��� ã�Ƽ� ���ϴ� ���·� ������ ���ڿ��� ��ȯ���ִ°�

		s = "�츮���� ���ѹα� ���ѵ��� ����";
		//s.replaceAll() �̰��Ѵٰ� ���ڿ���ü�� ������ �ٲٴ°��� �ƴϴ�.

		s = s.replaceAll("����", "����"); //������ ã�� ���ֶ�� ���ڷ� �ٲ�� �׸��� �װ� ���ڿ��� ��ƶ�
		System.out.println(s);

		//���� ����

		s = "          ��          ��           ";
		System.out.println("|"+s+"|");

		System.out.println("|"+s.trim()+"|"); //���� �����ڸ��� ���� ����
		//���� �����ڸ� ���� ����

		System.out.println("|"+s.replaceAll(" ","")+"|");
		//��� ������ ""�� ��ü

		int temp = Integer.parseInt("50");

		s = Integer.toString(30);
		System.out.printf("%s\n",s); //�̰� �������̵尡 �ƴ϶� �����ε� object�� string �� �����ε��Ѱ�. ������Ʈ�� toString�� �Ű������� ������. �׸��� ����� �־���. �߻� �޼ҵ尡�ӴϾ���
		//=>30

		int n = 2345678;
		System.out.println(n);
		System.out.format("%d\n",n);
		//printf�� ����� ���� format

		s = String.format("%d",n); //���ڿ��� ��ȯ�ϴ� ģ��
		System.out.println(s);

		s= String.format("%,d",n); //d�տ� ,�� ���� ������ϴ� ��ó�� 3�ڸ����� ,�� ����ش�.
		System.out.println(s);
		
		//String str ="�⺻,����,�迭";
		//String[] strArr = str.split(",");

		String[] strArr = "�⺻,����,�迭".split(",");
		//���� ����ü�� ���ڿ��̰� ���ڿ� ��ü�̴� �� String�� ����� �����ִ�.
		//142 143�� ���� �����̴�.

		for(String i : strArr)
			System.out.println(i);
		//�⺻ ���� ���




	}
}