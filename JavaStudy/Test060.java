//���� for������ ������ ��� �ǽ�
//���� ���� �غ���

//1.�ݺ����� 2��ø�� 2���Ἥ �غ��� (���� for)

//2.3��ø�� 1���Ἥ



public class Test060
{
	public static void main(String[] args)
	{

		/*
		int dan,gob;  //i = �� j�� ��

		for(gob=1;gob<=9;gob++){
			
			for(dan=2;dan<=5;dan++)
				{
				System.out.printf("%d * %d = %d\t",dan,gob,(dan*gob));
				
			}
			System.out.println(""); // 2345 ������ ����
		
	}
	
	  System.out.println("");
		
		for(gob=1;gob<=9;gob++){
			
			for(dan=6;dan<=9;dan++)
				{
				System.out.printf("%d * %d = %d\t",dan,gob,(dan*gob));
				
			}
			System.out.println(""); // 2345 ������ ����
		
	}
*/
/*
		int dan,gob,mondan;

		for(mondan=0;mondan<=4;mondan+=4) //0, 4������ 4 �κо� ����Ҽ� �ְ�
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
		
		System.out.print("������� ���ܼ��� �Է��ϼ���");
		int num = sc.nextInt();
		System.out.print("������� ĭ���� �Է��ϼ���");
		int numKan = sc.nextInt();

		

		for(mondan=1;mondan<=num;mondan++)  //������ �����ϴºκ� ���� �κ��� ������ �̺κ��� �ٸ�
			{
			for(gob=1;gob<=9;gob++)  //����ó��
				{

				for(dan=(4*mondan)-2;dan<=(4*mondan)+1;dan++) //�׷� ĭ������ ��� ��ȭ���Ѿ��ұ�?
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
					{   //���ܰ��� 1���� 2���ϰ������ if mondan ==1 (dan = 2345) else if mondan ==2 (dan = 6789) �� �Ҽ� �ִ�.  
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

				for(dan=mondan;dan<=(mondan+3);dan++) //a�� 2�϶� 2 3 4 5
					{								  // a�� 6�϶� 6 7 8 9
					System.out.printf("%d * %d = %d\t",dan,gob,dan*gob);
									
				}
				System.out.println("");
			}
			System.out.println("");
			}
			
*/
			

/*
			int dan,gob,mondan;
			//mondan = -1; for������ �������ѵ� ����� ���ƿͼ� �ʱ�ȭ�Ǵµ� �̰������� ����� �ٲ�
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