package com.connor.jdk.generic;

import java.util.ArrayList;

public class SubClass implements SuperClass<String>{



    // 这里是基于泛型桥接
    @Override
    public String getObj(String str) {


        return "hello" + str;

    }
}
