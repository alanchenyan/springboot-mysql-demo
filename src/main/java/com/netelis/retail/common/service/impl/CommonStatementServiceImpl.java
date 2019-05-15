package com.netelis.retail.common.service.impl;

import com.netelis.retail.common.mapper.ICommonStatementMapper;
import com.netelis.retail.common.service.ICommonStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List selectList(String statement, Object parameter){
        return commonStatementMapperImpl.selectList(statement,parameter);
    }
}