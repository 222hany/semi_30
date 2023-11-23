<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	session.invalidate();
	response.sendRedirect("mainpage.jsp");
%>