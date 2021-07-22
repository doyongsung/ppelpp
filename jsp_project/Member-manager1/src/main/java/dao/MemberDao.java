package dao;

import java.sql.Connection;

import domain.Member;

public class MemberDao {

	private MemberDao(){
		
	}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		return resultCnt;
	}
}
