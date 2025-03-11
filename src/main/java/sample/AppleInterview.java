package sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppleInterview {
	static WebDriver driver = new ChromeDriver();
	static AppleInterview apl= new AppleInterview();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		apl.handleGDPRConsent();
		
		WebElement input= driver.findElement(By.name("q"));
		input.sendKeys("Regression Testing");
		//Thread.sleep(10000);
		input.submit();
		List<WebElement> list = new ArrayList<WebElement>();
		list= driver.findElements(By.partialLinkText("regression"));
		
		
		for(WebElement we: list) {
			System.out.println("All elemnets are: "+we.getText());
		}
		
		
		}catch(Exception e) {
			e.getMessage();
		}finally{
			driver.quit();
		}
	}
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
