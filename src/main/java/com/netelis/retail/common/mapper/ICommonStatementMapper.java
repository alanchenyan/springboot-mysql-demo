package com.netelis.retail.common.mapper;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonStatementMapper {

    String insert(String statement, Object entity);

    void update(String statement, Object entity);

    void delete(String statement, Object parameter);

    List selectList(String statement, Object parameter);

    Object selectOne(String statement, Object parameter);

}
