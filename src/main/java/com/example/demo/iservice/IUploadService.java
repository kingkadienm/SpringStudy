package com.example.demo.iservice;

import com.example.demo.bean.response.ResponseBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传的
 */
@Component
public interface IUploadService {

    /**
     * 上传头像
     */
    public ResponseBean<String> uploadAvatar(MultipartFile multipartFile,String fileImagesPath);



}
