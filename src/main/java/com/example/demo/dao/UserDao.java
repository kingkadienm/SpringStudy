package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Date 2022/6/13 013 17:44
 * @Created by wangzs
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostMapping({"", "add"})
    public String addUser(User userEntity)   {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        Object[] params = new Object[]{id,
                userEntity.getUserName(),
                userEntity.getUserPassword(),
                new Date()};
        jdbcTemplate.update("insert into user(user_id,user_name,user_password,create_time) values(?,?,?,?)", params);
        return id;
    }



}
