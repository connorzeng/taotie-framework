package com.connor.other.test.filter;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {


    public static void main(String[] args) {

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
