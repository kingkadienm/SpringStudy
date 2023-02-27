package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        //日志的级别
        //由低到高 trace<debug<info<warn<error
        //可以调整需要输出的日志级别，日志就只会在这个级别以后的高级别生效
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用springboot默认规定的级别：root级别
        logger.info("这是info日志");
        logger.warn("这是warn信息");
        logger.error("这是error日志");
    }

    @Test
    public void testJdbc() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        maps.forEach(System.out::println);
    }


}
