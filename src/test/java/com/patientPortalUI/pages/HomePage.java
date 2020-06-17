package com.patientPortalUI.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.utils.BrowserUtils.waitForPresenceOfElement;
import static com.utils.Constants.HOME_PAGE_URL;

public class HomePage extends BasePage {

    public final static String PAGE_TITLE = "FollowMyHealth®";

    @FindBy(css = "#action-center-views")
    private WebElement actionCenterViews;


    @Override
    void openPage() {
        if (!isThePageOpen()) {
            driver.get(HOME_PAGE_URL);
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @Override
    public boolean isThePageOpen() {
        return getPageUrl().equals(HOME_PAGE_URL);
    }

    public String getPageUrl() {

        waitForPresenceOfElement("#home-button");
        return driver.getCurrentUrl();
    }


    @Override
    public List<String> getSelectedOptions() {
        return null;
    }

    @Override
    public WebElement getElementByName(String elementName) {
        String str = elementName.replaceAll(" ", "").toLowerCase();
        switch (str) {
            case "actioncenterviews":
                return actionCenterViews;
            default:
                throw new RuntimeException(elementName + " element could not be found in the " + this.getClass());

        }
    }

    @Override
    public String getPageTitle() {

        BrowserUtils.waitForPageTitle(PAGE_TITLE);
        return driver.getTitle();
    }
}
