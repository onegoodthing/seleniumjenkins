package sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * This class use list collection to print all the jobs with Associate keyword in then 
 * */
public class UsIng_Collections_Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.davy.ie/working-at-davy/opportunities");
		driver.manage().window().maximize();
		String title_page= driver.getTitle();
		System.out.println(title_page);
		try {
		List<WebElement> listJobs = new ArrayList<WebElement>();
		listJobs=(driver.findElements(By.partialLinkText("Associate")));
		if(listJobs.isEmpty()) {
			System.out.println("No job role with assciate");
		}
		else {
		for(WebElement associateJobs: listJobs) {
			System.out.println("Jobs Name:"+associateJobs.getText());
		
		}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}
	}

}
