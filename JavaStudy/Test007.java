//변수와 자료형 - 5일차
//변수와 자료형 실습 및 테스트 : boolean
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.io.*;
public class Test007{


	public static void main(String[] agrs)throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String plus="";
		ArrayList<Integer> menuList = new ArrayList<Integer>();

		do
		{	int num;
			System.out.print("구입할 메뉴 번호를 입력해 주세요 : ");
			num = Integer.parseInt(br.readLine());
			if(menuList.contains(num))
			{
				System.out.println("동일한 메뉴번호는 담으실수 없습니다 결제전 메뉴 개수를 추가해주세요");
			}
			else
			{
			menuList.add(num);
			}

			if(menuList.size()==3)
			 continue;
			System.out.print("메뉴를 더 담으시겠습니까? 최대 3개의 메뉴를 담을수 있습니다. (Y/N): ");
			plus = br.readLine();
			plus = plus.toUpperCase();
			menuList.trimToSize();
		}
		while (menuList.size() != 3 && !plus.equals("N"));
		
		System.out.print(menuList.size());
		Iterator<Integer> it = menuList.iterator();













	}









}