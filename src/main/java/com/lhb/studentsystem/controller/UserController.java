package com.lhb.studentsystem.controller;

import com.alibaba.fastjson.JSON;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.provider.SchoolProvider;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody String json, HttpServletRequest request) throws Exception {
        User user = JSON.parseObject(json, User.class);
        ResponseResult responseResult = userService.loginUser(user);
        String userName = userService.getUserName(user.getId());
        request.getSession().setAttribute("user", userName);
        return responseResult;
    }

    @RequestMapping("get/{id}")
    public ResponseResult getUserById(@PathVariable int id, HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("user");
        if (user != null) {
            return ResponseResult.Success(200, "陈工", "欢迎您" + user);
        }
        return ResponseResult.NotAllow();
    }
}
