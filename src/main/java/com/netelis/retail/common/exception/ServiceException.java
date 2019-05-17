package com.netelis.retail.common.exception;


import com.netelis.retail.common.i18n.I18nMessage;

/**
 * @author Alan Chen
 * @description 业务异常
 * @date 2019/4/1
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3583566093089790852L;
    private String errorCode = "";

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(I18nMessage yoPointError) {
        super(yoPointError.getMessage());
        this.errorCode = yoPointError.getMessageCode();
    }

    public ServiceException(I18nMessage yoPointError, String msg) {
        super(yoPointError.getMessage()+" "+msg);
        this.errorCode = yoPointError.getMessageCode();
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
