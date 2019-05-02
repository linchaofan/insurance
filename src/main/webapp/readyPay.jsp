<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/public.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
        <script type="text/javascript" src="js/jquery_cart.js"></script>  
        <link rel="stylesheet" type="text/css" href="css/checkOut.css" />
</head>
<body>
<div align="center">
<p>订单金额:<a style="color:red;font-size:20px">${schemePrice }元</a></p>
<p>账户余额:${account}元&nbsp;&nbsp;<a href="myWallet.action?holderPhone=${user.phone}" style="color:blue">去充值？</a></p>
</div>
<div align="center">
<a href="pay.action?holderPhone=${user.phone}&price=${schemePrice}&proposalNo=${proposalNo}" class="btn btn-primary">确认付款</a>&nbsp;&nbsp;
</div>
</body>
</html>