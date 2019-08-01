<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body leftmargin="2" topmargin="2" background=/images/allbg.gif>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background=/images/tbg.gif>&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="30%">产品名称:</td>
					<td width="30%">产品编码:</td>
					<td width="30%">产品类型:</td>				
		        </tr>	
		        <c:forEach var="product" items="${productList}" varStatus="status">
		        <tr>
		        <td bgcolor="#FFFFFF" align="center">${product.name}</td>
		        <td bgcolor="#FFFFFF" align="center">${product.code }</td>
		        <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                <c:when test="${product.typeCode=='yiliao'}">医疗保险
                </c:when>
                <c:otherwise><c:if test="${product.typeCode=='renshou'}">人寿保险
                </c:if>
                <c:if test="${product.typeCode=='yiwai'}">意外保险</c:if>
                <c:if test="${product.typeCode=='lvyou'}">旅游保险</c:if>
                </c:otherwise>
                </c:choose>
                </td>
		        <td bgcolor="#FFFFFF" align="center">
					    <a href="delete.action?productCode=${product.code}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">删除</a>					
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