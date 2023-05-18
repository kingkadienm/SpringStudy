package com.example.demo.config;


import com.example.demo.bean.response.ResponseBean;
import com.example.demo.utils.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author young
 * @date 2022/9/12 15:43
 * @description: 自定义异常配置
 */
@RestControllerAdvice
public class GlobalExceptionConfig {
    @ExceptionHandler(MyException.class)
    public ResponseBean<MyException> handle(MyException e) {
        e.printStackTrace();
        return ResponseBean.exception(e.getCode(), e.getMessage());
    }
}