package com.lhb.studentsystem.mapper;

import com.lhb.studentsystem.model.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    void addHomework(Homework homework);

    List<Homework> findAllWork();

    Homework findWorkById(@Param("homeworkId") Integer homeworkId);

    List<Homework> findWorkByUserId(@Param("userId") String userId);
}
