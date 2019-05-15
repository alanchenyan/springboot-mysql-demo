package com.netelis.retail.web.account.dao;

import com.netelis.retail.entiy.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
@Mapper
public interface UserDao {

    int insert(User user);

    List findByName(String name);

    List findLoginByName(String name);

}
