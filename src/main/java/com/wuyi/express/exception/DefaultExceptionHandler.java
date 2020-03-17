package com.wuyi.express.exception;

import com.wuyi.express.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author Joetao
 * 异常处理类
 * controller层异常无法捕获处理，需要自己处理
 * Created at 2018/8/27.
 */
@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    /**
     * 处理所有自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public CommonResult handleOrderException(BaseException e){
        log.error(e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult handlerException(Exception e) {
        if (e instanceof ConstraintViolationException) {
            log.error("【全局异常拦截】ConstraintViolationException", e);
            return CommonResult.failed(e.getMessage());
        }
        log.error("【全局异常拦截】 Exception", e);
        log.error("【全局异常拦截】: 异常信息 {} ", e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

}
