package com.connor.jdk.juc.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<String, String>(50, 0.75f);


//        // Collections.synchronizedMap(new HashMap<>());
//        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("hello","hello");

        System.out.println(map.size());





    }

}
