package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\API_Scenarios"},
        glue = {"com\\patientPortalAPI\\step_definitions"},
        dryRun = false,
        strict = true
)

public class runner_API {

}
