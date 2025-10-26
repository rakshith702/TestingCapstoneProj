package com.bmi.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/bmi/features",
        glue = "com.bmi.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestMainRunner {
}
