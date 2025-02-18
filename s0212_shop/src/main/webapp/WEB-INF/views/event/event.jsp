<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">EVENT</a></li>
				<li class="last">진행중 이벤트</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">EVENT<span>이벤트</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">진행중 이벤트</a></li>
					<li><a href="#" id="leftNavi2">종료된 이벤트</a></li>
					<li class="last"><a href="#" id="leftNavi3">당첨자 발표</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>진행중 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					
					<!-- list -->
					<div class="eventList">
						<ul>
							<!-- 반복 -->
							<c:forEach items="${list}" var="edto">
								<li>
									<div class="img">
										<a href="/event/eview?eno=${edto.eno}"><img src="/upload/board/${edto.efile}" alt="진행중 이벤트" /></a>
									</div>
									<div class="txt">
										<div class="subject">${edto.etitle }</div>
										<div class="day">이벤트 기간 : 
										<fmt:formatDate value="${edto.stdate}" pattern="yyyy-MM-dd"/>
										~ 
										<fmt:formatDate value="${edto.enddate}" pattern="yyyy-MM-dd"/>
										</div>
									</div>
								</li>
							</c:forEach>
							<!-- //반복 -->
							
						</ul>
					</div>
					<!-- //list -->

					<div class="btnAreaList">
						<!-- 페이징이동1 -->
						<div class="allPageMoving1">

						<a href="#" class="n"><img src="../images/btn/btn_pre2.gif" alt="처음으로"/></a><a href="#" class="pre"><img src="../images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
						<strong>1</strong>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#">4</a>
						<a href="#">5</a>
						<a href="#" class="next"><img src="../images/btn/btn_next1.gif" alt="뒤페이지로"/></a><a href="#" class="n"><img src="../images/btn/btn_next2.gif" alt="마지막페이지로"/></a>

						</div>
						<!-- //페이징이동1 -->
					</div>
					
					<!-- 검색 -->
					<div class="searchWrap">
						<div class="search">
							<ul>
								<li class="web"><img src="../images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
									<select>
										<option value="" />제목</option>
									</select>
								</li>
								<li><input type="text" class="searchInput" /></li>
								<li class="web"><a href="#"><img src="../images/btn/btn_search.gif" alt="검색" /></a></li>
								<li class="mobile"><a href="#"><img src="../images/btn/btn_search_m.gif" alt="검색" /></a></li>
							</ul>
						</div>
					</div>
					<!-- //검색 -->

				</div>
			</div>
			<!-- //contents -->

		</div>

		<!-- quickmenu -->
		<div id="quick">
			<div class="cart"><a href="#">장바구니</a></div>
			<div class="wish">
				<p class="title">위시 리스트</p>
				
				<div class="list">
					<ul>	
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="../images/img/sample_wish.gif" alt="" /></a>
					</ul>
				</div>

				<div class="total">
					<a href="#none" class="wishLeft"><img src="../images/btn/wish_left.gif" alt="" /></a>
					 <span class="page">1</span> / <span class="sum">3</span>
					<a href="#none" class="wishRight"><img src="../images/btn/wish_right.gif" alt="" /></a>
				</div>

			</div>

			<div class="top"><a href="#">TOP&nbsp;&nbsp;<img src="../images/ico/ico_top.gif" alt="" /></a></div>
		</div>
		<script type="text/javascript">
		$(function(){
			
			$(window).scroll(function(){
				var tg = $("div#quick");
				var xg = $("div#container");
				var limit = xg.height()- 500;
				var tmp = $(window).scrollTop();

				if (tmp > limit) {
					tg.css({"position" : "absolute","right" : "-150px","bottom" : "220px","top" : "auto"});
				}
				else {
					tg.css({"position" : "fixed","top" : "314px" , "margin-left" : "940px","right" : "auto"});
				}
			});

		});
		</script>
		<!-- //quickmenu -->

	</div>
	<!-- //container -->
<%@ include file="../footer.jsp" %>

