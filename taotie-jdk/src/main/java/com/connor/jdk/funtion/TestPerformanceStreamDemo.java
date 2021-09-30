package com.connor.jdk.funtion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


/**
 *
 * http://alexandrastech.blogspot.com/2016/04/java-8-parallel-streams-performance.html
 * Analysis of Results
 *
 * Parallel streams use a fork/join model when they execute. This means that the task is split into subtasks.
 * Each subtask is executed and the results combined. In this example, the list is partitioned and each partition is
 * summed. These partitions are then summed until we have one final answer.
 *
 * Clearly, this partitioning will be most effective when the partitions are roughly equal.
 * An ArrayList supports random access, so partitioning is much quicker and easier than with a LinkedList;
 * decomposing the list into these partitions is O(n).
 */
public class TestPerformanceStreamDemo {


    /**
     * ArrayList  21658860
     * LinkedList 153976220
     *
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();
        int n = 10000000;
        Stream<Integer> stream = IntStream.range(0, n)
                .map(i -> random.nextInt())
                .boxed();
        List<Integer> list = stream.collect(Collectors.toList());



        ArrayList<Integer> al = new ArrayList<>(list);
        LinkedList<Integer> ll = new LinkedList<>(list);


        System.out.println("ArrayList " +
                new Double(LongStream.range(0, 5)
                        .map(i -> timedSum(al))
                        .average()
                        .getAsDouble()).intValue());
        System.out.println("LinkedList " +
                new Double(LongStream.range(0, 5)
                        .map(i -> timedSum(ll))
                        .average()
                        .getAsDouble()).intValue());

    }


    public static long timedSum(List<Integer> values){
        long startTime = System.nanoTime();
        sum(values);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static int sum(List<Integer> values) {
        return values.parallelStream().mapToInt(i -> i).sum();
    }
}
