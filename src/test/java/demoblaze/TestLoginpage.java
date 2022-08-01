package demoblaze;

import demoblaze.config.EnvFactory;
import demoblaze.factories.DriverFactory;
import demoblaze.pages.Loginpage;
import com.typesafe.config.Config;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLoginpage {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    Loginpage loginpage = new Loginpage(driver);

    @Tag("smokeTest")
    @DisplayName("Demoblaze Automation Test Exercise")
    @BeforeAll
    static void setDriver() {
        driver.get(HOME_PAGE_URL); //Open homepage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("Login with valid username and password")
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void assertLogin(String username, String password) throws InterruptedException {
        loginpage.setUsername(username);
        loginpage.setPassword(password);
        loginpage.setLoginModelButton();
        Assert.assertTrue(loginpage.setLogoutHomeButton());
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
