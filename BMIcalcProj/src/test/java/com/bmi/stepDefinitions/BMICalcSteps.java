package com.bmi.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BMICalcSteps {
    WebDriver driver;

    @Given("user is on BMI Calculator page")
    public void user_is_on_bmi_calculator_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @When("user enters height {string} cm and weight {string} kg")
    public void user_enters_height_and_weight(String height, String weight) {
        driver.findElement(By.id("cheightmeter")).clear();
        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        driver.findElement(By.id("ckg")).clear();
        driver.findElement(By.id("ckg")).sendKeys(weight);
    }

    @When("user clicks on Calculate button")
    public void user_clicks_on_calculate_button() {
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("BMI result should be displayed")
    public void bmi_result_should_be_displayed() throws InterruptedException {
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//div[@class='bigtext']/b")).getText();
        System.out.println("Calculated BMI Result: " + result);
        driver.quit();
    }
}
