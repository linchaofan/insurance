package org.lcf.ins.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductSchemeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andAgeRangeIsNull() {
            addCriterion("age_range is null");
            return (Criteria) this;
        }

        public Criteria andAgeRangeIsNotNull() {
            addCriterion("age_range is not null");
            return (Criteria) this;
        }

        public Criteria andAgeRangeEqualTo(String value) {
            addCriterion("age_range =", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeNotEqualTo(String value) {
            addCriterion("age_range <>", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeGreaterThan(String value) {
            addCriterion("age_range >", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeGreaterThanOrEqualTo(String value) {
            addCriterion("age_range >=", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeLessThan(String value) {
            addCriterion("age_range <", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeLessThanOrEqualTo(String value) {
            addCriterion("age_range <=", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeLike(String value) {
            addCriterion("age_range like", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeNotLike(String value) {
            addCriterion("age_range not like", value, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeIn(List<String> values) {
            addCriterion("age_range in", values, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeNotIn(List<String> values) {
            addCriterion("age_range not in", values, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeBetween(String value1, String value2) {
            addCriterion("age_range between", value1, value2, "ageRange");
            return (Criteria) this;
        }

        public Criteria andAgeRangeNotBetween(String value1, String value2) {
            addCriterion("age_range not between", value1, value2, "ageRange");
            return (Criteria) this;
        }

        public Criteria andCoverageIsNull() {
            addCriterion("coverage is null");
            return (Criteria) this;
        }

        public Criteria andCoverageIsNotNull() {
            addCriterion("coverage is not null");
            return (Criteria) this;
        }

        public Criteria andCoverageEqualTo(String value) {
            addCriterion("coverage =", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageNotEqualTo(String value) {
            addCriterion("coverage <>", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageGreaterThan(String value) {
            addCriterion("coverage >", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageGreaterThanOrEqualTo(String value) {
            addCriterion("coverage >=", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageLessThan(String value) {
            addCriterion("coverage <", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageLessThanOrEqualTo(String value) {
            addCriterion("coverage <=", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageLike(String value) {
            addCriterion("coverage like", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageNotLike(String value) {
            addCriterion("coverage not like", value, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageIn(List<String> values) {
            addCriterion("coverage in", values, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageNotIn(List<String> values) {
            addCriterion("coverage not in", values, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageBetween(String value1, String value2) {
            addCriterion("coverage between", value1, value2, "coverage");
            return (Criteria) this;
        }

        public Criteria andCoverageNotBetween(String value1, String value2) {
            addCriterion("coverage not between", value1, value2, "coverage");
            return (Criteria) this;
        }

        public Criteria andHasSocialIsNull() {
            addCriterion("has_social is null");
            return (Criteria) this;
        }

        public Criteria andHasSocialIsNotNull() {
            addCriterion("has_social is not null");
            return (Criteria) this;
        }

        public Criteria andHasSocialEqualTo(String value) {
            addCriterion("has_social =", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialNotEqualTo(String value) {
            addCriterion("has_social <>", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialGreaterThan(String value) {
            addCriterion("has_social >", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialGreaterThanOrEqualTo(String value) {
            addCriterion("has_social >=", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialLessThan(String value) {
            addCriterion("has_social <", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialLessThanOrEqualTo(String value) {
            addCriterion("has_social <=", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialLike(String value) {
            addCriterion("has_social like", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialNotLike(String value) {
            addCriterion("has_social not like", value, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialIn(List<String> values) {
            addCriterion("has_social in", values, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialNotIn(List<String> values) {
            addCriterion("has_social not in", values, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialBetween(String value1, String value2) {
            addCriterion("has_social between", value1, value2, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andHasSocialNotBetween(String value1, String value2) {
            addCriterion("has_social not between", value1, value2, "hasSocial");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(String value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(String value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(String value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(String value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(String value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLike(String value) {
            addCriterion("deadline like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotLike(String value) {
            addCriterion("deadline not like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<String> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<String> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(String value1, String value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(String value1, String value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}