package com.connor.common;

import com.connor.common.tool.LogUtils;

/**
 * 这是一个main函数
 */
public class TestAgentStaic {

    /**
     * 静态代理
     * 配置java运行参数:<br>
     * 参数: -javaagent:xxx.jar=connor
     * -javaagent:G:\java\workspace_idea\taotie-framework\taotie-agent\target\taotei-agent-1.0.jar=connor
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test.main");
        LogUtils.hello();
    }


}
