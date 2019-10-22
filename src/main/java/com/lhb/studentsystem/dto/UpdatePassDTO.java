package com.lhb.studentsystem.dto;

import lombok.Data;

@Data
public class UpdatePassDTO {
    private String id;
    private String oldPassword;
    private String newPassword;
}
