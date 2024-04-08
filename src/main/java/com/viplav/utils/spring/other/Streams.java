package com.viplav.utils.spring.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Streams  - added to Java 8 to Collections
 * default method Collection.stream() inheritted by all 
 * implementing classes such as List, Set, Map etc
 */

public class Streams {

    @SuppressWarnings("unchecked")
    static void print(Stream stream){
        if(stream!=null) stream.forEach(e -> System.out.println(e));
    }

    static void printf(Object object){
        System.out.println(object);
    }

    static Stream<Integer> createStream1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
        return stream;
    }

    static Stream<String> createStream2(){
        Stream<String> stream2 = Stream.of("viplav","fauzdar","dingo","fauzdar","john","doe");
        return stream2;
    }

    static void intermediateAndTerminalOps(){
        Stream<String> stream = createStream2();
        printf(stream.distinct().count()); //distinct is intermediate & count is terminal operation
    }

    static void iterating(){
        Stream<Integer> stream = createStream1();
        printf(stream.anyMatch(e -> (e==1)));
    }

    static void filtering(){
        Stream<String> stream = createStream2();
        print(stream.filter(e -> (e.contains("f"))));
    }

    static List<Car> makeCars(){
        List<Car> cars = new ArrayList<>();
        Car carToyota = new Car("Toyota","Corola","Red");
        Car carHonda = new Car("Honda","Civic","Blue");
        Car carFord = new Car("Ford","Escape","Red");
        cars.add(carToyota);
        cars.add(carHonda);
        cars.add(carFord);
        return cars;
    }

    static void filtering2(){
        //give me red cars
        Stream<Car> redCars = makeCars().stream().filter(car -> car.color.equals("Red"));
        redCars.forEach(e -> System.out.println(e.make + ", " + e.model));
    }

    static void mapping(){
        Stream<Car> cars = makeCars().stream().map(car -> {
            if(car.color.equals("Blue"))
                return car;
            else
                return null;
        });
        if(cars!=null) cars.forEach(car -> {
            if(car!=null)
                System.out.println(car.make + ", " + car.model);
        });
    }

    static void reducing(){
        printf(createStream1().reduce(10,(a,b)->a+b));
    }

    static void collecting(){
        print(createStream2().map(e->e.toUpperCase()).collect(Collectors.toList()).stream());
    }

    static void intToInteger(){
        int[] x = {1,2,3,4,5};
        printf(IntStream.of(x).boxed().collect(Collectors.toList()));
    }

    static void iterate(){
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        print(streamIterated);
    }
        
    public static void main(String[] args) {

        print(createStream1());
        print(createStream2());

        intermediateAndTerminalOps();

        iterating();

        filtering();

        filtering2();

        mapping();

        reducing();

        collecting();

        intToInteger();
        
        iterate();

        print(createStream1().skip(2));

    }
    
}

class Car{
    String make;
    String model;
    String color;

    public Car(String make, String model, String color){
        this.make = make;
        this.model = model;
        this.color = color;
    }
}


