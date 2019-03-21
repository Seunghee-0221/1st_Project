<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<style>
#line{
	font-size: 1.2em;
	line-height: 45px;
}
#title {
	text-align: center;
	margin-bottom: 30px;
}

#paging {
	text-align: center;
}

b {
	color: red;
}
</style>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="users icon"></i>회원관리
			</h2>
		</div>
		<div class="ui middle aligned divided list">
			<c:forEach var="dto" items="${listMember }">
				<div class="item" id="line">
					<div class="right floated content">
						<div class="ui compact menu">
							<div class="ui simple dropdown item">
								회원등급 수정 <i class="dropdown icon"></i>
								<div class="menu">
									<div class="item"
										onclick="location='${conPath}/modifyRateMember.do?mId=${dto.mId}&rCode=1&pageNum=${param.pageNum }'">신규회원</div>
									<div class="item"
										onclick="location='${conPath}/modifyRateMember.do?mId=${dto.mId}&rCode=2&pageNum=${param.pageNum }'">일반회원</div>
									<div class="item"
										onclick="location='${conPath}/modifyRateMember.do?mId=${dto.mId}&rCode=3&pageNum=${param.pageNum }'">우수회원</div>
								</div>
							</div>
						</div>
						<div class="ui button"
							onclick="location='${conPath}/deleteMemberByAdmin.do?mId=${dto.mId}&pageNum=${param.pageNum }'">회원탈퇴
							처리</div>
					</div>
					<i class="user circle icon"></i>
					<div class="content">${dto.mId }(${dto.mNickname })</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br><br>
	<div id="paging">
		<div class="ui pagination menu">
			<c:if test="${pageNum != 1 }">
				<a class="icon item" href="${conPath }/managementMemberView.do?pageNum=1">
					<i class="angle double left icon"></i>
				</a>
			</c:if>
			<c:if test="${pageNum == 1 }">
				<a class="icon disabled item">
					<i class="angle double left icon"></i>
				</a>
			</c:if>
			<c:if test="${pageNum > 10 }">
				<a class="icon item" href="${conPath }/managementMemberView.do?pageNum=${startPage-1}">
					<i class="left chevron icon"></i>
				</a>
			</c:if>
			<c:if test="${pageNum <= 10 }">
				<a class="icon disabled item">
					<i class="left chevron icon"></i>
				</a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i == pageNum }">
					<a class="active item">${i }</a>
				</c:if>
				<c:if test="${i != pageNum }">
					<a class="item" href="${conPath }/managementMemberView.do?pageNum=${i }">${i }</a>
				</c:if>
			</c:forEach>
			<c:if test="${endPage != pageCnt}">
				<a class="icon item" href="${conPath }/managementMemberView.do?pageNum=${endPage+1}">
					<i class="right chevron icon"></i>
				</a>
			</c:if>
			<c:if test="${endPage == pageCnt}">
				<a class="icon disabled item">
					<i class="right chevron icon"></i>
				</a>
			</c:if>
			<c:if test="${pageNum != pageCnt }">
				<a class="icon item" href="${conPath }/managementMemberView.do?pageNum=${pageCnt}">
					<i class="angle double right icon"></i>
				</a>
			</c:if>
			<c:if test="${pageNum == pageCnt }">
				<a class="icon disabled item">
					<i class="angle double right icon"></i>
				</a>
			</c:if>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>