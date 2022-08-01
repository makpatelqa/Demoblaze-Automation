package demoblaze.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActionsHelper{
    WebDriverWait wait;
    WebDriver driver;

    public PageActionsHelper(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.wait = wait;
    }

    // Wait for the web element and click
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf((WebElement) element)).click();
    }

    // Wait for the web element and get text
    public String waitAndGetText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public Boolean waitAndIsDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void waitAndSendText(WebElement element, String str) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(str);
    }

    public void waitAForWebelement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
