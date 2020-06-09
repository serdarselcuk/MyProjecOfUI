package com.test.patientPortal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sign_In_Page extends BasePage {

    public final static String PAGE_TITLE = "FollowMyHealth® Sign In";

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
    @FindBy(linkText = "English")//xpath //span[text()='English']
    private WebElement englishDropDownElement;
    @FindBy(linkText = "About")   //        //a[text()='About']
    private WebElement aboutElement;
    @FindBy(css = "a[href *= 'itunes.apple.com']")
    private WebElement appStoreElement;
    @FindBy(css = "a[href *= 'https://play.google.com']")
    private WebElement googlePlayElement;
    @FindBy(xpath = "//div[text()='or, use an alternative']")
    private WebElement useAnAlternative;
    @FindBy(xpath = "//div[text()='or, use an alternative']/../following-sibling::div")
    private WebElement areaHiddenElement;

    @Override
    public WebElement getElementByName(String elementName) {
        elementName = elementName.replaceAll(" ", "").toLowerCase();
        switch (elementName) {
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
            case "englishdropdown":
                return englishDropDownElement;
            case "about":
                return aboutElement;
            case "appstore":
                return appStoreElement;
            case "googleplay":
                return googlePlayElement;
            case "useanalternative":
                return useAnAlternative;
            case "areahidden":
                return areaHiddenElement;
            default:
                throw new RuntimeException("element could not be found in the Sign_in_Page.class");
        }
    }

    @Override
    public String actualTitle() {
        return driver.getTitle();
    }

    @Override
    public boolean optionIsSelected(String selection) {

        return getElementByName("english DropDown").isSelected();

    }

    @Override
    public List<String> getSelectOptions() {
        List<String> result = new ArrayList<>();
        Select select = new Select(getElementByName("englishdropdown"));
        select.getOptions().forEach(p -> result.add(p.getText()));
        return result;
    }

    @Override
    public String getAttributeValue(String elementName, String attribute) {
        return getElementByName(elementName).getAttribute(attribute);
    }

    public List<String> textOfElement(String elementName) {
        String[] str = getElementByName("englishdropdown").getText().split(" ");
        return new LinkedList<>(Arrays.asList(str));

    }

}
