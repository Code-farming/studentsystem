package com.lhb.studentsystem.service;

import com.lhb.studentsystem.mapper.NoticeMapper;
import com.lhb.studentsystem.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    public List<Notice> findAllNotice() {
        List<Notice> list=noticeMapper.findAllNotice();
        return list;
    }
}
