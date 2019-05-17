package com.springboot.mysql.entiy;

import java.sql.Timestamp;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class BaseEntity {

    /**
     * uuid
     */
    private String keyId;

    /**
     * 逻辑删除标志：0：未删除；1：删除 默认值为0
     */
    private int deleted;

    /**
     * 数据创建时间 默认值为当前时间
     */
    private Timestamp createTime;

    /**
     * 数据修改时间 默认值为当前时间
     */
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
