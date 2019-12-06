package kotlinTest

import org.junit.Assert
import org.junit.Test

class LoginTest : BaseTest() {

    @Test
    fun sign_in_logout_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login()
        manager.login.logout()
        manager.navigation.openLoginPage()
        Assert.assertEquals("Login", manager.login.getLoginData())
    }
}
