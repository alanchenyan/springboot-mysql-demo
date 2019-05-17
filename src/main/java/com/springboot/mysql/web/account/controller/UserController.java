package com.springboot.mysql.web.account.controller;

import com.springboot.mysql.entiy.User;
import com.springboot.mysql.web.account.search.UserSearch;
import com.springboot.mysql.web.account.service.IUserService;
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
    public String save(@RequestBody User user) {
        return userServiceImpl.insertUser(user);
    }

    @GetMapping
    public List getUser(UserSearch userSearch) {
        return userServiceImpl.findUser(userSearch);
    }

    @GetMapping("/{keyId}")
    public User getOneUser(@PathVariable String keyId) {
        return userServiceImpl.getOneUser(keyId);
    }

    @GetMapping("/rpc/{keyId}")
    public User getOneUserByRpc(@PathVariable String keyId) {
        return userServiceImpl.getOneUserByRpc(keyId);
    }
}
