package com.connor.jdk.funtion;


import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTestDemo {


    // sorted 排序,
    // limit 分页
    //1. 过滤 filter
    //2. 转换 map
    //3. 聚合 reduce(聚合计算,求和,求平均值,求乘机)
    //4. 输出
    //      输出LIST,输出MAP,输出Array,分组输出.

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(34, "connor"));
        students.add(new Student(28, "huaxiang"));
        students.add(new Student(30, "xiaozongold"));
        students.add(new Student(20, "xiaozong"));
        students.add(new Student(21, "x0"));
        students.add(new Student(21, "x1"));
        students.add(new Student(21, "x2"));
        students.add(new Student(21, "x3"));


        //测试过滤
        testFilterStudent(students);

        //测试flatmap
        testFlatmap(students);

        //测试收集
        testCollectionStudent(students);

        //测试无限流
        testStreamStream();
    }

    private static void testFlatmap(List<Student> students) {

        // 打平操作
        students.stream().flatMap((student)->{
            ArrayList<String> stuAttrs = new ArrayList<>();
            stuAttrs.add(student.getAge() + "");
            stuAttrs.add(student.getName());
            return stuAttrs.stream();
        }).forEach(System.out::println);
    }

    private static void testStreamStream() {
        //Stream 空流
        Stream.empty().forEach((t) -> System.out.println(t + "hello"));

        //Stream 无限流 - generate
/*        Stream.generate(() -> {
            //生成一个随机数
            return Math.random();
        }).forEach((t) -> {
            System.out.println(t);
        });*/

        //Stream 无线流 -
        Student connor = new Student(34, "connor");
        //Stream.iterate(connor, t -> switchAge(t));
        //相当于这样的写法
        //.parallel() 使用这个来递增会有问题
        Stream.iterate(connor, (t) -> {
            return switchAge(t);
        }).limit(50).forEach(System.out::println);

//        Stream.iterate(0, t -> t+1
//        ).limit(50).forEach(System.out::println);
    }


    private static Student switchAge(Student t) {

        Student newOne = t;
        newOne.setAge(t.getAge() + 1);
        return newOne;
    }

    private static void testCollectionStudent(List<Student> students) {

        // 输出为List
        List<Student> collect = students.stream().filter((stu) -> {
            if (stu.getAge() < 30) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());


        // 输出为map
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);


        // 首字母相同分组输出.
        List<String> list = Arrays.asList("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);

        // 输出为数组
        List<String> list2 = Arrays.asList("Apple", "Banana", "Orange");
        String[] array = list2.stream().toArray(String[]::new);
    }


    /**
     * students过滤
     *
     * @param students
     */
    private static void testFilterStudent(List<Student> students) {

        // parallel是乱序的
        // 否则就是按照pipeline的顺序执行
        //students.stream().parallel().filter((s) -> {
        students.stream().filter((s) -> {
            if (s.getAge() < 30) {
                return true;
            }
            return false;
        }).filter((s) -> {
            if (s.getName().startsWith("x")) {
                return true;
            }
            return false;
        }).map((s) -> {
            if (s.getName().equals("xiaozong")) {
                s.setOk(true);
            }
            return s;
        }).forEach((s) -> {
            System.out.println(s);
        });

    }

}

