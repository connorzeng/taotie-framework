package com.connor.jdk.generic.array;

public class GenTest<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T t) {
        value = t;
    }


    public static void main(String[] args) {


        GenTest genArr[] = new GenTest[2];//创建泛型数组

        Object[] test = genArr;
        GenTest<StringBuffer> strBuf = new GenTest<StringBuffer>();
        strBuf.setValue(new StringBuffer());
        test[0] = strBuf;

        GenTest<String> ref = genArr[0];//上面两行相当于使用数组移花接木，让Java编译器把GenTest<StringBuffer>当作了GenTest<String>
        String value = ref.getValue();// 这里是重点！
    }
}
