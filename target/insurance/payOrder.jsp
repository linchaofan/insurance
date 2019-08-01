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
<div class="container">
    <div class="checkout-box">
        <form  id="checkoutForm" action="pay.action" method="post">
            <div class="checkout-box-bd">
                    <!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
                <input type="hidden" name="Checkout[addressState]" id="addrState"   value="0">
                <!-- 收货地址 -->
                <div class="xm-box">
                    <div class="box-hd ">
    <h2 class="title">收货地址</h2>
    <!---->
</div>
<div class="box-bd">
    <div class="clearfix xm-address-list" id="checkoutAddrList">
          <dl class="item" >
            <dt>
                <strong class="itemConsignee">${insOrder.insuredName }</strong>
                                <span class="itemTag tag">家</span>
                            </dt>
            <dd>
                <p class="tel itemTel">${insOrder.insuredPhone }</p>
                <p class="itemRegion">${insOrder.insuredNumberId }</p>
                <p class="itemStreet">${insOrder.insuredAddress }</p>
                                                        <span class="edit-btn J_editAddr">编辑</span>
                                                                </dd>
            <dd style="display:none">
                <input type="radio" name="Checkout[address]" class="addressId"  value="10140916720030323">
            </dd>
        </dl>
                        <div class="item use-new-addr"  id="J_useNewAddr" data-state="off">
             <span class="iconfont icon-add"><img src="images/add_cart.png" /></span> 
            使用新地址
        </div>
            </div>
        <input type="hidden" name="newAddress[type]" id="newType" value="common">
    <input type="hidden" name="newAddress[consignee]" id="newConsignee">
    <input type="hidden" name="newAddress[province]" id="newProvince">
    <input type="hidden" name="newAddress[city]" id="newCity">
    <input type="hidden" name="newAddress[district]" id="newCounty">
    <input type="hidden" name="newAddress[address]" id="newStreet">
    <input type="hidden" name="newAddress[zipcode]" id="newZipcode">
    <input type="hidden" name="newAddress[tel]" id="newTel">
    <input type="hidden" name="newAddress[tag_name]" id="newTag">
    <!--点击弹出新增/收货地址界面start-->
    <div class="xm-edit-addr-box" id="J_editAddrBox">
        <div class="bd">
            <div class="item">
                <label>收货人姓名<span>*</span></label> 
                <input type="text" name="userAddress[consignee]" id="Consignee" class="input" placeholder="收货人姓名" maxlength="15" autocomplete='off'>
                <p class="tip-msg tipMsg"></p>
            </div>
            <div class="item">
                <label>联系电话<span>*</span></label> 
                <input type="text" name="userAddress[tel]" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
                <p class="tel-modify-tip" id="telModifyTip"></p>
                <p class="tip-msg tipMsg"></p>
            </div>
            <div class="item">
                <label>地址<span>*</span></label>
                <select name="userAddress[province]" id="Provinces" class="select-1">
                    <option>省份/自治区</option>
                </select>
                <select name="userAddress[city]"  id="Citys" class="select-2" disabled>
                    <option>城市/地区/自治州</option>
                </select>
                <select name="userAddress[county]"  id="Countys" class="select-3" disabled>
                    <option>区/县</option>
                </select>
                <textarea   name="userAddress[street]" class="input-area" id="Street" placeholder="路名或街道地址，门牌号"></textarea>
                <p class="tip-msg tipMsg"></p>
            </div>
            <div class="item">
                <label>邮政编码<span>*</span></label> 
                <input type="text" name="userAddress[zipcode]" id="Zipcode" class="input" placeholder="邮政编码"  autocomplete='off'>
                <p class="zipcode-tip" id="zipcodeTip"></p>
                <p class="tip-msg tipMsg"></p>
            </div>
            <div class="item">
                <label>地址标签<span>*</span></label> 
                <input type="text" name="userAddress[tag]" id="Tag" class="input" placeholder='地址标签：如"家"、"公司"。限5个字内'  >
                <p class="tip-msg tipMsg"></p>
            </div>
        </div>
        <div class="ft clearfix">
            <button  type="button"  class="btn btn-lineDake btn-small " id="J_editAddrCancel">取消</button>
             <button type="button" class="btn btn-primary  btn-small " id="J_editAddrOk">保存</button>
        </div>
    </div>
    <!--点击弹出新增/收货地址界面end-->
    <div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
