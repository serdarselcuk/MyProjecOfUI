package com.test.patientPortal.pages;

import com.test.patientPortal.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.test.patientPortal.utils.BrowserUtils.clickWithWait;

public abstract class BasePage {

    static WebDriver driver = Driver.get();


    public BasePage() {
        driver = Driver.get();
        PageFactory.initElements(driver, this);
    }

    public static String getPageUrl() {

        return driver.getCurrentUrl();
    }

    public static <E extends Comparable<E>> boolean isSorted(List<E> list) {
        List<E> list1 = new ArrayList<E>(list);
        list.sort(Comparable::compareTo);
        return list.equals(list1);
    }

    public static <E extends Comparable<E>> Boolean isReversed(ArrayList<E> list) {
        ArrayList<E> list1 = new ArrayList<>(list);
        list1.sort(Comparator.reverseOrder());
        return list.equals(list1);
    }

    public void clickOn(String elementName) {
        clickWithWait(getElementByName(elementName));
    }

    abstract public boolean optionIsSelected(String selection);

    abstract public List<String> getSelectOptions();

    abstract public String getAttributeValue(String elementName, String attribute);

    abstract public List<String> textOfElement(String elementName);

    public abstract WebElement getElementByName(String elementName);

    boolean elementIsDisplayed(String elementName) {
        return getElementByName(elementName).isDisplayed();
    }

    boolean elementIsSelected(String elementName) {
        return getElementByName(elementName).isSelected();
    }

    boolean elementIsEnabled(String elementName) {
        return getElementByName(elementName).isEnabled();
    }

    public abstract String actualTitle();


}
