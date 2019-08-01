<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="css/style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/getSchemePrice.js"></script>
<script type="text/javascript" src="plugins/layer/layer.js"></script>
</head>

<body>
	<section class="aui-flexView"> <header
		class="aui-navBar aui-navBar-fixed"> <a href="javascript:;"
		class="aui-navBar-item"> <i class="icon icon-return"></i>
	</a>
	<div class="aui-center">
		<span class="aui-center-title">${productDetail.name}</span>
	</div>
	<a href="javascript:;" class="aui-navBar-item"> <i
		class="icon icon-class"></i>
	</a> </header> <section class="aui-scrollView">
	<div class="aui-ad-img">
		<img src="${productDetail.imgpath}" alt="">
	</div>
	<div class="aui-flex" style="padding-bottom: 5px">
		<div class="aui-flex-box">
			<h2>${productDetail.name}</h2>
			<p>${productDetail.title}-${productDetail.shortTitle}</p>
		</div>
	</div>
	<div class="aui-flex" style="padding-top: 0">
		<div class="aui-flex-box">
			<span> <em>赠专业服务</em> <em>性价比高</em>
			</span>
		</div>
	</div>
	<div>
		<ul class="aui-cho-box">
			<c:if test="${productDetail.ageRange!='off'}">
				<li class="aui-cho-item on">
					<p style="color:black">
						被保人周岁年龄:<input id="age" type="text" name="age" style="width:30px;">岁
					</p>
				</li>
			</c:if>
			<c:if test="${productDetail.coverageList.get(0)!='off'}">
			<li class="aui-cho-item on">
			<p style="color:black">保障金额:
			<select id="coverage" name="coverage">
			<option value="0">请选择</option>
			<c:forEach items="${productDetail.coverageList}" var="var" varStatus="vs">
                                <option value="${var}">${var}</option>
                            </c:forEach>
			</select>
			</p>
			</li>
			</c:if>
			<c:if test="${productDetail.hasSocial!='off'}">
				<li class="aui-cho-item on">
					<p style="color:black">
						有无社保:<input type="radio" id="hasSocial" name="hasSocial" value="yes" />有 <input
							type="radio" id="hasSocial" name="hasSocial" value="no" />无
					</p>
				</li>
			</c:if>
			<c:if test="${productDetail.deadLineList.get(0)!='off'}">
			<li class="aui-cho-item on">
			<p style="color:black">保障期限：
			<select id="deadLine" name="deadLine">
			<option value="0">请选择</option>
			<c:forEach items="${productDetail.deadLineList}" var="var" varStatus="vs">
                                <option value="${var}">${var}</option>
                            </c:forEach>
			</select>
			</p>
			</li>
			</c:if>
			<li class="aui-cho-item on">
			<div class="aui-counter">
			<i class="icon icon-counter"></i>
			<a onclick="getPrice('${productCode}');return false;" href="#" style="color: blue" >保费计算</a>
		    </div>
			</li>
			
		</ul>
	</div>
	<div class="aui-text-list">
		<div class="aui-flex">
			<div class="aui-flex-box">
				<h4>保险金额</h4>
			</div>
			<div class="aui-text-right">
			<c:forEach items="${productDetail.coverageList}" var="var" varStatus="vs">
            	${var}元
            	<c:if test="${!vs.last}">,</c:if>                 
            </c:forEach>	
			</div>
		</div>
		<div class="aui-flex">
			<div class="aui-flex-box">
				<h4>保障期限</h4>
			</div>
			<div class="aui-text-right">
			<c:forEach items="${productDetail.deadLineList}" var="var" varStatus="vs">
                ${var}
                <c:if test="${!vs.last}">,</c:if>
            </c:forEach>
			</div>
		</div>
		<div class="aui-flex">
			<div class="aui-flex-box">
				<h4>重病就医绿色通道</h4>
			</div>
			<div class="aui-text-right">
				<h5>免费</h5>
			</div>
		</div>
		<div class="aui-flex">
			<div class="aui-flex-box">
				<h4>投保年龄</h4>
			</div>
			<div class="aui-text-right">
				<h5>${minAge}岁~${maxAge}岁</h5>
			</div>
		</div>
		<div class="aui-flex">
			<div class="aui-flex-box">
				<a href="javascript:;">查看保障详情</a>
			</div>

		</div>
	</div>
	<div class="divHeight"></div>

	<div class="aui-tab" data-ydui-tab>
		<ul class="tab-nav">
			<li class="tab-nav-item tab-active"><a href="javascript:;">
					<span>产品介绍</span>
			</a></li>
			<li class="tab-nav-item"><a href="javascript:;"> <span>购买须知</span>
			</a></li>
			<li class="tab-nav-item"><a href="javascript:;"> <span>理赔流程</span>
			</a></li>
			<li class="tab-nav-item"><a href="javascript:;"> <span>常见问题</span>
			</a></li>
		</ul>
		<div class="aui-million-text">
			<h2>百万保险，你准备好了吗？</h2>
		</div>
		<div class="tab-panel">
			<div class="tab-panel-item tab-active">
				<p>${productDetail.introduce }</p>
			</div>
			<div class="tab-panel-item">
				<p>${productDetail.notice }</p>
			</div>
			<div class="tab-panel-item">
				<p>${productDetail.compensationNote }</p>
			</div>
			<div class="tab-panel-item">
				<p>${productDetail.question }</p>
			</div>
		</div>
	</div>


	</section>
	<div align="center" style="background-color: #E6E6FA">
		<p style="color: red;font-size:18px;" align="center">
			金额￥:<input type="text" style="background-color:transparent;border:0;width:60px;font-size:25px;" id="price" name="price" align="center" disabled="disabled" >&nbsp;&nbsp;&nbsp;
			<a href="setInsureInfo.jsp" style="color: blue"
				class="aui-tabBar-item">立即投保</a>
		</p>
	</div>
	</section>
	
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".aui-cho-box li").click(function() {

				$(this).addClass("on").siblings().removeClass("on");
				tola();
			});

		});

		function tola() {
			var $li = $(".aui-cho-box").children("li.on");
			var money = $li.children("i").text();
			var count = $(".auiSks").val();
			$(".aui-total span").text(money * count);
		}
	</script>
</body>
</html>