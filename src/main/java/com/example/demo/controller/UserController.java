package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.log.LogUtils;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean findAll() {
        ResponseBean responseBean = new ResponseBean();
        List<User> list = new ArrayList<>();
        list = userRepository.findAll();
        responseBean.setCode(200);
        responseBean.setMessage("success ");
        responseBean.setResult(list);
        LogUtils.printLog(list.toString());
        return responseBean;
    }


    @PostMapping(value = "/getByUserName",
            consumes = "application/json"
//            headers = "User-Agent=Android"
    )
    @ResponseBody
    public ResponseBean getByUserName(@RequestBody ReceiveBean receiveBean) {
        String userName = receiveBean.getUserName();
        System.out.println(userName);
        User user = userRepository.findUserByUserName(userName);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setMessage("success");
        responseBean.setResult(user);
        return responseBean;
    }

}
