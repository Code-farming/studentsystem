package com.lhb.studentsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserWork {
    private Integer id;
    private String userId;
    private Integer homeworkId;
    private String file;
    private String status;
    private Date commitTime;
    private Date modifiedTime;
}
