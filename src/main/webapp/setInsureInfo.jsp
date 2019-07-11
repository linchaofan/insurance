<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/gloab.css" rel="stylesheet">
<link href="css/index1.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
</head>
<body class="bgf4">
<div class="login-box f-mt10 f-pb50">
	<div class="main bgf">    
    	<div class="reg-box-pan display-inline">  
        	<div class="step">        	
                <ul>
                    <li class="col-xs-4 on">
                        <span class="num"><em class="f-r5"></em><i>1</i></span>                	
                        <span class="line_bg lbg-r"></span>
                        <p class="lbg-txt">核对投保人信息</p>
                    </li>
                    <li class="col-xs-4">
                        <span class="num"><em class="f-r5"></em><i>2</i></span>
                        <span class="line_bg lbg-l"></span>
                        <span class="line_bg lbg-r"></span>
                        <p class="lbg-txt">填写被保人信息</p>
                    </li>
                    <li class="col-xs-4">
                        <span class="num"><em class="f-r5"></em><i>3</i></span>
                        <span class="line_bg lbg-l"></span>
                        <p class="lbg-txt">核实投保</p>
                    </li>
                </ul>
            </div>
        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
            	<div class="part1">                	
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>姓名：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1"  id="holderName" name="holderName" /> <span class="ie8 icon-close close hide"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>投保人真实姓名</span></label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="2" maxlength="11" id="holderPhone" name="holderPhone"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请填写11位有效的手机号码</label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>身份证号：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" id="holderNumberId" name="holderNumberId" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" > 
                            <label class="focus">投保人真实身份证号码</label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" maxlength="6" id="verifyNo" class="txt03 f-r3 f-fl required" tabindex="4" style="width:167px" data-valid="isNonEmpty||isInt" data-error="验证码不能为空||请输入6位数字验证码" /> 
                           	<span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;">发送验证码</span>
                            <span class="ie8 icon-close close hide" style="right:130px"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）</span></label>   
                            <label class="focus valid"></label>                        
                        </div>
                    </div>
                    <div class="item col-xs-12" style="height:auto">
                        <span class="intelligent-label f-fl">&nbsp;</span>  
                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款"> 
                        	<input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
                        </p>                       
                        <label class="focus valid"></label> 
                    </div> 
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>    
                        <div class="f-fl item-ifo">
                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>                         
                        </div>
                    </div> 
                </div>
                <div class="part2" style="display:none">
                	<div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>姓名：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" id="insuredName" name="insuredName"/><span class="ie8 icon-close close hide"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>被保人真实姓名</span></label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                     <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="2" maxlength="11" id="insuredPhone" name="insuredPhone"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请填写被保人的手机号码</label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                    <span class="intelligent-label f-fl"><b class="ftx04">*</b>性别：</span>
                    <div class="f-fl item-ifo">
                            <input type="radio" name="insuredSex" value="1"/>男
                            <input type="radio" name="insuredSex" value="2"/>女
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus valid"></label>
                        </div>  
                    </div>
                    <div class="item col-xs-12">
                    <span class="intelligent-label f-fl"><b class="ftx04">*</b>出生日期：</span>
                    <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" id="insuredBirth" name="insuredBirth"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请按照‘yyyy-mm-dd’格式填写</label>
                            <label class="focus valid"></label>
                        </div>  
                    </div>
                    <div class="item col-xs-12">
                     <span class="intelligent-label f-fl"><b class="ftx04">*</b>身份证号：</span>
                     <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" id="insuredNumberId" name="insuredNumberId"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请填写被保人的身份证号码</label>
                            <label class="focus valid"></label>
                        </div>  
                    </div>
                    <div class="item col-xs-12">
                    <span class="intelligent-label f-fl"><b class="ftx04">*</b>电子邮箱：</span>
                    <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" id="email" name="email"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请正确填写邮箱格式</label>
                            <label class="focus valid"></label>
                        </div>  
                    </div>
                    <div class="item col-xs-12">
                     <span class="intelligent-label f-fl"><b class="ftx04">*</b>住址：</span>
                     <div class="f-fl item-ifo">
                            <input type="text" class="txt03 f-r3 required" id="address" name="address"/> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请详细填写被保人住址</label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>    
                        <div class="f-fl item-ifo">
                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">确认投保</a>                         
                        </div>
                    </div> 
                </div>
                <div class="part4 text-center" style="display:none">
                	<h3>恭喜你投保完成.......</h3>
                    <p class="c-666 f-mt30 f-mb50">查询结果请前往 <a href="checkOrderResult.action" class="c-blue" Style="font-size:18px">核保结果页面</a></p>
                </div>          
            </div>
        </div>
    </div>
