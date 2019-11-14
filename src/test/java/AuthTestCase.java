import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AuthTestCase extends BaseWebDriverTestContainer {

    @Test
    public void sign_in_add_address_logout_test_case() {
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("example@example.com");
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("testtest");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgotten Password'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::a[1]")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.id("input-firstname")).click();
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Test");
        driver.findElement(By.id("input-lastname")).click();
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Test");
        driver.findElement(By.id("input-address-1")).click();
        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("Address");
        driver.findElement(By.id("input-city")).click();
        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("City");
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("654321");
        driver.findElement(By.id("input-zone")).click();
        new Select(driver.findElement(By.id("input-zone"))).selectByVisibleText("Aberdeen");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Region / State'])[1]/following::option[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ US Dollar'])[1]/following::span[2]")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}
