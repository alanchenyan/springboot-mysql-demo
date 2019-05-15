package com.netelis.retail.web.account.service;

import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.search.UserSearch;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
public interface IUserService {

    int insert(User user);

    List findUser(UserSearch userSearch);

    List findLoginByName(String name);

}
