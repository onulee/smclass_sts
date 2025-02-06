<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		  h2{text-align: center;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  table{text-align: center; width:800px; margin:0 auto;}
		  th,td{height:40px; }
		</style>
	</head>
	<body>
	  <h2>로그인정보</h2>
	  <table>
	    <colgroup>
	      <col width="20%">
	      <col width="20%">
	      <col width="20%">
	      <col width="20%">
	      <col width="20%">
	    </colgroup>
	    <tr>
	      <th>아이디</th>
	      <th>패스워드</th>
	      <th>국어</th>
	      <th>영어</th>
	      <th>합계</th>
	    </tr>
	    <tr>
	      <td>${id }</td>
	      <td>${pw }</td>
	      <td>${pw }</td>
	      <td>${pw }</td>
	      <td>${pw }</td>
	    </tr>
	  </table>
	  
	   <div><a href="/">메인페이지 이동</a></div>
	
	
	</body>
</html>