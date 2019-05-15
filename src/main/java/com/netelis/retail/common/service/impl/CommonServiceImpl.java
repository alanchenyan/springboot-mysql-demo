package com.netelis.retail.common.service.impl;

import com.netelis.retail.common.service.ICommonService;
import com.netelis.retail.config.SqlSessionConfig;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@Service
public class CommonServiceImpl implements ICommonService {
    @Autowired
    SqlSessionConfig sqlSessionConfig;

    @Override
    public List selectList(String statement, Object parameter){
        List list = null;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            list = session.selectList(statement, parameter);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}