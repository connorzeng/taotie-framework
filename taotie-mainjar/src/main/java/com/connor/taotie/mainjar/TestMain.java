package com.connor.taotie.mainjar;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class TestMain {

    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        System.out.println("当前进程的标识为："+name);
        int index = name.indexOf("@");
        if (index != -1) {
            int pid = Integer.parseInt(name.substring(0, index));
            System.out.println("当前进程的PID为："+pid);
        }
        try {
            //这里休息60秒，是为了在windows管理器查看该应用程序的进程PID
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long id = Thread.currentThread().getId();
        System.out.println(id);
    }

    private static void testWhile() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

}
