package org.lcf.ins.dto;

import java.io.Serializable;

public class PolicyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4687235847587166425L;
	
	public Integer orderId;
	public String productName;
	public String companyName;
	public String endDate;
	
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
