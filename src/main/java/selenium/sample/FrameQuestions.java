package selenium.sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		try {
			
			/* Handle Sample Frame **/
			driver.get("https://demoqa.com/frames");
			driver.switchTo().frame("frame1");
			String frameText = driver.findElement(By.id("sampleHeading")).getText();
			System.out.println(frameText); // "This is a sample page"
			driver.switchTo().defaultContent(); // Return to main page
			
			
			/* Handle nested frames */
			driver.get("https://demoqa.com/nestedframes");
			// Switch to parent frame
			driver.switchTo().frame("frame1");
			// Switch to child frame inside parent
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			String childText = driver.findElement(By.tagName("body")).getText();
			driver.switchTo().parentFrame(); // Back to parent frame
		
			/** Handle counting frames */
			driver.get("https://practice-automation.com/iframes/");
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("Total iframes: " + iframes.size()); // Output: 2
			// Switch to first iframe
			driver.switchTo().frame(0);
			// Perform actions in iframe...
			List<WebElement> listTest = new ArrayList<WebElement>();
			listTest=(driver.findElements(By.partialLinkText("Test")));
			if(listTest.isEmpty()) {
				System.out.println("Test");
			}
			else {
			for(WebElement test: listTest) {
				System.out.println("Test inside Iframe Name:"+test.getText());
			
		}
			}
			}catch(Exception e) {
			e.getMessage();
		}finally{
			driver.quit();
		}
	}

}
