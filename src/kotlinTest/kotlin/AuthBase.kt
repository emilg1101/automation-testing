package kotlinTest

import kotlinTest.data.LoginData
import org.junit.Before

abstract class AuthBase : BaseTest() {

    private val validData = LoginData(Settings.data.email, Settings.data.password)

    @Before
    override fun setUp() {
        manager.navigation.openLoginPage()
        if (!manager.login.isLoggedIn()) {
            manager.login.login(validData)
        }
        manager.navigation.openLoginPage()
    }
}
