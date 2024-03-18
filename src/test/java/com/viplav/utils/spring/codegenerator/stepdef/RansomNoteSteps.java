package com.viplav.utils.spring.codegenerator.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import com.viplav.utils.spring.hackerrank.RansomNote;

public class RansomNoteSteps {

    private String[] magazine;
    private String[] note;
    private String result;

    @Given("I have a magazine with words {string}")
    public void i_have_a_magazine_with_words(String magazineWords) {
        magazine = magazineWords.split(" ");
    }

    @Given("I have a ransom note with words {string}")
    public void i_have_a_ransom_note_with_words(String noteWords) {
        note = noteWords.split(" ");
    }

    @When("I try to create the ransom note from the magazine")
    public void i_try_to_create_the_ransom_note_from_the_magazine() {
        try {
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));
            RansomNote.checkMagazine(magazine, note);
            result = outContent.toString().trim();
        } finally {
            System.setOut(System.out);
        }
    }

    @Then("I should be able to create the ransom note")
    public void i_should_be_able_to_create_the_ransom_note() {
        assertEquals("Yes", result);
    }
}