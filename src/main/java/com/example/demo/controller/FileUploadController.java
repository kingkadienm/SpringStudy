package com.example.demo.controller;


import com.example.demo.bean.response.ResponseBean;
import com.example.demo.iservice.IUploadService;
import com.example.demo.tools.PassToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
@RequestMapping("/upload")
public class FileUploadController {


    @Autowired
    IUploadService iUploadService;

    @Value("${file.images.path}")
    String fileImagesPath;
    @PassToken
    @PostMapping("/avatar")
    public ResponseBean<String> uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
       return iUploadService.uploadAvatar(multipartFile,fileImagesPath);
    }
}

