package com.test.patientPortal.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\featureFolder"},
        glue = {"com\\test\\patientPortal\\step_definitions"},
        dryRun = true
)

public class CucRunner {
}
