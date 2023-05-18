package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户
 * @author: wangzs
 * @create: 2022-04-12 23:52
 **/

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "user_name")
    private String userName = null;
    @Column(name = "user_id")
    private String userId = null;
    @Column(name = "user_password")
    private String userPassword = null;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "avatar_url")
    private String avatarUrl = null;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;

    }

}
