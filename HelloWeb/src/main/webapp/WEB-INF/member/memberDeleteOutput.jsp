<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/sidebar.jsp" %>
	<%@ include file="../include/top.jsp" %>
							
<%	String message = (String) request.getAttribute("result"); %>
<h3>삭제 결과</h3>
<p>삭제 결과 : <%=message %></p>
	<%@ include file="../include/footer.jsp" %>