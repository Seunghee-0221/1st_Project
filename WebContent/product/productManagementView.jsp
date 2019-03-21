<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품관리</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script>
		$(document).ready(function(){
			$('.menu .item')
			  .tab()
			;
		});
	</script>
	<style>
		#title {
			text-align: center;
			margin-bottom: 30px;
		}
		.menu .item:hover{
			cursor:pointer;
		}
		#line {
			height:105px;
			line-height:100px;
			font-size: 1.2em;
		}
		#line img {
			width:100px;
			height:100px;
			vertical-align:middle;
		}
		#button{
			line-height:105px;
		}
	</style>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="desktop icon"></i>상품관리
			</h2>
		</div>
		<button class="fluid ui button" onclick="location='${conPath}/productInsertView.do'">상품등록</button>
		<div class="ui top attached tabular menu">
			<div class="item active" data-tab="1">CPU</div>
			<div class="item" data-tab="2">메인보드</div>
			<div class="item" data-tab="3">메모리</div>
			<div class="item" data-tab="4">그래픽카드</div>
			<div class="item" data-tab="5">SSD</div>
			<div class="item" data-tab="6">하드디스크</div>
			<div class="item" data-tab="7">케이스</div>
			<div class="item" data-tab="8">파워</div>
		</div>
		<div class="ui bottom attached tab segment active" data-tab="1">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${cpuList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="2">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${mainboardList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="3">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${ramList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="4">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${vgaList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="5">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${ssdList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="6">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${hddList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="7">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${pcaseList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="8">
			<div class="ui middle aligned divided list">
				<c:forEach var="dto" items="${powerList }">
					<div class="item" id="line">
						<div class="right floated content" id="button">
							<div class="ui button"
								onclick="location='${conPath}/productModifyView.do?pNo=${dto.pNo}'">
								<i class="edit icon"></i>
								수정
							</div>
							<div class="ui button"
								onclick="location='${conPath}/productDelete.do?pNo=${dto.pNo}'">
								<i class="trash alternate outline icon"></i>
								삭제
							</div>
						</div>
						<c:if test="${not empty dto.pImg }">
							<img src="${conPath }/productImg/${dto.pImg}">
						</c:if>
						<c:if test="${empty dto.pImg }">
							<img src="${conPath }/productImg/nothing.jpg">
						</c:if>
						&nbsp;
						<a class="content" href="${conPath }/productContentView.do?pNo=${dto.pNo}"
						onClick="window.open(this.href, '', 'width=1100, height=800, left=400, top=100'); return false;">${dto.pName }</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>