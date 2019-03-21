<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HWing</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<script>
	$(document).ready(function(){
		$('.menu .item').tab();
	});
</script>
<style>
	.item:hover{cursor:pointer;}
	.column{text-align:center;}
	.newProduct{color:black; font-weight:bold;}
	.image{position:relative;}
	div img:last-child{top:-260px;}
</style>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<jsp:include page="header.jsp"/>
	<div class="ui container">
		<div class="ui grid">
			<c:forEach var="product" items="${newProduct }">
				<div class="four wide column">
					<a href="${conPath }/productContentView.do?pNo=${product.pNo}" class="newProduct"
					onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">
						<img class="ui medium image" src="${conPath }/productImg/${product.pImg}">
						<img class="ui mini image" src="${conPath }/img/new1.png">
						${product.pName }
					</a>
				</div>
			</c:forEach>
		</div>
		<br>
		<br>
		<div class="ui top attached tabular menu">
			<div class="item active" data-tab="first">공지사항</div>
			<div class="item" data-tab="second">뉴스/정보</div>
			<div class="item" data-tab="third">리뷰/사용기</div>
			<div class="item" data-tab="fourth">자유게시판</div>
		</div>
		<div class="ui bottom attached tab segment active" data-tab="first">
			<div class="ui relaxed divided list">
				<c:forEach var="notice" items="${nList }">
					<div class="item">
	  					<i class="angle right icon"></i>
  						<div class="content">
    						<a class="header" href="${conPath }/noticeContentView.do?nNo=${notice.nNo}">${notice.nTitle }</a>
    						<div class="description"><fmt:formatDate value="${notice.nDate }" pattern="MM-dd"/></div>
  						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="second">
			<div class="ui relaxed divided list">
				<c:forEach var="nBoard" items="${nbList }">
					<div class="item">
	  					<i class="angle right icon"></i>
  						<div class="content">
    						<a class="header" href="${conPath }/nBoardContentView.do?nbNo=${nBoard.nbNo}">${nBoard.nbTitle }</a>
    						<div class="description"><fmt:formatDate value="${nBoard.nbDate }" pattern="MM-dd"/></div>
  						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="third">
			<div class="ui relaxed divided list">
				<c:forEach var="rBoard" items="${rbList }">
					<div class="item">
	  					<i class="angle right icon"></i>
  						<div class="content">
    						<a class="header" href="${conPath }/rBoardContentView.do?rbNo=${rBoard.rbNo}">${rBoard.rbTitle }</a>
    						<div class="description"><fmt:formatDate value="${rBoard.rbDate }" pattern="MM-dd"/></div>
  						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="fourth">
			<div class="ui relaxed divided list">
				<c:forEach var="fBoard" items="${fbList }">
					<div class="item">
	  					<i class="angle right icon"></i>
  						<div class="content">
    						<a class="header" href="${conPath }/fBoardContentView.do?fbNo=${fBoard.fbNo}">${fBoard.fbTitle }</a>
    						<div class="description"><fmt:formatDate value="${fBoard.fbDate }" pattern="MM-dd"/></div>
  						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>