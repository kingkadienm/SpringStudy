package com.example.demo.log;

import com.example.demo.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: log
 * @author: wangzs
 * @create: 2022-04-14 22:52
 **/
public class LogUtils {
    static Logger log;

   static  {
        log = LoggerFactory.getLogger(LogUtils.class);
    }


    public static void printLog(String message) {
        log.debug(message);
    }

}
