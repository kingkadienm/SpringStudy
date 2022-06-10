package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    private String userName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_password")
    private String userPassword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
