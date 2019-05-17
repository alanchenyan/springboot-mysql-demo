package com.springboot.mysql.web.account.search;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public class UserSearch {

    private String userName;

    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
