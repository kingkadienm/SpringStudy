package com.example.demo;
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
    @Test
    void contextLoads() {
    }

    @Test
    public void testJdbc() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        maps.forEach(System.out::println);
    }
}
