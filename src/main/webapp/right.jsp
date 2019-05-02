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
<link rel="stylesheet" type="text/css" href="css/style1.css" />
</head>
<body>
<br>
<div align="center">
<p style="color:blue;font-size:20px">欢迎来到保险服务系统！</p><br>
<form action="search.action" method="post">
<p>商品名称:<input type="text" name="productName">&nbsp;&nbsp;---商品类型:<input type="text" name="productType">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="搜索" id="search">&nbsp;<input type="reset" value="重置">
</p>
</form>
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
            <a href="productDetail.action?productCode=${productCodes[status.count]}" class="goods-li-a" target="rightFrame">
                <img class="item-img" src="${product.imgpath}">
                <div class="item-text">
                    <strong>${product.name}</strong>
                    <p>${product.title}<br>${product.shortTitle}</p>
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
</body>
</html>

