package com.netelis.retail.rpc.statement.mapper.impl;

import com.netelis.retail.config.sqlsession.SqlSessionConfig;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.netelis.retail.rpc.statement.mapper.IRpcStatementMapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@Component
public class RpcStatementMapperImpl implements IRpcStatementMapper {

    @Autowired
    SqlSessionConfig sqlSessionConfig;

    @Override
    public String insert(String statement, Object entity) {
        String keyId = null;
        int affectedRowsNum = 0;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            affectedRowsNum = session.insert(statement, entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (affectedRowsNum == 1) {
            if (entity instanceof LinkedHashMap) {
                LinkedHashMap beanMap = (LinkedHashMap) entity;
                Object obj = beanMap.get("keyId");
                if (obj != null && obj instanceof String) {
                    keyId = (String) obj;
                }
            }
        }
        return keyId;
    }

    @Override
    public void update(String statement, Object entity) {
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            session.update(statement, entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(String statement, Object entity){
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            session.delete(statement, entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Override
    public List selectList(String statement, Object parameter) {
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
    public Object selectOne(String statement, Object parameter){
        Object result = null;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            result = session.selectOne(statement, parameter);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
