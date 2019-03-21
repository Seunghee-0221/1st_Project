<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 로그인</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<style type="text/css">
	body>.grid {
		height: 400px;
	}
	.image {
		margin-top: -100px;
	}
	
	.column {
		max-width: 450px;
	}
	</style>
	<script>
		$(document).ready(function() {
			$('.ui.form').form({
				fields : {
					id : {
						identifier : 'aId',
						rules : [ {
							type : 'empty',
							prompt : 'id를 입력하세요'
						}, {
							type : 'length[4]',
							prompt : 'id는 4자리 이상 입력하세요'
						} ]
					},
					password : {
						identifier : 'aPw',
						rules : [ {
							type : 'empty',
							prompt : '비밀번호를 입력하세요'
						}, {
							type : 'length[6]',
							prompt : '비밀번호는 6자리 이상 입력하세요'
						} ]
					}
				}
			});
		});
	</script>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg }');
		</script>
	</c:if>
	<c:if test="${not empty member or not empty admin }">
		<script>
			location='${conPath}/main.do';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h2 class="ui teal image header">
				<div class="content">관리자 로그인</div>
			</h2>
			<form class="ui large form" action="${conPath }/adminLogin.do"
				method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="aId"
								placeholder="id">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" name="aPw"
								placeholder="password">
						</div>
					</div>
					<div class="ui fluid large teal submit button">Login</div>
				</div>
				<div class="ui error message"></div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>