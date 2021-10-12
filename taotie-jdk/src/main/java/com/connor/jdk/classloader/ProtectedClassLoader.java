package com.connor.jdk.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 *
 */
public class ProtectedClassLoader extends ClassLoader {
    public  ProtectedClassLoader(ClassLoader parent){
        super(parent);
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] by = null;
        try {
            by = getByteByClassName(name);
            return defineClass(name, by, 0, by.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
    @Override
    public InputStream getResourceAsStream(String name) {
        return super.getResourceAsStream(name);
    }
    private byte[] getByteByClassName(String name) throws IOException {
        //File file = new File("C:\\Users\\gangg\\connor_workspace\\taotie-framework\\taotie-boot\\target\\classes\\com\\connor\\taotieboot\\dto\\Red.class");
        File file = new File("C:\\Users\\gangg\\connor_workspace\\taotie-framework\\taotie-boot\\target\\classes\\java\\util\\HashMap.class");
        InputStream is = new FileInputStream(file);
        byte[] by = new byte[is.available()];
        is.read(by);
        is.close();
        return by;
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        ClassLoader ml = new ProtectedClassLoader(ClassLoader.getSystemClassLoader().getParent());
        //Object obj = Class.forName("com.connor.taotieboot.dto.Red", true, ml).newInstance();

        //Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
        Object obj = Class.forName("java.lang.HashMap", true, ml).newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}