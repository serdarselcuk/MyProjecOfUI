package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\API_Scenarios"},
        glue = {"com\\patientPortalAPI\\step_definitions"},
        dryRun = false,
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)

public class runner_API {

}
