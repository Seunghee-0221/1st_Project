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
footer{margin-top:50px;}
p {
	color: #A0A0A0;
}
#f_area{padding:30px 0 50px;}
</style>
</head>
<body>
	<footer>
		<div class="ui inverted vertical footer segment" id="f_area">
			<div class="ui container">
				<div
					class="ui stackable inverted divided equal height stackable grid">
					<div class="four wide column">
						<h4 class="ui inverted header">HWing</h4>
						<p>대표 : 더조은</p>
						<p>Copyright© 2018 HWing. All rights reserved.</p>
					</div>
					<div class="five wide column">
						<h4 class="ui inverted header">문의</h4>
						<div class="ui inverted link list">
							<p>이메일 : mega-IT@tj.com</p>
							<p>주소 : 서울특별시 종로구 삼일대로 17길 51 스타골드빌딩</p>
						</div>
					</div>
					<div class="seven wide column">
						<h4 class="ui inverted header">참고사항</h4>
						<p>HWing은 컴퓨터관련 하드웨어 뉴스/정보를 수집하며<br>PC견적을 수행하는 사이트입니다.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>