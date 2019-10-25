package com.lhb.studentsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class Homework {
    private Integer id;
    private String title;
    private String fromId;
    private String content;
    private String files;
    private Date deadline;
    private Date createTime;
    private String format;
}
