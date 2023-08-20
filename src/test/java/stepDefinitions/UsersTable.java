package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;

import java.util.*;

public class UsersTable {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user login as librarian")
    public void user_login_as_librarian() {
        loginPage.loginAsRole("librarian");
    }

    @When("user clicks Users link")
    public void user_clicks_users_link() {
        dashboardPage.usersLink.click();
    }

    @Then("user should be able to see below columns")
    public void user_should_be_able_to_see_below_columns(List<String> expectedHeadings) {
        List<String> actualHeadings = new ArrayList<>();
        for (WebElement item : dashboardPage.tableHeadings) {
            actualHeadings.add(item.getText());
        }
        Assert.assertEquals(expectedHeadings,actualHeadings);

    }
}
