<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	 <h2>메인페이지</h2>
	 <sec:authorize access="isAuthenticated()">
	 <sec:authentication property="principal" var="principal"/>
	 <h3>섹션 : ${principal }</h3>
	 <ul>
		   <li><a href="/logout">로그아웃</a></li>
		   <li><a href="/board/blist">게시판</a></li>
		   <li><a href="/board/bwrite">글쓰기</a></li>
		   <li><a href="/member/memInfo">회원정보</a></li>
		   <li><a href="/member/mlist">회원리스트</a></li>
		   <li><a href="/board/bview?bno=2">게시글보기</a></li>
	 </ul>
	 </sec:authorize>
	 <sec:authorize access="!isAuthenticated()">
	 <h3>로그인을 해주세요</h3>
	 <ul>
		   <li><a href="/auth/login">로그인</a></li>
		   <li><a href="/auth/member">회원가입</a></li>
	 </ul>
	 </sec:authorize>
	
	</body>
	
</html>