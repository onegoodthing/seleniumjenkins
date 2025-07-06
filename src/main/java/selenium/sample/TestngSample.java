package selenium.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngSample {

	@Test
	public void sample() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://academy.naveenautomationlabs.com/");
		driver.manage().window().maximize();
		String title_page= driver.getTitle();
		System.out.println(title_page);
		try {
		Assert.assertEquals(title_page,"Your Store");
		
	}catch (Exception e) {
		// TODO: handle exception
	e.getMessage();
	}finally {
		driver.quit();
	}
		
}}
