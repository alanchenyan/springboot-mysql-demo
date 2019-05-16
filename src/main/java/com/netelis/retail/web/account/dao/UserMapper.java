package com.netelis.retail.web.account.dao;

import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.search.UserSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
@Mapper
public interface UserMapper {

    int insertUser(User user);

    List findUser(UserSearch userSearch);

    List findLoginByName(String name);

}