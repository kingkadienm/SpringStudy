package com.example.demo.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description: log
 * @author: wangzs
 * @create: 2022-04-14 22:52
 **/
public class LogUtils {
    private static final Log log = LogFactory.getLog(LogUtils.class);

    public static void printLog(String message){
         log.debug(message);
    }

}
