package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestController {
    @RequestMapping("/login")
    public String getLogin(){
        return "111111111111";
    }
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
}
