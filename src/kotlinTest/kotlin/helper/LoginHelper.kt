package kotlinTest.helper

import kotlinTest.data.LoginData
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginHelper(driver: WebDriver) : BaseHelper(driver) {

    fun login(data: LoginData) = with(driver) {
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

    fun isLoggedIn(): Boolean {
        return !driver.pageSource.contains("<input type=\"submit\" value=\"Login\" class=\"btn btn-primary\">")
    }

    fun isLoggedIn(email: String): Boolean {
        return driver.findElement(By.id("input-email")).getAttribute("value") == email
    }
}
