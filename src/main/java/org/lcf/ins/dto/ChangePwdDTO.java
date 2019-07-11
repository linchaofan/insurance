package org.lcf.ins.dto;

import java.io.Serializable;

public class ChangePwdDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1824696055367287376L;

	public String phone;
	public String numberId;
	public String oldPwd;
	public String password;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
