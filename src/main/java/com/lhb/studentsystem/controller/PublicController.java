package com.lhb.studentsystem.controller;

import com.alibaba.fastjson.JSON;
import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.model.Notice;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.HomeworkService;
import com.lhb.studentsystem.service.NoticeService;
import com.lhb.studentsystem.service.UserWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("admin")
public class PublicController {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/publicWork")
    @Transactional
    public ResponseResult publicWork(@RequestBody String json, HttpServletRequest request) {
        Homework homework = JSON.parseObject(json, Homework.class);
        //先不做判空，先利用前台的判空
        homeworkService.addHomework(homework);
        Integer homeworkId = homework.getId();
        ResponseResult responseResult = ResponseResult.Success(200, "发布成功", null);
        //向用户作业数据表里添加数据
        userWorkService.addUserWork(homeworkId);
        return responseResult;
    }

    @PostMapping("/publicNotice")
    public ResponseResult publicNotice(@RequestBody String json, HttpServletRequest request) {
        Notice notice = JSON.parseObject(json, Notice.class);
        Date date = new Date();
        notice.setCreateTime(date);
        noticeService.addNotice(notice);
        return ResponseResult.Success(200,"发布通知成功",null);
    }

}
