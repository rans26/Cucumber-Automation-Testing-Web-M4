package com.jc.randi.ujianm4.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature",
                    "src/test/resources/features/Products.feature",
                    "src/test/resources/features/Checkout.feature"},
        glue = {"com.jc.randi.ujianm4.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner {
}