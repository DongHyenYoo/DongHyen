//다중 for문으로 구구단 출력 실습
//실행 도중 해볼것

//1.반복문의 2중첩을 2번써서 해보기 (다중 for)

//2.3중첩을 1개써서



public class Test060
{
	public static void main(String[] args)
	{

		/*
		int dan,gob;  //i = 단 j는 곱

		for(gob=1;gob<=9;gob++){
			
			for(dan=2;dan<=5;dan++)
				{
				System.out.printf("%d * %d = %d\t",dan,gob,(dan*gob));
				
			}
			System.out.println(""); // 2345 연산후 개행
		
	}
	
	  System.out.println("");
		
		for(gob=1;gob<=9;gob++){
			
			for(dan=6;dan<=9;dan++)
				{
				System.out.printf("%d * %d = %d\t",dan,gob,(dan*gob));
				
			}
			System.out.println(""); // 2345 연산후 개행
		
	}
*/
/*
		int dan,gob,mondan;

		for(mondan=0;mondan<=4;mondan+=4) //0, 4값으로 4 부분씩 출력할수 있게
			{
			for(gob=1;gob<=9;gob++)
				{
				for(dan=2;dan<=5;dan++)
					{
					System.out.printf("%d * %d = %d\t",(dan+mondan),gob,(dan+mondan)*gob);
					


				}
				System.out.println("");
			}
			System.out.println("");
			}
*/


/*

		int dan,gob,mondan;
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("보고싶은 문단수를 입력하세요");
		int num = sc.nextInt();
		System.out.print("보고싶은 칸수를 입력하세요");
		int numKan = sc.nextInt();

		

		for(mondan=1;mondan<=num;mondan++)  //문단을 구성하는부분 밑의 부분은 같으나 이부분이 다름
			{
			for(gob=1;gob<=9;gob++)  //행을처리
				{

				for(dan=(4*mondan)-2;dan<=(4*mondan)+1;dan++) //그럼 칸개수는 어떻게 변화시켜야할까?
					{
						if(numKan == (4*mondan) - dan)
					System.out.printf("%d * %d = %d\t",dan,gob,dan*gob);
						else{
							
							System.out.printf("%d * %d = %d\t",dan,gob,dan*gob);
						}
									
				}
				System.out.println("");
			}
			System.out.println("");
			}

*/
/*
			int dan,gob,mondan;

		for(mondan=0;mondan<=4;mondan+=4)
			{
			for(gob=1;gob<=9;gob++)
				{
				for(dan=2;dan<=5;dan++)
					{   //문단값을 1부터 2로하고싶으면 if mondan ==1 (dan = 2345) else if mondan ==2 (dan = 6789) 로 할수 있다.  
					System.out.printf("%d * %d = %d\t",(dan+mondan),gob,(dan+mondan)*gob);
					


				}
				System.out.println("");
			}
			System.out.println("");
			}

*/
   
		int dan,gob,mondan;
	
		for(mondan=1;mondan<=2;mondan++)
			{
			for(gob=1;gob<=9;gob++)
				{

				for(dan=(4*mondan)-2;dan<=(4*mondan)+1;dan++)
					{
					System.out.printf("%d * %d = %d\t",dan,gob,dan*gob);
									
				}
				System.out.println("");
			}
			System.out.println("");
			}






/*

			int dan,gob,mondan;
	
		for(mondan=2;mondan<=6;mondan+=4) // 2 6
			{
			for(gob=1;gob<=9;gob++)
				{

				for(dan=mondan;dan<=(mondan+3);dan++) //a가 2일때 2 3 4 5
					{								  // a가 6일때 6 7 8 9
					System.out.printf("%d * %d = %d\t",dan,gob,dan*gob);
									
				}
				System.out.println("");
			}
			System.out.println("");
			}
			
*/
			

/*
			int dan,gob,mondan;
			//mondan = -1; for문에서 증가시켜도 여기로 돌아와서 초기화되는듯 이값에따라 결과가 바뀜
			int danmin = ((4*mondan)-2);
			int danmax = ((4*mondan)+1);
		//int a = -2;

		

		for(mondan=1;mondan<=2;mondan++)
			{
			for(gob=1;gob<=9;gob++)
				{

				for(dan=danmin;dan<=danmax;dan++)
					{
					System.out.printf("%d * %d = %d\t",dan,gob,(dan*gob));
					
					
					


				}
				System.out.println("");
			}
			System.out.println("");
			}
			*/








	}

}