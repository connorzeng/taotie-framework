package com.connor.jdk.util;

public class SystemUtils {

    public static void main(String[] args) {

        cpuProcessor();

    }

    private static void cpuProcessor() {

        //destop, 8核心
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
