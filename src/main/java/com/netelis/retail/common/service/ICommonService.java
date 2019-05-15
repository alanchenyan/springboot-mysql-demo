package com.netelis.retail.common.service;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface ICommonService {

    List selectList(String statement, Object parameter);
}
