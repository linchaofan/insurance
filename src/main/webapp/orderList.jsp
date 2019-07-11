<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
</head>
<body leftmargin="2" topmargin="2" background=/images/allbg.gif>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background=/images/tbg.gif>&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">订单流水号:</td>
					<td width="10%">下单日期:</td>
					<td width="10%">商品名称:</td>				
					<td width="18%">订单金额:</td>
					<td width="18%">订单状态:</td>
		        </tr>	
		        <c:forEach var="order" items="${orders}" varStatus="status">
		        <tr>
		        <td bgcolor="#FFFFFF" align="center">${order.linkNo}</td>
		        <td bgcolor="#FFFFFF" align="center"><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		        <td bgcolor="#FFFFFF" align="center">${order.productName}</td>
		        <td bgcolor="#FFFFFF" align="center">${order.totalPrice}</td>
		        <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                <c:when test="${order.checkStatus==4}">等待支付
                <c:if test="${user!=null }">
                <a href="goPay.action?orderId=${order.id}">去支付</a></c:if>
                </c:when>
                <c:otherwise><c:if test="${order.checkStatus==5}">已支付
                </c:if>
                <c:if test="${order.checkStatus==6}">支付失败
                <c:if test="${user!=null }">
                <a href="goPay.action?orderId=${order.id}">重新支付</a></c:if>
                </c:if>
                </c:otherwise>
                </c:choose>
                </td>
		        <td bgcolor="#FFFFFF" align="center">
					    <a href="orderDetail.action?orderId=${order.id}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">订单详情</a>					
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<c:if test="${order.checkStatus==4}">
					    <a href="deleteOrder.action?orderId=${order.id}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">删除</a>
					</c:if>
					<c:if test="${order.checkStatus==6}">
					    <a href="deleteOrder.action?orderId=${order.id}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">删除</a>
					</c:if>
					</td>	
		        </tr>
		        </c:forEach>
		        
			</table>
			<c:if test="${errorMsg!=null }">
			<font color="blue">${errorMsg}</font>
		</c:if>
	</body>
</html>