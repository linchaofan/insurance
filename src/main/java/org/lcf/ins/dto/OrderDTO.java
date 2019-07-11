package org.lcf.ins.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5104574314401579798L;
	
	public Integer id;
	public String linkNo;
	public String proposalNo;
	public String policyNo;
	public Integer holderId;
	public Integer insuredId;
	public Integer sellerId;
	public Integer productId;
	public String productName;
	public String productCode;
	public Long totalAmount;
	public Long totalPrice;
	public Integer policyNum;
	public Date beginDate;
	public Date endDate;
	public Integer beginHour;
	public Integer endHour;
	public Integer checkStatus;
	public Date hesitateEndTime;
	public Integer schemeId;
	public String schemeCode;
	public String schemeName;
	public String policyUrl;
	public Integer sysFlag;
	public Date editeTime;
	public Date createTime;
	public Integer orderType;
	public String note;
	public Integer isCancel;
	public Date cancelTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getHolderId() {
		return holderId;
	}
	public void setHolderId(Integer holderId) {
		this.holderId = holderId;
	}
	public Integer getInsuredId() {
		return insuredId;
	}
	public void setInsuredId(Integer insuredId) {
		this.insuredId = insuredId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getPolicyNum() {
		return policyNum;
	}
	public void setPolicyNum(Integer policyNum) {
		this.policyNum = policyNum;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getBeginHour() {
		return beginHour;
	}
	public void setBeginHour(Integer beginHour) {
		this.beginHour = beginHour;
	}
	public Integer getEndHour() {
		return endHour;
	}
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	public Date getHesitateEndTime() {
		return hesitateEndTime;
	}
	public void setHesitateEndTime(Date hesitateEndTime) {
		this.hesitateEndTime = hesitateEndTime;
	}
	public Integer getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}
	public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getPolicyUrl() {
		return policyUrl;
	}
	public void setPolicyUrl(String policyUrl) {
		this.policyUrl = policyUrl;
	}
	public Integer getSysFlag() {
		return sysFlag;
	}
	public void setSysFlag(Integer sysFlag) {
		this.sysFlag = sysFlag;
	}
	public Date getEditeTime() {
		return editeTime;
	}
	public void setEditeTime(Date editeTime) {
		this.editeTime = editeTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

}
