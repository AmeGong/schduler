package com.example.infra.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRecordDOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public TaskRecordDOExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
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
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(String value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(String value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(String value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(String value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(String value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(String value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLike(String value) {
            addCriterion("task_status like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotLike(String value) {
            addCriterion("task_status not like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<String> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<String> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(String value1, String value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(String value1, String value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskContextIsNull() {
            addCriterion("task_context is null");
            return (Criteria) this;
        }

        public Criteria andTaskContextIsNotNull() {
            addCriterion("task_context is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContextEqualTo(String value) {
            addCriterion("task_context =", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotEqualTo(String value) {
            addCriterion("task_context <>", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextGreaterThan(String value) {
            addCriterion("task_context >", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextGreaterThanOrEqualTo(String value) {
            addCriterion("task_context >=", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLessThan(String value) {
            addCriterion("task_context <", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLessThanOrEqualTo(String value) {
            addCriterion("task_context <=", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextLike(String value) {
            addCriterion("task_context like", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotLike(String value) {
            addCriterion("task_context not like", value, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextIn(List<String> values) {
            addCriterion("task_context in", values, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotIn(List<String> values) {
            addCriterion("task_context not in", values, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextBetween(String value1, String value2) {
            addCriterion("task_context between", value1, value2, "taskContext");
            return (Criteria) this;
        }

        public Criteria andTaskContextNotBetween(String value1, String value2) {
            addCriterion("task_context not between", value1, value2, "taskContext");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeIsNull() {
            addCriterion("next_exe_time is null");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeIsNotNull() {
            addCriterion("next_exe_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeEqualTo(Date value) {
            addCriterion("next_exe_time =", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeNotEqualTo(Date value) {
            addCriterion("next_exe_time <>", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeGreaterThan(Date value) {
            addCriterion("next_exe_time >", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_exe_time >=", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeLessThan(Date value) {
            addCriterion("next_exe_time <", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_exe_time <=", value, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeIn(List<Date> values) {
            addCriterion("next_exe_time in", values, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeNotIn(List<Date> values) {
            addCriterion("next_exe_time not in", values, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeBetween(Date value1, Date value2) {
            addCriterion("next_exe_time between", value1, value2, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andNextExeTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_exe_time not between", value1, value2, "nextExeTime");
            return (Criteria) this;
        }

        public Criteria andExeTimesIsNull() {
            addCriterion("exe_times is null");
            return (Criteria) this;
        }

        public Criteria andExeTimesIsNotNull() {
            addCriterion("exe_times is not null");
            return (Criteria) this;
        }

        public Criteria andExeTimesEqualTo(Integer value) {
            addCriterion("exe_times =", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesNotEqualTo(Integer value) {
            addCriterion("exe_times <>", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesGreaterThan(Integer value) {
            addCriterion("exe_times >", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("exe_times >=", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesLessThan(Integer value) {
            addCriterion("exe_times <", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesLessThanOrEqualTo(Integer value) {
            addCriterion("exe_times <=", value, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesIn(List<Integer> values) {
            addCriterion("exe_times in", values, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesNotIn(List<Integer> values) {
            addCriterion("exe_times not in", values, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesBetween(Integer value1, Integer value2) {
            addCriterion("exe_times between", value1, value2, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andExeTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("exe_times not between", value1, value2, "exeTimes");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_record
     *
     * @mbg.generated do_not_delete_during_merge Fri Mar 24 23:07:30 CST 2023
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_record
     *
     * @mbg.generated Fri Mar 24 23:07:30 CST 2023
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