<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核保记录</title>
</head>
<body>
<body leftmargin="2" topmargin="2" background=/images/allbg.gif>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background=/images/tbg.gif>&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="5%">编号:</td>
					<td width="18%">商品名称:</td>
					<td width="18%">投保单号:</td>
					<td width="10%">被保人:</td>				
					<td width="10%">核保状态:</td>
		        </tr>	
		        <c:forEach var="checkOrder" items="${checkOrders}" varStatus="status">
		        <tr>
		        <td bgcolor="#FFFFFF" align="center">${status.index+1}</td>
		        <td bgcolor="#FFFFFF" align="center">${checkOrder.productName}</td>
		        <td bgcolor="#FFFFFF" align="center">${checkOrder.proposalNo}</td>
		        <td bgcolor="#FFFFFF" align="center">${checkOrder.insuredName}</td>
		        <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                <c:when test="${checkOrder.checkStatus==1}">等待核保
                </c:when>
                <c:otherwise><c:if test="${checkOrder.checkStatus==2}">核保通过
                </c:if>
                <c:if test="${checkOrder.checkStatus==3}">核保失败
                </c:if>
                </c:otherwise>
                </c:choose>
                </td>
		        <td bgcolor="#FFFFFF" align="center">
					    <a href="myCheckDetail.action?orderId=${checkOrder.orderId}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">核保详情</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="deleteCheckOrder.action?orderId=${checkOrder.orderId}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">删除记录</a>
					</td>
		        </tr>
		        </c:forEach>
		        
			</table>
			<c:if test="${errorMsg!=null }">
			<font color="blue">${errorMsg}</font>
		</c:if>
	</body>
</body>
</html>