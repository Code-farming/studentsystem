package com.lhb.studentsystem.result;

import lombok.Data;

@Data
public class TableResult {
    private int code=0;
    private String msg="";
    private long count;
    private Object data;
}
