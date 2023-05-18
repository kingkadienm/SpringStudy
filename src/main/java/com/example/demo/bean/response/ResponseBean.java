package com.example.demo.bean.response;

import com.example.demo.enums.ResponseEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author young
 * @date 2022/8/19 21:52
 * @description: 统一返回结果的类
 */

@Data
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = 56665257248936049L;
    /**
     * 响应码
     **/
    private Integer code;

    /**
     * 返回消息
     **/
    private String message;

    /**
     * 返回数据
     **/
    private T result;

    private ResponseBean() {
    }

    /**
     * 操作成功ok方法
     */
    public static <T> ResponseBean<T> ok(T data) {
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getResultMessage());
        response.setResult(data);
        return response;
    }


    public static <T> ResponseBean<T> error(Integer errCode, String errMessage){
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    /**
     * 编译失败方法
     */
    public static <T> ResponseBean<T> buildFailure(Integer errCode, String errMessage) {
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }


    public static <T> ResponseBean<T> exception(Integer errCode, String errMessage) {
        ResponseBean<T> response = new ResponseBean<>();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
}
