package com.connor.jdk.algorithm;


/**
 * 请求这个数列中第N大的数
 */
public class TokN {


    /**
     * 求topN
     *
     * @param args
     */
    public static void main(String[] args) {

        //求排名第三大的数值
        int[] tables = new int[]{1, 2, 3, 5, 6, 9, 1, 4, 9};

        // 通过quickSort
        int k = sortTopNByQuickSork(tables, 0, tables.length-1, 3);
        System.out.println(k);


        int i = 20;
        System.out.printf("%010x\n",i);//按10位十六进制输出，向右靠齐，左边用0补齐

        String s=Integer.toBinaryString(i);
        System.out.println(s);
    }

    private static int sortTopNByQuickSork(int[] tables, int left, int right, int k) {

        int partionIndex = quickSorkPartionIndex(tables, left, right);

        if (k == partionIndex) {
            return tables[k];
        } else if (k < partionIndex) {
            return sortTopNByQuickSork(tables, left, partionIndex-1,k) ;
        } else {
            return sortTopNByQuickSork(tables, partionIndex + 1, right,k) ;
        }
    }

    private static int quickSorkPartionIndex(int[] tables, int left, int right) {

        if (left >= right){
            return right;
        }

        //取数组第一位作为partionValue(privot)
        int partionValue = tables[left];

        //双指针
        int index = left + 1;
        int partionIndex = left + 1;
        for (;index <= right; index++){

            if (tables[index] > tables[partionIndex]){
                //交换数值
                int temp = tables[index];
                tables[index] = tables[partionIndex];
                tables[partionIndex] = temp;

                //partionIndex右移
                partionIndex ++;
            }
        }

        partionIndex = partionIndex - 1;
        //交换数值
        tables[left] = tables[partionIndex];
        tables[partionIndex] = partionValue;

        return partionIndex;
    }

}
