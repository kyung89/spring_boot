package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import common.JDBConnect;

@Repository
public class LogDao extends JDBConnect {
	
	/*
	create table dblog (
		 id int auto_increment primary key,
		 method varchar(10) not null,
		 sqlstring varchar(256) not null, ➔ optional
		 regidate date default current_timestamp not null,
		 success boolean default true
	 )
	*/

	public int addLog(String method, String sql, boolean success) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		int result = 0;
		
		try {
			String query = "INSERT INTO DBLOG ( method, sqlstring, success ) VALUES ( ?,?,? )";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, method);
			psmt.setString(2, sql);
			psmt.setBoolean(3, success);
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("addLog() 에러");
			e.printStackTrace();
		} finally {
			try {
				// 사용한 리소스 반환. 사용하지 않은 리소스는 null이므로 실행하지 않음.
				if (rs != null)		rs.close();
				if (psmt != null)	psmt.close();
				if (stmt != null)	stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
