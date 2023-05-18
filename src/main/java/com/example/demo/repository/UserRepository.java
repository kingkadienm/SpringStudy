package com.example.demo.repository;

import com.example.demo.bean.QueryUserBean;
import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-12 23:58
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Transactional
    @Query("SELECT new com.example.demo.bean.QueryUserBean(u.userName, u.userId, u.createTime)  FROM User u WHERE u.userId = :inputUserId")
    List<QueryUserBean> findUserByUserId(@Param("inputUserId") String inputUserId);

//    @Query("select u.userName,u.userId,u.createTime,u.avatarUrl from User u where u.userId=:userID")
//    List<User> findUserByUserId(@Param("userID") String userID);


    @Query("select u.userName,u.userId,u.createTime,u.avatarUrl from User u where u.userName = :inputUserId")
    List<User> findUserByUserName(@Param("inputUserId") String userID);


}
