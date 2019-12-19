package kotlinTest

import kotlinTest.data.LoginData
import org.junit.Assert
import org.junit.Test

class LoginTest : BaseTest() {

    private val validData = LoginData(Settings.data.email, Settings.data.password)
    private val invalidData = LoginData("exampl@example.com", "testtesttest")

    @Test
    fun sign_in_valid_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login(validData)
        manager.navigation.openEditAccountPage()
        Assert.assertTrue(manager.login.isLoggedIn(validData.email))
    }

    @Test
    fun sign_in_invalid_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login(invalidData)
        manager.navigation.openLoginPage()
        Assert.assertTrue(!manager.login.isLoggedIn())
    }
}
