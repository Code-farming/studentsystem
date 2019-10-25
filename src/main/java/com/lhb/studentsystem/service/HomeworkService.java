package com.lhb.studentsystem.service;

import com.lhb.studentsystem.mapper.HomeworkMapper;
import com.lhb.studentsystem.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    public void addHomework(Homework homework) {
        homeworkMapper.addHomework(homework);
    }
}
