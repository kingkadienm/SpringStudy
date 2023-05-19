package com.example.demo.service;

import com.example.demo.bean.response.ResponseBean;
import com.example.demo.iservice.IUploadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Log4j2
@Component
public class UploadService implements IUploadService {


    @Override
    public ResponseBean<String> uploadAvatar(MultipartFile multipartFile,String fileImagesPath) {
        // 1、获取真实文件名
        String originalFilename = multipartFile.getOriginalFilename();
        // 2、截取图片的后缀 lastIndexOf最后出现.的位置
        String imgSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 3、生成唯一文件名
        String newFileName = UUID.randomUUID().toString() + imgSuffix;
        // 4、日期目录
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dataPath = dateFormat.format(new Date());
        // 5、指定文件上传后的目录
        String uploadPath = System.getProperty("user.dir") + fileImagesPath;
        log.info("图片上传位置:{}", uploadPath);
        File targetPath = new File(uploadPath, dataPath); // 拼接成新目录
        // mkdirs:不存在则创建，mkdir:不存在则返回false
        if (!targetPath.exists()) targetPath.mkdirs(); // 如果目录不存在，则递归创建
        // 6、指定文件上传后的服务器完整路径[包括文件名]
        File TargetFileName = new File(targetPath, newFileName);
        // 7、文件上传到指定目录
        try {
            multipartFile.transferTo(TargetFileName); // 文件上传到指定目录
            System.out.println(TargetFileName);
            String finalFileName = dataPath + "/" + newFileName;
//            resultMsg = request.getScheme() + "://" + request.getServerName() + ":" +
//                    request.getServerPort() + "/uploadFile/" + format + newName;
            return ResponseBean.ok(uploadPath + "/" + finalFileName); // 返回可访问的地址
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseBean.ok("失败");
        }
    }
}
