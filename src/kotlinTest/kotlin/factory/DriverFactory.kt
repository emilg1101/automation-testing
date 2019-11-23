package kotlinTest.factory

import org.openqa.selenium.WebDriver

object DriverFactory {

    fun getFactory(): Factory = ContainerWebDriverFactory() // FirefoxWebDriverFactory()

    interface Factory {
        fun build(): WebDriver
    }
}
