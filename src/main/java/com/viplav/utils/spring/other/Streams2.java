package com.viplav.utils.spring.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;

public class Streams2 {

    static void avgInt() {
        int[] x = { 1, 2, 3, 4, 5, 6 };
        Streams.printf(IntStream.of(x).average().getAsDouble());
    }

    static void intToInteger() {
        int[] x = { 1, 2, 3, 4, 5, 6 };
        Streams.printf(IntStream.of(x).boxed().toList());
        List<Integer> list = IntStream.of(x).boxed().collect(Collectors.toList());
        Streams.printf(list);
        Streams.printf(Arrays.stream(x).boxed().toList());
    }

    static void caseChange() {
        String[] strings = { "Viplav", "Fauzdar", "Dingo", "Singh" };
        List<String> list = Stream.of(strings).map(str -> str.toUpperCase()).collect(Collectors.toList());
        Streams.printf(list);
    }

    static void sumEvenOdd() {
        int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        IntStream even = IntStream.of(x).filter(i -> (i % 2 == 0));
        // even.forEach(System.out::println);
        Streams.printf(even.sum());
        IntStream odd = IntStream.of(x).filter(i -> (i % 2 != 0));
        // odd.forEach(System.out::println); //Stream gets exhausted just like java.io
        Streams.printf(odd.sum());
    }

    static void removeDupes() {
        int[] x = { 1, 1, 3, 4, 3, 6, 1, 8, 4, 10 };
        IntStream nodupes = IntStream.of(x).distinct();
        nodupes.forEach(System.out::println);
        String[] s = { "Viplav", "Fauzdar", "Dingo", "Fauzdar" };
        Stream<String> str = Stream.of(s).distinct();
        str.forEach(System.out::println);
    }

    //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    static void countStrings(){
        Streams.printf(Streams.createStream2().filter(s -> s.startsWith("v")).count());
    }

    //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    static void sortString(){
        Streams.printf(Streams.createStream2().sorted().collect(Collectors.toList()));
        Streams.printf(Streams.createStream2().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    //Write a Java program to find the maximum and minimum values in a list of integers using streams.
    static void minMax(){
        List<Integer> list = Arrays.asList(23,12,43,5,78,98,33,54);
        Streams.printf(list.stream().mapToInt(i -> i).min());
        Streams.printf(list.stream().mapToInt(i -> i*2).max());
        
        Streams.printf(IntStream.of(23,12,43,5,78,98,33,54).min().getAsInt());
        Streams.printf(IntStream.of(23,12,43,5,78,98,33,54).max().getAsInt());
    }

    //Write a Java program to find the second smallest and largest elements in a list of integers using streams.
    static void secondSmallestLargest(){
        List<Integer> list = Arrays.asList(23,12,43,5,78,98,33,54);
        Streams.printf(list.stream().sorted().collect(Collectors.toList()).get(1));
        Streams.printf(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(1));
    }

    public static void main(String... args) {
        avgInt();

        intToInteger();

        caseChange();

        sumEvenOdd();

        removeDupes();

        countStrings();

        sortString();

        minMax();

        secondSmallestLargest();
    }

}
