<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="../include/sidebar.jsp" %>
	<%@ include file="../include/top.jsp" %>
<body>
	<%
		Object obj = request.getAttribute("message");	// Object타입
		String result = (String) obj;
		//String id = (String) request.getAttribute("id");   // String타입
	%>
	<p>처리결과:<%=result %></p>
	
	
	<p>회원목록으로 이동</p>
	<a href="memberList.do">회원목록페이지</a>
	
	<%@ include file="../include/footer.jsp" %>