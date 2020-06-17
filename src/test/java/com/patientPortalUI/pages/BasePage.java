package com.patientPortalUI.pages;

import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

import static com.utils.BrowserUtils.clickWithWait;
import static com.utils.BrowserUtils.waitForPageToLoad;

public abstract class BasePage {

    static WebDriver driver;
    @FindBy(css = " ui-button-text-only.ui-state-active")
    public WebElement activeFeatureElement;

    /*
    navigates between :
        Home
        Messages
        My Health
        Wellness
    */
    @FindBy(css = "#home-button")
    protected WebElement homeButton;
    protected HashMap<String, WebElement> mainPageFeatures = new HashMap<>();

    public BasePage() {
        driver = Driver.get();
        openPage();
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String featureName) {

        List<WebElement> elements = driver.findElements(By.cssSelector("#nav-tab-collection>:nth-child(-n+4)"));

        elements.forEach(element ->
                mainPageFeatures.put(element.getText(), element)
        );

        clickWithWait(mainPageFeatures.get(featureName));
    }


    abstract public String getPageTitle();

    abstract void openPage();

    abstract public boolean isThePageOpen();

    abstract public List<String> getSelectedOptions();

    abstract public WebElement getElementByName(String elementName);

    public String getPageUrl() {
        waitForPageToLoad(5);
        return driver.getCurrentUrl();
    }

    public String getAttributeValueOf(String elementName, String attribute) {
        return getElementByName(elementName).getAttribute(attribute);
    }

    public String getTextOfElement(String elementName) {
        return getElementByName(elementName).getText();
    }

    public boolean elementIsDisplayed(String elementName) {
        return getElementByName(elementName).isDisplayed();
    }

    public boolean elementIsSelected(String elementName) {
        return getElementByName(elementName).isSelected();
    }

    public boolean elementIsEnabled(String elementName) {
        return getElementByName(elementName).isEnabled();
    }

    public void clickOn(String elementName) {
        clickWithWait(getElementByName(elementName));
    }


}
