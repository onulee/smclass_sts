<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">COMMUNITY</a></li>
				<li class="last">사용 후기</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">COMMUNITY<span>커뮤니티</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">체험단</a></li>
					<li><a href="#" id="leftNavi2">사용 후기</a></li>
					<li class="last"><a href="#" id="leftNavi3">ENJOY COFFEE</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(2,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>이벤트 등록</strong><span>쟈뎅 제품을 구매하신 회원님들의 소중한 후기입니다.</span></h2>
					
					<form action="/event/eventWrite" method="post" name="eventFrm" enctype="multipart/form-data">
					<div class="checkDivTab">
						
						<table summary="분류, 구매여부, 작은이미지, 평가, 제목, 상세 내용 순으로 포토 구매후기를 작성 하실수 있습니다." class="checkTable" border="1" cellspacing="0">
							<caption>포토 구매후기 작성</caption>
							<colgroup>
							<col width="19%" class="tw30" />
							<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><span>아이디</span></th>
									<td>
										<input type="text" id="id" name="id" class="wlong" />
									</td>
								</tr>
								<tr>
									<th scope="row"><span>제목</span></th>
									<td>
										<input type="text" name="etitle" class="wlong" />
									</td>
								</tr>
								<tr>
									<th scope="row"><span>상세 내용</span></th>
									<td>
										<textarea name="econtent" class="tta"></textarea>
									</td>
								</tr>	
								<tr>
									<th scope="row"><span>배너이미지</span></th>
									<td>
										<input type="file" name="files" class="fileType" />
									</td>
								</tr>							
								<tr>
									<th scope="row"><span>상세이미지</span></th>
									<td>
										<input type="file" name="files" class="fileType" />
									</td>
								</tr>							
							</tbody>
						</table>
					</div>

					<script>
					  function saveBtn(){
						  if(document.getElementById("id").value==""){
							  alert("데이터를 입력하셔야 합니다.");
							  return;
						  }
						  alert("이벤트를 등록합니다.");
						  eventFrm.submit();
					  }
					</script>
					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bCenter">
							<ul>																
								<li><a href="#" class="nbtnbig">취소</a></li>
								<li><a onclick="saveBtn()" class="sbtnMini">확인</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					</form>
					
				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->
<%@ include file="../footer.jsp" %>