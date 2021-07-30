package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import util.ConnectionProvider;
import util.JdbcUtil;

public class MemberListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		
		try {
			conn = ConnectionProvider.getConnection();
			request.setAttribute("result", dao.selectList(conn));
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
		}
		
		
		
		return "/WEB-INF/views/list_view.jsp";
	}

}
