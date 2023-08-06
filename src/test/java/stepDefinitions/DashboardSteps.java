package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.*;
import utilities.*;

import java.util.*;

public class DashboardSteps {

    LibraryLoginPage loginPage = new LibraryLoginPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Given("I logged into app")
    public void ı_logged_into_app() {
        loginPage.login();
    }

    @When("I check student navigation bar")
    public void ı_check_student_navigation_bar() {
        if (dashboardPage.userIcon.getText().contains("Student")) {
            System.out.println("The role is student");
        } else {
            System.out.println("The role is not student");

        }

    }

    @Then("I should see navigation options")
    public void ı_should_see_navigation_options(List<String> expectedList) {
        List<String> actualList = new ArrayList<>();
        for (WebElement option : dashboardPage.navOptions) {
            actualList.add(option.getText());
        }
        Assert.assertEquals(expectedList, actualList);
        Driver.closeDriver();

    }

    @When("choose classic from book categories")
    public void choose_classic_from_book_categories() {
        Select select = new Select(dashboardPage.bookCategoryDropDown);
        select.selectByVisibleText("Classic");
    }

    @Then("ISBN number should match book name")
    public void ısbn_number_should_match_book_name(Map<String, String> bookMap) {
        for (Map.Entry<String, String> name : bookMap.entrySet()) {
            String actualName = dashboardPage.getBookName(name.getKey());
            String expectedName = bookMap.get(name.getKey());
            System.out.println("actualName = " + actualName);
            System.out.println("expectedName = " + expectedName);
            Assert.assertEquals(expectedName,actualName);
        }


    }
}

