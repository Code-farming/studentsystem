package com.lhb.studentsystem.controller;

import com.alibaba.fastjson.JSON;
import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.HomeworkService;
import com.lhb.studentsystem.utils.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("user")
public class PublicController {
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/publicWork")
    public ResponseResult publicWork(@RequestBody String json, HttpServletRequest request) {
        Homework homework = JSON.parseObject(json, Homework.class);
        Date nowDate = DateHandler.getNowDate();
        homework.setCreateTime(nowDate);
        //先不做判空，先利用前台的判空
        homeworkService.addHomework(homework);
        ResponseResult responseResult = ResponseResult.Success(200, "发布成功", null);
        return responseResult;

    }
}
