package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-13 00:01
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        list = userRepository.findAll();
        System.out.println("================");
        return list;
    }

    @RequestMapping("/getByUserName")
    @ResponseBody
    public User getByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        return user;
    }

}
