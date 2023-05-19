package com.example.demo.service;

import com.example.demo.bean.response.ResponseBean;
import com.example.demo.iservice.IDownloadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Log4j2
@Component
public class DownloadService implements IDownloadService {
    @Override
    public ResponseBean<String> downloadAvatar(String downloadName, HttpServletResponse response, String fileImagesPath) {
        log.info("request param: {}", downloadName);

        try {
            String realPath = System.getProperty("user.dir") + fileImagesPath;
            System.out.println(realPath);
            // 获得文件输入流
            FileInputStream inputStream = new FileInputStream(new File(realPath, downloadName));
            // 设置响应头、以附件形式打开文件
            response.setHeader("content-disposition", "attachment; fileName=" + downloadName);
            ServletOutputStream outputStream = response.getOutputStream();
            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            outputStream.close();
            inputStream.close();
            return ResponseBean.ok("下载成功");
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
            return ResponseBean.error(400, "下载失败,请检查路径");
        }
    }
}
