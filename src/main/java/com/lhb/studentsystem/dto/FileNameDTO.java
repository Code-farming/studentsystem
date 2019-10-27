package com.lhb.studentsystem.dto;


import lombok.Data;

@Data
public class FileNameDTO {
    private String originalName;//原始文件名
    private String newName; //UUID重命名
}
