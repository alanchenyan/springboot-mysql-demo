package com.netelis.retail.common.controller;

import com.netelis.retail.common.service.ICommonStatementService;
import com.netelis.retail.common.vo.StatementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public List list(String statement,String parameter) {
        System.out.println("commonstatement list............."+statement+"  "+parameter);
        return CommonServiceImpl.selectList(statement,parameter);
    }

    @PostMapping("/list")
    public List list(@RequestBody StatementVO statementVO) {
        System.out.println("commonstatement list............."+statementVO);
        return CommonServiceImpl.selectList(statementVO.getStatement(),statementVO.getParameter());
    }

    @PostMapping
    public int add(@RequestBody StatementVO statementVO) {
        System.out.println("commonstatement add............."+statementVO);
        return CommonServiceImpl.insert(statementVO.getStatement(),statementVO.getParameter());
    }
}
