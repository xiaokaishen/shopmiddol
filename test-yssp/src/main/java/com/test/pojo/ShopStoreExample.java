package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopStoreExample {
    /**
     * shop_store
     */
    protected String orderByClause;

    /**
     * shop_store
     */
    protected boolean distinct;

    /**
     * shop_store
     */
    protected List<Criteria> oredCriteria;

    public ShopStoreExample() {
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
     * shop_store 2019-05-06
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIsNull() {
            addCriterion("store_province is null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIsNotNull() {
            addCriterion("store_province is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceEqualTo(String value) {
            addCriterion("store_province =", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotEqualTo(String value) {
            addCriterion("store_province <>", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceGreaterThan(String value) {
            addCriterion("store_province >", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("store_province >=", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLessThan(String value) {
            addCriterion("store_province <", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLessThanOrEqualTo(String value) {
            addCriterion("store_province <=", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLike(String value) {
            addCriterion("store_province like", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotLike(String value) {
            addCriterion("store_province not like", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIn(List<String> values) {
            addCriterion("store_province in", values, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotIn(List<String> values) {
            addCriterion("store_province not in", values, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceBetween(String value1, String value2) {
            addCriterion("store_province between", value1, value2, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotBetween(String value1, String value2) {
            addCriterion("store_province not between", value1, value2, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNull() {
            addCriterion("store_city is null");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNotNull() {
            addCriterion("store_city is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCityEqualTo(String value) {
            addCriterion("store_city =", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotEqualTo(String value) {
            addCriterion("store_city <>", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThan(String value) {
            addCriterion("store_city >", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThanOrEqualTo(String value) {
            addCriterion("store_city >=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThan(String value) {
            addCriterion("store_city <", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThanOrEqualTo(String value) {
            addCriterion("store_city <=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLike(String value) {
            addCriterion("store_city like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotLike(String value) {
            addCriterion("store_city not like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityIn(List<String> values) {
            addCriterion("store_city in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotIn(List<String> values) {
            addCriterion("store_city not in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityBetween(String value1, String value2) {
            addCriterion("store_city between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotBetween(String value1, String value2) {
            addCriterion("store_city not between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreRegionIsNull() {
            addCriterion("store_region is null");
            return (Criteria) this;
        }

        public Criteria andStoreRegionIsNotNull() {
            addCriterion("store_region is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRegionEqualTo(String value) {
            addCriterion("store_region =", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionNotEqualTo(String value) {
            addCriterion("store_region <>", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionGreaterThan(String value) {
            addCriterion("store_region >", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionGreaterThanOrEqualTo(String value) {
            addCriterion("store_region >=", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionLessThan(String value) {
            addCriterion("store_region <", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionLessThanOrEqualTo(String value) {
            addCriterion("store_region <=", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionLike(String value) {
            addCriterion("store_region like", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionNotLike(String value) {
            addCriterion("store_region not like", value, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionIn(List<String> values) {
            addCriterion("store_region in", values, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionNotIn(List<String> values) {
            addCriterion("store_region not in", values, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionBetween(String value1, String value2) {
            addCriterion("store_region between", value1, value2, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreRegionNotBetween(String value1, String value2) {
            addCriterion("store_region not between", value1, value2, "storeRegion");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcIsNull() {
            addCriterion("store_distributor_jc is null");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcIsNotNull() {
            addCriterion("store_distributor_jc is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcEqualTo(String value) {
            addCriterion("store_distributor_jc =", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcNotEqualTo(String value) {
            addCriterion("store_distributor_jc <>", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcGreaterThan(String value) {
            addCriterion("store_distributor_jc >", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcGreaterThanOrEqualTo(String value) {
            addCriterion("store_distributor_jc >=", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcLessThan(String value) {
            addCriterion("store_distributor_jc <", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcLessThanOrEqualTo(String value) {
            addCriterion("store_distributor_jc <=", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcLike(String value) {
            addCriterion("store_distributor_jc like", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcNotLike(String value) {
            addCriterion("store_distributor_jc not like", value, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcIn(List<String> values) {
            addCriterion("store_distributor_jc in", values, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcNotIn(List<String> values) {
            addCriterion("store_distributor_jc not in", values, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcBetween(String value1, String value2) {
            addCriterion("store_distributor_jc between", value1, value2, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorJcNotBetween(String value1, String value2) {
            addCriterion("store_distributor_jc not between", value1, value2, "storeDistributorJc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcIsNull() {
            addCriterion("store_distributor_qc is null");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcIsNotNull() {
            addCriterion("store_distributor_qc is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcEqualTo(String value) {
            addCriterion("store_distributor_qc =", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcNotEqualTo(String value) {
            addCriterion("store_distributor_qc <>", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcGreaterThan(String value) {
            addCriterion("store_distributor_qc >", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcGreaterThanOrEqualTo(String value) {
            addCriterion("store_distributor_qc >=", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcLessThan(String value) {
            addCriterion("store_distributor_qc <", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcLessThanOrEqualTo(String value) {
            addCriterion("store_distributor_qc <=", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcLike(String value) {
            addCriterion("store_distributor_qc like", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcNotLike(String value) {
            addCriterion("store_distributor_qc not like", value, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcIn(List<String> values) {
            addCriterion("store_distributor_qc in", values, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcNotIn(List<String> values) {
            addCriterion("store_distributor_qc not in", values, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcBetween(String value1, String value2) {
            addCriterion("store_distributor_qc between", value1, value2, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStoreDistributorQcNotBetween(String value1, String value2) {
            addCriterion("store_distributor_qc not between", value1, value2, "storeDistributorQc");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNull() {
            addCriterion("store_phone is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNotNull() {
            addCriterion("store_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneEqualTo(String value) {
            addCriterion("store_phone =", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotEqualTo(String value) {
            addCriterion("store_phone <>", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThan(String value) {
            addCriterion("store_phone >", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone >=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThan(String value) {
            addCriterion("store_phone <", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThanOrEqualTo(String value) {
            addCriterion("store_phone <=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLike(String value) {
            addCriterion("store_phone like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotLike(String value) {
            addCriterion("store_phone not like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIn(List<String> values) {
            addCriterion("store_phone in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotIn(List<String> values) {
            addCriterion("store_phone not in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneBetween(String value1, String value2) {
            addCriterion("store_phone between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotBetween(String value1, String value2) {
            addCriterion("store_phone not between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }
    }

    /**
     * shop_store
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * shop_store 2019-05-06
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