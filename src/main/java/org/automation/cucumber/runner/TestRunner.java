package org.automation.cucumber.runner;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/org/automation/cucumber/feature",
        glue = "org.automation.cucumber.stepDefinations",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true,
        tags = "@smoke"
)
public class TestRunner {
}
