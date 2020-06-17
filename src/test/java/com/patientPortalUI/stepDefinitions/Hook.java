package com.patientPortalUI.stepDefinitions;

import com.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {

    @Before("@UI_Tests")
    public void startUp() {
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After("@UI_Tests")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) scenario.attach
                (
                        ((TakesScreenshot) Driver.get())
                                .getScreenshotAs(OutputType.BYTES)
                        , scenario.getName(),
                        "image.png"
                );

        Driver.close();
    }
}
