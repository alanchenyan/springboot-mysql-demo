package com.netelis.retail.rpc.statement.vo;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class StatementSearchVO {

    private String statement;

    private Object parameter;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "StatementSearchVO{" +
                "statement='" + statement + '\'' +
                ", parameter=" + parameter +
                '}';
    }
}
