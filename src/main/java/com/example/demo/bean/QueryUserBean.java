package com.example.demo.bean;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class QueryUserBean implements Serializable {
    private String userName;
    private String userId;
    private Date date;

    public QueryUserBean(String userName, String userId, Date date) {
        this.userName = userName;
        this.userId = userId;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
