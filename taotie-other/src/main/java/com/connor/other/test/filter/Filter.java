package com.connor.other.test.filter;

public interface Filter {

    /**
     * 过滤器
     * @param next
     * @param invacation
     * @return
     */
    InvokeResult filter(Invoke next, Invocation invacation);
}
