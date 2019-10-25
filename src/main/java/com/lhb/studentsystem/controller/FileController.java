package com.lhb.studentsystem.controller;

import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.result.UploadResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileController {
    String realPath="d:\\uploadFile";

    @PostMapping("/uploadImage")
    public UploadResult uploadImage(HttpServletRequest request,
                                      @RequestParam(value = "editormd-image-file",required = false) MultipartFile multipartFile){
        //创建目录
        File folder = new File(realPath);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        //更改名字
        String oldName = multipartFile.getOriginalFilename();
        int length = oldName.length();
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."), length);
        String url = realPath + '\\' + newName;
        //存储文件
        try {
            multipartFile.transferTo(new File(folder,newName));
        } catch (Exception e) {
            e.printStackTrace();
            return UploadResult.error();
        }
        return UploadResult.Success("/ssm/file/get/"+newName);
    }

    @GetMapping("/get/{name}")
    public Object getByName(@PathVariable String name, HttpServletResponse response){
        String pathName = realPath + "\\" + name;
        File file = new File(pathName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            int length = name.length();
            String suffix = name.substring(name.lastIndexOf("."), length);
            response.setStatus(200);
            response.setContentType("image/"+suffix);
            ServletOutputStream outputStream=response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/uploadFile")
    public ResponseResult uploadFile(HttpServletRequest request,
                                     @RequestParam(value = "file",required = false) MultipartFile multipartFile){
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        String userPath = realPath+"\\"+username;
        //创建目录
        File folder = new File(userPath);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        //更改名字
        String oldName = multipartFile.getOriginalFilename();
        int length = oldName.length();
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."), length);
        //存储文件
        try {
            multipartFile.transferTo(new File(folder,newName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.Error();
        }
        return ResponseResult.Success(0,"上传成功",newName);
    }
}
