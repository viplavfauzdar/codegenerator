package com.viplav.utils.spring.hackerrank;

public class CloudJump {

    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else {
                i += 1;
            }
            jumps += 1;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] clouds = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(clouds)); // Output: 4

        System.out.println(System.getProperty("java.io.tmpdir"));
    }
    
}
