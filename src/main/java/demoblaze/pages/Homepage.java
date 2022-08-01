package demoblaze.pages;

import demoblaze.utils.PageActionsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {
    WebDriverWait wait;
    PageActionsHelper pageActionsHelper;
    int productSize;
    WebElement link;

    @FindBy(linkText = "Laptops")
    WebElement laptopHomeLink;

    @FindBy(linkText = "Monitors")
    WebElement monitorsHomeLink;

    @FindBy(linkText = "Phones")
    WebElement phonesHomeLink;

    @FindBy(id = "next2")
    WebElement nextButton;

    @FindBy(id = "prev2")
    WebElement previousButton;

    @FindBy(id="nava")
    WebElement websiteLogo;

    @FindBy(css = ".carousel-control-prev-icon")
    WebElement backCarousel;

    @FindBy(css = ".carousel-control-next-icon")
    WebElement nextCarousel;

    @FindBy(css = "#exampleModal span")
    WebElement closeContactModel;

    @FindBy(linkText = "Contact")
    WebElement contactButton;

    @FindBy(linkText = "About us")
    WebElement aboutUsLink;

    @FindBy(css = "button[class*='vjs-big-play-button']")
    WebElement playVideo;

    @FindBy(css = "#videoModal .modal-header span")
    WebElement closeAboutUsModel;

    @FindBy(id = "cartur")
    WebElement cartLink;

    //Initializing the Page Objects:
    public Homepage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pageActionsHelper = new PageActionsHelper(driver, wait);
    }

    public void setLaptopHomeLink(){
        pageActionsHelper.waitAndClick(laptopHomeLink);
    }

    public int getElementclass(WebDriver driver, String str){
        productSize = driver.findElements(By.linkText(str)).size();
        return productSize;
    }

    public Boolean getElementStatus(WebDriver driver, String str){
        link = driver.findElement(By.linkText(str));
        return pageActionsHelper.waitAndIsDisplayed(link);
    }


    public void clickOnNextButton(){
        pageActionsHelper.waitAndClick(nextButton);
    }

    public void clickOnPreviousButton(){
        pageActionsHelper.waitAndClick(previousButton);
    }

    public void setMonitorsHomeLink(){
        pageActionsHelper.waitAndClick(monitorsHomeLink);
    }

    public void setPhonesHomeLink(){
        pageActionsHelper.waitAndClick(phonesHomeLink);
    }

    public void clickHomepageLogo(){
        pageActionsHelper.waitAndClick(websiteLogo);
    }

    public void clickOnCurosels(){
        pageActionsHelper.waitAndClick(backCarousel);
        pageActionsHelper.waitAndClick(nextCarousel);
    }

    public void clickOnContactModel(){
        pageActionsHelper.waitAndClick(contactButton);
        pageActionsHelper.waitAndClick(closeContactModel);
    }

    public void clickOnAboutus(){
        pageActionsHelper.waitAndClick(aboutUsLink);
    }

    public void closeOnAboutusModel(){
        pageActionsHelper.waitAndClick(closeAboutUsModel);
    }

    public void clickOnCart(){
        pageActionsHelper.waitAndClick(cartLink);
    }

    public void setPlayVideo(){
        pageActionsHelper.waitAndClick(playVideo);
    }


}
