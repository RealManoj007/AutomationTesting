package org.automation.cucumber.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Hello World");
    }

    @When("user enter username and password")
    public void uenterUsernameAndPassword() {
        System.out.println("User enters username and password");
    }
    @And("click on login button")
    public void clickOnLoginButton() {
        System.out.println("User clicks on login button");
    }
    @Then("user is navigated to the home page")
    public void userNavigatedToHomePage() {
        System.out.println("User is navigated to the home page");
    }

}
