package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guest.domain.Message;
import guest.jdbc.JdbcUtil;

public class MessageDao {

	private MessageDao() {}
	
	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}
	
	//게시물 생성
	public int writeMessage(Connection conn, Message message) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql ="insert into guestbook_message (guestname, password, message) "
			    + "values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestname());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	//전체 게시물의 개수
	public int selectAllCount(Connection conn) throws SQLException {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
		stmt = conn.createStatement();
		
		String sql = "select count(*) from guestbook_message";
		
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			totalCount = rs.getInt(1);
		}
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
	
		return totalCount;
	}
	
	// 요청 페이지에 표헌할 메시지 리스트 구하기
	public List<Message> selectMessageList(Connection conn, int firstRow, int messageCountPerPage) throws SQLException{
		List<Message> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from guestbook_message order by regdate desc limit ?, ?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, firstRow);
		pstmt.setInt(2, messageCountPerPage);
		
		rs = pstmt.executeQuery();
		
		list = new ArrayList<Message>();
		while(rs.next()) {
			list.add(makeMessage(rs));
		}
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return list;
	}
	
	// messageid 로 게시물 검색
	public Message selectByMid(Connection conn,int mid) throws SQLException {
		Message message = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from guestbook_message where messageid=?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mid);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			message = makeMessage(rs);
			
		}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}

		return message;
	}
	
	private Message makeMessage(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setMessageid(rs.getInt("messageid"));
		message.setPassword(rs.getString("password"));
		message.setGuestname(rs.getString("guestname"));
		message.setMessage(rs.getString("message"));
		message.setRegdate(rs.getTimestamp("regdate"));
		
		
		return message;
	}
	
}