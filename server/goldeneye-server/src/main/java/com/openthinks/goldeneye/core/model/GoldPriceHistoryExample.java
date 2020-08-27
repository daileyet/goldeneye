package com.openthinks.goldeneye.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoldPriceHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoldPriceHistoryExample() {
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

        public Criteria andPriceTimeIsNull() {
            addCriterion("price_time is null");
            return (Criteria) this;
        }

        public Criteria andPriceTimeIsNotNull() {
            addCriterion("price_time is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTimeEqualTo(Date value) {
            addCriterion("price_time =", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotEqualTo(Date value) {
            addCriterion("price_time <>", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeGreaterThan(Date value) {
            addCriterion("price_time >", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("price_time >=", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeLessThan(Date value) {
            addCriterion("price_time <", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeLessThanOrEqualTo(Date value) {
            addCriterion("price_time <=", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeIn(List<Date> values) {
            addCriterion("price_time in", values, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotIn(List<Date> values) {
            addCriterion("price_time not in", values, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeBetween(Date value1, Date value2) {
            addCriterion("price_time between", value1, value2, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotBetween(Date value1, Date value2) {
            addCriterion("price_time not between", value1, value2, "priceTime");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNull() {
            addCriterion("unit_code is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("unit_code =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("unit_code <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("unit_code >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_code >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("unit_code <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("unit_code <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("unit_code like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("unit_code not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("unit_code in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("unit_code not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("unit_code between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("unit_code not between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(Float value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(Float value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(Float value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(Float value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(Float value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<Float> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<Float> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(Float value1, Float value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(Float value1, Float value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(Float value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(Float value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(Float value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(Float value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(Float value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<Float> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<Float> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(Float value1, Float value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(Float value1, Float value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNull() {
            addCriterion("lowest_price is null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNotNull() {
            addCriterion("lowest_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceEqualTo(Float value) {
            addCriterion("lowest_price =", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotEqualTo(Float value) {
            addCriterion("lowest_price <>", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThan(Float value) {
            addCriterion("lowest_price >", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("lowest_price >=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThan(Float value) {
            addCriterion("lowest_price <", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThanOrEqualTo(Float value) {
            addCriterion("lowest_price <=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIn(List<Float> values) {
            addCriterion("lowest_price in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotIn(List<Float> values) {
            addCriterion("lowest_price not in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceBetween(Float value1, Float value2) {
            addCriterion("lowest_price between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotBetween(Float value1, Float value2) {
            addCriterion("lowest_price not between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceIsNull() {
            addCriterion("highest_price is null");
            return (Criteria) this;
        }

        public Criteria andHighestPriceIsNotNull() {
            addCriterion("highest_price is not null");
            return (Criteria) this;
        }

        public Criteria andHighestPriceEqualTo(Float value) {
            addCriterion("highest_price =", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceNotEqualTo(Float value) {
            addCriterion("highest_price <>", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceGreaterThan(Float value) {
            addCriterion("highest_price >", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("highest_price >=", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceLessThan(Float value) {
            addCriterion("highest_price <", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceLessThanOrEqualTo(Float value) {
            addCriterion("highest_price <=", value, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceIn(List<Float> values) {
            addCriterion("highest_price in", values, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceNotIn(List<Float> values) {
            addCriterion("highest_price not in", values, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceBetween(Float value1, Float value2) {
            addCriterion("highest_price between", value1, value2, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andHighestPriceNotBetween(Float value1, Float value2) {
            addCriterion("highest_price not between", value1, value2, "highestPrice");
            return (Criteria) this;
        }

        public Criteria andChangeIsNull() {
            addCriterion("`change` is null");
            return (Criteria) this;
        }

        public Criteria andChangeIsNotNull() {
            addCriterion("`change` is not null");
            return (Criteria) this;
        }

        public Criteria andChangeEqualTo(String value) {
            addCriterion("`change` =", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotEqualTo(String value) {
            addCriterion("`change` <>", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThan(String value) {
            addCriterion("`change` >", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThanOrEqualTo(String value) {
            addCriterion("`change` >=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThan(String value) {
            addCriterion("`change` <", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThanOrEqualTo(String value) {
            addCriterion("`change` <=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLike(String value) {
            addCriterion("`change` like", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotLike(String value) {
            addCriterion("`change` not like", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeIn(List<String> values) {
            addCriterion("`change` in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotIn(List<String> values) {
            addCriterion("`change` not in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeBetween(String value1, String value2) {
            addCriterion("`change` between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotBetween(String value1, String value2) {
            addCriterion("`change` not between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andChangePercentIsNull() {
            addCriterion("change_percent is null");
            return (Criteria) this;
        }

        public Criteria andChangePercentIsNotNull() {
            addCriterion("change_percent is not null");
            return (Criteria) this;
        }

        public Criteria andChangePercentEqualTo(String value) {
            addCriterion("change_percent =", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentNotEqualTo(String value) {
            addCriterion("change_percent <>", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentGreaterThan(String value) {
            addCriterion("change_percent >", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentGreaterThanOrEqualTo(String value) {
            addCriterion("change_percent >=", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentLessThan(String value) {
            addCriterion("change_percent <", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentLessThanOrEqualTo(String value) {
            addCriterion("change_percent <=", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentLike(String value) {
            addCriterion("change_percent like", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentNotLike(String value) {
            addCriterion("change_percent not like", value, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentIn(List<String> values) {
            addCriterion("change_percent in", values, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentNotIn(List<String> values) {
            addCriterion("change_percent not in", values, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentBetween(String value1, String value2) {
            addCriterion("change_percent between", value1, value2, "changePercent");
            return (Criteria) this;
        }

        public Criteria andChangePercentNotBetween(String value1, String value2) {
            addCriterion("change_percent not between", value1, value2, "changePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangeIsNull() {
            addCriterion("mon_change is null");
            return (Criteria) this;
        }

        public Criteria andMonChangeIsNotNull() {
            addCriterion("mon_change is not null");
            return (Criteria) this;
        }

        public Criteria andMonChangeEqualTo(String value) {
            addCriterion("mon_change =", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeNotEqualTo(String value) {
            addCriterion("mon_change <>", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeGreaterThan(String value) {
            addCriterion("mon_change >", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeGreaterThanOrEqualTo(String value) {
            addCriterion("mon_change >=", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeLessThan(String value) {
            addCriterion("mon_change <", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeLessThanOrEqualTo(String value) {
            addCriterion("mon_change <=", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeLike(String value) {
            addCriterion("mon_change like", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeNotLike(String value) {
            addCriterion("mon_change not like", value, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeIn(List<String> values) {
            addCriterion("mon_change in", values, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeNotIn(List<String> values) {
            addCriterion("mon_change not in", values, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeBetween(String value1, String value2) {
            addCriterion("mon_change between", value1, value2, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangeNotBetween(String value1, String value2) {
            addCriterion("mon_change not between", value1, value2, "monChange");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentIsNull() {
            addCriterion("mon_change_percent is null");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentIsNotNull() {
            addCriterion("mon_change_percent is not null");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentEqualTo(String value) {
            addCriterion("mon_change_percent =", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentNotEqualTo(String value) {
            addCriterion("mon_change_percent <>", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentGreaterThan(String value) {
            addCriterion("mon_change_percent >", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentGreaterThanOrEqualTo(String value) {
            addCriterion("mon_change_percent >=", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentLessThan(String value) {
            addCriterion("mon_change_percent <", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentLessThanOrEqualTo(String value) {
            addCriterion("mon_change_percent <=", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentLike(String value) {
            addCriterion("mon_change_percent like", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentNotLike(String value) {
            addCriterion("mon_change_percent not like", value, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentIn(List<String> values) {
            addCriterion("mon_change_percent in", values, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentNotIn(List<String> values) {
            addCriterion("mon_change_percent not in", values, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentBetween(String value1, String value2) {
            addCriterion("mon_change_percent between", value1, value2, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andMonChangePercentNotBetween(String value1, String value2) {
            addCriterion("mon_change_percent not between", value1, value2, "monChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangeIsNull() {
            addCriterion("year_change is null");
            return (Criteria) this;
        }

        public Criteria andYearChangeIsNotNull() {
            addCriterion("year_change is not null");
            return (Criteria) this;
        }

        public Criteria andYearChangeEqualTo(String value) {
            addCriterion("year_change =", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeNotEqualTo(String value) {
            addCriterion("year_change <>", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeGreaterThan(String value) {
            addCriterion("year_change >", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeGreaterThanOrEqualTo(String value) {
            addCriterion("year_change >=", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeLessThan(String value) {
            addCriterion("year_change <", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeLessThanOrEqualTo(String value) {
            addCriterion("year_change <=", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeLike(String value) {
            addCriterion("year_change like", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeNotLike(String value) {
            addCriterion("year_change not like", value, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeIn(List<String> values) {
            addCriterion("year_change in", values, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeNotIn(List<String> values) {
            addCriterion("year_change not in", values, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeBetween(String value1, String value2) {
            addCriterion("year_change between", value1, value2, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangeNotBetween(String value1, String value2) {
            addCriterion("year_change not between", value1, value2, "yearChange");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentIsNull() {
            addCriterion("year_change_percent is null");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentIsNotNull() {
            addCriterion("year_change_percent is not null");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentEqualTo(String value) {
            addCriterion("year_change_percent =", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentNotEqualTo(String value) {
            addCriterion("year_change_percent <>", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentGreaterThan(String value) {
            addCriterion("year_change_percent >", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentGreaterThanOrEqualTo(String value) {
            addCriterion("year_change_percent >=", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentLessThan(String value) {
            addCriterion("year_change_percent <", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentLessThanOrEqualTo(String value) {
            addCriterion("year_change_percent <=", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentLike(String value) {
            addCriterion("year_change_percent like", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentNotLike(String value) {
            addCriterion("year_change_percent not like", value, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentIn(List<String> values) {
            addCriterion("year_change_percent in", values, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentNotIn(List<String> values) {
            addCriterion("year_change_percent not in", values, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentBetween(String value1, String value2) {
            addCriterion("year_change_percent between", value1, value2, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andYearChangePercentNotBetween(String value1, String value2) {
            addCriterion("year_change_percent not between", value1, value2, "yearChangePercent");
            return (Criteria) this;
        }

        public Criteria andGenericSubquery(String subQueryClause) {
            addCriterion(subQueryClause);
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