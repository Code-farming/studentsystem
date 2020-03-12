package com.lhb.studentsystem.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) throws IOException {
        String infile = "e:\\2.docx";
        String outfile = "e:\\1.docx";
        FileInputStream fileInputStream = new FileInputStream(infile);
        FileOutputStream fileOutputStream = new FileOutputStream(outfile);

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            int read = inputStreamChannel.read(buffer);
            if(read==-1){
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);
            buffer.clear();
        }

    }

}
