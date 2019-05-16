package com.netelis.retail.common.controller;

import com.netelis.retail.common.service.ICommonStatementService;
import com.netelis.retail.common.vo.StatementEditVO;
import com.netelis.retail.common.vo.StatementSearchVO;
import org.apache.ibatis.annotations.Update;
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
    public List list(@RequestBody StatementSearchVO statementVO) {
        System.out.println("commonstatement list............."+statementVO);
        return CommonServiceImpl.selectList(statementVO.getStatement(),statementVO.getParameter());
    }

    @PostMapping
    public Long insert(@RequestBody StatementEditVO statementEditVO) {
        System.out.println("commonstatement insert............."+statementEditVO);
        return CommonServiceImpl.insert(statementEditVO.getStatement(),statementEditVO.getEntity());
    }

    @PutMapping
    public void update(@RequestBody StatementEditVO statementEditVO) {
        System.out.println("commonstatement update............."+statementEditVO);
         CommonServiceImpl.update(statementEditVO.getStatement(),statementEditVO.getEntity());
    }
}
