package com.connor.agent.transformer;

import java.io.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.ProtectionDomain;

/**
 *
 */
public class MyTransformer implements ClassFileTransformer {


    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        //println className like this:
        //com/intellij/rt/execution/application/AppMainV2$Agent
        //java/util/concurrent/ConcurrentHashMap$ForwardingNode
        //com/intellij/rt/execution/application/AppMainV2
        //com/intellij/rt/execution/application/AppMainV2$1
        //java/lang/reflect/InvocationTargetException
        //System.out.println(className);
        try {
            String classReName = className.replace("/", ".");
            if (classReName.equals("com.connor.common.tool.LogUtils")) {
                System.out.println(classReName);

                // 使用这种方式不行
                /*URL[] urls = new URL[1];
                urls[0] = new URL("file:G:/java/repo/com/connor/taotie-common/1.0.1/taotie-common-1.0.1.jar");
                URLClassLoader urlClassLoader = new URLClassLoader(urls);
                Class clazz = loader.loadClass(classReName);
                return write(clazz);*/

                String logUtilsClzPath = "G:\\java\\repo\\com\\connor\\taotie-common\\1.0.1\\LogUtils.class";
                return readStream(new FileInputStream(logUtilsClzPath), true);

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 默认返回
        return new byte[0];
    }

    public byte[] write(Serializable object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);
        stream.writeObject(object);
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] readStream(InputStream inputStream, boolean close) throws IOException {
        if(inputStream == null) {
            throw new IOException("Class not found");
        } else {
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] data = new byte[4096];

                int bytesRead;
                while((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                    outputStream.write(data, 0, bytesRead);
                }

                outputStream.flush();
                byte[] var5 = outputStream.toByteArray();
                return var5;
            } finally {
                if(close) {
                    inputStream.close();
                }
            }
        }
    }
}
