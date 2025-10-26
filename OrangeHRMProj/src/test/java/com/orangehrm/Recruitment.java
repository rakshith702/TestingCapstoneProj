package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Recruitment {
    private WebDriver driver;
    private WebDriverWait wait;

    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By firstNameField = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField = By.name("lastName");
    private By emailField = By.xpath("//label[text()='Email']/parent::div/following-sibling::div//input");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By candidatesLink = By.linkText("Candidates");
    private By candidateTable = By.cssSelector(".oxd-table");
    private By deleteButton = By.xpath("//i[contains(@class,'bi-trash')]");
    private By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By editButton = By.xpath("//i[contains(@class,'bi-pencil')]");

    public Recruitment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToRecruitment() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu));
        driver.findElement(recruitmentMenu).click();
    }

    public void pressAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        driver.findElement(addButton).click();
    }

    public void inputFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputMiddleName(String middleName) {
        driver.findElement(middleNameField).sendKeys(middleName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void pressSave() {
        driver.findElement(saveButton).click();
    }

    public void addNewCandidate(String firstName, String middleName, String lastName, String email) {
        goToRecruitment();
        pressAddButton();
        inputFirstName(firstName);
        inputMiddleName(middleName);
        inputLastName(lastName);
        inputEmail(email);
        pressSave();
    }

    public void goToCandidates() {
        goToRecruitment();
        wait.until(ExpectedConditions.elementToBeClickable(candidatesLink));
        driver.findElement(candidatesLink).click();
    }

    public boolean isCandidateListVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(candidateTable));
            return driver.findElement(candidateTable).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeFirstCandidate() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        driver.findElements(deleteButton).get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        driver.findElement(confirmDeleteButton).click();
    }

    public void editFirstCandidate() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        driver.findElements(editButton).get(0).click();
    }

    public void updateCandidateMiddle(String newMiddleName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(middleNameField));
        WebElement middle = driver.findElement(middleNameField);
        middle.clear();
        middle.sendKeys(newMiddleName);
        pressSave();
    }
}
