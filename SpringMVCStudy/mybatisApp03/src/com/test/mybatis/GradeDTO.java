/*
 GradeDTO.java
*/
package com.test.mybatis;

public class GradeDTO
{
	
	private String sid,name,sub1,sub2,sub3,tot,avg,ch;
					//아이디,이름,과목1점수,과목2점수,과목3점수,총점,평균,합/불여부
	
	//※참고사항
	// 원칙적으로 각 데이터 타입이 존재하고
	// 여기에 맞춰 속성 타입을 지정하는 것이 맞다.
	// (String, int, double 등)
	// 하지만, 오라클에서 NUMBER로 구성되어있는 정수 및 실수를
	// 숫자로, 구성하는 과정에서 null 에 대한 컨트롤이 까다로워질 수 있다.
	// 이와 같은 이유로 실무에서는 편의상 String 으로 구성하는 경우가
	// 꽤있다.
	// 여기에는 날짜(Date) 타입도 적용된다.
	
	// 즉, 현재 사용하고 있는 sub1, sub2, sub3, tot, avg 와 같이
	//  상황에 따라 null 인 상태가 적용될 가능성이 농후한 컬럼의 경우
	// String 자료형을 선택하여 적용하는 것이
	// 처리 과정에서의 편의성을 얻어낼 수도 있다는 것이다.
	// 권장하는 사항은 아니지만
	// 이와 같은 처리 방법도 있다.
	
	
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

	public String getSub1()
	{
		return sub1;
	}

	public void setSub1(String sub1)
	{
		this.sub1 = sub1;
	}

	public String getSub2()
	{
		return sub2;
	}

	public void setSub2(String sub2)
	{
		this.sub2 = sub2;
	}

	public String getSub3()
	{
		return sub3;
	}

	public void setSub3(String sub3)
	{
		this.sub3 = sub3;
	}

	public String getTot()
	{
		return tot;
	}

	public void setTot(String tot)
	{
		this.tot = tot;
	}

	public String getAvg()
	{
		return avg;
	}

	public void setAvg(String avg)
	{
		this.avg = avg;
	}

	public String getCh()
	{
		return ch;
	}

	public void setCh(String ch)
	{
		this.ch = ch;
	}
	
	
	

}
