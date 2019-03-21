<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PC견적</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<script>
		$(document).ready(function(){
			var tot = 0;
			var selected = 0;
			function addComma(num) {
			  var regexp = /\B(?=(\d{3})+(?!\d))/g;
			  return num.toString().replace(regexp, ',');
			}
			$('.menu .item').tab();
			$('.cpu').click(function(){
				$('#cpuArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="cpuPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="cpu" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});	
			$('.mainboard').click(function(){
				$('#mainboardArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="mainboardPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="mainboard" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.ram').click(function(){
				$('#ramArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="ramPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="ram" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.vga').click(function(){
				$('#vgaArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="vgaPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="vga" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.ssd').click(function(){
				$('#ssdArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="ssdPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="ssd" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.hdd').click(function(){
				$('#hddArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="hddPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="hdd" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.pcase').click(function(){
				$('#pcaseArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="pcasePrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="pcase" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.power').click(function(){
				$('#powerArea').html('<div class="ui message">'+$(this).find('input[name="pName"]').val()+'<div class="rightAlign">'+addComma($(this).find('input[name="pPrice"]').val())+' 원</div>'+
						'<input type="hidden" id="powerPrice" value="'+$(this).find('input[name="pPrice"]').val()+'"><input type="hidden" name="power" value="'+$(this).find('input[name="pNo"]').val()+'"></div>');
			});
			$('.tab .button').click(function(){
				tot = Number($('#cpuPrice').val())+Number($('#mainboardPrice').val())+Number($('#ramPrice').val())+Number($('#vgaPrice').val())+Number($('#ssdPrice').val())+Number($('#hddPrice').val())+Number($('#pcasePrice').val())+Number($('#powerPrice').val());
				$('#totPrice').text(addComma(tot)+' 원');
				selected = 1;
			});
			$('form').submit(function(){
				if(${empty member}){
					alert('견적을 저장하시려면 로그인하세요');
					return false;
				}
				if(selected == 0){
					alert('상품을 하나 이상 선택하세요');
					return false;
				}
			});
		});
	</script>
	<style>
		#line {
			line-height:35px;
			font-size: 1.2em;
		}
		#cpuArea, #mainboardArea, #ramArea, #vgaArea, #ssdArea, #hddArea, #pcaseArea, #powerArea{margin:0;}
		.rightAlign{text-align:right;}
		#line {
			height:105px;
			line-height:100px;
			font-size: 1.2em;
		}
		#line img{width:100px; height:100px; vertical-align:middle;}
		#button{
			line-height:105px;
		}
		#title{
			text-align:center;
			margin:30px 0;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="dropbox icon"></i>PC견적
			</h2>
		</div>
		<div class="ui grid">
  			<div class="twelve wide stretched column">
  				<div class="ui tab active segment" data-tab="1">
					<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${cpuList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button cpu">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="2">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${mainboardList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button mainboard">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="3">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${ramList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button ram">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="4">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${vgaList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button vga">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="5">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${ssdList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button ssd">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="6">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${hddList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button hdd">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
  				<div class="ui tab segment" data-tab="7">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${pcaseList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button pcase">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
								onClick="window.open(this.href, '', 'width=1200, height=800, left=300, top=100'); return false;">${dto.pName }</a>
							</div>
						</c:forEach>
					</div>
	    		</div>
  				<div class="ui tab segment" data-tab="8">
    				<div class="ui middle aligned divided list">
						<c:forEach var="dto" items="${powerList }">
							<div class="item" id="line">
								<div class="right floated content" id="button">
									<fmt:formatNumber value="${dto.pPrice }" pattern="##,###,###"/>원 &nbsp;
									<div class="ui right labeled icon button power">
										<input type="hidden" name="pNo" value="${dto.pNo }">
										<input type="hidden" name="pPrice" value="${dto.pPrice }">
										<input type="hidden" name="pName" value="${dto.pName }">
										<i class="right arrow icon"></i>
										담기
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
								onClick="window.open(this.href, '', 'width=1200, height=800, left=300, top=100'); return false;">${dto.pName }</a>
							</div>
						</c:forEach>
					</div>
	    		</div>
  			</div>
  			<div class="four wide column">
				<form action="${conPath }/productEstimateInsert.do" method="post">
					<div class="ui vertical fluid right tabular menu" style="overflow:auto; height:500px;">
						<input type="hidden" name="mId" value="${member.mId }">
						<a class="item active" data-tab="1">
							<font style="vertical-align: inherit;">
								<font style="vertical-align: inherit;">CPU</font>
							</font>
						</a>
						<div id="cpuArea">
							<input type="hidden" id="cpuPrice" value="0">
						</div>
	      				<a class="item" data-tab="2">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">메인보드</font>
	      					</font>
	      				</a>
	      				<div id="mainboardArea">
							<input type="hidden" id="mainboardPrice" value="0">
						</div>
	      				<a class="item" data-tab="3">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">메모리</font>
	      					</font>
	      				</a>
	      				<div id="ramArea">
							<input type="hidden" id="ramPrice" value="0">
						</div>
	      				<a class="item" data-tab="4">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">그래픽카드</font>
	      					</font>
	      				</a>
	      				<div id="vgaArea">
							<input type="hidden" id="vgaPrice" value="0">
						</div>
	      				<a class="item" data-tab="5">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">SSD</font>
	      					</font>
	      				</a>
	      				<div id="ssdArea">
							<input type="hidden" id="ssdPrice" value="0">
						</div>
	      				<a class="item" data-tab="6">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">하드디스크</font>
	      					</font>
	      				</a>
	      				<div id="hddArea">
							<input type="hidden" id="hddPrice" value="0">
						</div>
	      				<a class="item" data-tab="7">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">케이스</font>
	      					</font>
	      				</a>
	      				<div id="pcaseArea">
							<input type="hidden" id="pcasePrice" value="0">
						</div>
	      				<a class="item" data-tab="8">
	      					<font style="vertical-align: inherit;">
	      						<font style="vertical-align: inherit;">파워</font>
	      					</font>
	      				</a>
	      				<div id="powerArea">
							<input type="hidden" id="powerPrice" value="0">
						</div>
	    			</div>
	    			<div class="ui message">총 합계금액 <div id="totPrice"class="rightAlign">0 원</div></div>
					<input type="submit" class="ui right floated button" value="견적저장">
				</form>
  			</div>
		</div> 
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>