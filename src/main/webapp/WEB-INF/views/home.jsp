<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file='include/header.jsp' %>

</head>
<body>
<%@ include file='include/menu.jsp' %>

<h2>heihihihihihi</h2>
<c:if test='${sessionScope.userid != null}'>
	<h2>
		${sessionScope.name}	
		( ${sessionScope.name} ) 님의 방문을 환영해
	</h2>
</c:if>
</body>
</html>

