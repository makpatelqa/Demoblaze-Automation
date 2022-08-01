package demoblaze.pages;

import demoblaze.utils.PageActionsHelper;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signuppage {
    WebDriverWait wait;
    PageActionsHelper pageActionsHelper;

    @FindBy(id ="signin2")
    WebElement signupHomeButton;

    @FindBy(id="sign-username")
    WebElement signupUsernameText;

    @FindBy(id = "sign-password")
    WebElement signupPasswordText;

    @FindBy(css = "#signInModal .btn-primary")
    WebElement signupModelButton;


    public Signuppage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pageActionsHelper = new PageActionsHelper(driver, wait);
    }

    public void setHomeSignupButton(){
        pageActionsHelper.waitAndClick(signupHomeButton);
    }

    public void setSignupUsernameText(String str){
        pageActionsHelper.waitAndSendText(signupUsernameText, str);
    }

    public void setSignupPasswordText(){
        pageActionsHelper.waitAndSendText(signupPasswordText, "Password@123");
    }

    public void setSignupModelButton(){
        pageActionsHelper.waitAndClick(signupModelButton);
    }

    public String getAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String text = alert.getText();
        return text;
    }

}
