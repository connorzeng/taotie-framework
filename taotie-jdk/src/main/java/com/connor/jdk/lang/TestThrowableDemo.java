package com.connor.jdk.lang;

public class TestThrowableDemo {

    public static final String hello = "hello1";
    public static final UserDto USER_DTO = new UserDto("zenggang");
    public static final UserDto USER_DTO1 = new UserDto("zenggang");

    public static void main(String[] args) {

        try {
            //NoClassDefFoundError 表示这个类在编译时期存在，但是在运行时却找不到此类，有时静态初始化块也会导致
            //另一方面，ClassNotFoundException 与编译时期无关，当你尝试在运行时使用反射加载类时，ClassNotFoundException 就会出现。

            Byte[] y = new Byte[Integer.MAX_VALUE];

            //throw  new Error("i am error");
        } catch (Error error) {


            System.out.println(error.getMessage());
            error.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.toString());

        System.out.println("hello1" == hello);
        System.out.println(USER_DTO == USER_DTO1);;

    }
}

class  TestDemo {

}
