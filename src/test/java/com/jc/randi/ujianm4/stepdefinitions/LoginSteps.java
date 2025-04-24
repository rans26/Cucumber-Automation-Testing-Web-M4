package com.jc.randi.ujianm4.stepdefinitions;

import com.jc.randi.ujianm4.Pages.LoginPage;
import com.jc.randi.ujianm4.Pages.ProductPage;
import com.jc.randi.ujianm4.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    ProductPage productsPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        Thread.sleep(1000);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        productsPage = new ProductPage(DriverManager.getDriver());
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }
}
