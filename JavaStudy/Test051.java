//정수 입력받아
//입력받은 정수가 소수인지 아닌지 판별하여
//결과를 출력하는 프로그램 구현

//소수란 1또는 자기 자신의 값 이외에 어떤 수로도 나누어 떨어지지않는수 단 1은 소수가 아님

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test051
{

	public static void main(String[] args)throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
		int i=2;

		System.out.print("정수 입력 : ");

		int num = Integer.parseInt(br.readLine());

		if(num == 1){
			System.out.printf("%d : 소수아님\n",num);
			return;}

		while(!(num%i ==0))
		{

		//	if(num%i != 0)
		//		System.out.printf("%d -> 소수\n",num);
		//	return;

		//	else if(num%i == 0)
		//	System.out.printf("%d -> 소수가 아님\n",num);
		//  return;

			i++;

			}

			if(num == i)
			System.out.printf("%d : 소수다\n",num);

			else
				System.out.printf("%d : 소수가 아니다\n",num);
*/
				
/*

				int i = 1;
				int num = Integer.parseInt(br.readLine());


				if(num %2 == 0) //짝수는 소수가 될수없으므로 거르기 1도 2로나누면 몫이 0.5로 나머지가 없으므로 여기서 걸림
					return;

					while(i<num)
					{
						i += 2; //짝수는 걸렀으므로 홀수로만
						
						if(num%i ==0 && num != i){
							System.out.printf("%d : 소수다\n",num);
							return;}

							if(num%i ==0 && num == i){
								System.out.printf("%d : 소수다\n",num);
								return;}

					}
*/

			int i = 1;
				int num = Integer.parseInt(br.readLine());   //반복문은 덜도는게 시스템에 좋다.

				boolean flag = true; //자주쓰는 방법중 하나다...

				while(i<num){   // 1<1 은 false이므로 while자체를 수행할수 없다. //안에 한줄일경우 {} 생략가능
					//System.out.print("반보옥");
					if(num%i == 0){
						flag = false; //이러면 100을 입력하면 99번을 강제로 수행하게된다.
						break;// break는 가장가까운 반복문을 빠져나간다. 즉 whilt에서 빠져나감
							  //break가 있으므로 입력받은 수가 나눠지는 순간 더이상 연산을 할필요가없어지므로 컴퓨터 리소스한테 좋당 
							  //120입력시 while -> if -> break로 바로 빠져나오므로 위의 반보옥이 한번밖에 나오지 않는다.

					}

					i++;

				}

				if( flag && num != 1) //flag 를 기본으로 true를 줬고 boolean은 논리연산자로써 flag == true를 쓸 이유가없이 그냥 flag만 써넣어도된다.
					System.out.printf("%d : 소수다\n",num);
				else
					System.out.printf("%d : 소수가 아님\n",num);



				

					
					

		
		


   }

}