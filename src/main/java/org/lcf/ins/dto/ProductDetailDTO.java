package org.lcf.ins.dto;

import java.io.Serializable;
import java.util.List;

public class ProductDetailDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2147234520478918971L;

	private String name;
	private String title;
	private String shortTitle;
	private String imgpath;
	private String introduce;
	private String notice;
	private String compensationNote;
	private String question;
	private String ageRange;
	private List<String> coverageList;
	private String hasSocial;
	private List<String> deadLineList;
	private Long price;
	
	public List<String> getCoverageList() {
		return coverageList;
	}
	public void setCoverageList(List<String> coverageList) {
		this.coverageList = coverageList;
	}
	public List<String> getDeadLineList() {
		return deadLineList;
	}
	public void setDeadLineList(List<String> deadLineList) {
		this.deadLineList = deadLineList;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getHasSocial() {
		return hasSocial;
	}
	public void setHasSocial(String hasSocial) {
		this.hasSocial = hasSocial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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
	
}
