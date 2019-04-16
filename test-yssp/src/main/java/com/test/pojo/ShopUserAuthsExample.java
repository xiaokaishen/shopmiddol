package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopUserAuthsExample {
    /**
     * shop_user_auths
     */
    protected String orderByClause;

    /**
     * shop_user_auths
     */
    protected boolean distinct;

    /**
     * shop_user_auths
     */
    protected List<Criteria> oredCriteria;

    public ShopUserAuthsExample() {
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

    /**
     * shop_user_auths 2019-04-15
     */
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

        public Criteria andUserAuthsIdIsNull() {
            addCriterion("user_auths_id is null");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdIsNotNull() {
            addCriterion("user_auths_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdEqualTo(Integer value) {
            addCriterion("user_auths_id =", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdNotEqualTo(Integer value) {
            addCriterion("user_auths_id <>", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdGreaterThan(Integer value) {
            addCriterion("user_auths_id >", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_auths_id >=", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdLessThan(Integer value) {
            addCriterion("user_auths_id <", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_auths_id <=", value, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdIn(List<Integer> values) {
            addCriterion("user_auths_id in", values, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdNotIn(List<Integer> values) {
            addCriterion("user_auths_id not in", values, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdBetween(Integer value1, Integer value2) {
            addCriterion("user_auths_id between", value1, value2, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andUserAuthsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_auths_id not between", value1, value2, "userAuthsId");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidIsNull() {
            addCriterion("primaryKeyId is null");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidIsNotNull() {
            addCriterion("primaryKeyId is not null");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidEqualTo(Long value) {
            addCriterion("primaryKeyId =", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidNotEqualTo(Long value) {
            addCriterion("primaryKeyId <>", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidGreaterThan(Long value) {
            addCriterion("primaryKeyId >", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidGreaterThanOrEqualTo(Long value) {
            addCriterion("primaryKeyId >=", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidLessThan(Long value) {
            addCriterion("primaryKeyId <", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidLessThanOrEqualTo(Long value) {
            addCriterion("primaryKeyId <=", value, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidIn(List<Long> values) {
            addCriterion("primaryKeyId in", values, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidNotIn(List<Long> values) {
            addCriterion("primaryKeyId not in", values, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidBetween(Long value1, Long value2) {
            addCriterion("primaryKeyId between", value1, value2, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andPrimarykeyidNotBetween(Long value1, Long value2) {
            addCriterion("primaryKeyId not between", value1, value2, "primarykeyid");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIsNull() {
            addCriterion("identity_type is null");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIsNotNull() {
            addCriterion("identity_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeEqualTo(String value) {
            addCriterion("identity_type =", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotEqualTo(String value) {
            addCriterion("identity_type <>", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeGreaterThan(String value) {
            addCriterion("identity_type >", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("identity_type >=", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeLessThan(String value) {
            addCriterion("identity_type <", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeLessThanOrEqualTo(String value) {
            addCriterion("identity_type <=", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeLike(String value) {
            addCriterion("identity_type like", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotLike(String value) {
            addCriterion("identity_type not like", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIn(List<String> values) {
            addCriterion("identity_type in", values, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotIn(List<String> values) {
            addCriterion("identity_type not in", values, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeBetween(String value1, String value2) {
            addCriterion("identity_type between", value1, value2, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotBetween(String value1, String value2) {
            addCriterion("identity_type not between", value1, value2, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNull() {
            addCriterion("identifier is null");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNotNull() {
            addCriterion("identifier is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifierEqualTo(String value) {
            addCriterion("identifier =", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotEqualTo(String value) {
            addCriterion("identifier <>", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThan(String value) {
            addCriterion("identifier >", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("identifier >=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThan(String value) {
            addCriterion("identifier <", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThanOrEqualTo(String value) {
            addCriterion("identifier <=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLike(String value) {
            addCriterion("identifier like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotLike(String value) {
            addCriterion("identifier not like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierIn(List<String> values) {
            addCriterion("identifier in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotIn(List<String> values) {
            addCriterion("identifier not in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierBetween(String value1, String value2) {
            addCriterion("identifier between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotBetween(String value1, String value2) {
            addCriterion("identifier not between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andCredentialIsNull() {
            addCriterion("credential is null");
            return (Criteria) this;
        }

        public Criteria andCredentialIsNotNull() {
            addCriterion("credential is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialEqualTo(String value) {
            addCriterion("credential =", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotEqualTo(String value) {
            addCriterion("credential <>", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialGreaterThan(String value) {
            addCriterion("credential >", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialGreaterThanOrEqualTo(String value) {
            addCriterion("credential >=", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialLessThan(String value) {
            addCriterion("credential <", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialLessThanOrEqualTo(String value) {
            addCriterion("credential <=", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialLike(String value) {
            addCriterion("credential like", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotLike(String value) {
            addCriterion("credential not like", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialIn(List<String> values) {
            addCriterion("credential in", values, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotIn(List<String> values) {
            addCriterion("credential not in", values, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialBetween(String value1, String value2) {
            addCriterion("credential between", value1, value2, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotBetween(String value1, String value2) {
            addCriterion("credential not between", value1, value2, "credential");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNull() {
            addCriterion("verified is null");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNotNull() {
            addCriterion("verified is not null");
            return (Criteria) this;
        }

        public Criteria andVerifiedEqualTo(Byte value) {
            addCriterion("verified =", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotEqualTo(Byte value) {
            addCriterion("verified <>", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThan(Byte value) {
            addCriterion("verified >", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThanOrEqualTo(Byte value) {
            addCriterion("verified >=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThan(Byte value) {
            addCriterion("verified <", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThanOrEqualTo(Byte value) {
            addCriterion("verified <=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedIn(List<Byte> values) {
            addCriterion("verified in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotIn(List<Byte> values) {
            addCriterion("verified not in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedBetween(Byte value1, Byte value2) {
            addCriterion("verified between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotBetween(Byte value1, Byte value2) {
            addCriterion("verified not between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkIsNull() {
            addCriterion("auths_remark is null");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkIsNotNull() {
            addCriterion("auths_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkEqualTo(String value) {
            addCriterion("auths_remark =", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkNotEqualTo(String value) {
            addCriterion("auths_remark <>", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkGreaterThan(String value) {
            addCriterion("auths_remark >", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("auths_remark >=", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkLessThan(String value) {
            addCriterion("auths_remark <", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkLessThanOrEqualTo(String value) {
            addCriterion("auths_remark <=", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkLike(String value) {
            addCriterion("auths_remark like", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkNotLike(String value) {
            addCriterion("auths_remark not like", value, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkIn(List<String> values) {
            addCriterion("auths_remark in", values, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkNotIn(List<String> values) {
            addCriterion("auths_remark not in", values, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkBetween(String value1, String value2) {
            addCriterion("auths_remark between", value1, value2, "authsRemark");
            return (Criteria) this;
        }

        public Criteria andAuthsRemarkNotBetween(String value1, String value2) {
            addCriterion("auths_remark not between", value1, value2, "authsRemark");
            return (Criteria) this;
        }
    }

    /**
     * shop_user_auths
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * shop_user_auths 2019-04-15
     */
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