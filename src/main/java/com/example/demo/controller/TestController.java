package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.repository.UserRepository;
import com.example.demo.tools.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("test")
public class TestController {


    @Autowired
    private RedisTemplate redisTemplate;

    @PassToken
    @RequestMapping("/login")
    public String getLogin() {
        redisTemplate.opsForValue().set("test/login", "ddddd");
        return "33333";
    }

    @PassToken
    @RequestMapping("")
    public Object getRedisValue() {
        return redisTemplate.opsForValue().get("test/login");

    }


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        list = userRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public User findUserNameAndUserIdByUserId(@RequestBody ReceiveBean userID) {
        return userRepository.findUserByUserId(userID.getUserID());
    }
}
