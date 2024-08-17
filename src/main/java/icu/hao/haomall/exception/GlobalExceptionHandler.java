package icu.hao.haomall.exception;

import icu.hao.haomall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(java.lang.Exception.class)
    @ResponseBody
    public Object handleSystemException(java.lang.Exception e) {
        log.error("default exception", e);
        return ApiRestResponse.error(ExceptionEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleSystemException(Exception e) {
        log.error("Exception", e);
        return ApiRestResponse.error(e.getCode(), e.getMessage());
    }
}
