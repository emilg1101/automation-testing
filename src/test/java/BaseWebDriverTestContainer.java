import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.concurrent.TimeUnit;

public abstract class BaseWebDriverTestContainer {

    protected WebDriver driver;

    public BaseWebDriverTestContainer() {
        super();
    }

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions());

    @Before
    public void setUp() {
        driver = chrome.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
