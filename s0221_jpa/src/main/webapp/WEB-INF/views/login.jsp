<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<script>
		  if("${chkLogin}"=="0"){
			  alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인해주세요.");
		  }
		  
		  if("${session_id}" != ""){
			  alert("로그인이 되었습니다.");
			  location.href = "/";
		  }
		  
		</script>
	</head>
	<body>
	  <h2>로그인</h2>
	  <form action="login" method="post">
	    <label>아이디</label>
	    <input type="text" name="id"><br/>
	    <label>패스워드</label>
	    <input type="password" name="pw"><br/>
	    <input type="submit" value="로그인">
	  </form>
	  
	  <div><a href="/">메인페이지 이동</a></div>
	
	</body>
</html>