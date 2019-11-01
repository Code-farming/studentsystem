package com.lhb.studentsystem.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileDownLoad {

    public static void downloadFile(File file, String contentType, HttpServletResponse response) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = bufferedInputStream.read(buffer);
            while (i != -1) {
                outputStream.write(buffer, 0, i);
                i = bufferedInputStream.read(buffer);
            }
            System.out.println("下载成功");
            response.setStatus(200);
            response.setContentType(contentType);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
