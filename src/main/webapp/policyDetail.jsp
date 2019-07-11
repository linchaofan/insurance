<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单明细</title>
</head>
<body>
<table cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#F7F3F7">
          <tr height="26" style="font-size:30px">
              <td class="blackTitle" align="center">保单明细如下：</td>
          </tr><tr></tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保险名称:${policyDetail.productName}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保险公司:${policyDetail.companyName}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保人姓名:${policyDetail.holderName}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">投保人身份证:${policyDetail.holderNumberId}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人姓名:${policyDetail.insuredName}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">被保人身份证:${policyDetail.insuredNumberId}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保险费用:${policyDetail.totalPrice}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保险金额:${policyDetail.totalAmount}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保障开始日期:${policyDetail.beginDate}</td>
          </tr>
          <tr height="26" style="font-size:15px">
          <td class="blackTitle" align="center">保障截止日期:${policyDetail.endDate}</td>
          </tr>

</table>
</body>
</html>