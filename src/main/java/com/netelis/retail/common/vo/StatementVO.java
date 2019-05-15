package com.netelis.retail.common.vo;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class StatementVO {

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
}
