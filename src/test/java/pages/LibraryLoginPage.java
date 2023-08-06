package pages;

import org.bouncycastle.jcajce.provider.asymmetric.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.*;

import javax.xml.xpath.*;

public class LibraryLoginPage {

    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement msg;
}
