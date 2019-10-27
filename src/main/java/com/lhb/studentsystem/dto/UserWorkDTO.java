package com.lhb.studentsystem.dto;

import com.lhb.studentsystem.model.Homework;
import com.lhb.studentsystem.model.UserWork;
import lombok.Data;

/***
 * @author LHB
 * 这是一个数据传输的模型，一个向前端页面返回的模型，包含了Homework的所有属性，以及UserWork的status
 */
@Data
public class UserWorkDTO {

   private Homework homeWork;
   private UserWork userWork;
}
