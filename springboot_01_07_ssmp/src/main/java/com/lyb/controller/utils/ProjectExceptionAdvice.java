package com.lyb.controller.utils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R daException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        return new R("服务器故障,请稍后再试");
    }
}
