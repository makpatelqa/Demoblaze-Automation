package demoblaze.pages;

import demoblaze.utils.PageActionsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Loginpage {
    WebDriverWait wait;
    PageActionsHelper pageActionsHelper;

    //Find all the webelements
    @FindBy(id = "login2")
    WebElement loginHomeButton;

    @FindBy(id = "loginusername")
    WebElement usernameText;

    @FindBy(id = "loginpassword")
    WebElement passwordText;

    @FindBy(css = "#logInModal .btn-primary")
    WebElement loginModelButton;

    @FindBy(id = "logout2")
    WebElement logoutHomeButton;


    //Initializing the Page Objects:
    public Loginpage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pageActionsHelper = new PageActionsHelper(driver, wait);
    }

    //Click on homepage and enter the username
    public void setUsername(String str) throws InterruptedException {
        pageActionsHelper.waitAndClick(loginHomeButton);
        pageActionsHelper.waitAndSendText(usernameText, str);
    }

    //Enter the password
    public void setPassword(String str) throws InterruptedException {
        pageActionsHelper.waitAndSendText(passwordText, str);
    }

    //Click on login button
    public void setLoginModelButton(){
        pageActionsHelper.waitAndClick(loginModelButton);
    }

    //Check successful login
    public boolean setLogoutHomeButton(){
        return pageActionsHelper.waitAndIsDisplayed(logoutHomeButton);
    }

}
