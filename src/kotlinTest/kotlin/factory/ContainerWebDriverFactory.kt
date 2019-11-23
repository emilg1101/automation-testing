package kotlinTest.factory

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.testcontainers.containers.BrowserWebDriverContainer

class ContainerWebDriverFactory : DriverFactory.Factory {

    override fun build(): WebDriver = BrowserWebDriverContainer<Nothing>().apply {
        withCapabilities(FirefoxOptions())
    }.webDriver
}
