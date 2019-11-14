package kotlinTest

import org.junit.After
import org.junit.Before
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

import java.util.concurrent.TimeUnit

abstract class BaseWebDriverTest {

    lateinit var driver: WebDriver

    @Before
    fun setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe")
        driver = FirefoxDriver()
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    }

    @After
    fun afterTest() {
        driver.quit()
    }
}
