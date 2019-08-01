<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
</head>
<body>
 <table cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#F7F3F7">
          <tr height="26" style="font-size:30px">
              <td class="blackTitle" align="center">订单详情如下：<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">商品名称:${order.productName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">流水号:${order.linkNo}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保单号:${order.proposalNo}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保单号:${order.policyNo}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保人:${order.holderName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人:${order.insuredName}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">创建时间:${order.orderDate}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保单份数:${order.policyNum}<br></td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">订单金额:${order.price}<br></td>
          </tr>
          
</table>
</body>
</html>