package com.lhb.studentsystem.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadResult {
    private int success;
    private String message;
    private String url;

    public UploadResult() {
    }

    public UploadResult(int success, String message, String url) {
        this.success = success;
        this.message = message;
        this.url = url;
    }

    public static UploadResult Success(String url) {
        return UploadResult.builder().success(1).message("上传成功").url(url).build();
    }

    public static UploadResult error(){
        return UploadResult.builder().success(0).message("上传失败").url(null).build();
    }
}
