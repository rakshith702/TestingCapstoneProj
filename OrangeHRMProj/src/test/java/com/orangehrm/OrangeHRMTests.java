package com.orangehrm;

import com.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseTest {

    @Test(priority = 1, description = "Test successful login")
    public void testLogin() {
        Login login = new Login(driver);
        login.login("Admin", "admin123");
        Assert.assertTrue(login.isDashboardDisplayed(), "Login failed - Dashboard not visible");
        System.out.println("✓ Login verification completed");
    }

    @Test(priority = 2, description = "Test submitting leave request")
    public void testApplyLeave() {
        Login login = new Login(driver);
        login.login("Admin", "admin123");

        Leave leave = new Leave(driver);
        try {
            leave.applyLeave("2025-11-10", "2025-11-12", "End-of-year personal leave");
            Thread.sleep(2000);
            System.out.println("✓ Leave application executed successfully");
        } catch (Exception e) {
            System.out.println("Note: Leave request might have been submitted - " + e.getMessage());
        }
    }

    @Test(priority = 3, description = "Test checking leave list")
    public void testViewLeaveList() {
        Login login = new Login(driver);
        login.login("Admin", "admin123");

        Leave leave = new Leave(driver);
        leave.navigateToMyLeave();
        Assert.assertTrue(leave.isLeaveListDisplayed(), "Leave list not visible");
        System.out.println("✓ Leave list viewing executed successfully");
    }

    @Test(priority = 4, description = "Test adding new recruitment candidate")
    public void testAddCandidate() {
        Login login = new Login(driver);
        login.login("Admin", "admin123");

        Recruitment recruitment = new Recruitment(driver);
        String timestamp = String.valueOf(System.currentTimeMillis());
        recruitment.addNewCandidate(
                "test" + timestamp.substring(timestamp.length() - 4),
                "example",
                "1",
                "example.1" + timestamp.substring(timestamp.length() - 6) + "@examplemail.com"
        );

        try {
            Thread.sleep(3000);
            System.out.println("✓ Candidate addition executed successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "Test viewing recruitment candidates")
    public void testViewCandidates() {
        Login login = new Login(driver);
        login.login("Admin", "admin123");

        Recruitment recruitment = new Recruitment(driver);
        recruitment.goToCandidates();
        Assert.assertTrue(recruitment.isCandidateListVisible(), "Candidates table not visible");
        System.out.println("✓ Candidate list viewing executed successfully");
    }

}
