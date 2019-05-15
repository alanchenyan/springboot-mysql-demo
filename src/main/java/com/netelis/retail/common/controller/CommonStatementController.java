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


    @PostMapping("/list")
    public List getUser(@RequestBody StatementVO statementVO) {
        System.out.println("commonstatement list............."+statementVO);
        return CommonServiceImpl.selectList(statementVO.getStatement(),statementVO.getParameter());
    }
}
