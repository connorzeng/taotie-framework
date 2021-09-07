package com.connor.jdk.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {

        int[] tables = {8, 5, 9, 1, 0, 3};


        int[] sortedTables = bubbleSort(tables);
        System.out.println(JSON.toJSONString(sortedTables));

        int[] selectSortedTables = selectSort(tables);
        System.out.println(JSON.toJSONString(selectSortedTables));

        int[] insertSortedTables = insertSort(tables);
        System.out.println(JSON.toJSONString(insertSortedTables));

        int[] mergeSortedTables = mergeSort(tables);
        System.out.println(JSON.toJSONString(mergeSortedTables));
    }

    /**
     * 归并排序
     * @param tables
     * @return
     */
    private static int[] mergeSort(int[] tables) {



    }



    /**
     * 插入排序
     *
     * @param tables
     * @return
     */
    private static int[] insertSort(int[] tables) {

        // {8, 5, 9, 1, 0, 3}
        //-->
        //->5,8,  9,1,0,3
        //->5,8,9   1,0,3
        //->1,5,8,9   0,3
        //->0,1,5,8,9   3
        //->0,1,3,5,8,9
        int[] inTables = Arrays.copyOf(tables, tables.length);

        for (int i = 1; i < inTables.length; i++) {

            //记录要插入的数据
            int temp = inTables[i];
            int j = i;

            while (j > 0 && temp < inTables[j - 1]) {
                // inTables[i]交换数据
                inTables[j] = inTables[j - 1];
                j--;//j插入下标
            }

            //插入数据
            if (temp != inTables[i]) {
                inTables[j] = temp;
            }

        }

        return inTables;
    }

    /**
     * 选择排序
     *
     * @param tables
     * @return
     */
    private static int[] selectSort(int[] tables) {
        int[] inTables = Arrays.copyOf(tables, tables.length);

        // {8, 5, 9, 1, 0, 3}
        //-->
        //->{0,   8, 5, 9, 1, 3}
        //->{0, 1,   5, 9, 8, 3}
        //->{0, 1, 3,   9, 8, 5}
        //->{0, 1, 3, 5,   9, 8}
        //->{0, 1, 3, 5, 8,   9}

        for (int i = 0; i < inTables.length; i++) {

            int minIndex = i;
            for (int j = i; j < inTables.length - 1; j++) {
                if (inTables[minIndex] > inTables[j + 1]) {
                    minIndex = j + 1;
                }
            }

            if (inTables[minIndex] < inTables[i]) {
                int temp = inTables[minIndex];
                inTables[minIndex] = inTables[i];
                inTables[i] = temp;
            }
        }

        return inTables;
    }

    /**
     * 冒泡排序
     *
     * @param tables
     * @return
     */
    private static int[] bubbleSort(int[] tables) {

        int[] inTables = Arrays.copyOf(tables, tables.length);

        //{8,5,9,1,0,3}
        //-->
        //->{5,8,1,0,3,9}
        //->{5,1,0,3,8,9}
        //->{1,0,3,5,8,9}
        //->{0,1,3,5,8,9}
        for (int i = 1; i < inTables.length; i++) {
            boolean flag = true;

            for (int j = 0; j < inTables.length - i; j++) {
                if (inTables[j] > inTables[j + 1]) {
                    int temp = inTables[j];
                    inTables[j] = inTables[j + 1];
                    inTables[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        return inTables;
    }


}
