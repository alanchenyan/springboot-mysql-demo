package com.netelis.retail.rpc.statement.controller;

import com.netelis.retail.rpc.statement.service.IRpcStatementService;
import com.netelis.retail.rpc.statement.vo.StatementEditVO;
import com.netelis.retail.rpc.statement.vo.StatementSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "1.0", description = "远程接口调用", value = "远程接口调用")
@RestController
@RequestMapping("/rpc/statement")
public class RpcStatementController {

    private Logger logger = LoggerFactory.getLogger(RpcStatementController.class);

    @Autowired
    IRpcStatementService rpcStatementServiceImpl;

    @ApiOperation("调用新增数据接口")
    @PostMapping
    public String insert(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement insert.............statementEditVO:" + statementEditVO);
        return rpcStatementServiceImpl.insert(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @ApiOperation("调用修改数据接口")
    @PutMapping
    public void update(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement update.............statementEditVO:" + statementEditVO);
        rpcStatementServiceImpl.update(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @ApiOperation("调用disable(逻辑删除)数据接口")
    @PutMapping("/disable/{statement}/{keyId}")
    public void disableById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement disableById.............statement:" + statement+"  keyId:"+keyId);
        rpcStatementServiceImpl.disableById(statement, keyId);
    }

    @ApiOperation("调用disable(逻辑删除)数据接口")
    @PutMapping("/disable")
    public void disable(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement disable.............statementEditVO:" + statementEditVO);
        rpcStatementServiceImpl.disable(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @ApiOperation("调用物理删除数据接口")
    @DeleteMapping("/{statement}/{keyId}")
    public void deleteById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement deleteById.............statement:" + statement+"  keyId:"+keyId);
        rpcStatementServiceImpl.deleteById(statement, keyId);
    }

    @ApiOperation("调用物理删除数据接口")
    @DeleteMapping
    public void delete(@RequestBody StatementEditVO statementEditVO) {
        logger.debug("commonstatement delete.............statementEditVO:" + statementEditVO);
        rpcStatementServiceImpl.delete(statementEditVO.getStatement(), statementEditVO.getEntity());
    }

    @ApiOperation("调用数据列表接口")
    @GetMapping("/list/{statement}/{parameter}")
    public List list(@PathVariable String statement, @PathVariable Object parameter) {
        logger.debug("commonstatement getOneById.............statement:" + statement+"  parameter:"+parameter);
        return rpcStatementServiceImpl.selectList(statement, parameter);
    }

    @ApiOperation("调用数据列表接口")
    @PostMapping("/list")
    public List list(@RequestBody StatementSearchVO statementVO) {
        logger.debug("commonstatement list.............statementVO:" + statementVO);
        return rpcStatementServiceImpl.selectList(statementVO.getStatement(), statementVO.getParameter());
    }

    @ApiOperation("调用数据项接口")
    @GetMapping("/{statement}/{keyId}")
    public Object getOneById(@PathVariable String statement, @PathVariable String keyId) {
        logger.debug("commonstatement getOneById.............statement:" + statement+"  keyId:"+keyId);
        return rpcStatementServiceImpl.selectOne(statement, keyId);
    }
}
