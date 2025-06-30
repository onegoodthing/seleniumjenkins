package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.net.ssl.HttpsURLConnection;

import java.net.URL;
import java.util.List;

public class CheckBrokenLinks {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/");
        driver.manage().window().maximize();
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

}
