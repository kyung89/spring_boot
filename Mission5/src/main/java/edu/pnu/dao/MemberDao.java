package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import common.JDBConnect;
import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao extends JDBConnect {
	
	private LogDao logDao = new LogDao();

	public List<MemberVO> getAllMember() {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<MemberVO> list = new ArrayList<>();
		
		String query = "SELECT * FROM MEMBER";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPass(rs.getString(3));
				vo.setRegidate(rs.getDate(4));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("getAllMember() 에러");
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
		return list;
	}
	
	public int getMemberCountById(Integer id) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM MEMBER WHERE ID=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("getMemberById(id) 에러");
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
		
		return totalCount;
	}

	public MemberVO getMemberById(Integer id) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		if(getMemberCountById(id) == 0) {
			return null;
		}
		
		MemberVO vo = new MemberVO();

		String query = "SELECT * FROM MEMBER WHERE ID=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
			
			rs.next();	
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setPass(rs.getString(3));
			vo.setRegidate(rs.getDate(4));
			
		} catch (Exception e) {
			System.out.println("getMemberById(id) 에러");
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
		
		return vo;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		if (getMemberCountById(memberVO.getId()) != 0) {
			return null;
		}
		
		try {
			String query = "INSERT INTO MEMBER ( id, name, pass ) VALUES ( ?,?,? )";
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, memberVO.getId());
			psmt.setString(2, memberVO.getName());
			psmt.setString(3, memberVO.getPass());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("addMember(memberVO) 에러");
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
		
		return getMemberById(memberVO.getId());
	}
	
	public int updateMember(MemberVO memberVO) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		if (getMemberCountById(memberVO.getId()) == 0) {
			return result;
		}
		
		try {
			String query = "UPDATE MEMBER SET NAME=?, PASS=? WHERE ID=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getName());
			psmt.setString(2, memberVO.getPass());
			psmt.setInt(3, memberVO.getId());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateMember(memberVO) 에러");
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
	
	public int removeMember(Integer id) {
		
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int result = 0;

		try {
			String query = "DELETE FROM MEMBER WHERE ID=?";
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("removeMember(id) 에러");
			e.printStackTrace();
			logDao.addLog("removeMember(id)", "DELETE FROM MEMBER WHERE ID=" + id, false);
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
