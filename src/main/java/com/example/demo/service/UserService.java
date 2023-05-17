package com.example.demo.service;

import com.example.demo.bean.response.ResponseBean;

import javax.servlet.http.HttpServletRequest;

public class UserService implements IUserService {
    @Override
    public ResponseBean loginCheck(HttpServletRequest request) {
        request.getHeader("");

        return null;
    }

    @Override
    public ResponseBean getLoginInfo() {
        return null;
    }

    @Override
    public ResponseBean loginUser() {
        return null;
    }
}
