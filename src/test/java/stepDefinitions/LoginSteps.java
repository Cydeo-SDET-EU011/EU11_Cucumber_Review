package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;
import utilities.*;

public class LoginSteps {


    LoginPage loginPage = new LoginPage();

    @Given("User go to library login page")
    public void user_go_to_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library1.url"));
    }

    @When("User enter student username and password and click login")
    public void user_enter_student_username_and_password_and_click_login() {
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("library.student.email"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("library.student.password"));
        loginPage.loginBtn.click();
    }

    @When("User enter library username and password and click login")
    public void user_enter_library_username_and_password_and_click_login() {
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("library.teacher.email"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("library.teacher.password"));
        loginPage.loginBtn.click();
    }

    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        String expected = "Login - Library";
        Assert.assertEquals(expected, Driver.getDriver().getTitle());
    }

    @When("user enter {string} information")
    public void userEnterInformation(String role) {

        String username = "";
        String password = "";
        switch (role.toLowerCase()) {

            case "student":
                username = ConfigurationReader.getProperty("library.student.email");
                password = ConfigurationReader.getProperty("library.student.password");
                break;

            case "librarian":
                username = ConfigurationReader.getProperty("library.teacher.email");
                password = ConfigurationReader.getProperty("library.teacher.password");
                break;
        }

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();


    }
}
