package kotlinTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.testcontainers.containers.BrowserWebDriverContainer

import java.util.concurrent.TimeUnit

abstract class BaseWebDriverTestContainer {

    lateinit var driver: WebDriver

    @Rule
    var chrome: BrowserWebDriverContainer<*> = BrowserWebDriverContainer<Nothing>().withCapabilities(FirefoxOptions())

    @Before
    fun setUp() {
        driver = chrome.getWebDriver()
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    }

    @After
    fun afterTest() {
        driver.quit()
    }
}
