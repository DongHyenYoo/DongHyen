package com.test;

public class MyData
{
	//주요 속성 구성
	
	private String name;
	private int age;
	
	public MyData()
	{
		//default 생성자 형태의 사용자 정의 생성자 추가
	}
	
	
	public MyData(String name, int age)
	{
		//매개변수가 2개인 사용자 정의 생성자 추가
		this.name = name;
		this.age = age;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public int getAge()
	{
		return age;
	}


	public void setAge(int age)
	{
		this.age = age;
	}
	
	
	
	
	

}
