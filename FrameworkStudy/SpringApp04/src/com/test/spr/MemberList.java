package com.test.spr;

public class MemberList
{
	//check~!!!
	//주요 속성 → 인터페이스 형태의 자료형
	private IDAO dao;

	
	//check~!!
	//setter 구성
	public void setDao(IDAO dao)
	{
		this.dao = dao;
	}
	
	//print() 메소드 구현
	public void print()
	{
		try
		{
			for(MemberDTO dto :dao.list())
			{
				System.out.printf("%10s %4s %15s %15s\n"
						, dto.getId(), dto.getName(), dto.getTel(), dto.getEmail());
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
	}
	

}

