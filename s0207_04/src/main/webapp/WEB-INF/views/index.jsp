<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script>
		  if("${param.chk}"=="1") alert("로그인이 되었습니다.");
		  if("${param.outChk}"=="1") alert("로그아웃이 되었습니다.");
		</script>
	</head>
	<body>
	 <h2>메인페이지</h2>
	 <ul>
	   <c:if test="${session_id == null }">
		   <li><a href="/board/blist">게시판</a></li>
		   <li><a href="/board/bview?bno=2">게시글보기</a></li>
		   <li><a href="/member/mlist">회원리스트</a></li>
		   <li><a href="/member/login">로그인</a></li>
		   <li><a href="/member/memInsert">회원가입</a></li>
	   </c:if>
	   <c:if test="${session_id != null }">
		   <li><a href="/member/memInfo">회원정보</a></li>
		   <li><a href="/member/logout">로그아웃</a></li>
	   </c:if>
	 </ul>
	
	</body>
</html>