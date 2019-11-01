package com.lhb.studentsystem.utils;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public void zipFileCreate(List<String> files, File zipfile) {
        byte[] buf = new byte[1024];
        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream = null;

        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipfile));
            for (String file : files) {
                fileInputStream = new FileInputStream(file);
                int length = file.length();
                String filename = file.substring(file.lastIndexOf("\\"), length);
                zipOutputStream.putNextEntry(new ZipEntry(filename));
                int read = fileInputStream.read(buf);
                while (read != -1) {
                    zipOutputStream.write(buf, 0, read);
                    read=fileInputStream.read(buf);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (zipOutputStream!=null){
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

