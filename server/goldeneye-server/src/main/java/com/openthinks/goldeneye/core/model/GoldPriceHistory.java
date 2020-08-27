package com.openthinks.goldeneye.core.model;

import java.util.Date;

public class GoldPriceHistory {
    private Long id;

    private Date priceTime;

    private String unitCode;

    private Float buyPrice;

    private Float sellPrice;

    private Float lowestPrice;

    private Float highestPrice;

    private String change;

    private String changePercent;

    private String monChange;

    private String monChangePercent;

    private String yearChange;

    private String yearChangePercent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(Date priceTime) {
        this.priceTime = priceTime;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Float getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Float highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change == null ? null : change.trim();
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent == null ? null : changePercent.trim();
    }

    public String getMonChange() {
        return monChange;
    }

    public void setMonChange(String monChange) {
        this.monChange = monChange == null ? null : monChange.trim();
    }

    public String getMonChangePercent() {
        return monChangePercent;
    }

    public void setMonChangePercent(String monChangePercent) {
        this.monChangePercent = monChangePercent == null ? null : monChangePercent.trim();
    }

    public String getYearChange() {
        return yearChange;
    }

    public void setYearChange(String yearChange) {
        this.yearChange = yearChange == null ? null : yearChange.trim();
    }

    public String getYearChangePercent() {
        return yearChangePercent;
    }

    public void setYearChangePercent(String yearChangePercent) {
        this.yearChangePercent = yearChangePercent == null ? null : yearChangePercent.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GoldPriceHistory other = (GoldPriceHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPriceTime() == null ? other.getPriceTime() == null : this.getPriceTime().equals(other.getPriceTime()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getSellPrice() == null ? other.getSellPrice() == null : this.getSellPrice().equals(other.getSellPrice()))
            && (this.getLowestPrice() == null ? other.getLowestPrice() == null : this.getLowestPrice().equals(other.getLowestPrice()))
            && (this.getHighestPrice() == null ? other.getHighestPrice() == null : this.getHighestPrice().equals(other.getHighestPrice()))
            && (this.getChange() == null ? other.getChange() == null : this.getChange().equals(other.getChange()))
            && (this.getChangePercent() == null ? other.getChangePercent() == null : this.getChangePercent().equals(other.getChangePercent()))
            && (this.getMonChange() == null ? other.getMonChange() == null : this.getMonChange().equals(other.getMonChange()))
            && (this.getMonChangePercent() == null ? other.getMonChangePercent() == null : this.getMonChangePercent().equals(other.getMonChangePercent()))
            && (this.getYearChange() == null ? other.getYearChange() == null : this.getYearChange().equals(other.getYearChange()))
            && (this.getYearChangePercent() == null ? other.getYearChangePercent() == null : this.getYearChangePercent().equals(other.getYearChangePercent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPriceTime() == null) ? 0 : getPriceTime().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getSellPrice() == null) ? 0 : getSellPrice().hashCode());
        result = prime * result + ((getLowestPrice() == null) ? 0 : getLowestPrice().hashCode());
        result = prime * result + ((getHighestPrice() == null) ? 0 : getHighestPrice().hashCode());
        result = prime * result + ((getChange() == null) ? 0 : getChange().hashCode());
        result = prime * result + ((getChangePercent() == null) ? 0 : getChangePercent().hashCode());
        result = prime * result + ((getMonChange() == null) ? 0 : getMonChange().hashCode());
        result = prime * result + ((getMonChangePercent() == null) ? 0 : getMonChangePercent().hashCode());
        result = prime * result + ((getYearChange() == null) ? 0 : getYearChange().hashCode());
        result = prime * result + ((getYearChangePercent() == null) ? 0 : getYearChangePercent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", priceTime=").append(priceTime);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", lowestPrice=").append(lowestPrice);
        sb.append(", highestPrice=").append(highestPrice);
        sb.append(", change=").append(change);
        sb.append(", changePercent=").append(changePercent);
        sb.append(", monChange=").append(monChange);
        sb.append(", monChangePercent=").append(monChangePercent);
        sb.append(", yearChange=").append(yearChange);
        sb.append(", yearChangePercent=").append(yearChangePercent);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private GoldPriceHistory obj;

        public Builder() {
            this.obj = new GoldPriceHistory();
        }

        public Builder id(Long id) {
            obj.id = id;
            return this;
        }

        public Builder priceTime(Date priceTime) {
            obj.priceTime = priceTime;
            return this;
        }

        public Builder unitCode(String unitCode) {
            obj.unitCode = unitCode;
            return this;
        }

        public Builder buyPrice(Float buyPrice) {
            obj.buyPrice = buyPrice;
            return this;
        }

        public Builder sellPrice(Float sellPrice) {
            obj.sellPrice = sellPrice;
            return this;
        }

        public Builder lowestPrice(Float lowestPrice) {
            obj.lowestPrice = lowestPrice;
            return this;
        }

        public Builder highestPrice(Float highestPrice) {
            obj.highestPrice = highestPrice;
            return this;
        }

        public Builder change(String change) {
            obj.change = change;
            return this;
        }

        public Builder changePercent(String changePercent) {
            obj.changePercent = changePercent;
            return this;
        }

        public Builder monChange(String monChange) {
            obj.monChange = monChange;
            return this;
        }

        public Builder monChangePercent(String monChangePercent) {
            obj.monChangePercent = monChangePercent;
            return this;
        }

        public Builder yearChange(String yearChange) {
            obj.yearChange = yearChange;
            return this;
        }

        public Builder yearChangePercent(String yearChangePercent) {
            obj.yearChangePercent = yearChangePercent;
            return this;
        }

        public GoldPriceHistory build() {
            return this.obj;
        }
    }
}