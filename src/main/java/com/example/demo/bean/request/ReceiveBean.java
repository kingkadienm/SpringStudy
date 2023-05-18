package com.example.demo.bean.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.Query;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-13 22:09
 **/


@NoArgsConstructor
@Data
@AllArgsConstructor
public class ReceiveBean {


    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userPassword")
    private String userPassword;
    @JsonProperty("userID")
    private String userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "ReceiveBean{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
