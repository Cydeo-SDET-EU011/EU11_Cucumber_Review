package stepDefinitions;

import io.cucumber.java.en.*;

public class firstSteps {

    @Given("I provide my credentials")
    public void I_provide_my_credentials() {
        System.out.println("i provided my credentials");
    }
    @When("I print them")
    public void I_print_them() {
        System.out.println(" I print them");
    }
    @Then("I should see them in the console")
    public void I_should_see_them_in_the_console() {
        System.out.println(" then i should see them in the console");
    }


}
