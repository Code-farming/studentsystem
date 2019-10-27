package com.lhb.studentsystem.service;

import com.lhb.studentsystem.dto.UserWorkDTO;
import com.lhb.studentsystem.mapper.HomeworkMapper;
import com.lhb.studentsystem.mapper.UserMapper;
import com.lhb.studentsystem.mapper.UserWorkMapper;
import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.model.UserWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWorkService {

    @Autowired
    private UserWorkMapper userWorkMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HomeworkMapper homeworkMapper;


    public void addUserWork(Integer homeworkId) {
        List<User> userList = userMapper.findAllUser();
        for (User user : userList) {
            UserWork userWork = new UserWork();
            userWork.setHomeworkId(homeworkId);
            userWork.setUserId(user.getId());
            userWorkMapper.InsertWork(userWork);
        }
    }

    public List<UserWorkDTO> findAllWork(String userId) {
        List<UserWorkDTO> userWorkDTOList=new ArrayList<>();
        //查找自己的作业
        List<UserWork> userWorks = userWorkMapper.findByUserId(userId);
        //通过遍历userWorks的homeworkId属性找到对应的作业要求
        for (UserWork userWork : userWorks) {
            Homework workById = homeworkMapper.findWorkById(userWork.getHomeworkId());
            UserWorkDTO userWorkDTO = new UserWorkDTO();
            userWorkDTO.setHomeWork(workById);
            userWorkDTO.setUserWork(userWork);
            userWorkDTOList.add(userWorkDTO);
        }
        return userWorkDTOList;
    }

    public UserWorkDTO findOneWork(String userId, Integer workId) {
        //通过workId获得作业的详情
        //通过workId 和 userId 获得用户作业提交情况
        Homework homework = homeworkMapper.findWorkById(workId);
        UserWork userWork = userWorkMapper.findWork(userId, workId);
        UserWorkDTO userWorkDTO = new UserWorkDTO();
        userWorkDTO.setHomeWork(homework);
        userWorkDTO.setUserWork(userWork);
        return userWorkDTO;
    }
}
