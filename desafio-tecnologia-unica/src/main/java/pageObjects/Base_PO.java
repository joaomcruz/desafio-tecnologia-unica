package pageObjects;

import Driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Variables;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }


    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }


    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_EXPLICIT_TIMEOUT));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<WebElement> returnWebElementPath(String element) {
        return getDriver().findElements(By.cssSelector(element));
    }

    public void waitForWebElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.PAGE_LOAD_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementsToBeVisible(WebElement element1, WebElement element2) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.PAGE_LOAD_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element1));
        wait.until(ExpectedConditions.visibilityOf(element2));
    }

    public void waitForListToBeVisible(List<WebElement> list) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }


    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_EXPLICIT_TIMEOUT));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void checkListIsNotEmpty(List<WebElement> list) {
        if (list.isEmpty()) {
            throw new NullPointerException(toString());
        }
    }

    public WebElement clickFirstElementRegularList(List<WebElement> listElements) {
        waitForListToBeVisible(listElements);
        try {
            checkListIsNotEmpty(listElements);
            listElements.get(0).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listElements.get(0);
    }

    public void clickFirstElementSpecialList(List<WebElement> listElements){
        checkListIsNotEmpty(listElements);
        listElements.get(0).click();
    }


    public void assertWebElementsString(String element1, WebElement actualPageElement) {
        waitForWebElementToBeVisible(actualPageElement);
        try {
            Assert.assertEquals(element1.toLowerCase(), actualPageElement.getText().toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void webElementContainsString(String stringToAssert, WebElement element) {
        waitForWebElementToBeVisible(element);
        try {
            assertThat(element.getText().toLowerCase()).contains(stringToAssert.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkReturnedNamesFromList(List<WebElement> listToCompare, String itemNameToCheck) {
        waitForListToBeVisible(listToCompare);
        for (WebElement item : listToCompare) {
            webElementContainsString(itemNameToCheck, item);
        }
    }


    public void webElementsContainsString(String stringToAssert, WebElement element1, WebElement element2) {
        waitForWebElementsToBeVisible(element1, element2);
        try {
            assertThat(element1.getText().toLowerCase()).contains(stringToAssert.toLowerCase());
            assertThat(element2.getText().toLowerCase()).contains(stringToAssert.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void webElementStringAssertion(WebElement element, String stringToAssert) {
        waitForWebElementToBeVisible(element);
        try {
            Assert.assertEquals(element.getText().toLowerCase(), stringToAssert.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void assertWebElementWithSelect(WebElement element1, Select element2) {
        Assert.assertEquals(element1.getText().replaceAll("[^\\d]", ""), element2.getFirstSelectedOption().getText());
    }


    public static void takeScreenshot(WebDriver driver, String filepath, String filename) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(filepath + File.separator + filename + "." + "jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
