package selenium.sample;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			try {
				driver.get("https://academy.naveenautomationlabs.com/");
				driver.manage().window().maximize();
				System.out.println("home page= "+driver.getTitle());	
				
				Wait<WebDriver> wdw = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
		                .pollingEvery(Duration.ofSeconds(5))
		                .ignoring(NoSuchElementException.class);
				
				//el.click();
				System.out.println("New page="+driver.getTitle());
			}catch(Exception e) {
				e.getMessage();
			}finally{
				driver.quit();
			}
		
	}

}
