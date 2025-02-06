<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터 확인</title>
		<style>
		  h2{text-align: center;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  table{text-align: center; width:400px; margin:0 auto;}
		  th,td{height:40px; }
		</style>
	</head>
	<body>
	  <h2>학생성적정보</h2>
	  <table>
	    <colgroup>
	      <col width="20%">
	      <col width="20%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="15%">
	      <col width="15%">
	    </colgroup>
	    <tr>
	      <th>학번</th>
	      <th>이름</th>
	      <th>국어</th>
	      <th>영어</th>
	      <th>수학</th>
	      <th>합계</th>
	      <th>평균</th>
	    </tr>
	    <tr>
	      <td>${stu.stuno }</td>
	      <td>${stu.name }</td>
	      <td>${stu.kor }</td>
	      <td>${stu.eng }</td>
	      <td>${stu.math }</td>
	      <td>${stu.total }</td>
	      <td>${stu.avg }</td>
	    </tr>
	  </table>
	  
	   <div><a href="/">메인페이지 이동</a></div>
	
	</body>
</html>