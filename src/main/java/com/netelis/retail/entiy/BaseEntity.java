package com.netelis.retail.entiy;

import java.sql.Timestamp;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class BaseEntity {

    private String keyId;

    private int deleted;

    private Timestamp createTime;

    private Timestamp updateTime;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
