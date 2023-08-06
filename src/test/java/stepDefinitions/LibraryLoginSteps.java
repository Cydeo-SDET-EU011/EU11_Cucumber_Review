package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import pages.*;
import utilities.*;

public class LibraryLoginSteps {

    LibraryLoginPage loginPage = new LibraryLoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am on the login page")
    public void ı_am_on_the_login_page() {
        Driver.getDriver().get("https://library1.cydeo.com/login.html");
    }
    @When("I enter valid credentials and login")
    public void ı_enter_valid_credentials_and_login() {
        loginPage.emailInput.sendKeys("student1@library");
        loginPage.passwordInput.sendKeys("libraryUser");
        loginPage.loginButton.click();
    }
    @Then("I should be on the dashboard")
    public void ı_should_be_on_the_dashboard() {
        String actualTitle = dashboardPage.title.getText();
        String expectedTitle = "Book Management";
        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.closeDriver();
    }

    @When("I enter invalid credentials and login")
    public void ı_enter_invalid_credentials_and_login() {
        loginPage.emailInput.sendKeys("student1@libraryinvalid");
        loginPage.passwordInput.sendKeys("libraryUserinvalid");
        loginPage.loginButton.click();
    }

    @Then("I should not be on the dashboard")
    public void ı_should_not_be_on_the_dashboard() throws InterruptedException {
        Thread.sleep(3000);
        String actualMsg = loginPage.msg.getText();
        String expectedMsg = "Sorry, Wrong Email or Password";
        Assert.assertEquals(expectedMsg,actualMsg);
        Driver.closeDriver();
    }
}
