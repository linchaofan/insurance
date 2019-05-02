package org.lcf.ins.dto;

import java.io.Serializable;

public class InsureOrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2845563462469159799L;
	
    private String holderName;
    private String holderPhone;
    private String holderNumberId;
    private String insuredName;
    private String insuredPhone;
    private String insuredSex;
    private String insuredBirth;
    private String insuredNumberId;
    private String insuredEmail;
    private String insuredAddress;
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
	public String getInsuredPhone() {
		return insuredPhone;
	}
	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}
	public String getInsuredSex() {
		return insuredSex;
	}
	public void setInsuredSex(String insuredSex) {
		this.insuredSex = insuredSex;
	}
	public String getInsuredBirth() {
		return insuredBirth;
	}
	public void setInsuredBirth(String insuredBirth) {
		this.insuredBirth = insuredBirth;
	}
	public String getInsuredNumberId() {
		return insuredNumberId;
	}
	public void setInsuredNumberId(String insuredNumberId) {
		this.insuredNumberId = insuredNumberId;
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
