package kotlinTest.manager

import kotlinTest.factory.DriverFactory
import kotlinTest.helper.AddressHelper
import kotlinTest.helper.LoginHelper
import kotlinTest.helper.NavigationHelper
import org.openqa.selenium.WebDriver

class AppManager {

    private val driver: WebDriver = DriverFactory.getFactory().build()
    private val baseUrl: String = "http://tutorialsninja.com/demo/index.php?route="

    val navigation: NavigationHelper = NavigationHelper(driver, baseUrl)
    val login: LoginHelper = LoginHelper(driver)
    val address: AddressHelper = AddressHelper(driver)

    fun stop() {
        driver.quit()
    }
}
