package com.example.demo.bean.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.Query;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-13 22:09
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ReceiveBean extends Query {


    @JsonProperty("user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
