package com.connor.jdk.generic.array;

import java.lang.reflect.Array;

public class GenericArrayWithType<T> {

    private T[] array;

    public GenericArrayWithType(Class<T> type, int length) {
        array = (T[]) Array.newInstance(type, length);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }
}
