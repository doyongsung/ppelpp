<%@page import="member.Member1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   List<Member1> members = new ArrayList<Member1>();
   members.add(new Member1("cool00","1110","COOL00"));
   members.add(new Member1("cool01","1111",null));
   members.add(new Member1("cool02","1112","COOL00"));
   members.add(new Member1("cool03","1113","COOL00"));
   members.add(new Member1("cool04","1114",null));
   members.add(new Member1("cool05","1115",null));
   members.add(new Member1("cool06","1116","COOL00"));
   members.add(new Member1("cool07","1117",null));
   members.add(new Member1("cool08","1118","COOL00"));
   members.add(new Member1("cool09","1119","COOL00"));
   
   session.setAttribute("members", members);

%>