package com.lhb.studentsystem.controller;

import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("work")
public class HomeController {
    @Autowired
    private HomeworkService service;
    @GetMapping("/allWork")
    public ResponseResult allWork(){
        List<Homework> allWork = service.findAllWork();
        return ResponseResult.Success(200,"全部作业",allWork);
    }
}
