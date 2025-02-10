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
	 <div>섹션아이디 : ${session_id }</div>
	 <div>섹션이름 : ${session_name } 님 환영합니다.</div>
	 <ul>
		   <li><a href="/member/login">로그인</a></li>
		   <li><a href="/member/logout">로그아웃</a></li>
		   <li><a href="/member/member">회원가입</a></li>
		   <li><a href="/board/blist">게시판</a></li>
		   <li><a href="/board/boardWrite">글쓰기</a></li>
		   <hr>
		   <li><a href="/board/bview?bno=2">게시글보기</a></li>
		   <li><a href="/member/mlist">회원리스트</a></li>
		   <li><a href="/member/memInfo">회원정보</a></li>
	 </ul>
	
	</body>
</html>