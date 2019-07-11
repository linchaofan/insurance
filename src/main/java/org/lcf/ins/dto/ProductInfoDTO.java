package org.lcf.ins.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductInfoDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2758926832869104432L;

	private Integer id;

    private String code;

    private String name;

    private Integer sellerId;

    private String saleCode;

    private String typeCode;

    private String title;

    private String shortTitle;

    private String imgpath;

    private Integer maxInsurant;

    private Integer hesitateDay;

    private String payNum;

    private Date createTime;

    private Date editeTime;

    private Integer sysFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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

	public Integer getMaxInsurant() {
		return maxInsurant;
	}

	public void setMaxInsurant(Integer maxInsurant) {
		this.maxInsurant = maxInsurant;
	}

	public Integer getHesitateDay() {
		return hesitateDay;
	}

	public void setHesitateDay(Integer hesitateDay) {
		this.hesitateDay = hesitateDay;
	}

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditeTime() {
		return editeTime;
	}

	public void setEditeTime(Date editeTime) {
		this.editeTime = editeTime;
	}

	public Integer getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(Integer sysFlag) {
		this.sysFlag = sysFlag;
	}
}
