package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopCmsUserExample {
    /**
     * shop_cms_user
     */
    protected String orderByClause;

    /**
     * shop_cms_user
     */
    protected boolean distinct;

    /**
     * shop_cms_user
     */
    protected List<Criteria> oredCriteria;

    public ShopCmsUserExample() {
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
     * shop_cms_user 2019-04-24
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

        public Criteria andCmsUserIdIsNull() {
            addCriterion("cms_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdIsNotNull() {
            addCriterion("cms_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdEqualTo(Long value) {
            addCriterion("cms_user_id =", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdNotEqualTo(Long value) {
            addCriterion("cms_user_id <>", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdGreaterThan(Long value) {
            addCriterion("cms_user_id >", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cms_user_id >=", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdLessThan(Long value) {
            addCriterion("cms_user_id <", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdLessThanOrEqualTo(Long value) {
            addCriterion("cms_user_id <=", value, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdIn(List<Long> values) {
            addCriterion("cms_user_id in", values, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdNotIn(List<Long> values) {
            addCriterion("cms_user_id not in", values, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdBetween(Long value1, Long value2) {
            addCriterion("cms_user_id between", value1, value2, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserIdNotBetween(Long value1, Long value2) {
            addCriterion("cms_user_id not between", value1, value2, "cmsUserId");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameIsNull() {
            addCriterion("cms_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameIsNotNull() {
            addCriterion("cms_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameEqualTo(String value) {
            addCriterion("cms_user_name =", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameNotEqualTo(String value) {
            addCriterion("cms_user_name <>", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameGreaterThan(String value) {
            addCriterion("cms_user_name >", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("cms_user_name >=", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameLessThan(String value) {
            addCriterion("cms_user_name <", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameLessThanOrEqualTo(String value) {
            addCriterion("cms_user_name <=", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameLike(String value) {
            addCriterion("cms_user_name like", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameNotLike(String value) {
            addCriterion("cms_user_name not like", value, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameIn(List<String> values) {
            addCriterion("cms_user_name in", values, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameNotIn(List<String> values) {
            addCriterion("cms_user_name not in", values, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameBetween(String value1, String value2) {
            addCriterion("cms_user_name between", value1, value2, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserNameNotBetween(String value1, String value2) {
            addCriterion("cms_user_name not between", value1, value2, "cmsUserName");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassIsNull() {
            addCriterion("cms_user_pass is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassIsNotNull() {
            addCriterion("cms_user_pass is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassEqualTo(String value) {
            addCriterion("cms_user_pass =", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassNotEqualTo(String value) {
            addCriterion("cms_user_pass <>", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassGreaterThan(String value) {
            addCriterion("cms_user_pass >", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassGreaterThanOrEqualTo(String value) {
            addCriterion("cms_user_pass >=", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassLessThan(String value) {
            addCriterion("cms_user_pass <", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassLessThanOrEqualTo(String value) {
            addCriterion("cms_user_pass <=", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassLike(String value) {
            addCriterion("cms_user_pass like", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassNotLike(String value) {
            addCriterion("cms_user_pass not like", value, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassIn(List<String> values) {
            addCriterion("cms_user_pass in", values, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassNotIn(List<String> values) {
            addCriterion("cms_user_pass not in", values, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassBetween(String value1, String value2) {
            addCriterion("cms_user_pass between", value1, value2, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserPassNotBetween(String value1, String value2) {
            addCriterion("cms_user_pass not between", value1, value2, "cmsUserPass");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgIsNull() {
            addCriterion("cms_user_img is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgIsNotNull() {
            addCriterion("cms_user_img is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgEqualTo(String value) {
            addCriterion("cms_user_img =", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgNotEqualTo(String value) {
            addCriterion("cms_user_img <>", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgGreaterThan(String value) {
            addCriterion("cms_user_img >", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("cms_user_img >=", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgLessThan(String value) {
            addCriterion("cms_user_img <", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgLessThanOrEqualTo(String value) {
            addCriterion("cms_user_img <=", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgLike(String value) {
            addCriterion("cms_user_img like", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgNotLike(String value) {
            addCriterion("cms_user_img not like", value, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgIn(List<String> values) {
            addCriterion("cms_user_img in", values, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgNotIn(List<String> values) {
            addCriterion("cms_user_img not in", values, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgBetween(String value1, String value2) {
            addCriterion("cms_user_img between", value1, value2, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserImgNotBetween(String value1, String value2) {
            addCriterion("cms_user_img not between", value1, value2, "cmsUserImg");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelIsNull() {
            addCriterion("cms_user_tel is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelIsNotNull() {
            addCriterion("cms_user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelEqualTo(String value) {
            addCriterion("cms_user_tel =", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelNotEqualTo(String value) {
            addCriterion("cms_user_tel <>", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelGreaterThan(String value) {
            addCriterion("cms_user_tel >", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("cms_user_tel >=", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelLessThan(String value) {
            addCriterion("cms_user_tel <", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelLessThanOrEqualTo(String value) {
            addCriterion("cms_user_tel <=", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelLike(String value) {
            addCriterion("cms_user_tel like", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelNotLike(String value) {
            addCriterion("cms_user_tel not like", value, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelIn(List<String> values) {
            addCriterion("cms_user_tel in", values, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelNotIn(List<String> values) {
            addCriterion("cms_user_tel not in", values, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelBetween(String value1, String value2) {
            addCriterion("cms_user_tel between", value1, value2, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserTelNotBetween(String value1, String value2) {
            addCriterion("cms_user_tel not between", value1, value2, "cmsUserTel");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusIsNull() {
            addCriterion("cms_user_status is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusIsNotNull() {
            addCriterion("cms_user_status is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusEqualTo(Byte value) {
            addCriterion("cms_user_status =", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusNotEqualTo(Byte value) {
            addCriterion("cms_user_status <>", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusGreaterThan(Byte value) {
            addCriterion("cms_user_status >", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("cms_user_status >=", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusLessThan(Byte value) {
            addCriterion("cms_user_status <", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusLessThanOrEqualTo(Byte value) {
            addCriterion("cms_user_status <=", value, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusIn(List<Byte> values) {
            addCriterion("cms_user_status in", values, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusNotIn(List<Byte> values) {
            addCriterion("cms_user_status not in", values, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusBetween(Byte value1, Byte value2) {
            addCriterion("cms_user_status between", value1, value2, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("cms_user_status not between", value1, value2, "cmsUserStatus");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthIsNull() {
            addCriterion("cms_user_auth is null");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthIsNotNull() {
            addCriterion("cms_user_auth is not null");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthEqualTo(Byte value) {
            addCriterion("cms_user_auth =", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthNotEqualTo(Byte value) {
            addCriterion("cms_user_auth <>", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthGreaterThan(Byte value) {
            addCriterion("cms_user_auth >", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthGreaterThanOrEqualTo(Byte value) {
            addCriterion("cms_user_auth >=", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthLessThan(Byte value) {
            addCriterion("cms_user_auth <", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthLessThanOrEqualTo(Byte value) {
            addCriterion("cms_user_auth <=", value, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthIn(List<Byte> values) {
            addCriterion("cms_user_auth in", values, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthNotIn(List<Byte> values) {
            addCriterion("cms_user_auth not in", values, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthBetween(Byte value1, Byte value2) {
            addCriterion("cms_user_auth between", value1, value2, "cmsUserAuth");
            return (Criteria) this;
        }

        public Criteria andCmsUserAuthNotBetween(Byte value1, Byte value2) {
            addCriterion("cms_user_auth not between", value1, value2, "cmsUserAuth");
            return (Criteria) this;
        }
    }

    /**
     * shop_cms_user
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * shop_cms_user 2019-04-24
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