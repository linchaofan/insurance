<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核保记录详情</title>
</head>
<body>
<table cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#F7F3F7">
          <tr height="26" style="font-size:30px">
              <td class="blackTitle" align="center">核保明细如下：<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">商品名称:${checkOrder.productName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保单号:${checkOrder.proposalNo}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保人姓名:${checkOrder.holderName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保人手机号:${checkOrder.holderPhone}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人姓名:${checkOrder.insuredName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人性别:${checkOrder.insuredSex=='1'?"男":"女"}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人身份证:${checkOrder.insuredNumberId}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人手机号:${checkOrder.insuredPhone}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人出生日期:${checkOrder.insuredBirth}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人邮箱:${checkOrder.insuredEmail}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人住址:${checkOrder.insuredAddress}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">当前核保状态:
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
          </tr>
          
</table>
</body>
</html>