<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/top_navi.js"></script>
<script type="text/javascript" src="../js/left_navi.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.anchor.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../js/html5.js"></script>
<script type="text/javascript" src="../js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function() {
	


});
</script>
</head>
<body>



<!--익스레이어팝업-->
<div id="ieUser" style="display:none">
	<div class="iewrap">	
		<p class="img"><img src="../images/ico/ico_alert.gif" alt="알림" /></p>
		<p class="txt">IE버전이 낮아 홈페이지 이용에 불편함이 있으므로 <strong>IE9이상이나 다른 브라우저</strong>를 이용해 주세요. </p>
		<ul>
			<li><a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie" target="_blank"><img src="../images/ico/ico_ie.gif" alt="IE 최신브라우저 다운" ></a></li>
			<li><a href="https://www.google.com/intl/ko/chrome/browser" target="_blank"><img src="../images/ico/ico_chrome.gif" alt="IE 최신브라우저 다운" ></a></li>
			<li><a href="http://www.mozilla.org/ko/firefox/new" target="_blank"><img src="../images/ico/ico_mozila.gif" alt="MOZILA 최신브라우저 다운" ></a></li>
			<li><a href="http://www.apple.com/safari" target="_blank"><img src="../images/ico/ico_safari.gif" alt="SAFARI 최신브라우저 다운" ></a></li>
			<li><a href="http://www.opera.com/ko/o/ie-simple" target="_blank"><img src="../images/ico/ico_opera.gif" alt="OPERA 최신브라우저 다운" ></a></li>		
		</ul>
		<p class="btn" onclick="msiehide();"><img src="../images/ico/ico_close.gif" alt="닫기" /></p>
	</div>
</div>
<!--//익스레이어팝업-->
<!--IE 6,7,8 사용자에게 브라우저 업데이터 설명 Div 관련 스크립트-->
 <script type="text/javascript">

     var settimediv = 200000; //지속시간(1000= 1초)
     var msietimer;

     $(document).ready(function () {
         msiecheck();
     });

     var msiecheck = function () {
         var browser = navigator.userAgent.toLowerCase();
         if (browser.indexOf('msie 6') != -1 ||
                browser.indexOf('msie 7') != -1 ||
				 browser.indexOf('msie 8') != -1) {
             msieshow();			 
         }
         else {
             msiehide();
         }
     }

     var msieshow = function () {
        $("#ieUser").show();
        msietimer = setTimeout("msiehide()", settimediv);
     }

     var msiehide = function () {
		$("#ieUser").hide();
        clearTimeout(msietimer);
     }
</script>

