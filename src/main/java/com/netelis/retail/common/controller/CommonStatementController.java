package com.netelis.retail.common.controller;

import com.netelis.retail.common.service.ICommonStatementService;
import com.netelis.retail.common.vo.StatementEditVO;
import com.netelis.retail.common.vo.StatementSearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(CommonStatementController.class);

    @Autowired
    ICommonStatementService CommonServiceImpl;

    @GetMapping("/{statement}/{parameter}")
    public List list(@PathVariable String statement, @PathVariable Object parameter) {
        logger.debug("commonstatement list............." + statement + "  " + parameter);
        return CommonServiceImpl.selectList(statement, parameter);
    }

    @PostMapping("/list")
    public List list(@RequestBody StatementSearchVO statementVO) {
        logger.debug("commonstatement list............." + statementVO);
        return CommonServiceImpl.selectList(statementVO.getStatement(), statementVO.getParameter());
    }

    @PostMapping
    public String insert(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement insert............." + statementEditVO);
        return CommonServiceImpl.insert(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @PutMapping
    public void update(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement update............." + statementEditVO);
        CommonServiceImpl.update(statementEditVO.getStatement(), statementEditVO.getEntity());
    }


    @DeleteMapping("/{statement}/{id}")
    public void deleteById(@PathVariable String statement, @PathVariable Long id) {
        logger.debug("commonstatement deleteById............." + id);
        CommonServiceImpl.deleteById(statement, id);
    }

    @DeleteMapping
    public void delete(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement delete............." + statementEditVO);
        CommonServiceImpl.delete(statementEditVO.getStatement(), statementEditVO.getEntity());
    }
}
