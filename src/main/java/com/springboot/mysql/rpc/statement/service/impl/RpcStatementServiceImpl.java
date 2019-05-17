package com.springboot.mysql.rpc.statement.service.impl;

import com.springboot.mysql.rpc.statement.mapper.IRpcStatementMapper;
import com.springboot.mysql.rpc.statement.service.IRpcStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@Service
public class RpcStatementServiceImpl implements IRpcStatementService {

    @Autowired
    IRpcStatementMapper rpcStatementMapperImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insert(String statement, Object entity) {
        return rpcStatementMapperImpl.insert(statement, entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(String statement, Object entity) {
        rpcStatementMapperImpl.update(statement, entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disableById(String statement, String keyId) {
        rpcStatementMapperImpl.update(statement, keyId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disable(String statement, Object parameter) {
        rpcStatementMapperImpl.update(statement, parameter);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String statement, String keyId) {
        rpcStatementMapperImpl.delete(statement, keyId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String statement, Object parameter) {
        rpcStatementMapperImpl.delete(statement, parameter);
    }

    @Override
    public List selectList(String statement, Object parameter) {
        return rpcStatementMapperImpl.selectList(statement, parameter);
    }

    @Override
    public Object selectOne(String statement, Object parameter) {
        return rpcStatementMapperImpl.selectOne(statement, parameter);
    }

    @Override
    public Object selectOne(String statement, String keyId) {
        return rpcStatementMapperImpl.selectOne(statement, keyId);
    }
}
