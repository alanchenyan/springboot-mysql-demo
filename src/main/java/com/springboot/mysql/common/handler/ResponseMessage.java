package com.springboot.mysql.common.handler;

import java.io.Serializable;

/**
 * @author Alan Chen
 * @description 请求响应消息实体类
 * @date 2019/1/4
 */
public class ResponseMessage implements Serializable {

    private String rcd;
    private String rmk;

    public ResponseMessage(String rcd, String rmk) {
        this.rcd = rcd;
        this.rmk = rmk;
    }

    public String getRcd() {
        return rcd;
    }

    public void setRcd(String rcd) {
        this.rcd = rcd;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }
}
