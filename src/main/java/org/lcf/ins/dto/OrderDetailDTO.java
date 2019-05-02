package org.lcf.ins.dto;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4342803922355438840L;
	
	public String productName;
	public String linkNo;
	public String proposalNo;
	public String policyNo;
	public String holderName;
	public String insuredName;
	public String orderDate;
	public Integer policyNum;
	public Long price;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLinkNo() {
		return linkNo;
	}
	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getPolicyNum() {
		return policyNum;
	}
	public void setPolicyNum(Integer policyNum) {
		this.policyNum = policyNum;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	

}
