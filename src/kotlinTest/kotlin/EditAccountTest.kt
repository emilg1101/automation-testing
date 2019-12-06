package kotlinTest

import org.junit.Assert
import org.junit.Test

class EditAccountTest : BaseTest() {

    @Test
    fun editAccount() {
        manager.navigation.openLoginPage()
        manager.login.login()
        manager.navigation.openEditAccountPage()
        manager.account.editAccount()
        manager.navigation.openEditAccountPage()
        val editedAccount = manager.account.getAccount()
        manager.login.logout()
        manager.navigation.openLoginPage()
        Assert.assertEquals(manager.account.data, editedAccount)
    }
}