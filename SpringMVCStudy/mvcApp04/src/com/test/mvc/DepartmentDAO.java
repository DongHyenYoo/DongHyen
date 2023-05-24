/*
 #10. DepartmetDAO.java
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

public class DepartmentDAO implements IDepartmentDAO
{
	
	private DataSource dataSource;
	

	public void setDatasource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Department> list() throws SQLException
	{
		
		ArrayList<Department> result = new ArrayList<Department>();
		
		Connection conn = dataSource.getConnection();
		
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
	public int add(Department department) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME) VALUES(DEPARTMENTSEQ.NEXTVAL, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, department.getDepartmentName());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		conn.close();
		
		return result;
	}

	@Override
	public int remove(String departmentId) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Integer.parseInt(departmentId));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		conn.close();
		
		
		return result;
	}

	@Override
	public int modify(Department department) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "UPDATE DEPARTMENT SET DEPARTMENTNAME = ? WHERE DEPARTMENTID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, department.getDepartmentName());
		pstmt.setInt(2, Integer.parseInt(department.getDepartmentId()));
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;
	}

	@Override
	public ArrayList<Department> depList() throws SQLException
	{
		
		ArrayList<Department> result = new ArrayList<Department>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME FROM DEPARTMENTVIEW ORDER BY DEPARTMENTID";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Department department = new Department();
			
			department.setDepartmentId(rs.getString("DEPARTMENTID"));
			department.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			result.add(department);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
		
	}

	
	
	
}
