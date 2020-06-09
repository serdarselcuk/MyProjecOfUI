package com.test.patientPortal.step_definitions;

import com.test.patientPortal.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static com.test.patientPortal.utils.Constants.UI_URL;

public class Hook {
    WebDriver driver = Driver.get();

    @Before
    public void startUp() {
        driver.get(UI_URL);
    }

    @After
    public void tearDown() {

        Driver.close();
    }
}
