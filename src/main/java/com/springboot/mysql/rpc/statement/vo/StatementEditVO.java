package com.springboot.mysql.rpc.statement.vo;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class StatementEditVO {

    private String statement;

    private Object entity;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "StatementEditVO{" +
                "statement='" + statement + '\'' +
                ", entity=" + entity +
                '}';
    }
}
