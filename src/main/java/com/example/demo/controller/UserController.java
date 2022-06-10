package com.example.demo.controller;

import com.example.demo.bean.ResponseBean;
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
        return list;
    }

    @RequestMapping("/getByUserName")
    @ResponseBody
    public ResponseBean getByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        ResponseBean responseBean = null;
        if (user == null) {
            responseBean = new ResponseBean(404, "没有该数据", null);
        } else {
            responseBean = new ResponseBean(200, "查询成功", user);
        }
        return responseBean;
    }

}
