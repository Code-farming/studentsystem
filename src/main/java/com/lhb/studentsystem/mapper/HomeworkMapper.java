package com.lhb.studentsystem.mapper;

import com.lhb.studentsystem.model.Homework;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeworkMapper {

    void addHomework(Homework homework);
}
