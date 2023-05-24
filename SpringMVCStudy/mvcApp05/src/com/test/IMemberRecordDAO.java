/* ======================================
 * #04. IMemberRecordDAO.java
 * - 인터페이스
 * ======================================
 */
package com.test;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemberRecordDAO
{
	public ArrayList<MemberRecord> list() throws SQLException;
	public int add(MemberRecord memberRecord) throws SQLException;
	public int remove(int scoreId) throws SQLException;	
	public int modify(MemberRecord memberRecord) throws SQLException;	
	
	public MemberRecord searchId(int scoreId) throws SQLException;	
}
