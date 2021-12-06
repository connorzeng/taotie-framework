package com.connor.jdk.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) throws Exception {

//        for (int i=2; i>0; i--){
//            System.out.println(i);
//        }
//        System.out.println("----------");
//        for (int i=2; i>0; --i){
//            System.out.println(i);
//        }
//        System.out.println("----------");
//        int i =1;
//        int j = i--;
//
//        int x =1;
//        int y = --x;
//        System.out.println(j);
//        System.out.println(y);

        int[] tables = {8, 5, 9, 1, 0, 3};
        //int[] tables = {8, 5, 9, 1, 0, 3, 101, 2, 2, 10, 7};
//        int[] tables = {1, 2, 3, 4, 4, 9, 1, 4, 9};

        System.out.println(tables.length);
        System.out.println(tables[tables.length - 1]);

        int[] sortedTables = bubbleSort(tables);
        System.out.println(JSON.toJSONString(sortedTables));

        //选择排序
        int[] selectSortedTables = selectSort(tables);
        System.out.println(JSON.toJSONString(selectSortedTables));


        //插入排序
        int[] insertSortedTables = insertSort(tables);
        System.out.println(JSON.toJSONString(insertSortedTables));


        //归并排序
        int[] mergeSortedTables = mergeSort(tables);
        System.out.println(JSON.toJSONString(mergeSortedTables));


        //快速排序, 数量量大的时候回造成栈溢出, 所以要最后4节点,或者8节点会使用插入排序.
        int[] quckSortedTables = quickSort(tables);
        System.out.println(JSON.toJSONString(quckSortedTables));
    }


    /**
     * 1.选定 pivot 中心轴.
     * 2.将大于pivot的数字放在pivot左边
     * 3.将小于pivot的数字放在pivot右边
     * 4.分别对左右子序列重复前三步
     *
     * @param
     * @return
     */
    public static int[] quickSort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }


    private static int[] quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return arr;
        }


        // 选取数组第一个作为privot
        int privotValue = arr[left];
        // 双指针
        int index = left + 1;
        int privotIndex = left + 1;
        for (; index <= right; index++) {
            if (arr[index] < privotValue) {

                int temp = arr[index];
                arr[index] = arr[privotIndex];
                arr[privotIndex] = temp;

                privotIndex++;
            }
        }


        //privot移动到partion位置
        privotIndex = privotIndex - 1;
        arr[left] = arr[privotIndex];
        arr[privotIndex] = privotValue;


        quickSort(arr, left, privotIndex - 1);
        quickSort(arr, privotIndex + 1, right);

        return arr;
    }


//    private static int[] quickSort(int[] arr, int left, int right) {
//        if (left < right) {
//            int partitionIndex = partition(arr, left, right);
//            quickSort(arr, left, partitionIndex - 1);
//            quickSort(arr, partitionIndex + 1, right);
//        }
//        return arr;
//    }
//
//    private static int partition(int[] arr, int left, int right) {
//        // 设定基准值（pivot）
//        int pivot = left;
//        int index = pivot + 1;
//        for (int i = index; i <= right; i++) {
//            if (arr[i] < arr[pivot]) {
//                swap(arr, i, index);
//                index++;
//            }
//        }
//        swap(arr, pivot, index - 1);
//        return index - 1;
//    }
//
//    private  static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    /**
     * 归并排序
     * 空间复杂度nlogn
     *
     * @param tables
     * @return
     */
    private static int[] mergeSort(int[] tables) {

        //8, 5, 9, 1, 0, 3
        //->
        //8, 5, 9,      1, 0, 3
        //8,    5, 9,      1,    0, 3
        //5,8,9   0,1,3
        //0,1,3,5,8,9
        if (tables.length < 2) {
            return tables;
        }

        int[] left = Arrays.copyOfRange(tables, 0, tables.length / 2);
        int[] right = Arrays.copyOfRange(tables, tables.length / 2, tables.length);

        int[] result = mergeTables(mergeSort(left), mergeSort(right));
        return result;
    }

    private static int[] mergeTables(int[] left, int[] right) {


        int[] result = new int[left.length + right.length];

        //5  9
        int index = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[index] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[index] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
            index++;//这个很重要
        }

        while (left.length > 0) {
            result[index] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
            index++;//这个很重要
        }

        while (right.length > 0) {
            result[index] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
            index++;//这个很重要
        }

        return result;
    }


    /**
     * 插入排序
     *
     * @param tables
     * @return
     */
    private static int[] insertSort(int[] tables) {

        // {8, 5, 9, 1, 1, 0, 3}
        //-->
        //->5,8,   9,1,1,0,3
        //->5,8,9    1,1,0,3
        //->1,5,8,9    1,0,3
        //->1,1,5,8,9    0,3
        //->0,1,1,5,8,9   ,3
        //->0,1,1,3,5,8,9
        int[] inTables = Arrays.copyOf(tables, tables.length);


        //{8, 5, 9, 1, 0, 3, 101, 2, 2, 10, 7};
        //[0,1,2,2,3,5,7,8,9,10,101]
        //[0,1,2,2,3,5,7,8,9,10,101]
        for (int i = 1; i < inTables.length; i++) {

            //记录要插入的数据
            int temp = inTables[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (inTables[j] > temp) {//当>=  会造成不稳定.
                    inTables[j + 1] = inTables[j];
                } else {
                    break;
                }
            }

            //插入数据
            inTables[j + 1] = temp;
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

        // {8, 5, 5, 1, 6,0, 3}
        //--> {0,  5, 5, 1, 6,8, 3}
        //--> {0,1,   5, 5, 6,8, 3}//这里造成了不稳定.
        //--> {0,1,3,    5, 6,8, 5}
        //--> {0,1,3, 5,    6,8, 5}
        //--> {0,1,3, 5, 5,   8, 6}
        //--> {0,1,3, 5, 5, 6, 8}


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
