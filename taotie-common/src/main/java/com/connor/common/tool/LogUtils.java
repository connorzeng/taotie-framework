package com.connor.common.tool;

public class LogUtils {


    public static void hello() {
        LogUtils logUtils = new LogUtils();
        logUtils.getInner();
        System.out.println("hello-1.0.2");

    }



    private void getInner() {
        new LogInner();
    }

    class LogInner{
        public LogInner(){
            System.out.println("LogInner.LogInner2");
        }
    }

}
