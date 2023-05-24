package com.test;

public class FriendDTO
{
	private String name, gender;
	private String age;
	private String[] idelType;
	//이상형은 여러개의 데이터가 동시에 전달되므로
	//즉 다중 선택이 가능하도록 구성했기때문에 배열로 처리가능
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String[] getIdelType()
	{
		return idelType;
	}
	public void setIdelType(String[] idelType)
	{
		this.idelType = idelType;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	
	
	
}
