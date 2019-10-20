package com.lhb.studentsystem.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String sysPassword;  //加密后传的值
    private String roleId;         //角色
}
