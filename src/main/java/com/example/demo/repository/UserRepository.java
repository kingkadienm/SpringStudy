package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @description:
 * @author: wangzs
 * @create: 2022-04-12 23:58
 **/
public interface UserRepository extends JpaRepository<User,Long>{

    User findUserByUserName(String userName);
}
