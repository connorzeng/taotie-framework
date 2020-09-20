package com.connor.jdk;

import com.connor.common.constants.City;
import org.junit.Test;

public class EnumDemo {


    /**
     *
     */
    @Test
    public void test1(){
        //1. 没有public构造方法
        //2. 默认所有值都是public static final
        //3. 提供valueof values
        City guangzhou = City.valueOf("Guangzhou");
        System.out.println(guangzhou);

        City[] values = City.values();
        for (City value : values){
            System.out.println(value);
        }


        // 为什么不直接使用City.valueOf("Guangzhou")
        City guangzhou1 = Enum.valueOf(City.class, "Guangzhou");
        System.out.println(guangzhou1);
    }


}
