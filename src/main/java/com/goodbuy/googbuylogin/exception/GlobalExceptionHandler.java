package com.goodbuy.googbuylogin.exception;


import com.goodbuy.googbuylogin.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 异常增强
 * @author: feiWoSCun
 * @Time: 2024/11/6
 * @Email: 2825097536@qq.com
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException e) {
        return generateMsg(e.getBindingResult(), e);
    }

    private Result<?> generateMsg(BindingResult bindingResult, Exception e) {
        StringBuilder errorMsg = new StringBuilder();
        bindingResult.getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        String message = errorMsg.toString();
        log.info("validation parameters error！The reason is:{}", message);
        return Result.fail(ExceptionEnums.PARAM_EXCEPTION);
    }

    /**
     * validation参数校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public Result<?> bindException(BindException e) {
        return generateMsg(e.getBindingResult(), e);
    }
    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Result<?> nullPointerException(NullPointerException e) {

        return Result.fail(ExceptionEnums.NULL_POINTER_EXCEPTION);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result<?> runtimeException(RuntimeException e) {
        log.error("simple exception！The reason is:{}", e.getMessage(), e);
        return Result.fail(500, e.getMessage());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> systemExceptionHandler(Exception e) {
        log.error("system exception！The reason is：{}", e.getMessage(), e);
        return Result.fail(ExceptionEnums.SYSTEM_FAIL);
    }

    /**
     * 处理计算异常
     * @param e @see ComputeException
     * @return computeException
     */
    @ExceptionHandler(value = ComputeException.class)
    public Result<?> computeException(ComputeException e) {
        log.error("compute exception！The reason is：{}", e.getMessage(), e);
        return Result.fail(ExceptionEnums.COMPUTE_FAIL);
    }

}