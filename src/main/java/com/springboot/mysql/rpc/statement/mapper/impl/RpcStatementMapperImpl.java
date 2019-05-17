package com.springboot.mysql.rpc.statement.mapper.impl;

import com.springboot.mysql.common.exception.DatabaseException;
import com.springboot.mysql.config.sqlsession.SqlSessionConfig;
import com.springboot.mysql.rpc.statement.mapper.IRpcStatementMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@Component
public class RpcStatementMapperImpl implements IRpcStatementMapper {

    private Logger logger = LoggerFactory.getLogger(RpcStatementMapperImpl.class);

    @Autowired
    SqlSessionConfig sqlSessionConfig;

    @Override
    public String insert(String statement, Object entity) {
        String keyId = null;
        int affectedRowsNum;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            affectedRowsNum = session.insert(statement, entity);
            session.commit();
        } catch (Exception e) {
            logger.error("SQL异常", e);
            throw new DatabaseException("SQL异常:" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
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
            logger.error("SQL异常", e);
            throw new DatabaseException("SQL异常:" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(String statement, Object entity) {
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            session.delete(statement, entity);
            session.commit();
        } catch (Exception e) {
            logger.error("SQL异常", e);
            throw new DatabaseException("SQL异常:" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public List selectList(String statement, Object parameter) {
        List list;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            list = session.selectList(statement, parameter);
            session.commit();
        } catch (Exception e) {
            logger.error("SQL异常", e);
            throw new DatabaseException("SQL异常:" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public Object selectOne(String statement, Object parameter) {
        Object result;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();
        try {
            session = factory.getObject().openSession();
            result = session.selectOne(statement, parameter);
            session.commit();
        } catch (Exception e) {
            logger.error("SQL异常", e);
            throw new DatabaseException("SQL异常:" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

}
