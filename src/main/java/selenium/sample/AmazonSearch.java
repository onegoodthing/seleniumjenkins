package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.amazon.ie/");
            driver.manage().window().maximize();

            // Accept cookies if the dialog is present
            try {
                WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
                acceptButton.click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("No cookies banner displayed.");
            }

            // Search for phones
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("phones" + Keys.ENTER);

            System.out.println("Search executed. Title: " + driver.getTitle());

            // Check for broken links on the resulting page
            checkBrokenLinks(driver);
        } finally {
            driver.quit();
        }
    }

    private static void checkBrokenLinks(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Checking " + links.size() + " links for validity...");
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href == null || href.isBlank()) {
                continue;
            }
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(href).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("Broken link: " + href + " (code " + responseCode + ")");
                }
            } catch (Exception e) {
                System.out.println("Error checking link: " + href + " - " + e.getMessage());
            }
        }
    }
}
