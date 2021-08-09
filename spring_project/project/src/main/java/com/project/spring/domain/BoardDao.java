package com.project.spring.domain;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.sql.DataSource;
import com.lje.springboard.dto.Board; 
import com.mysql.cj.xdevapi.PreparableStatement;


public class BoardDao{ 
	private BoardDao() { } 
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance(){
		return dao; } 
	public Connection getConnection()
	{ // 커넥트풀 Connection conn = null; try { Context initContext = new InitialContext(); Context envContext = (Context) initContext.lookup("java:/comp/env"); DataSource ds = (DataSource) envContext.lookup("jdbc/myoracleDB"); conn = ds.getConnection(); // etc. } catch (Exception e) { e.printStackTrace(); } return conn; } public List<Board> selectAll() { List<Board> list = new ArrayList<Board>(); Connection conn = null; PreparedStatement ps = null; ResultSet rs = null; String sql = "select * from mvc_board"; try { conn = getConnection(); ps = conn.prepareStatement(sql); rs = ps.executeQuery(); while (rs.next()) { Board board = new Board(); board.setBno(rs.getInt("bno")); board.setWriter(rs.getString("writer")); board.setTitle(rs.getString("title")); board.setWrite_date(rs.getTimestamp("write_date")); board.setHit(rs.getInt("hit")); list.add(board); } } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps, rs); } return list; } //조회수 증가 public void updateHit(int bno) { Connection conn = null; PreparedStatement ps = null; String sql = "update mvc_board set hit=hit+1 where bno=?"; try { conn = getConnection(); ps = conn.prepareStatement(sql); ps.setInt(1, bno); int n = ps.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps); } } public Board selectOne(int bno) { Board board = null; Connection conn = null; PreparedStatement ps = null; ResultSet rs = null; String sql = "select * from mvc_board where bno=?"; try { conn = getConnection(); ps = conn.prepareStatement(sql); ps.setInt(1, bno); rs = ps.executeQuery(); while (rs.next()) { board = new Board(); board.setBno(rs.getInt("bno")); board.setWriter(rs.getString("writer")); board.setTitle(rs.getString("title")); board.setContent(rs.getString("content")); board.setWrite_date(rs.getTimestamp("write_date")); board.setHit(rs.getInt("hit")); } } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps, rs); } return board; } public void insert(Board board) { Connection conn = null; PreparedStatement ps = null; String sql = "insert into mvc_board(bno, writer, title, content) " + "values (mvc_board_seq.nextval, ?,?,?)"; try { conn = getConnection(); ps = conn.prepareStatement(sql); ps.setString(1, board.getWriter()); ps.setString(2, board.getTitle()); ps.setString(3, board.getContent()); int n = ps.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps); } } public void update(Board board) { Connection conn = null; PreparedStatement ps = null; String sql = "update mvc_board set writer=?, title=?, content=? " + "where bno=?"; try { conn = getConnection(); ps = conn.prepareStatement(sql); ps.setString(1, board.getWriter()); ps.setString(2, board.getTitle()); ps.setString(3, board.getContent()); ps.setInt(4, board.getBno()); int n = ps.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps); } } public void delete(int bno) { Connection conn = null; PreparedStatement ps = null; String sql = "delete from mvc_board where bno=?"; try { conn = getConnection(); ps = conn.prepareStatement(sql); ps.setInt(1, bno); int n = ps.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally { closeDB(conn, ps); } } private void closeDB(Connection conn, PreparedStatement ps, ResultSet rs) { try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); } } private void closeDB(Connection conn, PreparedStatement ps) { try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); } } }
	}
}

