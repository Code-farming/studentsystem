package com.lhb.studentsystem.controller;

import com.alibaba.fastjson.JSON;
import com.lhb.studentsystem.dto.UpdatePassDTO;
import com.lhb.studentsystem.dto.UserDTO;
import com.lhb.studentsystem.mapper.UserMapper;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.result.TableResult;
import com.lhb.studentsystem.service.UserService;
import com.lhb.studentsystem.service.UserWorkService;
import com.lhb.studentsystem.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private UserMapper userMapper;

    String realPath = "d:\\uploadFile";

    @PostMapping("/login")
    public ResponseResult login(@RequestBody String json, HttpServletRequest request) throws Exception {
        User user = JSON.parseObject(json, User.class);
        ResponseResult responseResult = userService.loginUser(user);
        User user1 = userService.getUser(user.getId());
        request.getSession().setAttribute("user", user1);
        return responseResult;
    }

    @PostMapping("/updatePass")
    public ResponseResult updatePass(@RequestBody String json, HttpServletRequest request) {
        UpdatePassDTO updatePassDTO = JSON.parseObject(json, UpdatePassDTO.class);
        ResponseResult responseResult = userService.updatePassWord(updatePassDTO);
        return responseResult;
    }

    @RequestMapping("/logout")
    public ResponseResult logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        ResponseResult responseResult = ResponseResult.Success(200, "退出成功", null);
        return responseResult;
    }

    @RequestMapping("/findAllUser")
    public TableResult findAllUser(HttpServletRequest request) {
        List<User> allUser = userMapper.findAllUser();
        List<UserDTO> userDTOList=new ArrayList<>();
        TableResult tableResult = new TableResult();
        tableResult.setCount(allUser.size());
        for (User user : allUser) {
            Integer roleId = user.getRoleId();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            switch (roleId){
                case 1:
                    userDTO.setRole("普通学生");
                    break;
                case 2:
                    userDTO.setRole("课代表");
                    break;
                case 3:
                    userDTO.setRole("班长");
                    break;
            }
            userDTOList.add(userDTO);
        }
        tableResult.setData(userDTOList);
        return tableResult;
    }


    @PostMapping("/uploadWork")
    public ResponseResult uploadWork(HttpServletRequest request,
                                     @RequestParam(value = "file") MultipartFile multipartFile,
                                     @RequestParam("fromId") String fromId,
                                     @RequestParam("title") String title,
                                     String username,
                                     String userId,
                                     Integer workId) {
        System.out.println(title);
        String originalFilename = multipartFile.getOriginalFilename();
        User user = userMapper.findById(fromId);
        String fromName = user.getUsername();
        System.out.println(username);
        System.out.println(userId);

        //为课代表创建一个存放对应作业的目录
        String path = realPath + '\\' + fromName + '\\' + title;

        //学生作业的上传操作
        int length = originalFilename.length();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), length);
        String newName = userId + '-' + username + '-' + title + suffix;
        boolean b = FileUpload.uploadWork(path, newName, multipartFile);
        if (b) {
            userWorkService.createOrUpdateFile(newName,userId,workId);
            return ResponseResult.Success(200, "上传成功", null);
        }
        return ResponseResult.Error();
    }

}
