package demoblaze.pages;

import demoblaze.utils.PageActionsHelper;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkoutpage {
    WebDriverWait wait;
    PageActionsHelper pageActionsHelper;

    @FindBy(linkText = "Samsung galaxy s6")
    WebElement selectProduct;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cartLink;

    @FindBy(css = ".btn-success")
    WebElement placeOrderButton;

    @FindBy(id = "name")
    WebElement nameText;

    @FindBy(id = "country")
    WebElement countryText;

    @FindBy(id = "city")
    WebElement cityText;

    @FindBy(id = "card")
    WebElement cardText;

    @FindBy(id = "month")
    WebElement monthText;

    @FindBy(id = "year")
    WebElement yearText;

    @FindBy(css = "#orderModal .btn-primary")
    WebElement purchaseButton;



    //Initializing the Page Objects:
    public Checkoutpage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pageActionsHelper = new PageActionsHelper(driver, wait);
    }

    public void setSelectProduct(){
        pageActionsHelper.waitAndClick(selectProduct);
    }

    public void setAddToCart(){
        pageActionsHelper.waitAndClick(addToCart);
    }

    public void goToCart(){
        pageActionsHelper.waitAndClick(cartLink);
    }

    public Alert getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void setPlaceOrderButton(){
        pageActionsHelper.waitAndClick(placeOrderButton);
    }

    public boolean filloutForm(String name,String country,String city, String card, String month, String year){
        pageActionsHelper.waitAndSendText(nameText, name);
        pageActionsHelper.waitAndSendText(countryText, country);
        pageActionsHelper.waitAndSendText(cityText, city);
        pageActionsHelper.waitAndSendText(cardText, card);
        pageActionsHelper.waitAndSendText(monthText, month);
        pageActionsHelper.waitAndSendText(yearText, year);
        return true;
    }
    public void setpurchaseButton(){
        pageActionsHelper.waitAndClick(purchaseButton);
    }


}
