/*===================================
배열
-배열의 복사 데이터복사(깊은복사)
================================*/
//096과 비교


public class Test097
{
	public static void main(String[] args) //문자열형 배열로 선언한 argument 들
	{
		int[] nums = {10,20,30,40,50};

		int[] copys = nums;				//얕은 의미의 배열 복사 수행
										//주소값 복사

		//copys = nums; //얕은복사;

		int[] copys2 = copyArray(nums);	//깊은 의미의 배열 복사 수행
										//(사용자 정의 메소드 호출)

		int[] copys3 = (int[])nums.clone();	//깊은 의미의 배열 복사 수행
											//자바가 제공하는 clone()메소드
		
		//원본 배열 요소의 수정 발생~!!
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

	//매개변수로 int 배열 타입을 넘겨받아
	//이 배열을 복사한 후
	//복사한 배열을 반환하는 기능을 가진 메소드 정의
	public static int[] copyArray(int[] arr)
	{
		//매개변수로 넘겨받은 배열(arr)
		//즉 원본 배열 만큼의 배열방(메모리 공간)을 확보한
		// 복사할 배열방을 생성한다.

		int[] result = new int[arr.length];
		
		//각각의 원본 배열arr에 담겨있는 각각의요소들을 복사배열(result)에 담아내기
		//result = arr; x

		for(int i=0;i<arr.length;i++)
		{
			result[i] = arr[i]; //하나씩하나씩 실제 데이터를 옮겨받은 깊은 복사
		}

		//복사한 배열 반환
		return result;

	}

	

}