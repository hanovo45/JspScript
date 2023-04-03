<%@page import="co.dev.vo.MemberVO"  %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ include file="../include/sidebar.jsp" %>
	<%@ include file="../include/top.jsp" %>
	
	<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("members");
	System.out.print(list);
	%>
	<table border="1" class="table">
		<thead>
		<tr><td>id</td><td>name</td><td>pass</td><td>mail</td>
		</tr>
		</thead>
		<tbody>
	<%
		for(MemberVO member : list){
	%>
		<tr><td><a href='memberSearch.do?job=search&id=<%=member.getId() %>'><%=member.getId() %></a></td>
			<td><%=member.getName() %></td>
			<td><%=member.getPasswd() %></td>
			<td><%=member.getMail() %></td></tr>
	<%
		}
	%>
	</tbody>
	</table>
	<p>회원등록페이지 이동</p>
	<a href="memberInsertForm.do">회원등록페이지</a>
	
	<%@ include file="../include/footer.jsp" %>