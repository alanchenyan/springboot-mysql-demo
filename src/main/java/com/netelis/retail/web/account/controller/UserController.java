package com.netelis.retail.web.account.controller;

import com.netelis.retail.config.SqlSessionConfig;
import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.dao.UserDao;
import com.netelis.retail.web.account.service.IUserService;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Alan Chen
 * @description 用户
 * @date 2019/5/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;
    @Autowired
    SqlSessionConfig sqlSessionConfig;


    @PostMapping
    public int save() {
        User user = new User();
        user.setUserName("AC");
        user.setPhone("13417810161");
        user.setPassword("alanchen123");
        return userServiceImpl.insert(user);
    }

    @GetMapping
    public List getUser(@RequestParam(required = true) String name) {
        System.out.println("getUser.............");
       // return userServiceImpl.findByName(name);
        return loadUser();

    }

    @GetMapping("/findlogin")
    public List findLoginByName(@RequestParam(required = true) String name) {
        System.out.println("findLoginByName.............");
        return userServiceImpl.findLoginByName(name);
    }

    private List loadUser() {
        List list = null;
        SqlSession session = null;
        SqlSessionFactoryBean factory = sqlSessionConfig.createSqlSessionFactory();//getSqlSession();
        try {
            session = factory.getObject().openSession();
             list = session.selectList("findByName", "AC");
            System.out.println(list.size());
            //操作数据时，需要有提交操作
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}
