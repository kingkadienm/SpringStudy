package com.example.demo.controller;

import com.example.demo.bean.QueryUserBean;
import com.example.demo.bean.User;
import com.example.demo.log.LogUtils;
import com.example.demo.repository.UserRepository;
import com.example.demo.tools.PassToken;
import com.example.demo.tools.UserLoginToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("test")
public class TestController {


    @PassToken
    @RequestMapping("/login")
    public String getLogin() {
        return "33333";
    }

    @Autowired
    private UserRepository userRepository;

    @UserLoginToken
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        list = userRepository.findAll();
        return list;
    }

    @RequestMapping("/getUser")
    public List<QueryUserBean> findUserNameAndUserIdByUserId(String userID) {
        return userRepository.findUserByUserId(userID);
    }
}
