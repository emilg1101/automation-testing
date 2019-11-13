import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AuthTestCase {
    private RemoteWebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions());

    @Before
    public void setUp() throws Exception {
        driver = chrome.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTutorialsNinja() throws Exception {
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("example@example.com");
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("testtest");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgotten Password'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::a[1]")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.id("input-firstname")).click();
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Test");
        driver.findElement(By.id("input-lastname")).click();
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Test");
        driver.findElement(By.id("input-address-1")).click();
        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("Address");
        driver.findElement(By.id("input-city")).click();
        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("City");
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("654321");
        driver.findElement(By.id("input-zone")).click();
        new Select(driver.findElement(By.id("input-zone"))).selectByVisibleText("Aberdeen");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Region / State'])[1]/following::option[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ US Dollar'])[1]/following::span[2]")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
