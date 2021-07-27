package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Member;
import util.jdbcUtil;

public class MemberDao {

	private MemberDao(){
		
	}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "insert into member (memberid,password,membername) values(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMembername());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultCnt;

	}
	
	public List<Member> selectList(Connection conn){
		List<Member> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt= conn.createStatement();
			
			String sql = "select * from member";
			
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();
			
			while(rs.next()) {
				list.add(new Member(
						 rs.getInt(1),
						 rs.getString(2),
						 rs.getString(3),
						 rs.getString(4),
						 rs.getTimestamp(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);
		}

		return list;
	}
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from project.member where memberid =? and password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMemberid(rs.getString("memberid"));
				member.setMemberid(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
				member.setRegdate(rs.getTimestamp("regdate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		return member;
		
	}
	public Member selectByIdx(Connection conn,int idx) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberid(rs.getString("memberid"));
				member.setPassword(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	public int updateMember(Connection conn,Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update member set memberid =?, password = ?, membername = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMembername());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
	public int deleteMember(Connection conn, int idx) {
		int resultCnt =0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	
	
	
	
	
	
	
}
