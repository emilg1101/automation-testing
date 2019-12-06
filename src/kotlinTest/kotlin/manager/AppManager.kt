package kotlinTest.manager

import kotlinTest.factory.DriverFactory
import kotlinTest.helper.AccountHelper
import kotlinTest.helper.AddressHelper
import kotlinTest.helper.LoginHelper
import kotlinTest.helper.NavigationHelper
import org.openqa.selenium.WebDriver
import kotlin.concurrent.getOrSet

class AppManager {

    private val driver: WebDriver = DriverFactory.getFactory().build()
    private val baseUrl: String = "http://tutorialsninja.com/demo/index.php?route="

    val navigation: NavigationHelper = NavigationHelper(driver, baseUrl)
    val login: LoginHelper = LoginHelper(driver)
    val address: AddressHelper = AddressHelper(driver)
    val account: AccountHelper = AccountHelper(driver)

    companion object {
        private val thread = ThreadLocal<AppManager>()

        fun getInstance() = thread.getOrSet { AppManager() }
    }

    fun stop() {
        driver.quit()
    }
}
