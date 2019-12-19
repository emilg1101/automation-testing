package kotlinTest

import kotlinTest.data.AddressData
import kotlinTest.data.AddressList
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import javax.xml.bind.JAXBContext
import java.io.File
import java.lang.Exception

@RunWith(value = Parameterized::class)
class AddAddressTest(val data: AddressData) : AuthBase() {

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun testData(): MutableCollection<*> {
            return getTestData("AddressData.xml")
        }

        private fun getTestData(filename: String): MutableCollection<AddressData> {
            try {
                val jc = JAXBContext.newInstance(AddressList::class.java)
                val unmarshaller = jc.createUnmarshaller()
                val xml = File(javaClass.classLoader.getResource(filename).file)
                return (unmarshaller.unmarshal(xml) as? AddressList)?.data ?: mutableListOf()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return mutableListOf()
        }
    }

    @Test
    fun sign_in_add_address_logout_test_case() {
        manager.navigation.openAddressBookPage()
        manager.address.addAddress(data)
        val addedAddress = manager.address.getAddedAddress()
        manager.address.deleteAddress()
        Assert.assertEquals(data.toString(), addedAddress)
    }
}
