package com.netelis.retail.web.account.service.impl;

import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.dao.UserMapper;
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
    private UserMapper userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List findUser(UserSearch userSearch) {
        return userDao.findUser(userSearch);
    }

    @Override
    public List findLoginByName(String parameter){
        return userDao.findLoginByName(parameter);
    }
}