</div>                </div>
                <!-- 收货地址 END-->
                <div id="checkoutPayment">
                    <!-- 支付方式 -->
                                <div class="xm-box">
                <div class="box-hd ">
                    <h2 class="title">支付方式</h2>
                </div>
                <div class="box-bd">
                    <ul id="checkoutPaymentList" class="checkout-option-list clearfix J_optionList">
                                                <li class="item selected">
                            <input type="radio" name="Checkout[pay_id]" checked="checked" value="1">
                            <p>
                                在线支付                                <span></span>
                            </p>
                        </li>
                                            </ul>
                </div>
            </div>
            <!-- 支付方式 END-->
            <div class="xm-box">
                <div class="box-hd ">
                    <h2 class="title">配送方式</h2>
                </div>
                <div class="box-bd">
                    <ul id="checkoutShipmentList" class="checkout-option-list clearfix J_optionList">
                                                <li class="item selected">
                            <input type="radio" data-price="0" name="Checkout[shipment_id]" checked="checked" value="1">
                            <p>
                                快递配送（免运费）                                <span></span>
                            </p>
                        </li>
                                            </ul>
                </div>
            </div>
            <!-- 配送方式 END-->                    <!-- 配送方式 END-->
                </div>
                <!-- 送货时间 -->
                <div class="xm-box">
                    <div class="box-hd">
                        <h2 class="title">送货时间</h2>
                    </div>
                    <div class="box-bd">
                        <ul class="checkout-option-list clearfix J_optionList">
                                                        <li class="item selected"><input type="radio" checked="checked" name="Checkout[best_time]" value="1"><p>不限送货时间<span>周一至周日</span></p></li><li class="item "><input type="radio"  name="Checkout[best_time]" value="2"><p>工作日送货<span>周一至周五</span></p></li><li class="item "><input type="radio"  name="Checkout[best_time]" value="3"><p>双休日、假日送货<span>周六至周日</span></p></li>                        </ul>
                    </div>
                </div>
                <!-- 送货时间 END-->
                <!-- 发票信息 -->
                <div id="checkoutInvoice">
                    <div class="xm-box">
    <div class="box-hd">
        <h2 class="title">保单信息</h2>
    </div>
    <div class="box-bd">
        <ul class="checkout-option-list checkout-option-invoice clearfix J_optionList J_optionInvoice">
             <li class="hide">
                                 电子个人发票4  
             </li>
                        <li class="item selected">
                <!--<label><input type="radio"  class="needInvoice" value="0" name="Checkout[invoice]">不开发票</label>-->
                <input type="radio"    checked="checked"  value="4" name="Checkout[invoice]">
                <p>电子保单（非纸质）</p>
            </li>
                        <li class="item ">
                <input type="radio"   value="1" name="Checkout[invoice]">
                <p>普通保单（纸质）</p>
            </li>
        </ul>
                <p id="eInvoiceTip" class="e-invoice-tip ">
            电子保单是权威认可的有效凭证，可作为售后维权凭据，不会进行寄送。开单后不可更换纸质保单，如需纸质请选择普通保单。
        </p>
        <div class="invoice-info nvoice-info-1" id="checkoutInvoiceElectronic" style="display:none;">

            <p class="tip">电子保单目前仅对个人用户有效，通过邮箱发送，不用于寄送</p>
            <p>保单内容：商品明细、个人信息以及保障内容</p>
            <p>保单属性：个人</p>
        </div>
                <div class="invoice-info invoice-info-2" id="checkoutInvoiceDetail"  style="display:none;" >
            <p>保单内容：商品明细、个人信息以及保障内容</p>

        </div>

    </div>
</div>                </div>
                <!-- 发票信息 END-->
            </div>
            <div class="checkout-box-ft">
                 <!-- 商品清单 -->
                <div id="checkoutGoodsList" class="checkout-goods-box">
                                    <div class="xm-box">
                    <div class="box-hd">
                        <h2 class="title">确认订单信息</h2>
                    </div>
                    <div class="box-bd">
                        <dl class="checkout-goods-list">
                            <dt class="clearfix">
                                <span class="col col-1">商品名称</span>
                                <span class="col col-2">被保人</span>
                                <span class="col col-3">投保数量</span>
                                <span class="col col-4">保费总额</span>
                            </dt>
                                                        <dd class="item clearfix">
                                <div class="item-row">
                                    <div class="col col-1">
                                        <div class="g-pic">
                                            <img src="${productDetail.imgpath}" width="40" height="40" />
                                        </div>
                                        <div class="g-info">
                                        <a href="productDetail.action?productCode=${productCode}">
                                                ${productDetail.name }</a>
                                                                                                                                </div>
                                    </div>
                
                                    <div class="col col-2">${insOrder.insuredName }</div>
                                    <div class="col col-3">1</div>
                                    <div class="col col-4">${schemePrice }元</div>
                                </div>
                            </dd>
                           </dl>
                        <div class="checkout-count clearfix">
            
                            <!-- checkout-count-extend -->
                            <div class="checkout-price">
                                <ul>

                                    <li>
                                       订单总额：<span>${schemePrice }元</span>
                                    </li>
                                    <li>
                                        活动优惠：<span>-0元</span>
                                        <script type="text/javascript">
                                            checkoutConfig.activityDiscountMoney=0;
                                            checkoutConfig.totalPrice=244.00;
                                        </script>
                                    </li>
                                    <li>
                                        优惠券抵扣：<span id="couponDesc">-0元</span>
                                    </li>
                                    <li>
                                        运费：<span id="postageDesc">0元</span>
                                    </li>
                                </ul>
                                <p class="checkout-total">应付总额：<span><strong id="totalPrice">${schemePrice }</strong>元</span></p>
                            </div>
                            <!--  -->
                        </div>
                    </div>
                </div>
                </div>
 <!-- 商品清单 END -->
                <input type="hidden"  id="couponType" name="Checkout[couponsType]">
                <input type="hidden" id="couponValue" name="Checkout[couponsValue]">
                <div class="checkout-confirm">
                    
                     <a href="orderList.action?holderId=${user.id}" class="btn btn-lineDakeLight btn-back-cart">返回我的订单</a>
                     <a href="readyPay.action?holderPhone=${user.phone}" class="btn btn-primary" id="checkoutToPay" >立即支付</a></div>
                                     </div>
                                     </form>
                                     </div>
                                   
</div>
</body>
</html>