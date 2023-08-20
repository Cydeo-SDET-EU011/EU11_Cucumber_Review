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

    /*


    1. id
    2. name
    3. classname
    4. tagname
    5. linktext
    6. partiallinktext
     */

    /*
    custome locators
    css  and xpath

    css:
    snippet: tagName[attributeName='attribute vale']
    example: span[class='title']

    shortcut   using   "."  or "#"
    . stands for clas (if class value has space, you should replace that space with .)
    # stands for id

    example: span.title


    xpath:
    absolute xpath snippet: /html/body/ul/li/span
    relative xpath snippet:  //li[@attributeName='attribute value']
    example:  //span[@class='title']

     */

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//th[@rowspan='1']")
    public List<WebElement> tableHeadings;








    public String getBookName(String isbn){
        String xpath = "(//td[.='" + isbn + "']/following-sibling::td)[1]";
        WebElement book = Driver.getDriver().findElement(By.xpath(xpath));
        return book.getText();
    }

}
