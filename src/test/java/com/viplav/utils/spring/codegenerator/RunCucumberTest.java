package com.viplav.utils.spring.codegenerator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:build/cucumber-reports.html", "json:build/cucumber.json"},
    features = "src/test/resources/features", glue = "com.viplav.utils.spring.codegenerator.stepdef", monochrome = true
)
public class RunCucumberTest {
}