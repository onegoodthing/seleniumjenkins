package sample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Taking screenshot using selenium, File source and output.
 * */
public class ScreenshotSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.davy.ie/working-at-davy/opportunities");
		driver.manage().window().maximize();
		String title_page= driver.getTitle();
		System.out.println(title_page);
		try {
		TakesScreenshot screen= (TakesScreenshot)driver;
		File source= screen.getScreenshotAs(OutputType.FILE);
		File target= new File("FullSCreen.png");
		FileUtils.copyFile(source, target);
		
		//Specific `Element Screenshot using highlighter from JavA script executor
		WebElement wb= driver.findElement(By.xpath("//*[@id=\"davyLogo\"]"));
		highlighter(wb,driver);
		
		File src = wb.getScreenshotAs(OutputType.FILE);
		File trg= new File("Logo.png");
		FileUtils.copyFile(src, trg);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
		
		driver.quit();
		}
	}
	static void highlighter(WebElement we, WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red'", we);
	}
}
