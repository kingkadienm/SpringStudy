package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import org.springframework.web.bind.annotation.RequestBody;


public interface IUserService {

    public ResponseBean<User> login(String userName, String password);

    public ResponseBean<User> getLoginInfo();



    ResponseBean<User> registerUser(String userName, String password);

}
