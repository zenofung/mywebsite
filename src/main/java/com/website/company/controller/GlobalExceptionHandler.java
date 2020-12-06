package com.website.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常拦截器
 * @author pengyangyan
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView MyExceptionErrorHandler(RuntimeException ex) {
        ModelAndView m = new ModelAndView();
        logger.error("MyExceptionErrorHandler info:{}", ex.getMessage());
        m.setViewName("error/404");
        return m;
    }
}
