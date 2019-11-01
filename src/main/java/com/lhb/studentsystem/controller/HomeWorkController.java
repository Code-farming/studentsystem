package com.lhb.studentsystem.controller;

import com.lhb.studentsystem.dto.UserWorkDTO;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.UserWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class HomeWorkController {
    @Autowired
    private UserWorkService userWorkService;

    @GetMapping("/allWork")
    public ResponseResult allWork(@RequestParam("userId") String userId){
        List<UserWorkDTO> allWork = userWorkService.findAllWork(userId);
        return ResponseResult.Success(200,"全部作业",allWork);
    }

    @GetMapping("/findWork")
    public ResponseResult findWork(@RequestParam("userId") String userId,
                                   @RequestParam("workId") Integer workId){
        UserWorkDTO workDTO = userWorkService.findOneWork(userId, workId);
        return ResponseResult.Success(200,"单个作业详情",workDTO);
    }
}
