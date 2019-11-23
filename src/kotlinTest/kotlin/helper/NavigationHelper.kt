package kotlinTest.helper

import org.openqa.selenium.WebDriver

class NavigationHelper(driver: WebDriver, private val baseUrl: String) : BaseHelper(driver) {

    fun openLoginPage() = with(driver) {
        navigate().to("${baseUrl}account/login")
    }
}
