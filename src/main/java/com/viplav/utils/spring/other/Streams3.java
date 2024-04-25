package com.viplav.utils.spring.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams3 {

    public static void letterCount() {
        String[] names = {"viplav", "fauzdar", "dingo", "singh"};
        int count = Arrays.stream(names)
                .mapToInt(String::length)
                .sum();
        System.out.println(count);
    }

    public static void letterCount2() {
        String[] names = {"viplav", "fauzdar", "dingo", "singh"};
        int count = 0;
        for(String name: names){
            count += name.length();
        }
        System.out.println(count);
    }

    public static void letterCount3() {
        String[] names = {"viplav", "fauzdar", "dingo", "singh"};
        int count = Arrays.stream(names).mapToInt(s -> s.length()).sum();
        System.out.println(count);
    }

    public static void letterCount4() {
        String[] names = {"viplav", "fauzdar", "dingo", "singh"};
        long count = Arrays.stream(names).filter(s -> (s.length() > 5)).mapToInt(s -> s.length()).sum();
        System.out.println(count);
    }

    public static void main(String[] args) {
        // Your code here
        letterCount();

        int age = 50;
        System.out.println(age > 40 ? true : false);
        age += 10;
        System.out.println(age);

        letterCount2();

        letterCount3();

        System.out.println("Hello");

        letterCount4();

        int[] x = {1, 2, 3, 4, 5};
        List<Integer> xx = IntStream.of(x).boxed().collect((Collectors.toList()));
        System.out.println("xx:"+xx.size());
    }
}
