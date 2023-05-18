package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.request.ReceiveBean;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public ResponseBean registerUser(@RequestBody ReceiveBean receiveBean) {
        String userName = receiveBean.getUserName();
        log.info("========="+receiveBean.getUserName());
        List<User> user = userRepository.findUserByUserName(userName);
        for (User user1 : user) {
            log.error(user1.toString());
        }
        ResponseBean responseBean = null;

//        if (user == null) {
//            String id = UUID.randomUUID().toString().replaceAll("-", "");
//            User user1 = new User(userName, receiveBean.getUserPassword());
//            user1.setId(55L);
//            user1.setUserId(id);
//            user1.setCreateTime(new Date());
//            User save = userRepository.save(user1);
//            responseBean = new ResponseBean(200, "注册成功", save);
//        } else {
//        }
            responseBean = new ResponseBean(404, "该用户已经存在", user);
        return responseBean;
    }
}
