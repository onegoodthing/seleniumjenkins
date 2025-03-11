package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSample {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://academy.naveenautomationlabs.com/");
			driver.manage().window().maximize();
			System.out.println("home page= "+driver.getTitle());	
			WebDriverWait wdw= new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement el= wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Webinars']")));
			el.click();
			System.out.println("New page="+driver.getTitle());
		}catch(Exception e) {
			e.getMessage();
		}finally{
			driver.quit();
		}
	}
}
