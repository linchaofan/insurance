package org.lcf.ins.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5611481432641206195L;

	public String code;
	public String productName;
	public Integer sellerId; 
	public String type;
	public String title;
	public String shortTitle;
	public String introduce;
	public String notice;
	public String compensationNote;
	public String question;
	public MultipartFile image;
	
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getCompensationNote() {
		return compensationNote;
	}
	public void setCompensationNote(String compensationNote) {
		this.compensationNote = compensationNote;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
