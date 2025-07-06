package selenium.sample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

/**
 * Demonstrates exception handling in Selenium WebDriver while automating OpenCart.
 * 
 * <p>This program:
 * <ul>
 *   <li>Opens the OpenCart demo website</li>
 *   <li>Handles multiple Selenium-related exceptions</li>
 *   <li>Ensures proper cleanup by closing the browser</li>
 * </ul>
 * </p>
 * 
 * @author Siddhant
 * @version 1.0
 */
public class ExceptionHandlingDemo {
    
    /**
     * Main method to execute Selenium test case with exception handling.
     * 
     * <p>It opens the OpenCart demo website, attempts to perform a search,
     * and handles different Selenium exceptions gracefully.</p>
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open OpenCart demo website
            driver.get("https://demo.opencart.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            /**
             * Try to find the search box and perform a search operation.
             * 
             * Catches multiple exceptions:
             * <ul>
             *   <li>{@link NoSuchElementException} - If the search box is not found</li>
             *   <li>{@link StaleElementReferenceException} - If the element becomes stale</li>
             *   <li>{@link TimeoutException} - If the page takes too long to load</li>
             *   <li>{@link WebDriverException} - Any unexpected WebDriver issues</li>
             *   <li>{@link Exception} - General exception for any other errors</li>
             * </ul>
             * 
             */
            try {
                WebElement searchBox = driver.findElement(By.name("search"));
                searchBox.sendKeys("iPhone" + Keys.ENTER);
                System.out.println("✅ Search executed successfully.");
            } catch (NoSuchElementException e) {
                System.out.println("❌ NoSuchElementException: Element not found!");
            } catch (StaleElementReferenceException e) {
                System.out.println("❌ StaleElementReferenceException: Element is not attached to the page.");
            } catch (TimeoutException e) {
                System.out.println("❌ TimeoutException: Operation took too long.");
            } catch (WebDriverException e) {
                System.out.println("❌ WebDriverException: Issue with WebDriver.");
            } catch (Exception e) {
                System.out.println("❌ General Exception: " + e.getMessage());
            }

        } finally {
            /**
             * Ensures the browser is closed, preventing resource leaks.
             */
            driver.quit();
            System.out.println("✅ Browser closed successfully.");
        }
    }
}
