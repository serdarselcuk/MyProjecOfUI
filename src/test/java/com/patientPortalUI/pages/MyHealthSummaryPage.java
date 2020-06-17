package com.patientPortalUI.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static com.utils.Constants.MY_HEALTHSUMMARY_PAGE_URL;

public class MyHealthSummaryPage extends BasePage {

    public final static String PAGE_TITLE = "FollowMyHealth®";


    @FindBy(css = " div[data-bind*='address']")
    private WebElement addressTextElement;
    @FindBys(@FindBy(css = ".ui-widget-content.slick-row"))
    private WebElement providerElements;
    @FindBy(css = " .span6.summaryDemographicsText")
    private WebElement summaryDemographicsElement;
    @FindBy(css = ".span6.summaryDemographicsText>:nth-child(3)")
    private WebElement ageTextElement;

    @Override
    void openPage() {
        if (!isThePageOpen()) {
            driver.get(MY_HEALTHSUMMARY_PAGE_URL);
        }
        BrowserUtils.waitForPageToLoad(5);
    }

    @Override
    public boolean isThePageOpen() {
        return getPageUrl().equals(MY_HEALTHSUMMARY_PAGE_URL);
    }

    @Override
    public WebElement getElementByName(String elementName) {
        String str = elementName.replaceAll(" ", "").toLowerCase();
        switch (str) {
            case "addresstext":
                return addressTextElement;
            case "providers":
                return providerElements;
            case "summarydemographics":
                return summaryDemographicsElement;
            case "birthdaytext":
                return ageTextElement;
            default:
                throw new RuntimeException(elementName + " element could not be found in the " + this.getClass());

        }
    }

    @Override
    public String getPageTitle() {
        BrowserUtils.waitForPageTitle(PAGE_TITLE);
        return driver.getTitle();
    }

    @Override
    public List<String> getSelectedOptions() {
        return null;
    }

}
