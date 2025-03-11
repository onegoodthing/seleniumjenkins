package sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumBasics {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		String title_page= driver.getTitle();
		System.out.println(title_page);
		//ccs selector
		// by tag#id
		try {
		driver.findElement(By.cssSelector("nav#top"));
		// by tag#class
		driver.findElement(By.cssSelector("li#list-inline-item"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		driver.close();
		}
}
}

