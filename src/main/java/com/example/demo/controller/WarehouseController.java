package com.example.demo.controller;

import com.example.demo.bean.WarehouseBean;
import com.example.demo.bean.request.WarehouseRequestBean;
import com.example.demo.bean.response.ResponseBean;
import com.example.demo.repository.WarehouseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wangzs
 * @create: 2023/6/16 16:39
 **/

@RestController
@RequestMapping("/warehouse")
@Log4j2
public class WarehouseController {


    @Autowired
    private WarehouseRepository repository;

    @RequestMapping("/saveGoods")
    public ResponseBean saveGoods(@RequestBody WarehouseRequestBean bean){

        log.info(bean.toString());


        return ResponseBean.ok("okkkkk");
    }


}
