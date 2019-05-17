package com.springboot.mysql.rpc.statement.service;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
public interface IRpcStatementService {

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
     * disable(逻辑删除)数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param keyId 数据id
     */
    void disableById(String statement, String keyId);

    /**
     * disable(逻辑删除)数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter 查询删除数据的参数
     */
    void disable(String statement, Object parameter);

    /**
     * 物理删除数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param keyId 数据id
     */
    void deleteById(String statement, String keyId);

    /**
     * 物理删除数据接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter 查询删除数据的参数
     */
    void delete(String statement, Object parameter);

    /**
     * 获取数据列表接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter 查询参数
     * @return
     */
    List selectList(String statement, Object parameter);

    /**
     * 获取数据项接口
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter 查询参数
     * @return
     */
    Object selectOne(String statement, Object parameter);

    /**
     * 获取数据项接口
     * @param statement Unique identifier matching the statement to execute.
     * @param keyId 数据id
     * @return
     */
    Object selectOne(String statement, String keyId);
}
