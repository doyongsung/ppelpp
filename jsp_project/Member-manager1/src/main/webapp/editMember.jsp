<%@page import="domain.Member"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    
    String memberId = request.getParameter("memberid");
    String password = request.getParameter("password");
    String memberName = request.getParameter("membername");
    
    int resultCnt = 0;
    
    Connection conn = null;
    MemberDao dao = null;
    
    conn = ConnectionProvider.getConnection();
    dao = MemberDao.getInstance();
    
    resultCnt = dao.updateMember(conn, new Member(memberId,password,memberName));
    
    if(resultCnt > 0){
    	%>
    	<script>
    		alert('수정되었습니다.');
    		location.href="member_list.jsp";
    	</script>
    	<%
    }else{
    	%>
    	<script>
    	alert("해당 데이터를 찾지 못했습니다.");
    	location.href="member_list.jsp";
    	</script>
    	<%
    }
    
    %>