package kotlinTest.helper

import kotlinTest.data.AddressData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

class AddressHelper(driver: WebDriver) : BaseHelper(driver) {

    val data = AddressData(
            "Test",
            "Testovich",
            "Smth address",
            "City",
            "123456",
            "Aberdeen"
    )

    fun addAddress() = with(driver) {
        findElement(By.linkText("New Address")).click()
        findElement(By.id("input-firstname")).click()
        findElement(By.id("input-firstname")).clear()
        findElement(By.id("input-firstname")).sendKeys(data.firstName)
        findElement(By.id("input-lastname")).click()
        findElement(By.id("input-lastname")).clear()
        findElement(By.id("input-lastname")).sendKeys(data.lastName)
        findElement(By.id("input-address-1")).click()
        findElement(By.id("input-address-1")).clear()
        findElement(By.id("input-address-1")).sendKeys(data.addressOne)
        findElement(By.id("input-city")).click()
        findElement(By.id("input-city")).clear()
        findElement(By.id("input-city")).sendKeys(data.city)
        findElement(By.id("input-postcode")).click()
        findElement(By.id("input-postcode")).clear()
        findElement(By.id("input-postcode")).sendKeys(data.postcode)
        findElement(By.id("input-zone")).click()
        Select(findElement(By.id("input-zone"))).selectByVisibleText(data.region)
        findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Region / State'])[1]/following::option[2]")).click()
        findElement(By.xpath("//input[@value='Continue']")).click()
    }

    fun getAddedAddress(): String {
        return driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Address Book Entries'])[1]/following::td[1]")).text
    }
}
