package com.goodbuy.googbuylogin.login.exception;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/06
 * @Email: 2825097536@qq.com
 * @description:
 */
public class ComputeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    public ComputeException() {
        super();
    }

    public ComputeException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public ComputeException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ComputeException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ComputeException (ExceptionEnums error) {
        super();
        this.errorCode=error.code();
        this.errorMsg=error.message();

    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
