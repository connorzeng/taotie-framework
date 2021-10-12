package com.connor.jdk.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderDemo {

    //TODO  编写classloader
    //https://blog.csdn.net/Ditto_zhou/article/details/79972240
    //https://www.jianshu.com/p/69c4526b843d
    //https://www.cnblogs.com/java-chen-hao/p/11341004.html
    // tomcat打破的双亲委派只是在tomcat classloader关系这一层. 在JVM的calssloader还是遵循双亲委派
    //
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);//app

        System.out.println(classLoader.getParent());//ext

        System.out.println(classLoader.getParent().getParent());//boot



        ClassLoader myloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)
                    throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is;
                try {
                    is =getClass().getResourceAsStream(fileName);
                    if(is==null) {return super.loadClass(fileName);}
                    byte[] by = new byte[is.available()];
                    is.read(by);
                    is.close();
                    return defineClass(name, by, 0, by.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
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
                File file = new File("G:\\java\\workspace_idea\\taotie-framework\\taotie-boot\\target\\classes\\java\\lang\\Object.class");
                InputStream is = new FileInputStream(file);
                byte[] by = new byte[is.available()];
                is.read(by);
                is.close();
                return by;
            }
        };

        //G:\java\workspace_idea\taotie-framework\taotie-boot\target\classes\java\lang\Object.class
        Object obj = Class.forName("java.lang.Object", true, myloader).newInstance();
        myloader.loadClass("java.lang.Object").newInstance();


    }


}
