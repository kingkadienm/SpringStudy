package com.example.demo.bean.response;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-13 21:02
 **/
public class ResponseBean  {

    private int code;
    private String message;
    private Object result;

    public ResponseBean(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
