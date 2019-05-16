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

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

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
}
