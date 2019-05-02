package org.lcf.ins.entity;

import java.io.Serializable;

public class ProductScheme implements Serializable {
    private Integer id;

    private String productCode;

    private String ageRange;

    private String coverage;

    private String hasSocial;

    private String deadline;

    private Long price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange == null ? null : ageRange.trim();
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage == null ? null : coverage.trim();
    }

    public String getHasSocial() {
        return hasSocial;
    }

    public void setHasSocial(String hasSocial) {
        this.hasSocial = hasSocial == null ? null : hasSocial.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}