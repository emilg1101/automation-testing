package kotlinTest.helper

import kotlinTest.data.AccountData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class AccountHelper(driver: WebDriver) : BaseHelper(driver) {

    val data = AccountData(
            "Testtesttest",
            "NoSecondName",
            "example2@example.com",
            "1357924680"
    )

    fun editAccount() = with(driver) {
        findElement(By.id("input-firstname")).click()
        findElement(By.id("input-firstname")).clear()
        findElement(By.id("input-firstname")).sendKeys(data.firstName)
        findElement(By.id("input-lastname")).click()
        findElement(By.id("input-lastname")).clear()
        findElement(By.id("input-lastname")).sendKeys(data.secondName)
        findElement(By.id("input-email")).click()
        findElement(By.id("input-email")).clear()
        findElement(By.id("input-email")).sendKeys(data.email)
        findElement(By.id("input-telephone")).click()
        findElement(By.id("input-telephone")).clear()
        findElement(By.id("input-telephone")).sendKeys(data.phone)
        findElement(By.xpath("//input[@value='Continue']")).click()
    }

    fun getAccount(): AccountData {
        val firstName = driver.findElement(By.id("input-firstname")).getAttribute("value")
        val lastName = driver.findElement(By.id("input-lastname")).getAttribute("value")
        val email = driver.findElement(By.id("input-email")).getAttribute("value")
        val phone = driver.findElement(By.id("input-telephone")).getAttribute("value")
        return AccountData(firstName, lastName, email, phone)
    }
}
