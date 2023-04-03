<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String message = (String)request.getAttribute("message"); %>
	<p>처리결과 : <%=message %></p>
	<a href="memberUpdateForm.do">회원 수정 조회</a>
</body>
</html>