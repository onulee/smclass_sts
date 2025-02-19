<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가입회원정보</title>
		<style>
		  h2{text-align: center;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  table{text-align: center; width:1000px; margin:0 auto;}
		  th,td{height:40px; }
		</style>
	</head>
	<body>
	  <h2>가입회원정보</h2>
	  <table>
	    <colgroup>
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	    </colgroup>
	    <tr>
	      <th>아이디</th>
	      <th>패스워드</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>성별</th>
	      <th>취미</th>
	      <th>가입일</th>
	      <th>수정</th>
	      <th>삭제</th>
	    </tr>
	    <tr>
	      <td>${mdto.id }</td>
	      <td>${mdto.pw }</td>
	      <td>${mdto.name }</td>
	      <td>${mdto.phone }</td>
	      <td>${mdto.gender }</td>
	      <td>${mdto.hobby }</td>
	      <td>${mdto.mdate }</td>
	      <td>
	        <a href="/memUpdate?id=${mdto.id}">수정</a>
	      </td>
	      <td>
	        <button type="button" onclick="deleteBtn()">삭제</button>
	      </td>
	    </tr>
	  </table>
	  <script>
	    function deleteBtn(){
	    	if(confirm("${mdto.name}님 회원을 삭제하시겠습니까?")){
	    		location.href="/memDelete?id=${mdto.id}";
	    		alert("삭제되었습니다.");
	    	}
	    }
	  </script>
	  
	   <div><a href="/">메인페이지 이동</a></div>
	
	</body>
</html>