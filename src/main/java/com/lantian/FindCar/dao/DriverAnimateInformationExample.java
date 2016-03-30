package com.lantian.FindCar.dao;

import java.util.ArrayList;
import java.util.List;

public class DriverAnimateInformationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public DriverAnimateInformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_animate_information
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_animate_information
     *
     * @mbggenerated
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdIsNull() {
            addCriterion("driver_base_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdIsNotNull() {
            addCriterion("driver_base_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdEqualTo(Long value) {
            addCriterion("driver_base_id =", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdNotEqualTo(Long value) {
            addCriterion("driver_base_id <>", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdGreaterThan(Long value) {
            addCriterion("driver_base_id >", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("driver_base_id >=", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdLessThan(Long value) {
            addCriterion("driver_base_id <", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdLessThanOrEqualTo(Long value) {
            addCriterion("driver_base_id <=", value, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdIn(List<Long> values) {
            addCriterion("driver_base_id in", values, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdNotIn(List<Long> values) {
            addCriterion("driver_base_id not in", values, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdBetween(Long value1, Long value2) {
            addCriterion("driver_base_id between", value1, value2, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andDriverBaseIdNotBetween(Long value1, Long value2) {
            addCriterion("driver_base_id not between", value1, value2, "driverBaseId");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("phonenum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("phonenum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("phonenum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("phonenum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("phonenum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("phonenum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("phonenum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("phonenum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("phonenum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("phonenum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("phonenum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("phonenum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("phonenum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("phonenum not between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNull() {
            addCriterion("refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            addCriterion("refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLike(String value) {
            addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andCurrentLatIsNull() {
            addCriterion("current_lat is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLatIsNotNull() {
            addCriterion("current_lat is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLatEqualTo(Double value) {
            addCriterion("current_lat =", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatNotEqualTo(Double value) {
            addCriterion("current_lat <>", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatGreaterThan(Double value) {
            addCriterion("current_lat >", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatGreaterThanOrEqualTo(Double value) {
            addCriterion("current_lat >=", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatLessThan(Double value) {
            addCriterion("current_lat <", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatLessThanOrEqualTo(Double value) {
            addCriterion("current_lat <=", value, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatIn(List<Double> values) {
            addCriterion("current_lat in", values, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatNotIn(List<Double> values) {
            addCriterion("current_lat not in", values, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatBetween(Double value1, Double value2) {
            addCriterion("current_lat between", value1, value2, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLatNotBetween(Double value1, Double value2) {
            addCriterion("current_lat not between", value1, value2, "currentLat");
            return (Criteria) this;
        }

        public Criteria andCurrentLngIsNull() {
            addCriterion("current_lng is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLngIsNotNull() {
            addCriterion("current_lng is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLngEqualTo(Double value) {
            addCriterion("current_lng =", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngNotEqualTo(Double value) {
            addCriterion("current_lng <>", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngGreaterThan(Double value) {
            addCriterion("current_lng >", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngGreaterThanOrEqualTo(Double value) {
            addCriterion("current_lng >=", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngLessThan(Double value) {
            addCriterion("current_lng <", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngLessThanOrEqualTo(Double value) {
            addCriterion("current_lng <=", value, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngIn(List<Double> values) {
            addCriterion("current_lng in", values, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngNotIn(List<Double> values) {
            addCriterion("current_lng not in", values, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngBetween(Double value1, Double value2) {
            addCriterion("current_lng between", value1, value2, "currentLng");
            return (Criteria) this;
        }

        public Criteria andCurrentLngNotBetween(Double value1, Double value2) {
            addCriterion("current_lng not between", value1, value2, "currentLng");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_animate_information
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_animate_information
     *
     * @mbggenerated
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