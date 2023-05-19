package com.example.demo.iservice;

import com.example.demo.bean.response.ResponseBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Component
public interface IDownloadService {


    /**
     * 头像下载
     *
     * @param downloadName
     * @param response
     * @param fileImagesPath
     */
    public ResponseBean<String> downloadAvatar(String downloadName, HttpServletResponse response, String fileImagesPath);


}
