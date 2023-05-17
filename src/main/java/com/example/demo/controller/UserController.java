package com.example.demo.controller;

import com.example.demo.UserDao;
import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private UserDao userDao;

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public ResponseBean findAll() {
        List<User> list = userRepository.findAll();
        ResponseBean responseBean = null;
        if (list == null) {
            responseBean = new ResponseBean(404, "没有该数据", null);
        } else {
            responseBean = new ResponseBean(200, "查询成功", list);
        }
        return responseBean;
    }

    @RequestMapping(value = "/getByUserName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getByUserName(ReceiveBean receiveBean) {
        User user = userRepository.findUserByUserName(receiveBean.getUserName());
        ResponseBean responseBean = null;
        if (user == null) {
            responseBean = new ResponseBean(404, "没有该数据", null);
        } else {
            responseBean = new ResponseBean(200, "查询成功", user);
        }
        return responseBean;
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseBean registerUser(@RequestBody ReceiveBean receiveBean) {
        String userName = receiveBean.getUserName();
        User user = userRepository.findUserByUserName(userName);
        ResponseBean responseBean = null;
        if (user == null) {
            userDao.save(new User(userName));
            responseBean = new ResponseBean(200, "没有该数据", null);
        } else {
            responseBean = new ResponseBean(404, "该用户已经存在", user);
        }
        return responseBean;
    }

    @RequestMapping("/")
    @ResponseBody
    public ResponseBean loginUser(@RequestBody ReceiveBean receiveBean, HttpServletRequest request) {

        ResponseBean responseBean = iUserService.loginCheck(request);




        return iUserService.loginUser();
    }

}
