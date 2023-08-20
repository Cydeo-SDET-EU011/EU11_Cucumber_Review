package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;
import utilities.*;

public class LoginSteps {


    LoginPage loginPage =new LoginPage();

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
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        String expected = "Login - Library";
        Assert.assertEquals(expected,Driver.getDriver().getTitle());
    }
}
