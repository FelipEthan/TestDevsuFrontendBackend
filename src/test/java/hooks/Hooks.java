package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            driver = BasePage.initializeDriver(browser);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
