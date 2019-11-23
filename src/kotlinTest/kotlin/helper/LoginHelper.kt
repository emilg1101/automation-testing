package kotlinTest.helper

import kotlinTest.data.LoginData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginHelper(driver: WebDriver) : BaseHelper(driver) {

    private val data = LoginData("example@example.com", "testtest")

    fun login() = with(driver){
        findElement(By.id("input-email")).click()
        findElement(By.id("input-email")).clear()
        findElement(By.id("input-email")).sendKeys(data.email)
        findElement(By.id("input-password")).clear()
        findElement(By.id("input-password")).sendKeys(data.password)
        findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgotten Password'])[1]/following::input[1]")).click()
        findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::a[1]")).click()
    }

    fun logout() = with(driver) {
        Thread.sleep(1000)
        findElement(By.linkText("Logout")).click()
    }
}
