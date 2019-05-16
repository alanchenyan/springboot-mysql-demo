package com.netelis.retail.common.service;

import com.netelis.retail.entiy.BaseEntity;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonStatementService {

    String insert(String statement, Object entity);

    void update(String statement, Object entity);

    void deleteById(String statement, String keyId);

    void delete(String statement, Object entity);

    List selectList(String statement, Object parameter);

    Object selectOne(String statement, Object parameter);

    Object selectOne(String statement, String keyId);
}
