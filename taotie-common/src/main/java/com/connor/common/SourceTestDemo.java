package com.connor.common;

import java.io.*;
import java.util.Properties;

public class SourceTestDemo {

    public static void main(String[] args) throws IOException {

        // 当前class的加载路径
        // ../taotie-common/target/classes/com/connor/common/
        String pathClass = SourceTestDemo.class.getResource("").getPath();

        // 当前classloader的加载路径
        // ../taotie-common/target/classes/
        String pathClassloader = SourceTestDemo.class.getClassLoader().getResource("").getPath();

        System.out.println(pathClass);
        System.out.println(pathClassloader);

        // 加载resources下的资源使用classloader.getResources
        Properties connorPro = new Properties();
        connorPro.load(SourceTestDemo.class.getClassLoader().getResourceAsStream("connor.properties"));
        connorPro.list(System.out);

        // 设置UTF-8编码格式
        // 只有一个InputStream可以设置Encode
        Properties connorProUtf8 = new Properties();
        InputStream resourceAsStream = SourceTestDemo.class.getClassLoader().getResourceAsStream("connor.properties");
        InputStreamReader reader = new InputStreamReader(resourceAsStream, "UTF-8");
        connorProUtf8.load(reader);
        connorProUtf8.list(System.out);

        System.out.println(System.getenv().get("CLASSPATH"));
    }

}
