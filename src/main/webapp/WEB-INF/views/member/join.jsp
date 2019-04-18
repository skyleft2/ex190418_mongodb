<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<%@ include file='../include/header.jsp' %>

</head>

<body>
<%@ include file='../include/menu.jsp' %>

<h2>회원가입</h2>

<form name='frm' id='frm' method='post' action='/member/member_join.do'>
<table border='1' style='width:400px;'>
	<input type='text' name='_id' id='_id'/>
	<input type='password' name='passwd' id='passwd'/>
	<input type='text' name='name' id='name'/>
	<input type='submit' value='확인'/>
</table>
</form>

</body>
</html>

