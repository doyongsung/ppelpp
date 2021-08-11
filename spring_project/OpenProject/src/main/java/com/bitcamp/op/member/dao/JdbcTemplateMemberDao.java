package com.bitcamp.op.member.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.domain.Member;
import com.bitcamp.op.jdbc.JdbcUtil;


@Repository
public class JdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate template;
	

	public int insertMember(Member member) throws SQLException {
				
		int resultCnt = 0;
		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)"; 
		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
		
		if(member.getMemberphoto() != null) {
			resultCnt = template.update(sql2, 
										member.getMemberid(), 
										member.getPassword(),
										member.getMembername(),
										member.getMemberphoto()
			);
		} else {
			resultCnt = template.update(sql1,
					member.getMemberid(),
					member.getPassword(),
					member.getMembername()
			);
		}

		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from member";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getTimestamp(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}
	
	
	public Member selectByIdPw(String id, String pw) {
	
		//String sql = "select * from member where memberid=? and password=?";
		List<Member> list = template.query("select * from member where memberid=? and password=?", new MemberRowMapper(), id, pw);
		//Member member = list.isEmpty() ? null : list.get(0);
		
		return list.isEmpty() ? null : list.get(0);
	}

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		return template.queryForObject("select count(*) from member where memberid=?", Integer.class, memberId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}