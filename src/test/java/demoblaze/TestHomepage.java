package demoblaze;

import com.typesafe.config.Config;
import demoblaze.config.EnvFactory;
import demoblaze.factories.DriverFactory;
import demoblaze.pages.Homepage;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHomepage {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    Homepage homepage = new Homepage(driver);
    String newphones;
    String newmonitors;


    @Tag("smokeTest")
    @DisplayName("Demoblaze Automation Test Exercise")
    @BeforeAll
    static void setDriver() {
        driver.get(HOME_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("A parameterized test for laptop products")
    @Order(1)
    @ParameterizedTest(name = "{index} => laptop=''{0}''")
    @CsvFileSource(resources = "/product.csv", numLinesToSkip = 1)
    void assertProductLaptop(String laptop, String monitors,String phones){
        homepage.setLaptopHomeLink();
        Boolean isPresent = homepage.getElementclass(driver, laptop) > 0;

        for (int i = 0; i < laptop.length(); i++) {
            if (!isPresent) {
                homepage.clickOnNextButton();
            }
            Assert.assertTrue(homepage.getElementStatus(driver, laptop));
            break;
        }
    }

    @DisplayName("A parameterized test for Monitor products")
    @Order(2)
    @ParameterizedTest(name = "{index} => monitors=''{1}''")
    @CsvFileSource(resources = "/product.csv", numLinesToSkip = 1)
    void assertProductMonitors(String laptop, String monitors, String phones) throws InterruptedException {
        homepage.setMonitorsHomeLink();
        Boolean isPresent = homepage.getElementclass(driver, monitors) > 0;
        newmonitors = monitors;

        for (int i = 0; i < monitors.length(); i++) {
            if (!isPresent) {
                homepage.clickOnNextButton();
            }
            Thread.sleep(1000);
            Assert.assertTrue(homepage.getElementStatus(driver, newmonitors));
            break;
        }
    }

    @DisplayName("A parameterized test for phone products")
    @Order(3)
    @ParameterizedTest(name = "{index} => phones=''{2}''")
    @CsvFileSource(resources = "/product.csv", numLinesToSkip = 1)
    void assertProductPhones(String laptop, String monitors,String phones) throws InterruptedException {
        homepage.setPhonesHomeLink();
        Boolean isPresent = homepage.getElementclass(driver, phones) > 0;
        newphones = phones;

        for (int i = 0; i < phones.length(); i++) {
            if (!isPresent) {
                homepage.clickOnNextButton();
            }
            Thread.sleep(1000);
            Assert.assertTrue(homepage.getElementStatus(driver, newphones));
            break;
        }
    }

    @DisplayName("Click on all buttons and navigation")
    @Test
    @Order(4)
    void assertbuttonOnhomepage(){
        homepage.setMonitorsHomeLink();
        homepage.setPhonesHomeLink();
        homepage.setLaptopHomeLink();
        homepage.clickHomepageLogo();
        homepage.clickOnNextButton();
        homepage.clickOnPreviousButton();
        homepage.clickOnCurosels();
        homepage.clickOnContactModel();
        homepage.clickOnAboutus();
        homepage.closeOnAboutusModel();
        homepage.clickOnCart();
    }

    @AfterAll
    public static void tearDown() {
        try {
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            driver.quit();
        } catch (NoSuchWindowException ignored) {
            System.out.println("Window already closed");
        }

    }
}
