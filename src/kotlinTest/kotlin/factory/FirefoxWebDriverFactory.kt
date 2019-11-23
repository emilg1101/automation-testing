package kotlinTest.factory

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit

class FirefoxWebDriverFactory : DriverFactory.Factory {

    init {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe")
    }

    override fun build(): WebDriver =
            FirefoxDriver().also {
                it.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
            }
}
