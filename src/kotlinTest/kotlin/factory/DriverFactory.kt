package kotlinTest.factory

import org.openqa.selenium.WebDriver

object DriverFactory {

    fun getFactory(): Factory = FirefoxWebDriverFactory() // FirefoxWebDriverFactory()

    interface Factory {
        fun build(): WebDriver
    }
}
