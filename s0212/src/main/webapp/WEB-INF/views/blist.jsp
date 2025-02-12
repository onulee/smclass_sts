<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/notice_list.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/search" name="searchFrm" method="post">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="13%">
        <col width="*">
        <col width="13%">
        <col width="13%">
        <col width="13%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>파일첨부</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach items="${list}" var="bdto">
      <tr>
        <td><span class="table-notice">${bdto.bno}</span></td>
        <td class="table-title">
        <a href="/board/bview?bno=${bdto.bno}">${bdto.btitle}</a>
        </td>
        <td>${bdto.id}</td>
        <td><fmt:formatDate value="${bdto.bdate}" pattern="yyyy-MM-dd"/></td>
        <td>${bdto.bhit}</td>
        <td>
        <c:if test="${bdto.bfile != null }">
          <a href="/upload/${bdto.bfile}" download>
          <img src="/images/fileicon.png" width="25px">
          </a>
        </c:if>
        
        </td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
      <li class="first"></li>
      <li class="prev"></li>
      <li class="num"><div>1</div></li>
      <li class="next"></li>
      <li class="last"></li>
    </ul>

    <a href="/board/bwrite"><div class="write">쓰기</div></a>
  </section>

</body>
</html>