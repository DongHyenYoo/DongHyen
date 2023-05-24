/*===================================
클래스와 인스턴스
클래스와 인스턴스 활용
================================*/
//1~3사이의 난수를 발생시켜서
//가위 바위 보 게임 프로그램을 구현한다.
//단 클래스의 개념을 활용하여 처리할 수 있도록 한다.
//또한 배열을 활용하여 처리 할 수 있도록 한다.
//최종적으로 RpsGame 클래스를 완성할 수 있도록 한다.

//순서
//1.가위 바위 보 중입력하라는 메세지를 나타낼 메소드
//이 메소드는 내가 입력한 값을 멤버변수에 저장해야됨
//멤버변수 num 선언하자
//void ㅏㅌ입

//1.1~3사이의 난수를 발생시킬 메소드//이건 컴퓨터꺼
//결과출력에 중간에 포함될 메소드로 컴퓨터의 결과는 {가위, 바위,보}로 나올듯
//void 타입

//3. 비교해서 결과출력할 메소드 print
// 1 vs 3 = 1이 이기고
// 1 vs 2 = 2가
// 1 vs 1 = 비김

//2 vs 1 = 2가
//2 vs 3 = 3이

//3 vs 1 = 1이
//3 vs 2 = 3이

import java.util.Scanner;
import java.util.Random;

class RpsGame
{
	private int num;
	private int pcNum;

	public void input()
	{
		Scanner sc = new Scanner(System.in);
		
		runCom();

		do
		{
			System.out.print("1.가위, 2:바위, 3:보 중 입력(1~3) : ");
				num = sc.nextInt();	
		}
		while (num<1 || num >3);

	}

	private void runCom()
	{
		Random rd = new Random();
		pcNum = rd.nextInt(3)+1;
	}


	public void midVs() //중간결과
	{

		String[] st = {"가위","바위","보"};
				System.out.println("유저 : "+st[num-1]);
				System.out.println("컴퓨터 : "+st[pcNum-1]);
				System.out.println();
				
		}

	public String resultCalc()
	{
		String result = "무승부입니다!";
		
		//(유저=="가위" && 컴 =="보") || (유저=="바위" && 컴 =="가위") || (유저=="보" && 컴 =="바위")
		
		if((num==1 && pcNum ==3) || (num==2 && pcNum==1) || (num==3 && pcNum==2))
		{
			result = "당신이 승리했습니다!";
		}
		
		else if((num==1 && pcNum ==2) || (num==2 && pcNum==3) || (num==3 && pcNum==1)){

			result = "컴퓨터가 승리했습니다!";
		}

		

		return result;
	}



}



public class Test102
{
	public static void main(String[] args)
	{
	RpsGame ob = new RpsGame();
	ob.input();
	String result = ob.resultCalc();
	System.out.println(result);
	}

}