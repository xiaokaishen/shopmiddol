package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopReportExample {
    /**
     * shop_report
     */
    protected String orderByClause;

    /**
     * shop_report
     */
    protected boolean distinct;

    /**
     * shop_report
     */
    protected List<Criteria> oredCriteria;

    public ShopReportExample() {
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
     * shop_report 2019-04-24
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNull() {
            addCriterion("report_name is null");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNotNull() {
            addCriterion("report_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportNameEqualTo(String value) {
            addCriterion("report_name =", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotEqualTo(String value) {
            addCriterion("report_name <>", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThan(String value) {
            addCriterion("report_name >", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_name >=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThan(String value) {
            addCriterion("report_name <", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThanOrEqualTo(String value) {
            addCriterion("report_name <=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLike(String value) {
            addCriterion("report_name like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotLike(String value) {
            addCriterion("report_name not like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameIn(List<String> values) {
            addCriterion("report_name in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotIn(List<String> values) {
            addCriterion("report_name not in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameBetween(String value1, String value2) {
            addCriterion("report_name between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotBetween(String value1, String value2) {
            addCriterion("report_name not between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportPhoneIsNull() {
            addCriterion("report_phone is null");
            return (Criteria) this;
        }

        public Criteria andReportPhoneIsNotNull() {
            addCriterion("report_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReportPhoneEqualTo(String value) {
            addCriterion("report_phone =", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneNotEqualTo(String value) {
            addCriterion("report_phone <>", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneGreaterThan(String value) {
            addCriterion("report_phone >", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("report_phone >=", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneLessThan(String value) {
            addCriterion("report_phone <", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneLessThanOrEqualTo(String value) {
            addCriterion("report_phone <=", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneLike(String value) {
            addCriterion("report_phone like", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneNotLike(String value) {
            addCriterion("report_phone not like", value, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneIn(List<String> values) {
            addCriterion("report_phone in", values, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneNotIn(List<String> values) {
            addCriterion("report_phone not in", values, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneBetween(String value1, String value2) {
            addCriterion("report_phone between", value1, value2, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportPhoneNotBetween(String value1, String value2) {
            addCriterion("report_phone not between", value1, value2, "reportPhone");
            return (Criteria) this;
        }

        public Criteria andReportMailboxIsNull() {
            addCriterion("report_mailbox is null");
            return (Criteria) this;
        }

        public Criteria andReportMailboxIsNotNull() {
            addCriterion("report_mailbox is not null");
            return (Criteria) this;
        }

        public Criteria andReportMailboxEqualTo(String value) {
            addCriterion("report_mailbox =", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxNotEqualTo(String value) {
            addCriterion("report_mailbox <>", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxGreaterThan(String value) {
            addCriterion("report_mailbox >", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("report_mailbox >=", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxLessThan(String value) {
            addCriterion("report_mailbox <", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxLessThanOrEqualTo(String value) {
            addCriterion("report_mailbox <=", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxLike(String value) {
            addCriterion("report_mailbox like", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxNotLike(String value) {
            addCriterion("report_mailbox not like", value, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxIn(List<String> values) {
            addCriterion("report_mailbox in", values, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxNotIn(List<String> values) {
            addCriterion("report_mailbox not in", values, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxBetween(String value1, String value2) {
            addCriterion("report_mailbox between", value1, value2, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportMailboxNotBetween(String value1, String value2) {
            addCriterion("report_mailbox not between", value1, value2, "reportMailbox");
            return (Criteria) this;
        }

        public Criteria andReportAlipayIsNull() {
            addCriterion("report_alipay is null");
            return (Criteria) this;
        }

        public Criteria andReportAlipayIsNotNull() {
            addCriterion("report_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andReportAlipayEqualTo(String value) {
            addCriterion("report_alipay =", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayNotEqualTo(String value) {
            addCriterion("report_alipay <>", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayGreaterThan(String value) {
            addCriterion("report_alipay >", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayGreaterThanOrEqualTo(String value) {
            addCriterion("report_alipay >=", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayLessThan(String value) {
            addCriterion("report_alipay <", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayLessThanOrEqualTo(String value) {
            addCriterion("report_alipay <=", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayLike(String value) {
            addCriterion("report_alipay like", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayNotLike(String value) {
            addCriterion("report_alipay not like", value, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayIn(List<String> values) {
            addCriterion("report_alipay in", values, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayNotIn(List<String> values) {
            addCriterion("report_alipay not in", values, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayBetween(String value1, String value2) {
            addCriterion("report_alipay between", value1, value2, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportAlipayNotBetween(String value1, String value2) {
            addCriterion("report_alipay not between", value1, value2, "reportAlipay");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveIsNull() {
            addCriterion("report_test_drive is null");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveIsNotNull() {
            addCriterion("report_test_drive is not null");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveEqualTo(String value) {
            addCriterion("report_test_drive =", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveNotEqualTo(String value) {
            addCriterion("report_test_drive <>", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveGreaterThan(String value) {
            addCriterion("report_test_drive >", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveGreaterThanOrEqualTo(String value) {
            addCriterion("report_test_drive >=", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveLessThan(String value) {
            addCriterion("report_test_drive <", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveLessThanOrEqualTo(String value) {
            addCriterion("report_test_drive <=", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveLike(String value) {
            addCriterion("report_test_drive like", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveNotLike(String value) {
            addCriterion("report_test_drive not like", value, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveIn(List<String> values) {
            addCriterion("report_test_drive in", values, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveNotIn(List<String> values) {
            addCriterion("report_test_drive not in", values, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveBetween(String value1, String value2) {
            addCriterion("report_test_drive between", value1, value2, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportTestDriveNotBetween(String value1, String value2) {
            addCriterion("report_test_drive not between", value1, value2, "reportTestDrive");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeIsNull() {
            addCriterion("report_update_time is null");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeIsNotNull() {
            addCriterion("report_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeEqualTo(String value) {
            addCriterion("report_update_time =", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeNotEqualTo(String value) {
            addCriterion("report_update_time <>", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeGreaterThan(String value) {
            addCriterion("report_update_time >", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("report_update_time >=", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeLessThan(String value) {
            addCriterion("report_update_time <", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("report_update_time <=", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeLike(String value) {
            addCriterion("report_update_time like", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeNotLike(String value) {
            addCriterion("report_update_time not like", value, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeIn(List<String> values) {
            addCriterion("report_update_time in", values, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeNotIn(List<String> values) {
            addCriterion("report_update_time not in", values, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeBetween(String value1, String value2) {
            addCriterion("report_update_time between", value1, value2, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("report_update_time not between", value1, value2, "reportUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeIsNull() {
            addCriterion("report_create_time is null");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeIsNotNull() {
            addCriterion("report_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeEqualTo(String value) {
            addCriterion("report_create_time =", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeNotEqualTo(String value) {
            addCriterion("report_create_time <>", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeGreaterThan(String value) {
            addCriterion("report_create_time >", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("report_create_time >=", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeLessThan(String value) {
            addCriterion("report_create_time <", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("report_create_time <=", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeLike(String value) {
            addCriterion("report_create_time like", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeNotLike(String value) {
            addCriterion("report_create_time not like", value, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeIn(List<String> values) {
            addCriterion("report_create_time in", values, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeNotIn(List<String> values) {
            addCriterion("report_create_time not in", values, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeBetween(String value1, String value2) {
            addCriterion("report_create_time between", value1, value2, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportCreateTimeNotBetween(String value1, String value2) {
            addCriterion("report_create_time not between", value1, value2, "reportCreateTime");
            return (Criteria) this;
        }

        public Criteria andReportStatusIsNull() {
            addCriterion("report_status is null");
            return (Criteria) this;
        }

        public Criteria andReportStatusIsNotNull() {
            addCriterion("report_status is not null");
            return (Criteria) this;
        }

        public Criteria andReportStatusEqualTo(Byte value) {
            addCriterion("report_status =", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusNotEqualTo(Byte value) {
            addCriterion("report_status <>", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusGreaterThan(Byte value) {
            addCriterion("report_status >", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("report_status >=", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusLessThan(Byte value) {
            addCriterion("report_status <", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusLessThanOrEqualTo(Byte value) {
            addCriterion("report_status <=", value, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusIn(List<Byte> values) {
            addCriterion("report_status in", values, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusNotIn(List<Byte> values) {
            addCriterion("report_status not in", values, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusBetween(Byte value1, Byte value2) {
            addCriterion("report_status between", value1, value2, "reportStatus");
            return (Criteria) this;
        }

        public Criteria andReportStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("report_status not between", value1, value2, "reportStatus");
            return (Criteria) this;
        }
    }

    /**
     * shop_report
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * shop_report 2019-04-24
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