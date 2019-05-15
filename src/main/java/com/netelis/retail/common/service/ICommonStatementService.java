package com.netelis.retail.common.service;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonStatementService {

    List selectList(String statement, Object parameter);

    int insert(String statement, Object parameter);
}
