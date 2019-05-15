package com.netelis.retail.common.controller;

import com.netelis.retail.common.service.ICommonStatementService;
import com.netelis.retail.common.vo.StatementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    //getUser(@RequestParam(required = true) String statement,@RequestParam Object parameter)
    @GetMapping("/getlist")
    public List getUser(StatementVO statementVO) {
        System.out.println("commonstatement getlist.............");
        return CommonServiceImpl.selectList(statementVO.getStatement(),statementVO.getParameter());
    }
}
