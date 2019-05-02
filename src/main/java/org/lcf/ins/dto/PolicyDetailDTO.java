package org.lcf.ins.dto;

import java.io.Serializable;

public class PolicyDetailDTO extends PolicyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7886810411075001796L;
	
	public String holderName;
	public String holderNumberId;
	public String insuredName;
	public String insuredNumberId;
	public Long totalPrice; //保费
	public Long totalAmount; //保险金额
	public String payTime; //支付日期
	public String beginDate;  //生效
	
	
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getHolderNumberId() {
		return holderNumberId;
	}
	public void setHolderNumberId(String holderNumberId) {
		this.holderNumberId = holderNumberId;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredNumberId() {
		return insuredNumberId;
	}
	public void setInsuredNumberId(String insuredNumberId) {
		this.insuredNumberId = insuredNumberId;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	
}
