package com.lhb.studentsystem.dto;

import com.lhb.studentsystem.model.Notice;
import lombok.Data;

@Data
public class NoticeDTO {
    private Notice notice;
    private String name;
}
