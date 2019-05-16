package com.netelis.retail.rpc.statement.mapper;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface IRpcStatementMapper {

    /**
     * 新增数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param entity A parameter object to pass to the statement.
     * @return
     */
    String insert(String statement, Object entity);

    /**
     * 修改数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param entity A parameter object to pass to the statement.
     */
    void update(String statement, Object entity);

    /**
     * 删除数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     */
    void delete(String statement, Object parameter);

    /**
     * 获取数据列表接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return
     */
    List selectList(String statement, Object parameter);

    /**
     * 获取数据项接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return
     */
    Object selectOne(String statement, Object parameter);

}
