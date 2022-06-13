package com.example.demo;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Date 2022/6/13 013 17:44
 * @Created by wangzs
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User use) {

        jdbcTemplate.update("insert into user (name) values(?)", use.getUserName());

    }

}
