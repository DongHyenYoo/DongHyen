/*===================================
�迭
-�迭�� ����� �ʱ�ȭ
================================*/

/*
	�迭�� ����

	1.�迭�̶� ũ��� �ڷ����� ���� ���ҵ��� ��
	   ������ ���� ������ ���� �ڷ��� ����ü�� �ǹ��ϴ� ������
	   ���� ������ �ڷ�� �� ����
	   ���������� �ڷ����� �ο����� �ʰ�
	   �ϳ��� �̸��� ������ �ϰ������� ó���� �������� ���ȴ�.

	 2. �ڹٿ����� �迭�� ������ ���� ������ ���� ���ȴ�.
	   �迭 ���� -> �迭�� �޸� �Ҵ� -> �迭 ��� ����(�迭 ����� ���)


	���� �� ����

	�ڷ���[] ������ ;
	������ = new �ڷ���[���ũ��];
	������[�ε���] = ��;
	
	�����鿡�� �޸𸮸� ���� ���������� �Ҵ��ϴ°� �ƴ� 
	�迭�� ���ٷ� ���̾ �޸𸮸� �Ҵ��Ѵ�.

	���� �������� ���� �ּҸ� �������ִ°Ϳ� ���� �迭�� ���� ù�κ��� 0��°�� �ּҸ� ����ϰ��ִ�.
	int���̸� 4����Ʈ�� �Ѿ�� �ڷḦ ã�� double �� 8����Ʈ�� �Ѿ�� ã�´�.
	�� �ڷ������� ũ�Ⱑ �޶����Ƿ� ���� �ڷ����̾�� �Ѵ�.
	�ڹٴ� �迭���� �޸𸮸� �Ҵ��Ҷ� �ٸ� ������ �Ҵ���� �޸��� ������ ħ������ ������
	�迭�� ũ�⸦ ���� �ٸ������� �޸𸮿� �Ҵ�������� ���� �� �ٵ��� �޸𸮸� �Ҵ��Ѵ�.

	�迭�� ���̴� ��ȭ��ų �� ����.
	�ڹ��� �迭�� ���� �ٸ� ������ �޸𸮸� ħ���ҰŰ����� ���� ������ �����ο� �޸𸮸� �ٽ� �Ҵ�޴´�.
	�� �ּҸ� �ٲ������. �׸��� �����ּҿ� �ִ� �޸𸮴� -> �迭�� ���̸� ��ȭ��ų �� ���⶧���� 

	ex) int[] arr;
	  arr = new int[3];
	  arr[0,1,2] = ?;




*/

public class Test079
{

	public static void main(String[] args)
	{

		//�迭 ����
		//int[] = arr; //�迭�� �ڷ��� = �̸�;
		//arr = new int[10]; //�̸� = ���ο� �ڷ��� �迭 //�޸� �Ҵ���
		//arr[] = ; //�̸�[��ġ] = ��; �Ҵ�� �޸𸮿� ���� ����ֱ�

		int[] arr = new int[10]; //int[] = arr + arr = int[10]; �� ����.
		int[] arr2 = {1,2,3,4,5,6,7,8,9,0}; //�迭 ũ�⸦ �������� �ʰ� ����
		int arr2[] = {1,2,3,4,5,6,7,8,9,0};// ���� ����.

		//�迭��� ���
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		//���� �Ҵ����� �ʴ� ������ ������ �ڵ����� 0���� �ʱ�ȭ�ȴ�.

		//System.out.println(arr);
		//�̻��� ���
		//�迭������ϱ� ���� �迭 ������ �Ϲݺ���ó�� ����ϴ� �������� �ۼ��ϸ�
		//������ �����Ͱ� ��µǴ°��� �ƴ϶� �̻��� �ڵ尡 ��µ�
		//�ڹٴ� �޸� �ּҰ��� ����ڰ� �����ϴ� ���� ������� �����Ƿ� �ڹٰ� ���������� ��ü�� �����ϱ� ���� ������ �ø���ѹ��� ��µǴ°�
		
		//System.out.println(arr2[1]);

		for(int i=0;i<10;i++){
		//System.out.println(arr2[i]);
		System.out.printf("%2d",arr[i]);
		 //1 2 3 0 0 0 0 0 0 0����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		}


	}

}