package com.website.company.utils;


import cn.hutool.core.util.IdUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description: 
 *          ________
 *          ___  __/______________
 *          __  /_ ___  __ \  ___/
 *          _  __/ __  /_/ / /__
 *          /_/    _  .___/\___/
 *                 /_/
 * @author: www.fpcs.top
 *
 * @create: 2021-03-02 13:57
 */

public class ImageUploadUtil {
    public static String uploadImage(MultipartFile file, String uploadPath, String accessPath){
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
        if(!fileSuffix.equals(".jpg") && !fileSuffix.equals(".jpeg") && !fileSuffix.equals(".png") && !fileSuffix.equals(".gif")){
            throw new RuntimeException("请上传图片");
        }
        //唯一id
        String uuid = IdUtil.randomUUID();
        File newFile = new File(uploadPath + uuid + fileSuffix);
        try {
            FileUtils.writeByteArrayToFile(newFile, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessPath + uuid + fileSuffix;
    }
    
}