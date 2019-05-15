package com.netelis.retail.web.account.service.impl;

import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.dao.UserDao;
import com.netelis.retail.web.account.search.UserSearch;
import com.netelis.retail.web.account.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public List findUser(UserSearch userSearch) {
        return userDao.findUser(userSearch);
    }

    @Override
    public List findLoginByName(String name){
        return userDao.findLoginByName(name);
    }
}
