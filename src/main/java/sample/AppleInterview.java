package sample;

import java.util.Arrays;
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
		checkSecondHighest();
		try {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		apl.handleGDPRConsent();
		
		WebElement input= driver.findElement(By.name("q"));
		input.sendKeys("Regression Testing");
		//Thread.sleep(10000);
		input.submit();
		List<WebElement> list;
		list= driver.findElements(By.partialLinkText("regression"));
		for(WebElement we: list) {
			System.out.println("All elements are: "+we.getText());
		}
		} catch (NullPointerException e) {
			e.getMessage();
			throw new NullPointerException();
		}
		finally{
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
	public static void checkSecondHighest(){
		try {
			int[] a = {23,87,32,78,99,99,89,99};
			Arrays.sort(a);
				System.out.println(Arrays.toString(a));
				System.out.println("Second Highest "+a[a.length-2]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
