package com.nan19.controller;

import com.nan19.pojo.Result;
import com.nan19.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        // TODO 把文件内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        // 保证文件的名字是唯一的，从而防止文件覆盖
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // file.transferTo(new File("/Users/nanlu/Desktop/Web/files/" + filename));
        String url = AliOssUtil.puloadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}
