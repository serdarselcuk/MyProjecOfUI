package com.helpers;

import com.patientPortalUI.pages.BasePage;
import com.patientPortalUI.pages.HomePage;
import com.patientPortalUI.pages.MyHealthSummaryPage;
import com.patientPortalUI.pages.SignInPage;
import com.utils.Driver;

import static com.utils.Constants.*;

public class TestContext {
    public BasePage page;
    public String
            actionCenterWarning,
            prefferedName,
            featureName;


    private HomePage getHomePage() {
        return new HomePage();
    }

    private SignInPage getSignInPage() {
        return new SignInPage();
    }

    private MyHealthSummaryPage getMyHealthSummaryPage() {
        return new MyHealthSummaryPage();
    }

//    private MessagesPage getMessagesPage(){
//        return new MessagesPage();
//    }
//
//    private WellnessPage getWellnessPage(){
//        return new WellnessPage();
//    }

    public BasePage getPageOf(String pageName) {
        String p_Name = pageName.replaceAll(" ", "").toLowerCase();

        BasePage page = null;

        switch (p_Name) {
            case "homepage":
                page = getHomePage();
                break;
            case "myhealthsummarypage":
                page = getMyHealthSummaryPage();
                break;
            case "signinpage":
                page = getSignInPage();
                break;
            default:
                throw new RuntimeException(pageName + " !!!Page could not be found in context.\n Last Page was :" + Driver.get().getCurrentUrl());
        }
        return page;
    }

    public String expectedPage_URL() {

        String p_Name = featureName.replaceAll(" ", "").toLowerCase();

        switch (p_Name) {
            case "home":
                return HOME_PAGE_URL;
            case "myhealth":
                return MY_HEALTHSUMMARY_PAGE_URL;
            case "signin":
                return SIGN_IN_URL;
            case "messages":
                return MESSAGES_PAGE_URL;
            case "wellness":
                return WELLNESS_PAGE_URL;
            default:
                throw new RuntimeException(featureName + " !!!Page url could not be found in CONSTANTS.");
        }

    }


}
