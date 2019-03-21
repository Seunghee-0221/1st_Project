<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품등록</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=xm2s0g4rn0v76xq46qy83s40zk89w5ikf7i2fk07d7xn07up"></script>
	<script>
		tinymce.init({
			selector : 'textarea#image-tools',
			height : 500,
			plugins : [
					"advlist autolink lists link image charmap print preview anchor",
					"searchreplace visualblocks code fullscreen",
					"insertdatetime media table paste imagetools wordcount" ],
			toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
			content_css : [
					'//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
					'//www.tiny.cloud/css/codepen.min.css' ]
		});
	</script>
	<script>
		$(document).ready(function(){
			$('.ui.dropdown').dropdown();
			$('form').submit(function(){
				if($('input[name="pCode"]').val() == ""){
					alert('상품분류를 선택해주세요');
					return false;
				}
			});
			$('#pImg').change(function(){
				$('#filename').val($('input[type=file]')[0].files[0].name);
			});
		});
	</script>
	<style>
		#title {
			text-align: center;
			margin-bottom: 30px;
		}
		#pImg{display:none;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="pencil alternate icon"></i>상품등록
			</h2>
		</div>
		<form class="ui form" action="${conPath }/productInsert.do" method="post" enctype="multipart/form-data">
			<div class="ui form">
				<div class="fields">
					<div class="eight wide field">
						<label>상품명</label>
						<input type="text" name="pName" placeholder="상품명" required="required">
					</div>
					<div class="three wide field">
						<label>분류</label>
						<div class="ui selection dropdown">
							<input type="hidden" name="pCode">
							<i class="dropdown icon"></i>
							<div class="default text">분류</div>
							<div class="menu">
								<div class="item" data-value="CPU">CPU</div>
								<div class="item" data-value="MAINBOARD">메인보드</div>
								<div class="item" data-value="RAM">메모리</div>
								<div class="item" data-value="VGA">그래픽카드</div>
								<div class="item" data-value="SSD">SSD</div>
								<div class="item" data-value="HDD">하드디스크</div>
								<div class="item" data-value="PCASE">케이스</div>
								<div class="item" data-value="POWER">파워</div>
							</div>
						</div>
					</div>
					<div class="two wide field">
						<label>가격(원)</label>
						<input type="text" name="pPrice" maxlength="8" placeholder="원" required="required"
						onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
					</div>
					<div class="three wide field">
						<input type="file" id="pImg" name="pImg">
						<label>대표이미지</label>
						<label for="pImg">
							<div class="ui action input">
								<input type="text" id="filename" readonly="readonly">
								<div class="ui red right icon button">
								    <i class="upload icon"></i>
								</div>
							</div>
						</label>
					</div>
				</div>
			</div>
			<textarea id="image-tools" name="pContent">
			</textarea>
			<br>
			<input type="submit" value="등록하기" class="ui right floated primary button">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>