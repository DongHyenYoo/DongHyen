/*
 #09. EmployeeDAO.java
 - 데이터베이스 액션 처리 클래스
				   직원 데이터 입출력 및 수정 삭제 액션
				   Connection 객체에 대한 의존성 주입 준비
				   (인터페이스 속성 구성 / setter 정의)
 */

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class EmployeeDAO implements IEmployeeDAO
{

	private DataSource dataSource;

	public void setdataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Employee> list() throws SQLException
	{

		ArrayList<Employee> result = new ArrayList<Employee>();

		Connection conn = dataSource.getConnection();

		// sql
		String sql = "SELECT EMPLOYEEID, NAME, SSN, BIRTHDAY, LUNAR, LUNARNAME, TELEPHONE, DEPARTMENTID, DEPARTMENTNAME"
				+ ", POSITIONID, POSITIONNAME, REGIONID, REGIONNAME, BASICPAY, EXTRAPAY, PAY, GRADE FROM EMPLOYEEVIEW";

		// 작업객체
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{

			Employee employee = new Employee();

			employee.setEmployeeId(rs.getString("EMPLOYEEID"));
			employee.setName(rs.getString("NAME"));
			employee.setSsn(rs.getString("SSN"));
			employee.setBirthday(rs.getString("BIRTHDAY"));
			employee.setLunar(rs.getInt("LUNAR"));
			employee.setLunarName(rs.getString("LUNARNAME"));
			employee.setTelephone(rs.getString("TELEPHONE"));
			employee.setDepartmentId(rs.getString("DEPARTMENTID"));
			employee.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			employee.setPositionId(rs.getString("POSITIONID"));
			employee.setPositionName(rs.getString("POSITIONNAME"));
			employee.setRegionId(rs.getString("REGIONID"));
			employee.setRegionName(rs.getString("REGIONNAME"));
			employee.setBasicPay(rs.getInt("BASICPAY"));
			employee.setExtraPay(rs.getInt("EXTRAPAY"));
			employee.setPay(rs.getInt("PAY"));
			employee.setGrade(rs.getInt("GRADE"));

			result.add(employee);

		}

		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	@Override
	public ArrayList<Region> regionList() throws SQLException
	{
		ArrayList<Region> result = new ArrayList<Region>();
		
		Connection conn = dataSource.getConnection();
		
		//sql
		String sql = "SELECT REGIONID, REGIONNAME, DELCHECK FROM REGIONVIEW ORDER BY REGIONID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Region region = new Region();
			
			region.setRegionId(rs.getString("REGIONID"));
			region.setRegionName(rs.getString("REGIONNAME"));
			region.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(region);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public ArrayList<Department> departmentList() throws SQLException
	{
		ArrayList<Department> result = new ArrayList<Department>();
		
		Connection conn = dataSource.getConnection();
		
		//sql
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME, DELCHECK FROM DEPARTMENTVIEW ORDER BY DEPARTMENTID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Department department = new Department();
			
			department.setDepartmentId(rs.getString("DEPARTMENTID"));
			department.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			department.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(department);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public ArrayList<Position> positionList() throws SQLException
	{
		ArrayList<Position> result = new ArrayList<Position>();
		
		Connection conn = dataSource.getConnection();
		
		//sql
		String sql = "SELECT POSITIONID, POSITIONNAME, MINBASICPAY, DELCHECK FROM POSITIONVIEW ORDER BY POSITIONID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Position position = new Position();
			
			position.setPositionId(rs.getString("POSITIONID"));
			position.setPositionName(rs.getString("POSITIONNAME"));
			position.setMinBasicPay(rs.getInt("MINBASICPAY"));
			position.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(position);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		
		return result;
	}

	@Override
	public int getMinBasicPay(String positionId) throws SQLException
	{
		
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT MINBASICPAY FROM POSITIONVIEW WHERE POSITIONID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Integer.parseInt(positionId));
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			result = rs.getInt("MINBASICPAY");
		}
		
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int employeeAdd(Employee employee) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO EMPLOYEE(EMPLOYEEID, NAME, SSN1, SSN2, BIRTHDAY, LUNAR, TELEPHONE, DEPARTMENTID"
				+ ", POSITIONID, REGIONID, BASICPAY, EXTRAPAY) VALUES(EMPLOYEESEQ.NEXTVAL"
				+ ", ?, ? , CRYPTPACK.ENCRYPT(?, ?)"
				+ ", TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, employee.getName());
		pstmt.setString(2, employee.getSsn1());
		pstmt.setString(3, employee.getSsn2());
		pstmt.setString(4, employee.getSsn2());
		pstmt.setString(5, employee.getBirthday());
		pstmt.setInt(6, employee.getLunar());
		pstmt.setString(7, employee.getTelephone());
		pstmt.setInt(8, Integer.parseInt(employee.getDepartmentId()));
		pstmt.setInt(9, Integer.parseInt(employee.getPositionId()));
		pstmt.setInt(10, Integer.parseInt(employee.getRegionId()));
		pstmt.setInt(11, employee.getBasicPay());
		pstmt.setInt(12, employee.getExtraPay());
		
		result = pstmt.executeUpdate();
		
		
		return result;
	}

	@Override
	public int remove(String employeeId) throws SQLException
	{
		
		int result = 0;
		Connection conn = dataSource.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(employeeId));
		result = pstmt.executeUpdate();
		pstmt.close();
		
		conn.close();
		
		return result;
	}
	
	
	

	@Override
	public int modify(Employee employee) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		String sql = "UPDATE EMPLOYEE"
				  + " SET NAME=?, BIRTHDAY=TO_DATE(?, 'YYYY-MM-DD')"
				     + ", LUNAR=?, TELEPHONE=?"
				     + ", DEPARTMENTID=?, POSITIONID=?, REGIONID=?"
				     + ", BASICPAY=?, EXTRAPAY=?"
				     + ", SSN1=?, SSN2=CRYPTPACK.ENCRYPT(?, ?)"
				  + " WHERE EMPLOYEEID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employee.getName());
		pstmt.setString(2, employee.getBirthday());
		pstmt.setInt(3, employee.getLunar());
		pstmt.setString(4, employee.getTelephone());
		pstmt.setInt(5, Integer.parseInt(employee.getDepartmentId()));
		pstmt.setInt(6, Integer.parseInt(employee.getPositionId()));
		pstmt.setInt(7, Integer.parseInt(employee.getRegionId()));
		pstmt.setInt(8, employee.getBasicPay());
		pstmt.setInt(9, employee.getExtraPay());
		pstmt.setString(10, employee.getSsn1());
		pstmt.setString(11, employee.getSsn2());
		pstmt.setString(12, employee.getSsn2());
		pstmt.setInt(13, Integer.parseInt(employee.getEmployeeId()));
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public Employee searchId(String employeeId) throws SQLException
	{
		Employee result = new Employee();
		
		Connection conn = dataSource.getConnection();
		String sql = "SELECT EMPLOYEEID, NAME, SSN1"
				 + ", TO_CHAR(BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY, LUNAR"
				 + ", TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID"
				 + ", BASICPAY, EXTRAPAY"
				 + " FROM EMPLOYEE"
				 + " WHERE EMPLOYEEID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(employeeId));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{	
			// 여기는 employee 객체 생성하면 안 된다.
			
			result.setEmployeeId(rs.getString("EMPLOYEEID"));
			result.setName(rs.getString("NAME"));
			result.setSsn1(rs.getString("SSN1"));
			result.setBirthday(rs.getString("BIRTHDAY"));
			result.setLunar(rs.getInt("LUNAR"));
			result.setTelephone(rs.getString("TELEPHONE"));
			result.setDepartmentId(rs.getString("DEPARTMENTID"));
			result.setPositionId(rs.getString("POSITIONID"));
			result.setRegionId(rs.getString("REGIONID"));
			result.setBasicPay(rs.getInt("BASICPAY"));
			result.setExtraPay(rs.getInt("EXTRAPAY"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public String searchSSN(String ssn2,String employeeId) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		String result = "";
		
		String sql = "SELECT CRYPTPACK.DECRYPT(SSN2, ?) AS SSN2 FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ssn2);
		pstmt.setString(2, employeeId);
		
		ResultSet rs =  pstmt.executeQuery();
		
		if(rs.next())
		{
			result = rs.getString("SSN2");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	//일반 직원 로그인

	@Override
	public String login(String id, String pw) throws SQLException
	{
		//String result = ""; 	//-- 이렇게 하면 비밀번호 틀려도 넘어감
				String result = null;
				Connection conn = dataSource.getConnection();
				String sql = "SELECT NAME"
						  + " FROM EMPLOYEE"
						  + " WHERE EMPLOYEEID=? "
						    + " AND SSN2 = CRYPTPACK.ENCRYPT(?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, id);
				pstmt.setInt(1, Integer.parseInt(id));
				pstmt.setString(2, pw);
				pstmt.setString(3, pw);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
					result = rs.getString("NAME");
				
				rs.close();
				pstmt.close();
				conn.close();
				
				return result;
	}

	@Override
	public String loginAdmin(String id, String pw) throws SQLException
	{
		//String result = ""; 	//-- 이렇게 하면 비밀번호 틀려도 넘어감
				String result = null;
				Connection conn = dataSource.getConnection();
				String sql = "SELECT NAME"
						  + " FROM EMPLOYEE"
						  + " WHERE EMPLOYEEID=? "
						    + " AND SSN2 = CRYPTPACK.ENCRYPT(?, ?)"
						    + " AND GRADE=0";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, id);
				pstmt.setInt(1, Integer.parseInt(id));
				pstmt.setString(2, pw);
				pstmt.setString(3, pw);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
					result = rs.getString("NAME");
				
				rs.close();
				pstmt.close();
				conn.close();
				
				return result;
	}

	@Override
	public ArrayList<Employee> empList() throws SQLException
	{
		
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT EMPLOYEEID, NAME, SSN, BIRTHDAY, LUNARNAME, TELEPHONE, DEPARTMENTNAME, POSITIONNAME, REGIONNAME FROM EMPLOYEEVIEW ORDER BY EMPLOYEEID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Employee dto = new Employee();
			
			dto.setEmployeeId(rs.getString("EMPLOYEEID"));
			dto.setName(rs.getString("NAME"));
			dto.setSsn1(rs.getString("SSN"));
			dto.setLunarName(rs.getString("LUNARNAME"));
			dto.setTelephone(rs.getString("TELEPHONE"));
			dto.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			dto.setPositionName(rs.getString("POSITIONNAME"));
			dto.setRegionName(rs.getString("REGIONNAME"));
			
			result.add(dto);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		
		return result;
		
	}
	
	
	
	
	

}
