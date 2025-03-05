<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">MEMBERSHIP</a></li>
				<li class="last">회원가입</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">MEMBERSHIP<span>멤버쉽</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">로그인</a></li>
					<li><a href="#" id="leftNavi2">회원가입</a></li>
					<li><a href="#" id="leftNavi3">아이디/<span>비밀번호 찾기</span></a></li>
					<li><a href="#" id="leftNavi4">회원약관</a></li>
					<li><a href="#" id="leftNavi5">개인정보<span>취급방침</span></a></li>
					<li class="last"><a href="#" id="leftNavi6">이메일무단<span>수집거부</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(2,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="member">
					<h2><strong>회원가입</strong><span>회원으로 가입하시면 보다 더 다양한 혜택을 누리실 수 있습니다.</span></h2>
					
					<!-- STEP -->
					<div class="stepWrap">
						<div class="step stepon">
							<p class="web">STEP 01</p>
							<p class="txt">실명확인</p>
							<p class="ck"><img src="../images/bg/bg_step.png" alt="현재위치" /></p>
						</div>

						<div class="step">
							<p class="web">STEP 02</p>
							<p class="txt">약관 동의</p>
						</div>

						<div class="step">
							<p class="web">STEP 03</p>
							<p class="txt"><span>회원정보</span> <span>입력</span></p>
						</div>

						<div class="step">
							<p class="web">STEP 04</p>
							<p class="txt"><span>회원가입</span> <span>완료</span></p>
						</div>
					</div>
					<!-- //STEP -->
						

					<div class="alertBox">
						<ul>
							<li>회원님의 실명확인 및 가입 여부를 확인하는 절차입니다.</li>
							<li>회원님의 개인 정보 보호를 위해 실명확인을 실시하고 있습니다.</li>
						</ul>
					</div>
					
					<!-- table추가 -->
					<div class="checkDivTab">
						<table summary="분류, 구매여부, 평가, 제목, 상세 내용 순으로 상품평을 작성 하실수 있습니다." class="checkTable" border="1" cellspacing="0">
							<caption>상품평 작성</caption>
							<colgroup>
							<col width="25%" class="tw30" />
							<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><span>이메일주소 입력</span></th>
									<td>
										<input type="text" class="wlong" name="email" />
									</td>
								</tr>
								<tr>
									<th scope="row"><span>인증코드</span></th>
									<td>
										<input type="text" id="pwCode" class="wlong" />
									</td>
								</tr>
															
							</tbody>
						</table>
					</div>

					<script>
					  $(function(){
						 
						 $(".nbtnbig").click(()=>{
							let email = $('input[name="email"]');
							if(email.val().length<1){
								alert("이메일을 입력하셔야 합니다.");
								return;
							}
							alert("인증코드를 이메일로 발송했습니다."); 
							alert(email.val());
							//ajax 이메일발송
							$.ajax({
								url:"/member/sendEmail2",
								type:"post",
								data:{"email":email.val()},
								success:function(data){
									alert("성공");
									console.log(data);
									
									
								},
								error:function(){
									alert("이메일 발송 실패");
								}
							});//ajax
						 });//emailbtn 
						 
						 
						 $(".sbtnMini").click(()=>{
							//alert("인증코드 : ${pwCode}"); 
							$.ajax({
								url:"/member/pwCodeCheck",
								type:"post",
								data:{"pwCode":$("#pwCode").val()},
								success:function(data){
									console.log(data);
									if(data == "1"){
										alert("인증코드 완료.\n다음단계로 이동합니다.");
										//이동
										location.href="/member/step02";
									}else{
										alert("인증코드 실패. 인증코드를 다시 입력하세요.");
										$("#pwCode").val("");
										$("#pwCode").focus();
									}
									
									
								},
								error:function(){
									alert("이메일 발송 실패");
								}
							});//ajax
							
							
							
						 });
						 
						 
					  });//jquery
					</script>
					
					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bCenter">
							<ul>																
								<li><a class="nbtnbig">인증코드 발송</a></li>
								<li><a class="sbtnMini">다음으로</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->


				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->
<%@ include file="../footer.jsp" %>


