package com.example.demo.service;

import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;


public interface IUserService {

    public ResponseBean loginCheck(HttpServletRequest request);

    public ResponseBean getLoginInfo();

    public ResponseBean loginUser();

    ResponseBean registerUser(@RequestBody ReceiveBean receiveBean);

}
