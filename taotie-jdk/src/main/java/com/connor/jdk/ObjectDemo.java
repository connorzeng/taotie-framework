package com.connor.jdk;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.core.NamedThreadLocal;

public class ObjectDemo {

    public static void main(String[] args) {

        System.out.println(ClassLayout.parseInstance(new NullObj()).toPrintable());
    }

}

class NullObj{

}
