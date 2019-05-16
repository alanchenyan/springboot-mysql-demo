package com.netelis.retail.common.service.impl;

import com.netelis.retail.common.mapper.ICommonStatementMapper;
import com.netelis.retail.common.service.ICommonStatementService;
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
public class CommonStatementServiceImpl implements ICommonStatementService {

    @Autowired
    ICommonStatementMapper commonStatementMapperImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insert(String statement, Object entity){
        return commonStatementMapperImpl.insert(statement,entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(String statement, Object entity){
        commonStatementMapperImpl.update(statement,entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disableById(String statement, String keyId){
        commonStatementMapperImpl.update(statement,keyId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disable(String statement, Object parameter){
        commonStatementMapperImpl.update(statement,parameter);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(String statement, String keyId){
        commonStatementMapperImpl.delete(statement,keyId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String statement, Object parameter){
        commonStatementMapperImpl.delete(statement,parameter);
    }


    @Override
    public List selectList(String statement, Object parameter){
        return commonStatementMapperImpl.selectList(statement,parameter);
    }

    @Override
    public Object selectOne(String statement, Object parameter){
        return commonStatementMapperImpl.selectOne(statement,parameter);
    }

    @Override
    public Object selectOne(String statement, String keyId){
        return commonStatementMapperImpl.selectOne(statement,keyId);
    }
}
