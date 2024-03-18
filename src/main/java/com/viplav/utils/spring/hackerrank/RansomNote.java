package com.viplav.utils.spring.hackerrank;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents a RansomNote.
 * It provides methods to check if a ransom note can be formed from a given magazine.
 */
public class RansomNote {

    /**
     * This method checks if a ransom note can be formed from a given magazine.
     * It prints "Yes" if the note can be formed, "No" otherwise.
     *
     * @param magazine an array of strings representing the words in the magazine
     * @param note an array of strings representing the words in the ransom note
     */
    public static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String word : magazine) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        for (String word : note) {
            if (!words.containsKey(word) || words.get(word) == 0) {
                System.out.println("No");
                return;
            }
            words.put(word, words.get(word) - 1);
        }
        System.out.println("Yes");
    }

    /**
     * This method checks if a ransom note can be formed from a given magazine.
     * It uses Java 8 Lambdas for the implementation.
     * It prints "Yes" if the note can be formed, "No" otherwise.
     *
     * @param magazine an array of strings representing the words in the magazine
     * @param note an array of strings representing the words in the ransom note
     */
    public static void checkMagazineLambda(String[] magazine, String[] note) {
        HashMap<String, Integer> words = new HashMap<>();
        Arrays.stream(magazine).forEach(word -> words.compute(word, (k, v) -> v == null ? 1 : v + 1));
        for (String word : note) {
            if (!words.containsKey(word) || words.get(word) == 0) {
                System.out.println("No");
                return;
            }
            words.computeIfPresent(word, (k, v) -> v - 1);
        }
        System.out.println("Yes");
    }

     /**
     * This method checks if a ransom note can be formed from a given magazine.
     * It uses a different approach for the implementation.
     * It prints "Yes" if the note can be formed, "No" otherwise.
     *
     * @param magazine an array of strings representing the words in the magazine
     * @param note an array of strings representing the words in the ransom note
     */
    public static void checkMagazine2(String[] magazine, String[] note) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String word : magazine) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        for (String word : note) {
            if (!words.containsKey(word) || words.get(word) == 0) {
                System.out.println("No");
                return;
            }
            words.put(word, words.get(word) - 1);
            if (words.get(word) == 0) {
                words.remove(word);
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] note = { "give", "one", "grand", "today" };
        checkMagazine(magazine, note);
        checkMagazineLambda(magazine, note);
    }
}
