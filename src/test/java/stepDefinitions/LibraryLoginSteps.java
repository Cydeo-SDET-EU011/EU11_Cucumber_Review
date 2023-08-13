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

    @When("I enter {string} credentials and login")
    public void ı_enter_credentials_and_login(String role) {
        String username = "";
        String password = "";
        switch (role){
            case "student":
                username = ConfigurationReader.getProperty("library.student.email");
                password = ConfigurationReader.getProperty("library.student.password");
                break;
            case "librarian":
                username = ConfigurationReader.getProperty("library.teacher.email");
                password = ConfigurationReader.getProperty("library.teacher.password");
                break;
            default:
                username = ConfigurationReader.getProperty("library.student.email");
                password = ConfigurationReader.getProperty("library.student.password");

        }
        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

    }
    @Then("I should see {string} page")
    public void ı_should_see_page(String role) throws InterruptedException {
        Thread.sleep(10000);
        String actualRole = dashboardPage.userIcon.getText();
        switch (role){
            case "student":
                Assert.assertTrue( actualRole.contains("Student"));
                break;

            case "librarian":
                Assert.assertTrue(actualRole.contains("Librarian"));
                break;
        }
    }

    @When("I login with {string},{string}")
    public void i_login_with(String username, String password) {
//    loginPage.emailInput.sendKeys(username);
//    loginPage.passwordInput.sendKeys(password);
//    loginPage.loginButton.click();

        loginPage.login(username,password);

    }

    @Then("I should not be able to log in")
    public void i_should_not_be_able_to_log_in() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Login"));
    }


}
