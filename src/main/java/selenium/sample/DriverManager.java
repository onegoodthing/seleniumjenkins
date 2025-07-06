package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    // Private Constructor to prevent instantiation
    private DriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Public method to get the instance of the class
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    // Method to get WebDriver
    public WebDriver getDriver() {
        return driver;
    }

    // Method to quit the driver
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null; // Reset instance
        }
    }
    
    // Method to handle GDPR Consent Pop-Up
    public void handleGDPRConsent() {
        try {
            WebElement acceptButton = driver.findElement(By.xpath("//button//div[contains(text(),'Accept all')]"));
            if (acceptButton.isDisplayed()) {
                acceptButton.click();
                System.out.println("GDPR consent accepted.");
            }
        } catch (Exception e) {
            System.out.println("No GDPR pop-up found, continuing test execution.");
        }
    }
}

