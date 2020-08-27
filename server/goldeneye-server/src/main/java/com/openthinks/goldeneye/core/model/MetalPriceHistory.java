package com.openthinks.goldeneye.core.model;

import java.util.Date;

public class MetalPriceHistory {
    private Long id;

    private String metalCode;

    private String unitCode;

    private Date priceTime;

    private Float price;

    private String change;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetalCode() {
        return metalCode;
    }

    public void setMetalCode(String metalCode) {
        this.metalCode = metalCode == null ? null : metalCode.trim();
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public Date getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(Date priceTime) {
        this.priceTime = priceTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change == null ? null : change.trim();
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
        MetalPriceHistory other = (MetalPriceHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMetalCode() == null ? other.getMetalCode() == null : this.getMetalCode().equals(other.getMetalCode()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getPriceTime() == null ? other.getPriceTime() == null : this.getPriceTime().equals(other.getPriceTime()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getChange() == null ? other.getChange() == null : this.getChange().equals(other.getChange()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMetalCode() == null) ? 0 : getMetalCode().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getPriceTime() == null) ? 0 : getPriceTime().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getChange() == null) ? 0 : getChange().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", metalCode=").append(metalCode);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", priceTime=").append(priceTime);
        sb.append(", price=").append(price);
        sb.append(", change=").append(change);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private MetalPriceHistory obj;

        public Builder() {
            this.obj = new MetalPriceHistory();
        }

        public Builder id(Long id) {
            obj.id = id;
            return this;
        }

        public Builder metalCode(String metalCode) {
            obj.metalCode = metalCode;
            return this;
        }

        public Builder unitCode(String unitCode) {
            obj.unitCode = unitCode;
            return this;
        }

        public Builder priceTime(Date priceTime) {
            obj.priceTime = priceTime;
            return this;
        }

        public Builder price(Float price) {
            obj.price = price;
            return this;
        }

        public Builder change(String change) {
            obj.change = change;
            return this;
        }

        public MetalPriceHistory build() {
            return this.obj;
        }
    }
}