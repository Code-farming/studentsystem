package com.lhb.studentsystem.mapper;

import com.lhb.studentsystem.model.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    void addNotice(Notice notice);

    List<Notice> findAllNotice();
}
