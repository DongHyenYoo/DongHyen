/*===================================
�迭
-�迭�� ���� �����ͺ���(��������)
================================*/
//096�� ��


public class Test097
{
	public static void main(String[] args) //���ڿ��� �迭�� ������ argument ��
	{
		int[] nums = {10,20,30,40,50};

		int[] copys = nums;				//���� �ǹ��� �迭 ���� ����
										//�ּҰ� ����

		//copys = nums; //��������;

		int[] copys2 = copyArray(nums);	//���� �ǹ��� �迭 ���� ����
										//(����� ���� �޼ҵ� ȣ��)

		int[] copys3 = (int[])nums.clone();	//���� �ǹ��� �迭 ���� ����
											//�ڹٰ� �����ϴ� clone()�޼ҵ�
		
		//���� �迭 ����� ���� �߻�~!!
		nums[1] = 2000;

		

		for(int i=0;i<nums.length;i++)
		{
			System.out.printf("%4d",nums[i]);
		}
		System.out.println();

		for(int i=0;i<copys.length;i++)
		{
			System.out.printf("%4d",copys[i]);
		}
		System.out.println();

		for(int i=0;i<copys2.length;i++)
		{
			System.out.printf("%4d",copys2[i]);
		}
		System.out.println();
		for(int i=0;i<copys3.length;i++)
		{
			System.out.printf("%4d",copys3[i]);
		}
		System.out.println();

	}

	//�Ű������� int �迭 Ÿ���� �Ѱܹ޾�
	//�� �迭�� ������ ��
	//������ �迭�� ��ȯ�ϴ� ����� ���� �޼ҵ� ����
	public static int[] copyArray(int[] arr)
	{
		//�Ű������� �Ѱܹ��� �迭(arr)
		//�� ���� �迭 ��ŭ�� �迭��(�޸� ����)�� Ȯ����
		// ������ �迭���� �����Ѵ�.

		int[] result = new int[arr.length];
		
		//������ ���� �迭arr�� ����ִ� �����ǿ�ҵ��� ����迭(result)�� ��Ƴ���
		//result = arr; x

		for(int i=0;i<arr.length;i++)
		{
			result[i] = arr[i]; //�ϳ����ϳ��� ���� �����͸� �Űܹ��� ���� ����
		}

		//������ �迭 ��ȯ
		return result;

	}

	

}