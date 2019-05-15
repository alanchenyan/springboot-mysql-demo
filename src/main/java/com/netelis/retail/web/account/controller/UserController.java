package com.netelis.retail.web.account.controller;

import com.netelis.retail.entiy.User;
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
        return userServiceImpl.findByName(name);
    }

    @GetMapping("/findlogin")
    public List findLoginByName(@RequestParam(required = true) String name) {
        System.out.println("findLoginByName.............");
        return userServiceImpl.findLoginByName(name);
    }
}
