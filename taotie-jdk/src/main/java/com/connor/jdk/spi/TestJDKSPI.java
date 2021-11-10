package com.connor.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestJDKSPI {

    public static void main(String[] args) {
        ServiceLoader<TestSPI> load = ServiceLoader.load(TestSPI.class);

        Iterator<TestSPI> iterator = load.iterator();

    }
}
