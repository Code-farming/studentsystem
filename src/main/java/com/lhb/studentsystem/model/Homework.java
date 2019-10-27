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
    private String originalName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    //默认情况下timeZone为GMT（即标准时区），而北京是在东八区，所以会造成差8小时。
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private String format;
    private String status;
}
