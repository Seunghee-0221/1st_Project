<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<style>
header{margin-bottom:20px;}
li {
	list-style: none;
}

a {
	color: black;
}

a:hover {
	color: black;
}

#top_menu {
	overflow: hidden;
}

#top_menu li {
	float: right;
	list-style: none;
}

#center {
	text-align: center;
}

#search_area {
	margin: 10px auto;
	width: 100%
}
#nickname {
	font-weight:bold;
	font-size:1.2em;
	line-height:35px;
}
</style>
<script>
	$(function() {
		$('#search_btn').click(
				function() {
					location.href = "${conPath}/totalSearch.do?search="
							+ $('#search_box').val();
				});
		$('#search_box').keyup(
				function(key) {
					if (key.keyCode == 13) {
						location.href = "${conPath}/totalSearch.do?search="
								+ $('#search_box').val();
					}
				});
	});
</script>
</head>
<body>
	<header>
		<div class="ui container">
			<c:if test="${empty member and empty admin }">
				<ul id="top_menu">
					<li><button class="ui black basic button"
							onclick="location='${conPath}/joinView.do'">회원가입</button></li>
					<li><button class="ui black basic button"
							onclick="location='${conPath}/loginView.do'">로그인</button></li>
				</ul>
			</c:if>
			<c:if test="${not empty member and empty admin }">
				<ul id="top_menu">
					<li><button class="ui black basic button"
							onclick="location='${conPath}/logout.do'">로그아웃</button></li>
					<li><button class="ui black basic button"
							onclick="location='${conPath}/modifyMemberView.do'">정보수정</button></li>
					<li><button class="ui black basic button"
							onclick="location='${conPath}/myEstimateView.do?mId=${member.mId }'">내 견적함</button></li>		
					<li><span id="nickname">${member.mNickname }님 ▶</span> &nbsp; &nbsp;</li>
				</ul>
			</c:if>
			<c:if test="${empty member and not empty admin }">
				<ul id="top_menu">
					<li><button class="ui black basic button"
							onclick="location='${conPath}/logout.do'">로그아웃</button></li>
					<li><button class="ui black basic button"
							onclick="location='${conPath}/productManagementView.do'">상품관리</button></li>
					<li><button class="ui black basic button"
							onclick="location='${conPath}/managementMemberView.do'">회원관리</button></li>
					<c:if test="${admin.aMaster eq 1 }">
						<li><button class="ui black basic button"
							onclick="location='${conPath}/managementAdminastorView.do'">관리자리스트</button></li>
						<li><button class="ui black basic button"
							onclick="location='${conPath}/insertAdminastorView.do'">관리자등록</button></li>
					</c:if>
					<li><span id="nickname">관리자 님 ▶</span> &nbsp; &nbsp;</li>
				</ul>
			</c:if>
			<div id="center">
				<a href="${conPath }/main.do"><img
					src="${conPath }/img/logo.png" alt="로고" id="img_logo"></a>
			</div>
			<div class="five ui inverted buttons">
				<button class="ui inverted primary button"
					onclick="location='${conPath}/noticeView.do'">공지사항</button>
				<button class="ui inverted primary button"
					onclick="location='${conPath}/nBoardView.do'">뉴스/정보</button>
				<button class="ui inverted primary button"
					onclick="location='${conPath}/rBoardView.do'">리뷰/사용기</button>
				<button class="ui inverted primary button"
					onclick="location='${conPath}/fBoardView.do'">자유게시판</button>
				<button class="ui inverted primary button"
					onclick="location='${conPath}/productEstimateView.do'">PC견적</button>
			</div>
			<div class="ui icon labeled input" id="search_area">
				<div class="ui label">통합검색</div>
				<input type="text" placeholder="검색어를 입력해 주세요" id="search_box">
				<i class="inverted circular search link icon" id="search_btn"></i>
			</div>
		</div>
	</header>
</body>
</html>