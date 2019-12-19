package kotlinTest

import org.junit.Assert
import org.junit.Test

class EditAccountTest : AuthBase() {

    @Test
    fun editAccount() {
        manager.navigation.openEditAccountPage()
        manager.account.editAccount()
        manager.navigation.openEditAccountPage()
        val editedAccount = manager.account.getAccount()
        Assert.assertEquals(manager.account.data, editedAccount)
    }
}
