package com.viplav.utils.spring.other;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Streams4 {

    static OptionalDouble avg(){
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        OptionalDouble d = IntStream.of(x).average();
        return d;
    }

    public static void main(String[] args) {
        // your code here
        System.out.println(avg());
    }
    
}