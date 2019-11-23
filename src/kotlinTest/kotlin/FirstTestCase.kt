package kotlinTest

import org.junit.Test

class FirstTestCase : BaseTest() {

    @Test
    fun sign_in_logout_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login()
        manager.login.logout()
        manager.navigation.openLoginPage()
    }

    @Test
    fun sign_in_add_address_logout_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login()
        manager.address.addAddress()
        manager.login.logout()
        manager.navigation.openLoginPage()
    }
}
