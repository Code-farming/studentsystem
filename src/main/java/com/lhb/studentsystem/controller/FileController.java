package com.lhb.studentsystem.controller;

import com.lhb.studentsystem.dto.FileNameDTO;
import com.lhb.studentsystem.mapper.HomeworkMapper;
import com.lhb.studentsystem.mapper.UserMapper;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.result.UploadResult;
import com.lhb.studentsystem.utils.FileDownLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileController {
    String realPath = "d:\\uploadFile";
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;

    @PostMapping("/uploadImage")
    public UploadResult uploadImage(HttpServletRequest request,
                                    @RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile) {
        //创建目录
        File folder = new File(realPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        //更改名字
        String oldName = multipartFile.getOriginalFilename();
        int length = oldName.length();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), length);
        String url = realPath + '\\' + newName;
        //存储文件
        try {
            multipartFile.transferTo(new File(folder, newName));
        } catch (Exception e) {
            e.printStackTrace();
            return UploadResult.error();
        }
        return UploadResult.Success("/ssm/file/get/" + newName);
    }

    @GetMapping("/get/{name}")
    public Object getByName(@PathVariable String name, HttpServletResponse response) {
        String pathName = realPath + "\\" + name;
        File file = new File(pathName);
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            int length = name.length();
            String suffix = name.substring(name.lastIndexOf("."), length);
            response.setStatus(200);
            response.setContentType("image/" + suffix);
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @PostMapping("/uploadFile")
    public ResponseResult uploadFile(HttpServletRequest request,
                                     @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        String userPath = realPath + "\\" + username;
        //创建目录
        File folder = new File(userPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        //更改名字
        String oldName = multipartFile.getOriginalFilename();
        int length = oldName.length();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), length);
        //存储文件
        try {
            multipartFile.transferTo(new File(folder, newName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.Error();
        }
        FileNameDTO fileNameDTO = new FileNameDTO();
        fileNameDTO.setOriginalName(oldName);
        fileNameDTO.setNewName(newName);
        return ResponseResult.Success(0, "上传成功", fileNameDTO);
    }

    @GetMapping("/getFile/{fromId}/{fileName}/{originalName}")
    public Object getFile(HttpServletResponse response, @PathVariable String fileName, @PathVariable String fromId, @PathVariable String originalName) {
        User user = userMapper.findById(fromId);
        String username = user.getUsername();
        String path = realPath + '\\' + username + '\\' + fileName;
        File file = new File(path);
        //根据文件的后缀选择不同的方式
        int length = fileName.length();
        String suffix = fileName.substring(fileName.lastIndexOf("."), length);
        System.out.println(suffix);
        if (suffix.equals(".zip")) {
            FileDownLoad.downloadFile(file,"application/x-download",response);
        } else {
            FileDownLoad.downloadFile(file,"application/msword",response);
        }
        return null;
    }

}
