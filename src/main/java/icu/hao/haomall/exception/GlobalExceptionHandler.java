package icu.hao.haomall.exception;

import icu.hao.haomall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        return handleBindingResult(e.getBindingResult());
    }

    private ApiRestResponse handleBindingResult(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                messages.add(defaultMessage);
            }
        }
        if (messages.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.RRQUEST_PARAM_ERROR);
        }
        return ApiRestResponse.error(ExceptionEnum.RRQUEST_PARAM_ERROR.getCode(), messages.toString());
    }

}
