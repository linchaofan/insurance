package org.lcf.ins.entity;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer sellerId;

    private String typeCode;

    private String title;

    private String shortTitle;

    private String imgpath;

    private Integer maxInsurant;

    private Integer hesitateDay;

    private String introduce;

    private String notice;

    private String compensationNote;

    private String question;

    private Date createTime;

    private Date editeTime;

    private Integer sysFlag;

    private static final long serialVersionUID = 1L;

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
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle == null ? null : shortTitle.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getCompensationNote() {
        return compensationNote;
    }

    public void setCompensationNote(String compensationNote) {
        this.compensationNote = compensationNote == null ? null : compensationNote.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
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