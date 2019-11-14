import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseWebDriverTest {

    protected WebDriver driver;

    public BaseWebDriverTest() {
        super();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
