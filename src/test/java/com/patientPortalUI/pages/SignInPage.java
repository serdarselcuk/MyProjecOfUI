package com.patientPortalUI.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.utils.BrowserUtils.waitForPageTitle;
import static com.utils.BrowserUtils.waitForPageToLoad;
import static com.utils.Constants.*;

public class SignInPage extends BasePage {

    public final static String PAGE_TITLE = "FollowMyHealth® Sign In";

    @FindBy(css = "button[title ='click to sign in to your account']")
    private WebElement largeSignInButton;
    @FindBy(id = "UserName")
    private WebElement userNameTextBoxElement;
    @FindBy(id = "Password")//(type = password / text))
    private WebElement passwordTextBoxElement;
    @FindBy(css = ".signin-toggle-password-btn")
    private WebElement showPassWordButtonElement;
    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButtonElement;
    @FindBy(linkText = "I need to sign up")//or xpath //a[text()='I need to sign up'])
    private WebElement contactUsLinkElement;
    @FindBy(css = ".support.jardogs-hypertext.dropdown-toggle")//xpath //span[text()='English']
    private WebElement languageDropDownElement;
    @FindBy(linkText = "About")   //        //a[text()='About']
    private WebElement aboutElement;
    @FindBy(css = "a[href *= 'itunes.apple.com']")
    private WebElement appStoreElement;
    @FindBy(css = "a[href *= 'https://play.google.com']")
    private WebElement googlePlayElement;
    @FindBy(xpath = "//div[text()='or, use an alternative']")
    private WebElement useAnAlternative;
    @FindBy(xpath = "//div[text()='or, use an alternative']/../following-sibling::div")
    private WebElement alternativeSignInAreaHiddenElement;


    @Override
    void openPage() {
        if (!isThePageOpen()) {
            driver.get(SIGN_IN_URL);
        }
        waitForPageToLoad(5);
    }

    @Override
    public boolean isThePageOpen() {
        return getPageUrl().equals(SIGN_IN_URL);
    }

    @Override
    public WebElement getElementByName(String elementName) {
        String str = elementName.replaceAll(" ", "").toLowerCase();
        switch (str) {
            case "largesigninbutton":
                return largeSignInButton;
            case "usernametextbox":
                return userNameTextBoxElement;
            case "passwordtextbox":
                return passwordTextBoxElement;
            case "showpasswordbutton":
                return showPassWordButtonElement;
            case "signinbutton":
                return signInButtonElement;
            case "contactuslink":
                return contactUsLinkElement;
            case "languageDropDown":
                return languageDropDownElement;
            case "about":
                return aboutElement;
            case "appstore":
                return appStoreElement;
            case "googleplay":
                return googlePlayElement;
            case "useanalternative":
                return useAnAlternative;
            case "alternativesigninareahiddenelement":
                return alternativeSignInAreaHiddenElement;
            default:
                throw new RuntimeException(elementName + " element could not be found in the " + this.getClass());
        }
    }


    @Override
    public String getPageTitle() {
        waitForPageTitle(PAGE_TITLE);
        return driver.getTitle();
    }

    @Override
    public List<String> getSelectedOptions() {
        List<String> result = new ArrayList<>();
        Select select = new Select(languageDropDownElement);
        select.getOptions().forEach(p -> result.add(p.getText()));
        return result;
    }

    public boolean sendCredentials() {
        userNameTextBoxElement.sendKeys(USER_NAME);
        passwordTextBoxElement.sendKeys(PASSWORD);

        return userNameTextBoxElement.getAttribute("class").contains("ng-not-empty");
    }

    public boolean login() {

        if (sendCredentials()) {
            passwordTextBoxElement.sendKeys(Keys.ENTER);
            return true;
        } else {
            return false;
        }
    }

}
