package demoblaze;

import com.typesafe.config.Config;
import demoblaze.config.EnvFactory;
import demoblaze.factories.DriverFactory;
import demoblaze.pages.Signuppage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

public class TestSignup {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    static Logger log = Logger.getLogger(TestLoginpage.class);
    Signuppage signuppage = new Signuppage(driver);

    @Tag("smokeTest")
    @DisplayName("Demoblaze Automation Test Exercise")
    @BeforeAll
    static void setDriver() {
        driver.get(HOME_PAGE_URL); //Open homepage
    }

    @Test
    @Order(1)
    @DisplayName("Successful signup with random username")
    void assertSuccessSignup() {
        signuppage.setHomeSignupButton();
        signuppage.setSignupUsernameText(DriverFactory.generatedString);
        signuppage.setSignupPasswordText();
        signuppage.setSignupModelButton();
        Assert.assertEquals(signuppage.getAlertText(), "Sign up successful.");
    }

    @AfterAll
    public static void tearDown() {
        try{driver.close();} catch (Exception e) {e.printStackTrace();}
        try{driver.quit();} catch(NoSuchWindowException ignored){System.out.println("Window already closed");
        }
    }

}
