<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	  <h2>메인페이지</h2>
	  <h4>섹션 : ${session_id }</h4>
	  <c:if test="${session_id == null }">
		  <div><a href="/stuInput">학생성적입력</a></div>
		  <div><a href="/login">로그인</a></div>
		  <div><a href="/member">회원가입</a></div>
		  <div><a href="/board?bno=1&btitle=이벤트안내">게시판</a></div>
	  </c:if>
	  <c:if test="${session_id !=null }">
		  <div><a href="/logout">로그아웃</a></div>
		  <div><a href="/memInfo">회원정보</a></div>
	  </c:if>
	
	</body>
</html>