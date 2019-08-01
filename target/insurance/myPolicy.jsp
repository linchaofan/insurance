<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单列表</title>
</head>
<body leftmargin="2" topmargin="2" background=/images/allbg.gif>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background=/images/tbg.gif>&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="10%">编号:</td>
					<td width="20%">保险方:</td>
					<td width="20%">保险商品:</td>
					<td width="20%">保障截止日期:</td>				
		        </tr>	
		        <c:forEach var="policy" items="${polices}" varStatus="status">
		        <tr>
		        <td bgcolor="#FFFFFF" align="center">${status.index+1}</td>
		        <td bgcolor="#FFFFFF" align="center">${policy.companyName}</td>
		        <td bgcolor="#FFFFFF" align="center">${policy.productName}</td>
		        <td bgcolor="#FFFFFF" align="center">${policy.endDate}</td>
		        <td bgcolor="#FFFFFF" align="center">
					    <a href="policyDetail.action?orderId=${policy.orderId}"  style="font-family: 微软雅黑;font-size: 15px;color:blue">保单明细</a>
					</td>
		        </tr>
		        </c:forEach>
		        
			</table>
			<c:if test="${errorMsg!=null }">
			<font color="blue">${errorMsg}</font>
		</c:if>
	</body>
</html>