package kotlinTest

import org.junit.Assert
import org.junit.Test

class AddAddressTest : BaseTest() {

    @Test
    fun sign_in_add_address_logout_test_case() {
        manager.navigation.openLoginPage()
        manager.login.login()
        manager.address.addAddress()
        val addedAddress = manager.address.getAddedAddress()
        manager.login.logout()
        manager.navigation.openLoginPage()
        Assert.assertEquals(manager.address.data.toString(), addedAddress)
    }
}
