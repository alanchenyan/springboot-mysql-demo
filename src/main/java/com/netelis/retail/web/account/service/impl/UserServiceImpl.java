package com.netelis.retail.web.account.service.impl;

import com.netelis.retail.common.mapper.ICommonStatementMapper;
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
    private UserMapper userMapper;
    @Autowired
    ICommonStatementMapper commonStatementMapperImpl;

    @Override
    public String insertUser(User user) {
        userMapper.insertUser(user);
        return user.getKeyId();
    }

    @Override
    public List findUser(UserSearch userSearch) {
        return userMapper.findUser(userSearch);
    }

    @Override
    public User getOneUser(String keyId){
        return (User)commonStatementMapperImpl.selectOne("getOneUser",keyId);
    }
}
