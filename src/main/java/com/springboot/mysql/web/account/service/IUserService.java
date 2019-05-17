package com.springboot.mysql.web.account.service;

import com.springboot.mysql.entiy.User;
import com.springboot.mysql.web.account.search.UserSearch;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
public interface IUserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    String insertUser(User user);

    /**
     * 查询用户
     * @param userSearch
     * @return
     */
    List findUser(UserSearch userSearch);

    /**
     * 获取单个用户
     * @param keyId
     * @return
     */
    User getOneUser(String keyId);

    /**
     * 获取单个用户
     * @param keyId
     * @return
     */
    User getOneUserByRpc(String keyId);

}
