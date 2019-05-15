package com.netelis.retail.common.controller;

import com.netelis.retail.common.service.ICommonStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/15
 */
@RestController
@RequestMapping("/commonstatement")
public class CommonStatementController {

    @Autowired
    ICommonStatementService CommonServiceImpl;


    @GetMapping("/getlist")
    public List getUser(@RequestParam(required = true) String statement,@RequestParam(required = true) String name) {
        System.out.println("commonstatement getlist.............");
        return CommonServiceImpl.selectList(statement,name);
    }
}
