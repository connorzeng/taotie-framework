package com.connor.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ConnorProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("myName is connor begin");
        //动态代理怎么处理void返回
        //判断是是否是接口
        //Object invoke = method.invoke(proxy, args);


        System.out.println("myName is connor end");
        return null;
    }
}


//动态代理实际上是JVM在运行期动态创建class字节码并加载的过程，它并没有什么黑魔法，把上面的动态代理改写为静态实现类大概长这样：
//public class HelloDynamicProxy implements Hello {
//    InvocationHandler handler;
//    public HelloDynamicProxy(InvocationHandler handler) {
//        this.handler = handler;
//    }
//    public void morning(String name) {
//        handler.invoke(
//                this,
//                Hello.class.getMethod("morning", String.class),
//                new Object[] { name });
//    }
//}
