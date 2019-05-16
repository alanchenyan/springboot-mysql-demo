package com.netelis.retail.web.account.controller;

import com.netelis.retail.entiy.User;
import com.netelis.retail.web.account.search.UserSearch;
import com.netelis.retail.web.account.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public int save(@RequestBody User user) {
        return userServiceImpl.insertUser(user);
    }

    @GetMapping
    public List getUser(UserSearch userSearch) {
        System.out.println("getUser.............");
        return userServiceImpl.findUser(userSearch);
    }

    @GetMapping("/findlogin")
    public List findLoginByName(@RequestParam(required = true) String parameter) {
        System.out.println("findLoginByName.............");
        return userServiceImpl.findLoginByName(parameter);
    }
}
