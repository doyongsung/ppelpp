package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil1;
import member.Member;



public class MemberDao {
	
	// 싱글톤 패턴
	// 인스턴스 생성 막기
	private MemberDao() {}
	
	// 클래스 내부에서 인스턴스 생성
	static MemberDao dao = new MemberDao();
	
	// 외부에서 참조값을 반환 받을 수 있는 메소드
	public static MemberDao getInstance() {
		return dao == null ? new MemberDao() : dao;
	}
	
	public List<Member> getMemberList(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = null;
		
		try {
		stmt = conn.createStatement();
		
		String sql = "select * from member1";
		
		rs = stmt.executeQuery(sql);
		
		list = new ArrayList<Member>();
		
		while(rs.next()) {
			list.add(new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(rs);
			JdbcUtil1.close(stmt);
		}
	
		
		return list;
		
		
	}
	
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into project.member1 values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getRegdate());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(pstmt);
		}
		return resultCnt;
	}


}
