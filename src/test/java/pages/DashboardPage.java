package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.*;

import java.util.*;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h3")
    public WebElement title;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    public WebElement userIcon;

    @FindBy(xpath = "//li[@class='nav-item']")
    public List<WebElement> navOptions;

    @FindBy(id = "book_categories")
    public WebElement bookCategoryDropDown;


    public String getBookName(String isbn){
        String xpath = "(//td[.='" + isbn + "']/following-sibling::td)[1]";
        WebElement book = Driver.getDriver().findElement(By.xpath(xpath));
        return book.getText();
    }

}