<div id="allwrap">
<div id="wrap">

	<div id="header">
		
		<div id="snbBox">
			<h1>
			<a href="/">
			  <img src="../images/txt/logo.gif" alt="JARDIN SHOP" />
			</a>
			</h1>
			<div id="quickmenu">
				<div id="mnaviOpen"><img src="../images/btn/btn_mnavi.gif" width="33" height="31" alt="메뉴열기" /></div>
				<div id="mnaviClose"><img src="../images/btn/btn_mnavi_close.gif" width="44" height="43" alt="메뉴닫기" /></div>
				<ul>
					<li><a href="/event/event">EVENT</a></li>
					<li><a href="#">CUSTOMER</a></li>
					<li><a href="#">COMMUNITY</a></li>
				</ul>
			</div>
			<div id="snb">
				<ul>
					<li><a href="#">LOGIN</a></li>
					<li><a href="#">JOIN</a></li>
					<li><a href="#">MY PAGE</a></li>
					<li><a href="#">CART</a></li>
				</ul>

				<div id="search">
					<input type="text" class="searchType" />
					<input type="image" src="../images/btn/btn_main_search.gif" width="23" height="20" alt="검색하기" />
				</div>
			</div>
		</div>
	</div>


	<!-- GNB -->
	<div id="gnb">
		
		<div id="top">
			<ul>
				<li class="brand t1"><a href="#" id="topNavi1">JARDIN’s BRAND</a>
					<ul id="topSubm1">
						<li><a href="#">클래스</a></li>
						<li><a href="#">홈스타일 카페모리</a></li>
						<li><a href="#">드립커피백</a></li>
						<li><a href="#">카페리얼 커피</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">카페리얼 음료</a></li>
						<li><a href="#">마일드커피백</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">카페포드</a></li>
						<li><a href="#">모히또파티</a></li>
						<li><a href="#">테이크아웃 카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi2">원두</a>
					<ul id="topSubm2">
						<li><a href="#">클래스</a></li>
						<li><a href="#">로스터리샵</a></li>
						<li><a href="#">커피휘엘</a></li>
						<li><a href="#">산지별 생두</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi3">원두커피백</a>
					<ul id="topSubm3">
						<li><a href="#">드립커피 로스트</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">마일드커피백</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi4">인스턴트</a>
					<ul id="topSubm4">
						<li><a href="#">까페모리</a></li>
						<li><a href="#">홈스타일카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi5">음료</a>
					<ul id="topSubm5">
						<li><a href="#">까페리얼</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">모히또</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi6">커피용품</a>
					<ul id="topSubm6">
						<li><a href="#">종이컵</a></li>
						<li><a href="#">커피필터</a></li>
						<li><a href="#">머신 등</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi7">선물세트</a></li>
				<li class="t2"><a href="#" id="topNavi8">대량구매</a></li>
			</ul>
		</div>

		<script type="text/javascript">initTopMenu();</script>
	</div>
	<!-- //GNB -->

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="/">HOME</a></li>
				<li><a href="/event/event">EVENT</a></li>
				<li class="last">진행중 이벤트</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">EVENT<span>이벤트</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">진행중 이벤트</a></li>
					<li><a href="#" id="leftNavi2">종료된 이벤트</a></li>
					<li class="last"><a href="#" id="leftNavi3">당첨자 발표</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>진행중 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					
					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<li>${edto.etitle}</li>
								</ul>
							</div>
							<div class="day">
								<p class="txt">이벤트 기간
								<span>
								<fmt:formatDate value="${edto.stdate}" pattern="yyyy-MM-dd"/>
								~ 
								<fmt:formatDate value="${edto.enddate}" pattern="yyyy-MM-dd"/>
								</span></p>
							</div>
						</div>

						<div class="viewContents">
						    ${edto.econtent}
						    <br/>
							<img src="/upload/board/${edto.efile2}" alt="" />
						</div>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							<col width="100px" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									<td><a href="#">상품 재입고는 언제 되나요?</a></td>
									<td>&nbsp;</td>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td>다음 글이 없습니다.</td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->
					<script>
					  $(function(){
						  let chk = 0; //화면창 열림체크
						  let cno;
						  let eno = "${edto.eno}";
						  let id = "${session_id}";
						  let cdate;
						  let ccontent;
						  
						  
						  //댓글쓰기
						  $(".replyBtn").click(function(){
							 if("${session_id}"==""){
								 alert("로그인을 하셔야 댓글을 사용할수 있습니다.");
								 if(confirm("로그인페이지로 이동할까요?")){
									 location.href="/member/login";
								 }
								 return;
							 } 
							  
							 if($(".replyType").val().length<1){
								 alert("댓글 내용을 입력하셔야 저장이 가능합니다.");
								 $(".replyType").focus();
								 return;
							 }
							 alert("댓글을 저장합니다."); 
							 console.log("총 개수 : "+(Number($(".allcount").text())+1));
							 
							 let cpw = $(".replynum").val();
							 let ccontent = $(".replyType").val();
							 let eno = "${edto.eno}";
							 
							 //ajax
							 $.ajax({
								url:"/event/cwrite", //링크주소
								type:"post",         //타입
								data:{"eno":eno,"cpw":cpw,"ccontent":ccontent}, //파라미터
								dataType:"json", //리턴받을 값의 형태
								success:function(data){
									console.log(data.cno);
									console.log(data.ccontent);
									console.log(data.cdate);
									
									let hdata = "";
									//데이터 html코드 생성
									hdata += '<ul id="'+data.cno+'">';
									hdata += '<li class="name">'+data.id+'<span> [ '+
										moment(data.cdate).format("YYYY-MM-DD HH:mm:ss")
										+' ]</span></li>';
									hdata += '<li class="txt">'+data.ccontent+'</li>';
									hdata += '<li class="btn">';
									hdata += '<a class="rebtn updateBtn">수정</a>&nbsp';
									hdata += '<a class="rebtn deleteBtn">삭제</a>';
									hdata += '</li>';
									hdata += '</ul>';
									
									$(".replyBox").prepend(hdata);
									
									//총개수 1증가
									let allcount = Number($(".allcount").text())+1;
									$(".allcount").text(allcount);
									
									//입력된 글 삭제
									$(".replynum").val("");
									$(".replyType").val("");
								},
								error:function(){
									alert("댓글저장 실패");
								}
							 });//ajax
						  });//댓글쓰기-replyBtn
						  
						  //댓글삭제 - 정적형태:화면표시가 되면 추가된 html소스에는 적용이 안됨.
						  //$(".deleteBtn").click(function(){ });
						  
						  //댓글삭제 - 동적형태:추가적인 html소스에서도 적용이 가능
						  $(document).on("click",".deleteBtn",function(){
							  console.log($(this).closest("ul").attr("id"));
							  let cno = $(this).closest("ul").attr("id");
							  if(confirm(cno+"번 댓글을 삭제하시겠습니까?")){
							      alert(cno+"번 게시글이 삭제되었습니다.");
								  
							      $.ajax({
							    	url:"/event/cdelete", //링크주소
									type:"post",         //타입
									data:{"cno":cno}, //파라미터
									dataType:"text", //리턴받을 값의 형태
									success:function(data){
										console.log(data);
										//삭제
										$("#"+cno).remove();
										//총개수 1증가
										let allcount = Number($(".allcount").text())-1;
										$(".allcount").text(allcount);
										
									},
									error:function(){
										alert("댓글저장 실패");
									}
							      });//ajax
							  }
						  });//deleteBtn
						  
						  //updateBtn 수정화면
						  $(document).on("click",".updateBtn",function(){
							  if (chk==1){
								  alert("다른 수정화면이 열려 있습니다. 완료,취소를 한후 수정이 가능합니다.");
								  return;
							  }
							  chk=1;
							  cno = $(this).closest("ul").attr("id");
							  cdate = $(this).closest("ul").children(".name").children("span").text();
							  ccontent = $(this).closest("ul").children(".txt").text();
							  console.log(cno);
							  console.log(cdate);
							  console.log(id);
							  console.log(ccontent);
							  
							  alert(cno+"번 하단댓글을 수정합니다.");
							  
							  let hdata = `
								<li class="name">`+id+`<span> `+cdate+`</span></li>
								<li class="txt"><textarea class="replyType">`+ccontent+`</textarea></li>
								<li class="btn">
								  <a class="rebtn saveBtn">완료</a>
								  <a class="rebtn cancelBtn">취소</a>
								</li>
							  `;
							  $("#"+cno).html(hdata);
						  });//.updateBtn
						  
						  //수정화면 취소
						  $(document).on("click",".cancelBtn",function(){
							  alert(cno+"번 취소버튼 클릭")
							  console.log(id);
							  console.log(cdate);
							  console.log(ccontent);
							  
							  let hdata = `
								<li class="name">`+ id +` <span>`+ cdate +`</span></li>
								<li class="txt">`+ ccontent+`</li>
								<li class="btn">
								  <a class="rebtn updateBtn">수정</a>
								  <a class="rebtn deleteBtn">삭제</a>
								</li>
							  `;
							  $("#"+cno).html(hdata);
							  chk=0;
						  });//.cancelBtn
						  
						  //댓글수정 저장
						  $(document).on("click",".saveBtn",function(){
							  alert(cno+"번 댓글수정을 하였습니다.");
							  ccontent = $(this).closest("ul").children(".txt").children(".replyType").val();
							  
							 //ajax
							 $.ajax({
								url:"/event/cupdate", //링크주소
								type:"post",         //타입
								data:{"eno":eno,"cno":cno,"ccontent":ccontent}, //파라미터
								dataType:"json", //리턴받을 값의 형태
								success:function(data){
									console.log(data.cno);
									console.log(data.ccontent);
									console.log(data.cdate);
									
									let hdata = "";
									//데이터 html코드 생성
									hdata += '<li class="name">'+data.id+'<span> [ '+
										moment(data.cdate).format("YYYY-MM-DD HH:mm:ss")
										+' ]</span></li>';
									hdata += '<li class="txt">'+data.ccontent+'</li>';
									hdata += '<li class="btn">';
									hdata += '<a class="rebtn updateBtn">수정</a>&nbsp';
									hdata += '<a class="rebtn deleteBtn">삭제</a>';
									hdata += '</li>';
									
									$("#"+cno).html(hdata);
									
								},
								error:function(){
									alert("댓글저장 실패");
								}
							 });//ajax
							 chk=0; 
						  });//.saveBtn
						  
						  
						  
					  });//jquery
					
					</script>

					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange allcount">${clist.size()}</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" /></p>
								<textarea class="replyType"></textarea>
							</li>
							<li class="btn"><a class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>

					<div class="replyBox">
						<c:forEach items="${clist}" var="cdto">
						<c:if test="${session_id == cdto.id }">
							<ul id="${cdto.cno}">
								<li class="name">${cdto.id} <span>[${cdto.cdate }]</span></li>
								<li class="txt">${cdto.ccontent }</li>
								<li class="btn">
									<a class="rebtn updateBtn">수정</a>
									<a class="rebtn deleteBtn">삭제</a>
								</li>
							</ul>
						</c:if>
						<c:if test="${session_id != cdto.id }">
						<ul>
							<li class="name">${cdto.id} <span>[${cdto.cdate }]</span></li>
							<c:if test="${cdto.cpw != null }">
							<li class="txt">
								<a class="passwordBtn"><span class="orange">※ 비밀글입니다.</span></a>
							</li>
							</c:if>
							<c:if test="${cdto.cpw == null }">
								<li class="txt">${cdto.ccontent }</li>
							</c:if>
						</ul>
						</c:if>
						</c:forEach>

						<!-- 비밀글 창
						<ul>
							<li class="name">${cdto.id} <span>[${cdto.cdate }]</span></li>
							<li class="txt">
								<a class="passwordBtn"><span class="orange">※ 비밀글입니다.</span></a>
							</li>
						</ul>
						 -->
					</div>
					<!-- //댓글 -->


					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bRight">
							<ul>
								<li><a href="/event/event" class="sbtnMini mw">목록</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					
				</div>
			</div>
			<!-- //contents -->


