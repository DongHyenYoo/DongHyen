/*===================================
자바의 주요 클래스
-자바에서 기본적으로 제공하는 주요 클래스들
-Math 클래스
================================*/

/*
   java.util.Random 클래스는

   여러 형태의 난수를 발생시켜 제공하는 클래스이다.
   Math클래스의 정적 메소드인 random() 메소드도 난수를 제공하는 메소드이지만
   0.0~1.0사이의 실수 형태만 발생하게 되므로
   필요한 여러 형태의 난수를 만들어내기 위해서는 추가적인 연산을 수행해야 한다.
   그래서 자바는 여러 형태의 난수를 발생시켜주는
   전용 클래스인 Random클래스를 별도로 제공
   */

  //로또 번호 생성(난수 발생 프로그램)

  //프로그램이 실행되면 기본적으로 로또를
  //5게임 수행하는 프로그램 구현


 //실행 예)
// 3 5 12 24 31 41
//1 2 8 36 41 42
//4 9 12 13 22 30
// 5 10 13 14 22 40
//22 31 36 40 43 44
import java.util.Random;
import java.util.Arrays;


class Lotto
{
	//배열 변수 선언 및 메모리 할당 -> 로또 번호를 담아둘 배열방 6칸
	private int num[] = new int[6];
	//num = new int[6] 이거 안된다... 


	Lotto()
	{
		num = new int[6];
	}

	//getter
	public int[] getNum()
	{
		return num;
	}

	public void start()
	{
		Random rd = new Random();


		int count=0; //같은걸 찾아서 다시 난수생성한 횟수
		int n;
/*
		for(int i=0;i<num.length;i++)
			{

			num[i] = rd.nextInt(45)+1;

			for(int j=0;j<i;j++)

				if(num[j] == num[i])
				{
			num[j] = rd.nextInt(45)+1;
			count++;
				}
			}
		System.out.println(count);
		*/

		jump:

		while(count<6)
		{
			n = rd.nextInt(45)+1;

			for(int i=0;i<count;i++)
			{
				if(num[i]==n)
					continue jump;

			}
			num[count++] = n;

		}

		sorting();

	}


	private void sorting()
	{
		Arrays.sort(num);
	}
}

public class Test146
{
	public static void main(String[] args)
	{
		Lotto ob = new Lotto();


		for(int i=1;i<=5;i++)
		{
			ob.start();
			for(int j : ob.getNum())
			System.out.printf("%4d",j);

			System.out.println();
		}

		
		
		System.out.println();
	}
}