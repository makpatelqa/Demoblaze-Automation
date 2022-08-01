package demoblaze;

import com.typesafe.config.Config;
import demoblaze.config.EnvFactory;
import demoblaze.factories.DriverFactory;
import demoblaze.pages.Homepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TestAboutus {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    Homepage homepage = new Homepage(driver);

    @Tag("smokeTest")
    @DisplayName("Demoblaze Automation Test Exercise")
    @BeforeAll
    static void setDriver() {
        driver.get(HOME_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @DisplayName("Play video on about-us page")
    @Test
    void playAboutUsVideo() throws InterruptedException {
        homepage.clickOnAboutus();
        homepage.setPlayVideo();
        Thread.sleep(2000);
        homepage.closeOnAboutusModel();
    }

    @AfterAll
    public static void tearDown() {
        try{driver.close();} catch (Exception e) {e.printStackTrace();}
        try{driver.quit();} catch(NoSuchWindowException ignored){System.out.println("Window already closed");
        }
    }


}
