package com.lhb.studentsystem.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {


    public static boolean uploadWork(String path, String newName, MultipartFile multipartFile) {
        //创建文件
        File folder=new File(path);
        //如果作业是第一次提交的话，就会新建一个目录
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        try {
            multipartFile.transferTo(new File(folder,newName));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
