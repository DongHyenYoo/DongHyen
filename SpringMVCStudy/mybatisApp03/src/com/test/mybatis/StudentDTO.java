/*
 StudentDTO.java
 */

package com.test.mybatis;

public class StudentDTO
{

	//주요 속성 구성
	private String sid, name, tel; //아이디, 이름, 전화번호
	private int sub;//참조 레코드 수
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public int getSub()
	{
		return sub;
	}
	public void setSub(int sub)
	{
		this.sub = sub;
	}
	
	
	
	
	

}
