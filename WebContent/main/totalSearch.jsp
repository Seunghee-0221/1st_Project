<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합검색 결과</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="ui container">
		<div class="ui top attached tabular menu">
			<div class="item">뉴스/정보</div>
		</div>
		<br>
		<div class="ui bottom attached segment">
			<div class="ui relaxed divided list">
				<c:if test="${not empty nBoardList }">
					<c:forEach var="nBoard" items="${nBoardList }">
						<div class="item">
							<i class="large github middle aligned icon"></i>
							<div class="content">
								<a class="header" href="${conPath }/nBoardContentView.do?nbNo=${nBoard.nbNo}">${nBoard.nbTitle }</a>
								<div class="description"><fmt:formatDate value="${nBoard.nbDate }" pattern="MM-dd"/></div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty nBoardList }">
					<p>검색 결과가 없습니다</p>
				</c:if>
			</div>
		</div>
		<div class="ui top attached tabular menu">
			<div class="item">리뷰/사용기</div>
		</div>
		<br>
		<div class="ui bottom attached segment">
			<div class="ui relaxed divided list">
				<c:if test="${not empty rBoardList }">
					<c:forEach var="rBoard" items="${rBoardList }">
						<div class="item">
							<i class="large github middle aligned icon"></i>
							<div class="content">
								<a class="header" href="${conPath }/rBoardContentView.do?rbNo=${rBoard.rbNo}">${rBoard.rbTitle }</a>
								<div class="description"><fmt:formatDate value="${rBoard.rbDate }" pattern="MM-dd"/></div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty rBoardList }">
					<p>검색 결과가 없습니다</p>
				</c:if>
			</div>
		</div>
		<div class="ui top attached tabular menu">
			<div class="item">자유게시판</div>
		</div>
		<br>
		<div class="ui bottom attached segment">
			<div class="ui relaxed divided list">
				<c:if test="${not empty fBoardList }">
					<c:forEach var="fBoard" items="${fBoardList }">
						<div class="item">
							<i class="large github middle aligned icon"></i>
							<div class="content">
								<a class="header" href="${conPath }/fBoardContentView.do?fbNo=${fBoard.fbNo}">${fBoard.fbTitle }</a>
								<div class="description"><fmt:formatDate value="${fBoard.fbDate }" pattern="MM-dd"/></div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty fBoardList }">
					<p>검색 결과가 없습니다</p>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>