package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Leave {
    private WebDriver driver;
    private WebDriverWait wait;

    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By applyButton = By.linkText("Apply");
    private By leaveTypeDropdown = By.xpath("//label[text()='Leave Type']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private By leaveTypeOption = By.xpath("//div[@role='option']/span");
    private By fromDateField = By.xpath("//label[text()='From Date']/parent::div/following-sibling::div//input");
    private By toDateField = By.xpath("//label[text()='To Date']/parent::div/following-sibling::div//input");
    private By commentsField = By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea");
    private By applyLeaveButton = By.cssSelector("button[type='submit']");
    private By myLeaveLink = By.linkText("My Leave");
    private By leaveListTable = By.cssSelector(".oxd-table");

    public Leave(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu));
        driver.findElement(leaveMenu).click();
    }

    public void clickApply() {
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).click();
    }

    public void selectLeaveType() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown));
        driver.findElement(leaveTypeDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeOption));
        driver.findElements(leaveTypeOption).get(1).click();
    }

    public void enterFromDate(String date) {
        WebElement fromDate = driver.findElement(fromDateField);
        fromDate.clear();
        fromDate.sendKeys(date);
    }

    public void enterToDate(String date) {
        WebElement toDate = driver.findElement(toDateField);
        toDate.clear();
        toDate.sendKeys(date);
    }

    public void enterComments(String comments) {
        driver.findElement(commentsField).sendKeys(comments);
    }

    public void clickApplyLeaveButton() {
        driver.findElement(applyLeaveButton).click();
    }

    public void applyLeave(String fromDate, String toDate, String comments) {
        navigateToLeave();
        clickApply();
        selectLeaveType();
        enterFromDate(fromDate);
        enterToDate(toDate);
        enterComments(comments);
        clickApplyLeaveButton();
    }

    public void navigateToMyLeave() {
        navigateToLeave();
        wait.until(ExpectedConditions.elementToBeClickable(myLeaveLink));
        driver.findElement(myLeaveLink).click();
    }

    public boolean isLeaveListDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(leaveListTable));
            return driver.findElement(leaveListTable).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
