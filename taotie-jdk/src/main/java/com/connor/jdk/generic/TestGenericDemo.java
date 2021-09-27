package com.connor.jdk.generic;


import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法,
 * 泛型类,
 * 泛型接口
 * 先声明,在使用.
 *
 * 1. 在代码编译期就进行类型检查.
 * 2. 避免类型转化的硬编码.
 * 3. 提高代码重用. (如实现? extends Comparable)
 *
 */
public class TestGenericDemo {

    public static void main(String[] args) {

        //下界
        List<? extends Number> eList = null;
        eList = new ArrayList<Integer>();
        eList = new ArrayList<Long>();


        //上界
        List<? super Number> fo2 = null;
        fo2 = new ArrayList<Object>();


        //?无界
        List<?> fo3 = null;
        fo3 = new ArrayList<Object>();

    }


}

/**
 * 先声明,在使用.
 * @param <K>
 * @param <V>
 */
class GenUserClass<K,V>{

    /**
     * 成员方法可以使用类声明的泛型
     * @param k
     * @return
     */
    public V getValue(K k){
        return null;
    }


    // 静态方法使用类声明的泛型会抛出错误
    /*public static V getStaticValue(){
        return null;
    }*/

    /**
     *
     *
     * @param <T>
     * @return
     */
    public static  <T> T getStaticValue(){
        return null;
    }
}
