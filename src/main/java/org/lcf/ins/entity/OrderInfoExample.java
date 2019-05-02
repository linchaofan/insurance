package org.lcf.ins.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andLinkNoIsNull() {
            addCriterion("link_no is null");
            return (Criteria) this;
        }

        public Criteria andLinkNoIsNotNull() {
            addCriterion("link_no is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNoEqualTo(String value) {
            addCriterion("link_no =", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoNotEqualTo(String value) {
            addCriterion("link_no <>", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoGreaterThan(String value) {
            addCriterion("link_no >", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoGreaterThanOrEqualTo(String value) {
            addCriterion("link_no >=", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoLessThan(String value) {
            addCriterion("link_no <", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoLessThanOrEqualTo(String value) {
            addCriterion("link_no <=", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoLike(String value) {
            addCriterion("link_no like", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoNotLike(String value) {
            addCriterion("link_no not like", value, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoIn(List<String> values) {
            addCriterion("link_no in", values, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoNotIn(List<String> values) {
            addCriterion("link_no not in", values, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoBetween(String value1, String value2) {
            addCriterion("link_no between", value1, value2, "linkNo");
            return (Criteria) this;
        }

        public Criteria andLinkNoNotBetween(String value1, String value2) {
            addCriterion("link_no not between", value1, value2, "linkNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoIsNull() {
            addCriterion("proposal_no is null");
            return (Criteria) this;
        }

        public Criteria andProposalNoIsNotNull() {
            addCriterion("proposal_no is not null");
            return (Criteria) this;
        }

        public Criteria andProposalNoEqualTo(String value) {
            addCriterion("proposal_no =", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotEqualTo(String value) {
            addCriterion("proposal_no <>", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoGreaterThan(String value) {
            addCriterion("proposal_no >", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoGreaterThanOrEqualTo(String value) {
            addCriterion("proposal_no >=", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLessThan(String value) {
            addCriterion("proposal_no <", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLessThanOrEqualTo(String value) {
            addCriterion("proposal_no <=", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLike(String value) {
            addCriterion("proposal_no like", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotLike(String value) {
            addCriterion("proposal_no not like", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoIn(List<String> values) {
            addCriterion("proposal_no in", values, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotIn(List<String> values) {
            addCriterion("proposal_no not in", values, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoBetween(String value1, String value2) {
            addCriterion("proposal_no between", value1, value2, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotBetween(String value1, String value2) {
            addCriterion("proposal_no not between", value1, value2, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIsNull() {
            addCriterion("policy_no is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIsNotNull() {
            addCriterion("policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoEqualTo(String value) {
            addCriterion("policy_no =", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotEqualTo(String value) {
            addCriterion("policy_no <>", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoGreaterThan(String value) {
            addCriterion("policy_no >", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("policy_no >=", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLessThan(String value) {
            addCriterion("policy_no <", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("policy_no <=", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLike(String value) {
            addCriterion("policy_no like", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotLike(String value) {
            addCriterion("policy_no not like", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIn(List<String> values) {
            addCriterion("policy_no in", values, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotIn(List<String> values) {
            addCriterion("policy_no not in", values, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoBetween(String value1, String value2) {
            addCriterion("policy_no between", value1, value2, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotBetween(String value1, String value2) {
            addCriterion("policy_no not between", value1, value2, "policyNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdIsNull() {
            addCriterion("holder_id is null");
            return (Criteria) this;
        }

        public Criteria andHolderIdIsNotNull() {
            addCriterion("holder_id is not null");
            return (Criteria) this;
        }

        public Criteria andHolderIdEqualTo(Integer value) {
            addCriterion("holder_id =", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotEqualTo(Integer value) {
            addCriterion("holder_id <>", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdGreaterThan(Integer value) {
            addCriterion("holder_id >", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("holder_id >=", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdLessThan(Integer value) {
            addCriterion("holder_id <", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdLessThanOrEqualTo(Integer value) {
            addCriterion("holder_id <=", value, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdIn(List<Integer> values) {
            addCriterion("holder_id in", values, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotIn(List<Integer> values) {
            addCriterion("holder_id not in", values, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdBetween(Integer value1, Integer value2) {
            addCriterion("holder_id between", value1, value2, "holderId");
            return (Criteria) this;
        }

        public Criteria andHolderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("holder_id not between", value1, value2, "holderId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Long value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Long value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Long value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Long value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Long> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Long> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Long value1, Long value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Long value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Long value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Long value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Long value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Long> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Long> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Long value1, Long value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPolicyNumIsNull() {
            addCriterion("policy_num is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNumIsNotNull() {
            addCriterion("policy_num is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNumEqualTo(Integer value) {
            addCriterion("policy_num =", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumNotEqualTo(Integer value) {
            addCriterion("policy_num <>", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumGreaterThan(Integer value) {
            addCriterion("policy_num >", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("policy_num >=", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumLessThan(Integer value) {
            addCriterion("policy_num <", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumLessThanOrEqualTo(Integer value) {
            addCriterion("policy_num <=", value, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumIn(List<Integer> values) {
            addCriterion("policy_num in", values, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumNotIn(List<Integer> values) {
            addCriterion("policy_num not in", values, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumBetween(Integer value1, Integer value2) {
            addCriterion("policy_num between", value1, value2, "policyNum");
            return (Criteria) this;
        }

        public Criteria andPolicyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("policy_num not between", value1, value2, "policyNum");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNull() {
            addCriterion("scheme_id is null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNotNull() {
            addCriterion("scheme_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdEqualTo(Integer value) {
            addCriterion("scheme_id =", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotEqualTo(Integer value) {
            addCriterion("scheme_id <>", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThan(Integer value) {
            addCriterion("scheme_id >", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scheme_id >=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThan(Integer value) {
            addCriterion("scheme_id <", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThanOrEqualTo(Integer value) {
            addCriterion("scheme_id <=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIn(List<Integer> values) {
            addCriterion("scheme_id in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotIn(List<Integer> values) {
            addCriterion("scheme_id not in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdBetween(Integer value1, Integer value2) {
            addCriterion("scheme_id between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scheme_id not between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlIsNull() {
            addCriterion("policy_url is null");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlIsNotNull() {
            addCriterion("policy_url is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlEqualTo(String value) {
            addCriterion("policy_url =", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlNotEqualTo(String value) {
            addCriterion("policy_url <>", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlGreaterThan(String value) {
            addCriterion("policy_url >", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("policy_url >=", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlLessThan(String value) {
            addCriterion("policy_url <", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlLessThanOrEqualTo(String value) {
            addCriterion("policy_url <=", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlLike(String value) {
            addCriterion("policy_url like", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlNotLike(String value) {
            addCriterion("policy_url not like", value, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlIn(List<String> values) {
            addCriterion("policy_url in", values, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlNotIn(List<String> values) {
            addCriterion("policy_url not in", values, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlBetween(String value1, String value2) {
            addCriterion("policy_url between", value1, value2, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyUrlNotBetween(String value1, String value2) {
            addCriterion("policy_url not between", value1, value2, "policyUrl");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNull() {
            addCriterion("sys_flag is null");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNotNull() {
            addCriterion("sys_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSysFlagEqualTo(Integer value) {
            addCriterion("sys_flag =", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotEqualTo(Integer value) {
            addCriterion("sys_flag <>", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThan(Integer value) {
            addCriterion("sys_flag >", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_flag >=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThan(Integer value) {
            addCriterion("sys_flag <", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThanOrEqualTo(Integer value) {
            addCriterion("sys_flag <=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagIn(List<Integer> values) {
            addCriterion("sys_flag in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotIn(List<Integer> values) {
            addCriterion("sys_flag not in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagBetween(Integer value1, Integer value2) {
            addCriterion("sys_flag between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_flag not between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andEditeTimeIsNull() {
            addCriterion("edite_time is null");
            return (Criteria) this;
        }

        public Criteria andEditeTimeIsNotNull() {
            addCriterion("edite_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditeTimeEqualTo(Date value) {
            addCriterion("edite_time =", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeNotEqualTo(Date value) {
            addCriterion("edite_time <>", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeGreaterThan(Date value) {
            addCriterion("edite_time >", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edite_time >=", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeLessThan(Date value) {
            addCriterion("edite_time <", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeLessThanOrEqualTo(Date value) {
            addCriterion("edite_time <=", value, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeIn(List<Date> values) {
            addCriterion("edite_time in", values, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeNotIn(List<Date> values) {
            addCriterion("edite_time not in", values, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeBetween(Date value1, Date value2) {
            addCriterion("edite_time between", value1, value2, "editeTime");
            return (Criteria) this;
        }

        public Criteria andEditeTimeNotBetween(Date value1, Date value2) {
            addCriterion("edite_time not between", value1, value2, "editeTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andIsCancelIsNull() {
            addCriterion("is_cancel is null");
            return (Criteria) this;
        }

        public Criteria andIsCancelIsNotNull() {
            addCriterion("is_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andIsCancelEqualTo(Integer value) {
            addCriterion("is_cancel =", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotEqualTo(Integer value) {
            addCriterion("is_cancel <>", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThan(Integer value) {
            addCriterion("is_cancel >", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cancel >=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThan(Integer value) {
            addCriterion("is_cancel <", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThanOrEqualTo(Integer value) {
            addCriterion("is_cancel <=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelIn(List<Integer> values) {
            addCriterion("is_cancel in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotIn(List<Integer> values) {
            addCriterion("is_cancel not in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelBetween(Integer value1, Integer value2) {
            addCriterion("is_cancel between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cancel not between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
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