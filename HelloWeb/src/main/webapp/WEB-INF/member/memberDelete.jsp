<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/sidebar.jsp" %>
	<%@ include file="../include/top.jsp" %>
							
	<h3>회원삭제조회(memberDelete.jsp)</h3>
<%
	MemberVO member = (MemberVO) request.getAttribute("vo");
	String message = (String) request.getAttribute("message");
	if(message != null){	// 조회된 정보가 있으면 화면 결과표시
%>
	<p><%=message %></p>
<%
	}
%>
	<form action="memberSearch.do">
	<input type="hidden" name="job" value="delete">
	찾을ID: <input type="text" name="id">
	<input type="submit" value="찾기">
	</form>
	
	<p></p>
	<h3>회원삭제정보</h3>
<% 		
	if(member != null){	// 조회된 정보가 있으면 화면 결과 표시
%>
	<form action="memberDelete.do">
		ID: <input type="text" name="id" value="<%=member.getId() %>" readonly><br>
		<input type="submit" value="삭제">
	</form>
<%
	}
%>
	<%@ include file="../include/footer.jsp" %>