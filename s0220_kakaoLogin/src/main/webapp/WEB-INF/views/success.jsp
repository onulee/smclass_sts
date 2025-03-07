<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
</head>
<body>
<section>
    <h1>결제 성공</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">구매 상품 내역</th>
      </tr>
      
      <tr>
        <td colspan="3" class="article">
        상품명 :  카카오 인형 
        </td>
      </tr>
      <tr>
        <td colspan="3"><strong>상품명</strong> <span class="separator">|</span> [인형] 카카오 라이언 인형 </td>
      </tr>
      <tr>
        <td colspan="3"><strong>금액</strong> <span class="separator">|</span> [최종] 10,000원</td>
      </tr>
    </table>
    <script>
      function buyBtn(){
    	  if(confirm("상품을 구매하시겠습니까?")){
              let buyData = {
                  name: '카카오인형',    // 카카오페이에 보낼 대표 상품명
                  totalPrice: 10000 // 총 결제금액
              };
            
              $.ajax({
                  url: '/pay/orderPay',
                  type: 'POST',
                  data: buyData,
                  dataType: 'json',
                  success: function(data) {
                	  alert("성공");
                      console.log(data);
                      console.log(data.next_redirect_pc_url);
                	  location.href = data.next_redirect_pc_url;
                  },
                  error:function(){
                	  alert("실패");
                  }
              });
    	  }
      }
    </script>
    <a href="/">
    <div class="list" style="background:#00efef;">메인페이지</div>
    </a>
  </section>
</body>
</html>