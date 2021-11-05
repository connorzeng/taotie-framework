package com.connor.jdk.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) {

        String filePath = FileWrite.class.getClass().getResource("/tempFile.txt").getPath();
        fileWrite(filePath, "hello,connor");
    }

    public static void fileWrite(String filePath, String content) {
        File file = new File(filePath);
        //创建FileWriter对象
        BufferedWriter writer = null;
        try {
            //如果文件不存在，创建文件
            if (!file.exists())
                file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);//写入内容
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
