package com.lhb.studentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Homework {
    private Integer id;
    private String title;
    private String fromId;
    private String content;
    private String files;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private String format;
}
