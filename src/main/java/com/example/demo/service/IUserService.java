package com.example.demo.service;

import com.example.demo.bean.response.ResponseBean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public interface IUserService {

    public ResponseBean loginCheck(HttpServletRequest request);

    public ResponseBean getLoginInfo();

    public ResponseBean loginUser();

}
