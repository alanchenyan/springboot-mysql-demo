package com.netelis.retail.config.sqlsession;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Alan Chen
 * @description SqlSession配置
 * @date 2019/5/14
 */
@Configuration
public class SqlSessionConfig {

    private Logger logger = LoggerFactory.getLogger(SqlSessionConfig.class);

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.configuration.map-underscore-to-camel-case}")
    private boolean mapUnderscoreToCamelCase;


    @Bean
    public SqlSessionFactoryBean createSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = null;
        try {
            DataSource dataSource = new PooledDataSource(driverClassName, url, username, password);

            sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);

            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(mapperLocations));

            org.apache.ibatis.session.Configuration configuration = sqlSessionFactoryBean.getObject().getConfiguration();
            //设置驼峰匹配规则
            configuration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);
            sqlSessionFactoryBean.setConfiguration(configuration);

        } catch (Exception e) {
            logger.error("创建SqlSession连接工厂错误：{}", e);
        }
        return sqlSessionFactoryBean;
    }
}