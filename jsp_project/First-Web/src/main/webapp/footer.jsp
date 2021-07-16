<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <footer>
         이메일 :<%= request.getParameter("email") %> ,
         전화번호 : <%= request.getParameter("tel") %>
    </footer>