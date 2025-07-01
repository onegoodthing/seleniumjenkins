package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.List;
/**
 * Adding Java class to check for broken links in a website
 * It first accept the cookie setting to necessary then use a web element list and send the ulr to
 * checkLinksRequestCode method to check for request status
 * */
public class CheckBrokenLinks {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();

        driver.get("https://personalbanking.bankofireland.com/borrow/loans/car-loan/");
        driver.manage().window().maximize();
        acceptNecessaryCookies(driver);

        try {
            List<WebElement> webElementLink = driver.findElements(By.tagName("a"));
            for (WebElement checkBrokenLink : webElementLink) {
                String url = checkBrokenLink.getDomAttribute("href");
                checkLinksRequestCode(url);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            driver.quit();
        }
       }

    public static void checkLinksRequestCode(String url){
    try{
    HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();
    con.setRequestMethod("HEAD");
    con.connect();
    int responseCode = con.getResponseCode();
    if(responseCode >= 400){
        System.out.println(url+" this link is broken");
    }
    } catch (Exception e) {
        System.out.println(url + " is a broken link");
    }
    }
/**
 * This method only accept necessary Cookies
 * **/
    public static void acceptNecessaryCookies(WebDriver driver ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("onetrust-reject-all-handler"))).click();
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
    }
}
