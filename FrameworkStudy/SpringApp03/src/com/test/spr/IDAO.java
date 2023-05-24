/*
 IDAO.java
 - 인터페이스
 */

package com.test.spr;

import java.sql.SQLException;
import java.util.List;

public interface IDAO
{
	/*
	 * ★ IDAO는 기능적으론 필요하지는 않음 , IDAO타입으로 MemberList한테 자리를 만들어 놓기 위함 ★
	 * 
	 * 가령 MssqlDAO / OracleDAO를 번갈아가면서 사용하려는데... 기존의 방식대로면 MemberList안에 MssqlDAO /
	 * OracleDAO 인스턴스 생성해줬는데, 이방식 대로라면 번갈아가면서 사용할때마다 새로 짜고 바꿔주고 해야함.
	 * 
	 * 그런데 IDAO타입으로 자리를 마련해두면 어떤 DAO가 와도 만들어서 장착이 가능함
	 * 
	 * 즉 IDAO는 어떤 DAO가 와도 쓸수있는 공통적인 속성을 가져야한다.
	 */
	
	
	public List<MemberDTO> list() throws ClassNotFoundException, SQLException;
	
	
}
