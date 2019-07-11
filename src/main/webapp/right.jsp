<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
</head>
<body>
<br>
<div align="center">
<p style="color:blue;font-size:20px">欢迎来到保险服务系统！</p><br>
<p>商品名称:<input type="text" id="productName" name="productName">
&nbsp;&nbsp;---商品类型:
<select id="type">
	<option value="0">请选择</option>
	<option value="医疗">医疗保险</option>
	<option value="人寿">人寿保险</option>
	<option value="意外">意外保险</option>
	<option value="旅游">旅游保险</option>	
</select>
&nbsp;&nbsp;&nbsp;&nbsp;
<button id="search" onclick="goSearch();">搜索</button>&nbsp;<input type="reset" value="重置">
</p>
</div>
<br><br>
<c:if test="${products!=null }">
<div class="part1">
<div align="center">
<p style="color:blue;font-size:20px">---为您推荐---</p>
</div><br>
<div class="pro_recommend">
    <ul>
    <c:forEach var="product" items="${products}" varStatus="status">
        <li>
        	<c:forEach var="productCode" items="${productCodes}" varStatus="codeStatus"> 
        	<c:if test="${codeStatus.count == status.count}">
        	<a href="productDetail.action?productCode=${productCode}" class="goods-li-a" target="rightFrame">
        	<img class="item-img" src="${product.imgpath}">
                <div class="item-text">
                    <strong>${product.name}</strong>
                    <p>${product.title}<br>${product.shortTitle}</p>
                    <span>查看详情</span>
                </div>
                <i class="i-p-hot"></i>
            </a>
        	</c:if>
        	</c:forEach>          
        </li>
    </c:forEach> 
    </ul>
</div>
</div>
</c:if>
<c:if test="${searchProducts!=null }">
<div class="part2">
<div align="center">
<p style="color:blue;font-size:20px">---搜索得到的匹配结果如下：---</p>
</div><br>
<div class="pro_recommend">
    <ul>
    <c:forEach var="searchProduct" items="${searchProducts}" varStatus="status">
        <li>
            <a href="productDetail.action?productCode=${searchProduct.code}" class="goods-li-a" target="rightFrame">
                <img class="item-img" src="${searchProduct.imgpath}">
                <div class="item-text">
                    <strong>${searchProduct.name}</strong>
                    <p>${searchProduct.title}<br>${searchProduct.shortTitle}</p>
                    <span>查看详情</span>
                </div>
                <i class="i-p-hot"></i>
            </a>
        </li>
    </c:forEach> 
    </ul>
</div>
</div>
</c:if>
<script type="text/javascript">
/* var list = []
$(document).ready(function(){
$.ajax({
	async: false,
	        url: "getCodes.action",
	        success: function (msg) {
	        console.log(msg)
			list = msg
	        },
	        error: function (msg) {
	        console.log(msg)
			list = msg
	        }
	})
	$.get(
		"getCodes.action",
		function(data) {
			console.log(data)
			list = data.productCodes
		}
		) 
		console.log(list)
})
function myTest(item){
	var codes = [<c:forEach items="${productCodes}" var="status"> "${status}",</c:forEach>]
	console.log(codes)
	var i = codes[item-1]
	var url = 'productDetail.action?productCode=' + i
	console.log(url)
	window.location.href= url
} */

function goSearch(){
	var productName = $("#productName").val();
	var index1 = document.getElementById("type").selectedIndex;
	var productType = document.getElementById("type").options[index1].value;
	$.ajax({
	async: false,
	        url: "search.action",
	        type: "post",
	        data:{"productName":JSON.stringify(productName),"productType":JSON.stringify(productType)},
	        success: function (msg) {
	        window.location.href="right.jsp";
	        },
	        error: function (msg) {
	        window.location.href="right.jsp";
	        }
	});
	}
	

</script>
</body>
</html>

