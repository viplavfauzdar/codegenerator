package com.viplav.utils.spring.codegenerator.hackerrank;

import org.junit.jupiter.api.Test;

import com.viplav.utils.spring.hackerrank.RansomNote;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RansomNoteTest {

    @Test
    public void testCheckMagazine() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] note = { "give", "one", "grand", "today" };
        RansomNote.checkMagazine(magazine, note);

        assertEquals("Yes\n", outContent.toString());
    }

    @Test
    public void testCheckMagazineLambda() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] note = { "give", "one", "grand", "today" };
        RansomNote.checkMagazineLambda(magazine, note);

        assertEquals("Yes\n", outContent.toString());
    }

    @Test
    public void testCheckMagazine2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String[] magazine = { "give", "me", "one", "grand", "today", "night" };
        String[] note = { "give", "one", "grand", "today" };
        RansomNote.checkMagazine2(magazine, note);

        assertEquals("Yes\n", outContent.toString());
    }
}