<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
$(function(){
	
	var winWidth = $(window).width();
	if(winWidth > 767){
		var layerCheck = 540;
	}else{
		var layerCheck = 320;
	}

	$(".passwordBtn").fancybox({
		'autoDimensions'    : false,
		'showCloseButton'	: false,
		'width' : layerCheck,
		'padding' : 0,
		'type'			: 'iframe',
		'onComplete' : function() {
			$('#fancybox-frame').load(function() { // wait for frame to load and then gets it's height
			$('#fancybox-content').height($(this).contents().find('body').height());
			});
		}
	});


});
</script>

		</div>
	</div>
	<!-- //container -->




	<div id="footerWrap">
		<div id="footer">
			<div id="fnb">
				<ul>
					<li class="left"><a href="#">개인정보취급방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li class="left"><a href="#">이메일무단수집거부</a></li>
					<li><a href="#">고객센터</a></li>
					<li class="left brand"><a href="#">쟈뎅 브랜드 사이트</a></li>
				</ul>
			</div>
			
			<div id="finfo">
				<div id="flogo"><img src="../images/txt/flogo.gif" alt="JARDIN THE COFFEE CREATOR, SINCE 1984" /></div>
				<address>
					<ul>
						<li>㈜쟈뎅</li>
						<li>대표자 윤영노</li>
						<li class="tnone">주소 서울시 강남구 논현동 4-21번지 영 빌딩</li>
						<li class="webnone">소비자상담실 02)546-3881</li>
						<li>사업자등록번호 211-81-24727</li>
						<li class="tnone">통신판매신고 제 강남 – 1160호</li>
						<li class="copy">COPYRIGHT © 2014 JARDIN <span>ALL RIGHTS RESERVED.</span></li>
					</ul>
				</address>

				<div id="inicis"><img src="../images/ico/ico_inicis.png" alt="이니시스 결제시스템" /></div>
			</div>
		</div>
	</div>



</div>
</div>
</body>
</html>