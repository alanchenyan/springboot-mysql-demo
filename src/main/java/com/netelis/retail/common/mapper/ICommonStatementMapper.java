package com.netelis.retail.common.mapper;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonStatementMapper {

    List selectList(String statement, Object parameter);

    Long insert(String statement, Object entity);

    void update(String statement, Object entity);

    void delete(String statement, Object entity);

}
