package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String userName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "token")
    private String token;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;

    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createTime=" + createTime +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
