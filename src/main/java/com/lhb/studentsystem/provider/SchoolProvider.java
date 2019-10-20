package com.lhb.studentsystem.provider;

import com.lhb.studentsystem.dto.SchoolResultDTO;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class SchoolProvider {

//    public static void main(String[] args) {
//        String code = "MTcxNTQzMjM0%%%bGl1MDY2MzIzNTMxMzA=";
//        try {
//            SchoolResultDTO schoolResultDTO = getStatus(code);
//            System.out.println(schoolResultDTO.getBody().string());
//            System.out.println(schoolResultDTO.isFlag());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public SchoolResultDTO getStatus(String encoded) {
        SchoolResultDTO schoolResultDTO = new SchoolResultDTO();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)  //禁制OkHttp的重定向操作，我们自己处理重定向
                .followSslRedirects(false)
                .cookieJar(new LocalCookieJar())   //为OkHttp设置自动携带Cookie的功能
                .build();
        try {
            RequestBody body = new FormBody.Builder().add("encoded", encoded).build();
            Request request = new Request.Builder()
                    .url("http://jwxt.gduf.edu.cn/jsxsd/xk/LoginToXk")
                    .post(body)
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();
            int code = response.code();
            if (code == 302) {
                Request redirectRequest = new Request.Builder()
                        .url("http://jwxt.gduf.edu.cn/jsxsd/framework/xsMain.jsp")
                        .build();
                //拿到登陆后操作的某个网页的内容
                Response response2 = client.newCall(redirectRequest).execute();
                ResponseBody responseBody = response2.body();
                String userName = findUserName(responseBody);
                schoolResultDTO.setFlag(response2.code() == 200);
                schoolResultDTO.setUsername(userName);
                return schoolResultDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        schoolResultDTO.setFlag(false);
        schoolResultDTO.setUsername(null);
        return schoolResultDTO;
    }

    public String findUserName(ResponseBody body) throws Exception {
        String string = body.string();
        Document document = Jsoup.parse(string);
        Element top1_divLoginName = document.getElementById("Top1_divLoginName");
        String text = top1_divLoginName.text();
        String regex = "([\u4e00-\u9fa5]+)";
        String name = "";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            name += matcher.group(0);
        }
        return name;
    }
}


