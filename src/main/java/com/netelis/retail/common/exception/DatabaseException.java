package com.netelis.retail.common.exception;

/**
 * @author Alan Chen
 * @description 数据库异常
 * @date 2019/5/17
 */
public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg) {
        super(msg);
    }
}
