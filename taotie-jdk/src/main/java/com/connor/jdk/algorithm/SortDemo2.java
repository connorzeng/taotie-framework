package com.connor.jdk.algorithm;

import java.util.Arrays;

public class SortDemo2 {


    /**
     * JDK排序:
     * Arrays.sort:  数据,二分, 对象
     * int[] tables = {8, 5, 9, 1, 0, 3};
     *
     * @param args
     */
    public static void main(String[] args) {


//        bubleSortTest();
//        selectSortTest();
//        insertSortTest();
        qucikSortTest();

    }

    private static void qucikSortTest() {
        int[] tables = {8, 5, 9, 1, 0, 3};
        int[] tables2 = {1, 2, 3, 4, 5, 6};
        int[] tables3 = {2, 1, 3, 4, 5, 6};
        qucikSort(tables);
        qucikSort(tables2);
        qucikSort(tables3);
        Arrays.stream(tables).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables2).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables3).forEach(System.out::println);
    }


    private static void insertSortTest() {
        int[] tables = {8, 5, 9, 1, 0, 3};
        int[] tables2 = {1, 2, 3, 4, 5, 6};
        int[] tables3 = {2, 1, 3, 4, 5, 6};
        insertSort(tables);
        insertSort(tables2);
        insertSort(tables3);
        Arrays.stream(tables).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables2).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables3).forEach(System.out::println);

    }


    private static void selectSortTest() {
        int[] tables = {8, 5, 9, 1, 0, 3};
        int[] tables2 = {1, 2, 3, 4, 5, 6};
        int[] tables3 = {2, 1, 3, 4, 5, 6};
        selectSort(tables);
        selectSort(tables2);
        selectSort(tables3);
        Arrays.stream(tables).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables2).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables3).forEach(System.out::println);
    }


    private static void bubleSortTest() {

        int[] tables = {8, 5, 9, 1, 0, 3};
        int[] tables2 = {1, 2, 3, 4, 5, 6};
        int[] tables3 = {2, 1, 3, 4, 5, 6};
        bubleSort(tables);
        bubleSort(tables2);
        bubleSort(tables3);
        Arrays.stream(tables).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables2).forEach(System.out::println);
        System.out.println("--------");
        Arrays.stream(tables3).forEach(System.out::println);

    }

    /**
     * @param tables
     * @return
     */
    private static int[] bubleSort(int[] tables) {

        if (tables == null || tables.length <= 1) {
            return tables;
        }

        for (int i = 0; i < tables.length; i++) {
            boolean flag = true;//优化2: 判断已经有序的可以break
            for (int j = i + 1; j < tables.length; j++) {//优化点1: j < tables.length - i
                if (tables[i] > tables[j]) {
                    swap(tables, i, j);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        return tables;
    }

    private static int[] selectSort(int[] tables) {

        if (tables == null || tables.length <= 1) {
            return tables;
        }

        for (int i = 0; i < tables.length; i++) {
            //遍历选择最小的,
            int minIndex = i;
            for (int j = i + 1; j < tables.length; j++) {
                if (tables[minIndex] > tables[j]) {
                    minIndex = j;
                }
            }
            //然后把最小的值替换到首位
            if (minIndex != i) {
                swap(tables, minIndex, i);
            }
        }
        return tables;
    }


    //插入排序,局部有序性,稳定的,常用的.
    private static int[] insertSort(int[] tables) {
        if (tables == null || tables.length <= 1) {
            return tables;
        }

        //第一位有序,据此来进行排序
        for (int i = 1; i < tables.length; i++) {
            // 0位有序
            // 找到要插入的位置
            for (int inserted = 0; inserted <= i - 1; inserted++) {
                if (tables[inserted] > tables[i]) {
                    swap(tables, i, inserted);
                }
            }
        }

        return tables;
    }

    private static int[] qucikSort(int[] tables) {
        if (tables == null || tables.length <= 1) {
            return tables;
        }

        //寻找基准位
        qucikSort(tables, 0, tables.length - 1);

        return tables;
    }

    private static int[] qucikSort(int[] tables, int left, int right) {

        if (tables == null || tables.length <= 1 || left >= right) {
            return tables;
        }

        // int[] tables = {8, 5, 9, 1, 0, 3};
        int poxValue = tables[left];
        int index = left + 1;//慢指针,遍历完后指向中间位置,index结束后要-1
        int i = index;//快指针,遍历完整个数组
        for (; i <= right; i++) {
            if (tables[i] < poxValue) {
                swap(tables, i, index);
                index++;
            }
        }
        index -= 1;//index结束后要-1
        swap(tables, left, index);


        //分割index,递归排序
        qucikSort(tables, left, index);
        qucikSort(tables, index + 1, right);


        return tables;
    }


    private static void swap(int[] tables, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = tables[i];
        tables[i] = tables[j];
        tables[j] = temp;
    }


}
