<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sku_style.css" />
<title>添加商品</title>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/createSkuTable.js"></script>
<script type="text/javascript" src="js/customSku.js"></script>
<script type="text/javascript" src="plugins/layer/layer.js"></script>
<title>添加商品</title>
</head>
<body background="blue">
<div class="demo-title">添加产品的属性值</div>

<div></tr><td>产品标识码:<input id="code" name="code" type="text" /></td></div>
		<ul class="SKU_TYPE">
			<li is_required='1' propid='1' sku-type-name="ageRange"><em>*</em>年龄范围：</li>
		</ul>
		<ul>
			<li><label><input type="checkbox" class="sku_value" propvalid='11' value="1-10" />1-10岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='12' value="11-20" />11-20岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='13' value="21-30" />21-30岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='14' value="31-40" />31-40岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='15' value="41-50" />41-50岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='16' value="51-60" />51-60岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='17' value="61-70" />61-70岁</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='18' value="off" />无需</label></li>
		</ul>
		<div class="clear"></div>
		<ul class="SKU_TYPE">
			<li is_required='1' propid='2' sku-type-name="coverage"><em>*</em>保险金额：</li>
		</ul>
		<ul>
			<li><label><input type="checkbox" class="sku_value" propvalid='21' value="100000" />10万</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='22' value="500000" />50万</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='23' value="1000000" />100万</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='24' value="2000000" />200万</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='25' value="4000000" />400万</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='25' value="off" />无需</label></li>
		</ul>
		<div class="clear"></div>
					
		<ul class="SKU_TYPE">
			<li is_required='1' propid='3' sku-type-name="deadLine">保障期限：</li>
		</ul>
		<ul>
			<li><label><input type="checkbox" class="sku_value" propvalid='31' value="7天" />7天</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='32' value="15天" />15天</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='33' value="30天" />30天</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='34' value="6个月" />6个月</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='35' value="1年" />1年</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='36' value="2年" />2年</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='37' value="3年" />3年</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='38' value="off" />无需</label></li>
		</ul>
		<div class="clear"></div>
		<ul class="SKU_TYPE">
			<li is_required='1' propid='4' sku-type-name="hasSocial">有无社保：</li>
		</ul>
		<ul>
			<li><label><input type="checkbox" class="sku_value" propvalid='41' value="yes" />有</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='42' value="no" />无</label></li>
			<li><label><input type="checkbox" class="sku_value" propvalid='43' value="off" />无需</label></li>
		</ul>
		<div class="clear"></div>
		<input type="button" class="cloneSku" value="添加自定义sku属性">

		<!--sku模板,用于克隆,生成自定义sku-->
		<div id="skuCloneModel" style="display: none;">
			<div class="clear"></div>
			<ul class="SKU_TYPE">
				<li is_required='0' propid='' sku-type-name="">
					<a href="javascript:void(0);" class="delCusSkuType">移除</a>
					<input type="text" class="cusSkuTypeInput" />：
				</li>
			</ul>
			<ul>
				<li>
					<input type="checkbox" class="model_sku_val" propvalid='' value="" />
					<input type="text" class="cusSkuValInput" />
				</li>
				<input type="button" class="cloneSkuVal" value="添加自定义属性值">
			</ul>
			<div class="clear"></div>
		</div>
		<!--单个sku值克隆模板-->
		<li style="display: none;" id="onlySkuValCloneModel">
			<input type="checkbox" class="model_sku_val" propvalid='' value="" />
			<input type="text" class="cusSkuValInput" />
			<a href="javascript:void(0);" class="delCusSkuVal">删除</a>
		</li>
		<div class="clear"></div>
		<div id="skuTable"></div>
		<script type="text/javascript" src="js/getSetSkuVals.js"></script>
		<div align="center">
		<input type="button" value="提交" id="submit"></input>
		</div>

</body>
</html>
