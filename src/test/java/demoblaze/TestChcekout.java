package demoblaze;

import com.typesafe.config.Config;
import demoblaze.config.EnvFactory;
import demoblaze.factories.DriverFactory;
import demoblaze.pages.Checkoutpage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestChcekout {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    Checkoutpage checkoutpage = new Checkoutpage(driver);

    @Tag("smokeTest")
    @DisplayName("Demoblaze Automation Test Exercise")
    @BeforeAll
    static void setDriver() {
        driver.get(HOME_PAGE_URL); //Open homepage
    }

    @DisplayName("Checkout scenario")
    @ParameterizedTest(name = "E2E checkout")
    @CsvFileSource(resources = "/testuser.csv", numLinesToSkip = 1)
    void AssertCheckout(String name,String country,String city, String card, String month, String year) throws InterruptedException {
        checkoutpage.setSelectProduct();
        checkoutpage.setAddToCart();
        checkoutpage.getAlert().accept();
        checkoutpage.goToCart();
        checkoutpage.setPlaceOrderButton();
        checkoutpage.filloutForm(name, country, city, card, month, year);
        checkoutpage.setpurchaseButton();
    }

    @AfterAll
    public static void tearDown() {
        try{driver.close();} catch (Exception e) {e.printStackTrace();}
        try{driver.quit();} catch(NoSuchWindowException ignored){System.out.println("Window already closed");
        }
    }

}
