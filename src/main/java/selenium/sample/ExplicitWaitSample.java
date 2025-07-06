package selenium.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSample {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		/*
		 * Adding code to open brave browser through selenium
		 * */
		options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://community.lambdatest.com/");
		try {
			driver.get("https://academy.naveenautomationlabs.com/");
			driver.manage().window().maximize();
			System.out.println("home page= "+driver.getTitle());	
			WebDriverWait wdw= new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement el= wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Webinars']")));
			el.click();
			System.out.println("New page="+driver.getTitle());
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			driver.quit();
		}
	}
}
