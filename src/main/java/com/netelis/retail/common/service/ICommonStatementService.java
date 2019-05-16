package com.netelis.retail.common.service;

import com.netelis.retail.entiy.BaseEntity;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonStatementService {

    List selectList(String statement, Object parameter);

    Long insert(String statement, Object entity);
}
