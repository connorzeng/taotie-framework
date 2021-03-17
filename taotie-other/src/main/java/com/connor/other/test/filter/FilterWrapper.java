package com.connor.other.test.filter;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class FilterWrapper {


    public static Invoke buildChain(Invoke currentNode, List<Filter> filters) {

        if (CollectionUtils.isEmpty(filters)) {
            return currentNode;
        }

        for (Filter filter : filters) {
            // 要点一: 必须在循环体里面每次进行next赋值.
            final Invoke next = currentNode;
            Invoke currentNodeNew = new Invoke() {
                @Override
                public InvokeResult invoke(Invocation invacation) {
                    return filter.filter(next, invacation);
                }
            };

            // 要点二: 刷新当前节点为最新.
            currentNode = currentNodeNew;
        }

        return currentNode;
    }
}
