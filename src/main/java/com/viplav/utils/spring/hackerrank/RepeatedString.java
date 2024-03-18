package com.viplav.utils.spring.hackerrank;

public class RepeatedString {
    public static long countAsInRepeatedString(String s, long n) {
        long count = 0;
        long len = s.length();
        long remainder = n % len;
        long repeats = n / len;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                count += (i < remainder) ? repeats + 1 : repeats;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        System.out.println(countAsInRepeatedString(s, n)); // Output: 7
    }
}
