package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.*;

public class LoginPage {


    // stale Element exception




    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement userNameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    public void loginAsRole(String role){
        Driver.getDriver().get(ConfigurationReader.getProperty("library1.url"));
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

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
