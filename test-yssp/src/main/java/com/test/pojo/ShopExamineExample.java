package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopExamineExample {
    /**
     * shop_examine
     */
    protected String orderByClause;

    /**
     * shop_examine
     */
    protected boolean distinct;

    /**
     * shop_examine
     */
    protected List<Criteria> oredCriteria;

    public ShopExamineExample() {
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
     * shop_examine 2019-05-05
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

        public Criteria andExamineIdIsNull() {
            addCriterion("examine_id is null");
            return (Criteria) this;
        }

        public Criteria andExamineIdIsNotNull() {
            addCriterion("examine_id is not null");
            return (Criteria) this;
        }

        public Criteria andExamineIdEqualTo(Integer value) {
            addCriterion("examine_id =", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotEqualTo(Integer value) {
            addCriterion("examine_id <>", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdGreaterThan(Integer value) {
            addCriterion("examine_id >", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("examine_id >=", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdLessThan(Integer value) {
            addCriterion("examine_id <", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdLessThanOrEqualTo(Integer value) {
            addCriterion("examine_id <=", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdIn(List<Integer> values) {
            addCriterion("examine_id in", values, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotIn(List<Integer> values) {
            addCriterion("examine_id not in", values, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdBetween(Integer value1, Integer value2) {
            addCriterion("examine_id between", value1, value2, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("examine_id not between", value1, value2, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdIsNull() {
            addCriterion("examine_store_id is null");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdIsNotNull() {
            addCriterion("examine_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdEqualTo(Integer value) {
            addCriterion("examine_store_id =", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdNotEqualTo(Integer value) {
            addCriterion("examine_store_id <>", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdGreaterThan(Integer value) {
            addCriterion("examine_store_id >", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("examine_store_id >=", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdLessThan(Integer value) {
            addCriterion("examine_store_id <", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("examine_store_id <=", value, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdIn(List<Integer> values) {
            addCriterion("examine_store_id in", values, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdNotIn(List<Integer> values) {
            addCriterion("examine_store_id not in", values, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("examine_store_id between", value1, value2, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("examine_store_id not between", value1, value2, "examineStoreId");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameIsNull() {
            addCriterion("examine_store_name is null");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameIsNotNull() {
            addCriterion("examine_store_name is not null");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameEqualTo(String value) {
            addCriterion("examine_store_name =", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameNotEqualTo(String value) {
            addCriterion("examine_store_name <>", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameGreaterThan(String value) {
            addCriterion("examine_store_name >", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("examine_store_name >=", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameLessThan(String value) {
            addCriterion("examine_store_name <", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameLessThanOrEqualTo(String value) {
            addCriterion("examine_store_name <=", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameLike(String value) {
            addCriterion("examine_store_name like", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameNotLike(String value) {
            addCriterion("examine_store_name not like", value, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameIn(List<String> values) {
            addCriterion("examine_store_name in", values, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameNotIn(List<String> values) {
            addCriterion("examine_store_name not in", values, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameBetween(String value1, String value2) {
            addCriterion("examine_store_name between", value1, value2, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineStoreNameNotBetween(String value1, String value2) {
            addCriterion("examine_store_name not between", value1, value2, "examineStoreName");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIsNull() {
            addCriterion("examine_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIsNotNull() {
            addCriterion("examine_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdEqualTo(Integer value) {
            addCriterion("examine_user_id =", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotEqualTo(Integer value) {
            addCriterion("examine_user_id <>", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdGreaterThan(Integer value) {
            addCriterion("examine_user_id >", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("examine_user_id >=", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdLessThan(Integer value) {
            addCriterion("examine_user_id <", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("examine_user_id <=", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIn(List<Integer> values) {
            addCriterion("examine_user_id in", values, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotIn(List<Integer> values) {
            addCriterion("examine_user_id not in", values, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdBetween(Integer value1, Integer value2) {
            addCriterion("examine_user_id between", value1, value2, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("examine_user_id not between", value1, value2, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIsNull() {
            addCriterion("examine_user_name is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIsNotNull() {
            addCriterion("examine_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameEqualTo(String value) {
            addCriterion("examine_user_name =", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotEqualTo(String value) {
            addCriterion("examine_user_name <>", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameGreaterThan(String value) {
            addCriterion("examine_user_name >", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("examine_user_name >=", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLessThan(String value) {
            addCriterion("examine_user_name <", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLessThanOrEqualTo(String value) {
            addCriterion("examine_user_name <=", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLike(String value) {
            addCriterion("examine_user_name like", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotLike(String value) {
            addCriterion("examine_user_name not like", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIn(List<String> values) {
            addCriterion("examine_user_name in", values, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotIn(List<String> values) {
            addCriterion("examine_user_name not in", values, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameBetween(String value1, String value2) {
            addCriterion("examine_user_name between", value1, value2, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotBetween(String value1, String value2) {
            addCriterion("examine_user_name not between", value1, value2, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneIsNull() {
            addCriterion("examine_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneIsNotNull() {
            addCriterion("examine_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneEqualTo(String value) {
            addCriterion("examine_user_phone =", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneNotEqualTo(String value) {
            addCriterion("examine_user_phone <>", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneGreaterThan(String value) {
            addCriterion("examine_user_phone >", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("examine_user_phone >=", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneLessThan(String value) {
            addCriterion("examine_user_phone <", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("examine_user_phone <=", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneLike(String value) {
            addCriterion("examine_user_phone like", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneNotLike(String value) {
            addCriterion("examine_user_phone not like", value, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneIn(List<String> values) {
            addCriterion("examine_user_phone in", values, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneNotIn(List<String> values) {
            addCriterion("examine_user_phone not in", values, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneBetween(String value1, String value2) {
            addCriterion("examine_user_phone between", value1, value2, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserPhoneNotBetween(String value1, String value2) {
            addCriterion("examine_user_phone not between", value1, value2, "examineUserPhone");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayIsNull() {
            addCriterion("examine_user_alipay is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayIsNotNull() {
            addCriterion("examine_user_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayEqualTo(String value) {
            addCriterion("examine_user_alipay =", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayNotEqualTo(String value) {
            addCriterion("examine_user_alipay <>", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayGreaterThan(String value) {
            addCriterion("examine_user_alipay >", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayGreaterThanOrEqualTo(String value) {
            addCriterion("examine_user_alipay >=", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayLessThan(String value) {
            addCriterion("examine_user_alipay <", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayLessThanOrEqualTo(String value) {
            addCriterion("examine_user_alipay <=", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayLike(String value) {
            addCriterion("examine_user_alipay like", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayNotLike(String value) {
            addCriterion("examine_user_alipay not like", value, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayIn(List<String> values) {
            addCriterion("examine_user_alipay in", values, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayNotIn(List<String> values) {
            addCriterion("examine_user_alipay not in", values, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayBetween(String value1, String value2) {
            addCriterion("examine_user_alipay between", value1, value2, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineUserAlipayNotBetween(String value1, String value2) {
            addCriterion("examine_user_alipay not between", value1, value2, "examineUserAlipay");
            return (Criteria) this;
        }

        public Criteria andExamineStateIsNull() {
            addCriterion("examine_state is null");
            return (Criteria) this;
        }

        public Criteria andExamineStateIsNotNull() {
            addCriterion("examine_state is not null");
            return (Criteria) this;
        }

        public Criteria andExamineStateEqualTo(Byte value) {
            addCriterion("examine_state =", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateNotEqualTo(Byte value) {
            addCriterion("examine_state <>", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateGreaterThan(Byte value) {
            addCriterion("examine_state >", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("examine_state >=", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateLessThan(Byte value) {
            addCriterion("examine_state <", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateLessThanOrEqualTo(Byte value) {
            addCriterion("examine_state <=", value, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateIn(List<Byte> values) {
            addCriterion("examine_state in", values, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateNotIn(List<Byte> values) {
            addCriterion("examine_state not in", values, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateBetween(Byte value1, Byte value2) {
            addCriterion("examine_state between", value1, value2, "examineState");
            return (Criteria) this;
        }

        public Criteria andExamineStateNotBetween(Byte value1, Byte value2) {
            addCriterion("examine_state not between", value1, value2, "examineState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("payment_state is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("payment_state is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(Byte value) {
            addCriterion("payment_state =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(Byte value) {
            addCriterion("payment_state <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(Byte value) {
            addCriterion("payment_state >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_state >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(Byte value) {
            addCriterion("payment_state <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(Byte value) {
            addCriterion("payment_state <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<Byte> values) {
            addCriterion("payment_state in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<Byte> values) {
            addCriterion("payment_state not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(Byte value1, Byte value2) {
            addCriterion("payment_state between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_state not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeIsNull() {
            addCriterion("examine_establish_time is null");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeIsNotNull() {
            addCriterion("examine_establish_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeEqualTo(String value) {
            addCriterion("examine_establish_time =", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeNotEqualTo(String value) {
            addCriterion("examine_establish_time <>", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeGreaterThan(String value) {
            addCriterion("examine_establish_time >", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("examine_establish_time >=", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeLessThan(String value) {
            addCriterion("examine_establish_time <", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeLessThanOrEqualTo(String value) {
            addCriterion("examine_establish_time <=", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeLike(String value) {
            addCriterion("examine_establish_time like", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeNotLike(String value) {
            addCriterion("examine_establish_time not like", value, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeIn(List<String> values) {
            addCriterion("examine_establish_time in", values, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeNotIn(List<String> values) {
            addCriterion("examine_establish_time not in", values, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeBetween(String value1, String value2) {
            addCriterion("examine_establish_time between", value1, value2, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineEstablishTimeNotBetween(String value1, String value2) {
            addCriterion("examine_establish_time not between", value1, value2, "examineEstablishTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeIsNull() {
            addCriterion("examine_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeIsNotNull() {
            addCriterion("examine_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeEqualTo(String value) {
            addCriterion("examine_modify_time =", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeNotEqualTo(String value) {
            addCriterion("examine_modify_time <>", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeGreaterThan(String value) {
            addCriterion("examine_modify_time >", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("examine_modify_time >=", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeLessThan(String value) {
            addCriterion("examine_modify_time <", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeLessThanOrEqualTo(String value) {
            addCriterion("examine_modify_time <=", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeLike(String value) {
            addCriterion("examine_modify_time like", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeNotLike(String value) {
            addCriterion("examine_modify_time not like", value, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeIn(List<String> values) {
            addCriterion("examine_modify_time in", values, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeNotIn(List<String> values) {
            addCriterion("examine_modify_time not in", values, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeBetween(String value1, String value2) {
            addCriterion("examine_modify_time between", value1, value2, "examineModifyTime");
            return (Criteria) this;
        }

        public Criteria andExamineModifyTimeNotBetween(String value1, String value2) {
            addCriterion("examine_modify_time not between", value1, value2, "examineModifyTime");
            return (Criteria) this;
        }
    }

    /**
     * shop_examine
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * shop_examine 2019-05-05
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