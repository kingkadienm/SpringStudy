package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.enums.ResponseEnum;
import com.example.demo.iservice.IUserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.SM4Utils;
import com.example.demo.utils.TokenUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Log4j2
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseBean<User> login(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);
        String encryptPassword = SM4Utils.encrypt(password);
        if (user == null) {
            return ResponseBean.error(ResponseEnum.USER_EX.getCode(), "用户不存在");

        } else if (user.getUserPassword().contentEquals(encryptPassword)) {
            String token = TokenUtils.getToken(user.getUserId(), encryptPassword);
            user.setToken(token);
            userRepository.save(user);
            user.setUserPassword(null);
            return ResponseBean.ok(user);
        } else {
            return ResponseBean.error(ResponseEnum.SUCCESS.getCode(), "账号或密码错误");
        }

    }

    @Override
    public ResponseBean<User> getLoginInfo() {
        return null;
    }


    @Override
    public ResponseBean<User> registerUser(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);
        ResponseBean<User> responseBean = null;
        if (user == null) {
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String encryptPassword = SM4Utils.encrypt(password);
            User user1 = new User(userName, encryptPassword);
            user1.setId(55L);
            user1.setUserId(id);
            user1.setCreateTime(new Date());
            user1.setToken("");
            user1.setAvatarUrl("");
            user1.setUserPassword("");
            User save = userRepository.save(user1);
            responseBean = ResponseBean.ok(save);

        } else {
            user.setUserPassword(null);
            log.info(user.toString());
            responseBean = ResponseBean.error(200, "该用户已注册");
        }
        return responseBean;
    }
}
