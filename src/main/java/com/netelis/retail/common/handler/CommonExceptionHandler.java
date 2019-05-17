package com.netelis.retail.common.handler;

import com.netelis.retail.common.exception.DatabaseException;
import com.netelis.retail.common.exception.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author Alan Chen
 * @description 全局异常管理类
 * @date 2019/1/4
 */
@ControllerAdvice
public class CommonExceptionHandler {


    /**
     * 拦截 自定义ServiceException异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(ServiceException e){
        return new ResponseMessage(e.getErrorCode(),e.getMessage());
    }

    /**
     * 拦截JSR validator校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(ConstraintViolationException e){
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder stringBuilder  = new StringBuilder();
        for (ConstraintViolation<?> item : violations) {
            stringBuilder.append(item.getMessage()).append(";");
            System.out.println(item.getMessage());
        }
        return new ResponseMessage("ConstraintViolationException",stringBuilder.toString());
    }


    /**
     * DataBase constraint 校验
     * 如：ERROR: duplicate key value violates unique constraint "rolname"
     * @param e
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(DataIntegrityViolationException e){
        return new ResponseMessage("DataIntegrityViolationException",e.getMessage());
    }

    /**
     * 数据库异常
     * @param e
     * @return
     */
    @ExceptionHandler(DatabaseException.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(DatabaseException e){
        return new ResponseMessage("DatabaseException",e.getMessage());
    }


    /**
     * 拦截Exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(Exception e){
        return new ResponseMessage("Exception",e.getMessage());
    }

}