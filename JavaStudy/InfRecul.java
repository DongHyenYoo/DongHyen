//메소드의 재귀호출


public class InfRecul
{
	public static void main(String[] args)
	{

		showHi(3);

		//코드 내에서 2군데 위치를 바꾼다.
	}

	public static void showHi(int cnt) 
	{
		
		System.out.println("Hi~");
		showHi(cnt--); //무한루프 해결해봐라
		if(cnt==1) 
			return;
		
		;
		
	}





	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		if(cnt==1)
			return;
		cnt--; //이러면 됨
		showHi(cnt);
		

	}

	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		if(cnt==1)
			return;
		showHi(--cnt); //보영님 코드
		

	}

	public static void showHi(int cnt)
	{
		if(cnt==0)
			return;
		System.out.println("Hi~"); //내 코드
		showHi(--cnt);
		

	}





/*
	public static void showHi(int cnt) //변수이름을 따로 선언해줘도 된다. 즉 여기 내에서의 변수인것 으로 봐도될듯
	{
		
		System.out.println("Hi~");
		if(cnt==1) 
			return;
		System.out.println(cnt);
		showHi(cnt--);  //다음에 호출할때 -를 해 이지만 cnt의 범위가 showHi라서 3만이 나온다.
		System.out.println(cnt+"ㄴㅇㄹ"); //위에서 재귀해버려서 값이 나오지조차 않는다.
	}
/*
	public static void showHi(int cnt) 3
	{
		
		System.out.println("Hi~");
		showHi(cnt--);   //showHi(2) 호출
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //다음에 부를때 2로할거야
	}

	public static void showHi(int cnt) 2
	{
		
		System.out.println("Hi~");
		showHi(cnt--);	//showHi(1) 호출
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //다음에 부를때 2로할거야
	}

	public static void showHi(int cnt)
	{
		
		System.out.println("Hi~");
		showHi(cnt--);	//showHi(0) 호출
		if(cnt==1) 
			return;
		System.out.println(cnt);
		 //다음에 부를때 2로할거야
	}
		

*/


}