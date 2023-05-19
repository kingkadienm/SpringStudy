package com.example.demo.controller;

import com.example.demo.bean.response.ResponseBean;
import com.example.demo.iservice.IDownloadService;
import com.example.demo.tools.PassToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/download")
@Log4j2
public class FileDownloadController {

    @Value("${file.images.path}")
    String fileImagesPath;

    @Autowired
    private IDownloadService iDownloadService;

    @PassToken
    @GetMapping("/avatar")
    public ResponseBean<String> downloadAvatar(@RequestParam("downloadName") String downloadName, HttpServletResponse response) {
     return    iDownloadService.downloadAvatar(downloadName, response,fileImagesPath);
    }
}