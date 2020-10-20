package com.connor.taotie.dependency.scope;


/**
 * 自定义scope
 */
public class ThreadlocalScopeDemo {

    // 1.新建一个ThreadlocalScope继承Scope
        // 在新建类里面维护一个NamedThreadLocal-->ThreadLocal
        // bean最终还是要在beanFactory里面获取
    // 2.容器启动的时候需要注册这个Scope
        // BeanFactoryPostProcessor
    // 3.多线程执行获取bean



    public static void main(String[] args) {



    }


}
