package com.connor.other.test.filter;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {


    public static void main(String[] args) {

        int i = 10;
        int j = 7;
        System.out.println(i&8);//10&8==8
        System.out.println(j&8);//7&8==0

        // 1.添加过滤器
        List<Filter> filters = new ArrayList<>();
        filters.add((next, invocation) -> {
            System.out.println("doFilterOne");
            return next.invoke(invocation);
        });
        filters.add((next, invocation) -> {
            System.out.println("doFilterTwo");
            return next.invoke(invocation);
        });
        filters.add((next, invocation) -> {
            System.out.println("doFilterThree");
            return next.invoke(invocation);
        });

        // 2.buildChain
        Invoke invoke = FilterWrapper.buildChain(invacation -> {
            System.out.println("last invoker");
            return new InvokeResult();
        }, filters);

        // 3.执行
        invoke.invoke(new Invocation());
    }

}