</div>
<div class="m-sPopBg" style="z-index:998;"></div>
<div class="m-sPopCon regcon">
	<div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
    <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
    </div>
    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
</div>
<script>
$(function(){	
	//第一页的确定按钮
	$("#btn_part1").click(function(){						
		$(".part1").hide();
		$(".part2").show();
		$(".step li").eq(1).addClass("on");
	});
	//第二页的确定按钮
	$("#btn_part2").click(function(){	
	    $(".part2").hide();	
<<<<<<< HEAD
		var data = {} ;
		data.holderName = $("#holderName").val();
		data.holderPhone = $("#holderPhone").val();
		data.holderNumberId = $("#holderNumberId").val();
		data.insuredName = $("#insuredName").val();
		data.insuredPhone = $("#insuredPhone").val();
		data.insuredSex = $('input:radio[name="insuredSex"]:checked').val();
		data.insuredBirth = $("#insuredBirth").val();
		data.insuredNumberId = $("#insuredNumberId").val();
		data.insuredEmail = $("#email").val();
		data.insuredAddress = $("#address").val();
		if(!data.holderName){
		
			alert('投保人姓名不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		
		if(!data.holderPhone){
			alert('投保人手机号码不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		} else if(data.holderPhone.length < 11){
			alert('投保人手机号码格式错误！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		
		if(!data.holderNumberId){
			alert('投保人身份证号码不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		if(!data.insuredName){
			alert('被保人姓名不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		if(!data.insuredPhone){
			alert('被保人手机号码不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		} else if(data.insuredPhone.length < 11){
			alert('被保人手机号码格式错误！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		if(!data.insuredSex){
			alert('被保人性别不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		if(!data.insuredBirth){
			alert('被保人出生日期不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		} else {
			var birth = data.insuredBirth.match(/^(\d{4})(-)(\d{2})(-)(\d{2})$/);
			if(birth==null){
				alert('被保人出生日期格式错误！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
			}
		}
		if(!data.insuredNumberId){
			alert('被保人身份证号码不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		if(!data.insuredEmail){
			alert('被保人电子邮箱不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		} else {
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!myreg.test(data.insuredEmail)){
				alert('被保人电子邮箱格式错误！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
			}
		}
		if(!data.insuredAddress){
			alert('被保人住址信息不能为空！请重新填写');
			$(".part1").show(); 
			$(".part2").hide();
			$(".step li").eq(1).removeClass("on"); // 2 变暗
			return
		}
		
		$.ajax({
		                async: false,
				        url: "checkOrder.action",
				        type: "post",
				        contentType : "application/json;charsetset=UTF-8",
				        dataType:'json',
				        data: JSON.stringify(data),
				        success: function (msg) {
				        	$(".part4").show();
				        },
				        error: function (msg) {
				        	$(".part4").show();
				        }
		});		
		return
=======
	var data = {} ;
	data.holderName = $("#holderName").val();
	data.holderPhone = $("#holderPhone").val();
	data.holderNumberId = $("#holderNumberId").val();
	data.insuredName = $("#insuredName").val();
	data.insuredPhone = $("#insuredPhone").val();
	data.insuredSex = $('input:radio[name="insuredSex"]:checked').val();
	data.insuredBirth = $("#insuredBirth").val();
	data.insuredNumberId = $("#insuredNumberId").val();
	data.insuredEmail = $("#email").val();
	data.insuredAddress = $("#address").val();
	$.ajax({
	                async: false,
			        url: "checkOrder.action",
			        type: "post",
			        contentType : "application/json;charsetset=UTF-8",
			        dataType:'json',
			        data: JSON.stringify(data),
			        success: function (msg) {
			        	$(".part4").show();
			        },
			        error: function (msg) {
			        	$(".part4").show();
			        }
	});		
>>>>>>> b16026bdc3aa043d6527e5195e2b0b0220640a87
	});		
});
function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
	$(".m-sPopBg,.m-sPopCon").hide();		
}
</script>
</body>
</html>