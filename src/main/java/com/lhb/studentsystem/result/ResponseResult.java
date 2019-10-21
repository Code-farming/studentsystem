package com.lhb.studentsystem.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResult {
    private int code;
    private String msg;
    private Object data;


    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult() {
    }


    public static ResponseResult Success(int code, String msg, Object data) {
        return ResponseResult.builder().code(code).msg(msg).data(data).build();
    }

    public static ResponseResult Error(int code, String msg, Object data) {
        return ResponseResult.builder().code(code).msg(msg).data(data).build();
    }

    public static ResponseResult Error() {
        return ResponseResult.builder().code(500).msg("error").data(null).build();
    }

    public static ResponseResult NotAllow() {
        return ResponseResult.builder().code(411).msg("error").data(null).build();
    }
}
