package com.example.demo.controller;

import cn.hutool.core.text.CharSequenceUtil;
import com.example.demo.dao.UserDao;
import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.enums.ResponseEnum;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import com.example.demo.tools.PassToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-13 00:01
 **/
@RestController
@Log4j2
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserDao userDao;

    //    @Qualifier("IUserService")
    @Autowired
    private IUserService iUserService;

    @PostMapping("/getAllUser")
    @ResponseBody

    public ResponseBean<List<User>> findAll() {
        List<User> list = userRepository.findAll();
        ResponseBean<List<User>> responseBean = null;
        if (list == null) {
            responseBean = ResponseBean.error(ResponseEnum.SUCCESS.getCode(), "没有该数据");
        } else {
            responseBean = ResponseBean.ok(list);
        }
        return responseBean;
    }

//    @RequestMapping(value = "/getByUserName", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseBean getByUserName(ReceiveBean receiveBean) {
//        User user = userRepository.findUserByUserId(receiveBean.getUserName());
//        ResponseBean responseBean = null;
//        if (user == null) {
//            responseBean = new ResponseBean(404, "没有该数据", null);
//        } else {
//            responseBean = new ResponseBean(200, "查询成功", user);
//        }
//        return responseBean;
//    }

    @PostMapping(value = "/register")
    @ResponseBody
    @PassToken
    public ResponseBean<User> registerUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        log.info("========registerUser=" + userName);
        log.info("========registerUser=" + password);
        if (CharSequenceUtil.isBlank(userName) || CharSequenceUtil.isBlank(password)) {
            return ResponseBean.error(200, "账号密码不能为空");
        }
        return iUserService.registerUser(userName, password);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    @PassToken
    public ResponseBean<User> loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {

        if (CharSequenceUtil.isBlank(userName) || CharSequenceUtil.isBlank(password)) {

            return ResponseBean.error(200, "账号密码不能为空");
        }

        return iUserService.login(userName, password);
    }

}
