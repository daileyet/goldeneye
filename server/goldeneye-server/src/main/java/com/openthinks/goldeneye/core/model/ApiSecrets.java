package com.openthinks.goldeneye.core.model;

import java.util.Date;

public class ApiSecrets {
    private Long id;

    private Long bizUid;

    private String apiCode;

    private String apiSecret;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBizUid() {
        return bizUid;
    }

    public void setBizUid(Long bizUid) {
        this.bizUid = bizUid;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode == null ? null : apiCode.trim();
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret == null ? null : apiSecret.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        ApiSecrets other = (ApiSecrets) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizUid() == null ? other.getBizUid() == null : this.getBizUid().equals(other.getBizUid()))
            && (this.getApiCode() == null ? other.getApiCode() == null : this.getApiCode().equals(other.getApiCode()))
            && (this.getApiSecret() == null ? other.getApiSecret() == null : this.getApiSecret().equals(other.getApiSecret()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizUid() == null) ? 0 : getBizUid().hashCode());
        result = prime * result + ((getApiCode() == null) ? 0 : getApiCode().hashCode());
        result = prime * result + ((getApiSecret() == null) ? 0 : getApiSecret().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bizUid=").append(bizUid);
        sb.append(", apiCode=").append(apiCode);
        sb.append(", apiSecret=").append(apiSecret);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private ApiSecrets obj;

        public Builder() {
            this.obj = new ApiSecrets();
        }

        public Builder id(Long id) {
            obj.id = id;
            return this;
        }

        public Builder bizUid(Long bizUid) {
            obj.bizUid = bizUid;
            return this;
        }

        public Builder apiCode(String apiCode) {
            obj.apiCode = apiCode;
            return this;
        }

        public Builder apiSecret(String apiSecret) {
            obj.apiSecret = apiSecret;
            return this;
        }

        public Builder createTime(Date createTime) {
            obj.createTime = createTime;
            return this;
        }

        public Builder updateTime(Date updateTime) {
            obj.updateTime = updateTime;
            return this;
        }

        public ApiSecrets build() {
            return this.obj;
        }
    }
}