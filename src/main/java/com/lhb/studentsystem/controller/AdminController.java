package com.lhb.studentsystem.controller;

import com.lhb.studentsystem.dto.UserWorkDTO;
import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.model.UserWork;
import com.lhb.studentsystem.result.ResponseResult;
import com.lhb.studentsystem.service.HomeworkService;
import com.lhb.studentsystem.service.UserService;
import com.lhb.studentsystem.service.UserWorkService;
import com.lhb.studentsystem.utils.FileDownLoad;
import com.lhb.studentsystem.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    String realPath = "d:\\uploadFile";
    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserWorkService userWorkService;

    @GetMapping("/allWork")
    public ResponseResult allWork(String userId) {
        System.out.println(userId);
        List<Homework> allWorkByUserId = homeworkService.findAllWorkByUserId(userId);
        return ResponseResult.Success(200, "查询成功", allWorkByUserId);
    }

    @GetMapping("/getWorkZip")
    public Object getWorkZip(String fromId, String title, Integer workId, HttpServletResponse response){
        //获取发布人的姓名以及相对应的作业名
        ArrayList<String> list = new ArrayList<>();
        User user = userService.getUser(fromId);
        String username = user.getUsername();
        //打包作业 start
        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);
        for (UserWork userWork : workList) {
            String file = userWork.getFile();
            if (file==null){
                continue;
            }
            String path= realPath+"\\"+username+"\\"+title+"\\"+file;
            System.out.println(path);
            list.add(path);
        }
        String zipPath=realPath+"\\"+username+"\\"+title+"\\"+title+".zip";
        File file = new File(zipPath);
        if (file.exists()){
            file.delete();
        }
        file = new File(zipPath);
        ZipUtils zipUtils = new ZipUtils();
        zipUtils.zipFileCreate(list,file);
        //打包作业 end
        //下载作业包
        File file1=new File(zipPath);
        FileDownLoad.downloadFile(file1,"application/x-download",response);
        return null;
    }

}
