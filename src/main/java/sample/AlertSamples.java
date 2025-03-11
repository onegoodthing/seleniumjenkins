package sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSamples {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://www.selenium.dev/selenium/web/alerts.html");
            driver.manage().window().maximize();

            /** Handle prompt alert with input*/
            driver.findElement(By.id("prompt")).click();
            Alert promptAlert = driver.switchTo().alert();
            promptAlert.sendKeys("Selenium Test");
            promptAlert.accept();

            /**Simple Alert Accept*/
            driver.findElement(By.id("alert")).click();
            Alert simple = driver.switchTo().alert();
            simple.accept();


            /**Simple Alert Dismiss*/
            driver.findElement(By.id("alert")).click();
            simple.dismiss();

            /**Slow Alert Check with explicit wait*/
            driver.findElement(By.id("slow-alert")).click();
            WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert slow = wdw.until(ExpectedConditions.alertIsPresent());
            slow.accept();

        } catch (Exception e) {
            e.getMessage();
        } finally {
            driver.quit();
        }
    }

}
