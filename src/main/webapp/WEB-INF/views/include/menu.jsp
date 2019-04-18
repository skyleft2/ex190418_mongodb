<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<a href='/'>Home</a>
<a href='/memo.do'>메모장</a>
<a href='/guestbook.do'>방명록</a>

<div style='text-aling:rigth;'>
<c:choose>
	<c:when test='${sessionScope.userid == null}'>
		<a href='/member/login.do'>로그인</a>
	</c:when>
	<c:otherwise>
		${sessionScope.userid} 님이 로그인 중 입니다.
		<a href='/member/logout.do'>로그아웃</a>
	</c:otherwise>
</c:choose>
</div>

