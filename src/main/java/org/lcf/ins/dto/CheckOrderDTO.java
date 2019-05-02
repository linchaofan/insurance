package org.lcf.ins.dto;

import java.io.Serializable;

public class CheckOrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5749445885840168464L;

	public Integer orderId;
	public String productName;
	public String proposalNo;
	public String holderName;
	public String holderPhone;
	public String insuredName;
	public String insuredSex;
	public String insuredNumberId;
	public String insuredPhone;
	public String insuredBirth;
	public String insuredEmail;
	public String insuredAddress;
	public Integer checkStatus;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getHolderPhone() {
		return holderPhone;
	}
	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredSex() {
		return insuredSex;
	}
	public void setInsuredSex(String insuredSex) {
		this.insuredSex = insuredSex;
	}
	public String getInsuredNumberId() {
		return insuredNumberId;
	}
	public void setInsuredNumberId(String insuredNumberId) {
		this.insuredNumberId = insuredNumberId;
	}
	public String getInsuredPhone() {
		return insuredPhone;
	}
	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}
	public String getInsuredBirth() {
		return insuredBirth;
	}
	public void setInsuredBirth(String insuredBirth) {
		this.insuredBirth = insuredBirth;
	}
	public String getInsuredEmail() {
		return insuredEmail;
	}
	public void setInsuredEmail(String insuredEmail) {
		this.insuredEmail = insuredEmail;
	}
	public String getInsuredAddress() {
		return insuredAddress;
	}
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}
	
	
}
