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
    ICommonStatementService commonServiceImpl;

    @PostMapping
    public String insert(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement insert.............statementEditVO:" + statementEditVO);
        return commonServiceImpl.insert(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @PutMapping
    public void update(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement update.............statementEditVO:" + statementEditVO);
        commonServiceImpl.update(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @PutMapping("/disable/{statement}/{keyId}")
    public void disableById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement disableById.............statement:" + statement+"  keyId:"+keyId);
        commonServiceImpl.disableById(statement, keyId);
    }

    @PutMapping("/disable")
    public void disable(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement disable.............statementEditVO:" + statementEditVO);
        commonServiceImpl.disable(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @DeleteMapping("/{statement}/{keyId}")
    public void deleteById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement deleteById.............statement:" + statement+"  keyId:"+keyId);
        commonServiceImpl.deleteById(statement, keyId);
    }

    @DeleteMapping
    public void delete(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement delete.............statementEditVO:" + statementEditVO);
        commonServiceImpl.delete(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @GetMapping("/list/{statement}/{parameter}")
    public List list(@PathVariable String statement, @PathVariable Object parameter) {
        logger.debug("commonstatement getOneById.............statement:" + statement+"  parameter:"+parameter);
        return commonServiceImpl.selectList(statement, parameter);
    }

    @PostMapping("/list")
    public List list(@RequestBody StatementSearchVO statementVO) {
        logger.debug("commonstatement list.............statementVO:" + statementVO);
        return commonServiceImpl.selectList(statementVO.getStatement(), statementVO.getParameter());
    }

    @GetMapping("/{statement}/{keyId}")
    public Object getOneById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement getOneById.............statement:" + statement+"  keyId:"+keyId);
        return commonServiceImpl.selectList(statement, keyId);
    }
}
