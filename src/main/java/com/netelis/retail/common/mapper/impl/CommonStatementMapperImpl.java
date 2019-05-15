package com.netelis.retail.common.mapper.impl;

import com.netelis.retail.common.mapper.ICommonStatementMapper;
import com.netelis.retail.config.SqlSessionConfig;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@Component
public class CommonStatementMapperImpl implements ICommonStatementMapper {

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

    @Override
    public int insert(String statement, Object parameter){
        int id = 0;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            id = session.insert(statement,parameter);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }
}
