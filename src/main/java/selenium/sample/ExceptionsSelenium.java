package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionsSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		try {
			//ccs selector
			// by tag#id
			driver.get("https://demo.opencart.com/");
			driver.manage().window().maximize();
			String title_page= driver.getTitle();
			System.out.println(title_page);
		driver.findElement(By.cssSelector("nav#top"));
		// by tag#class
		driver.findElement(By.cssSelector("li#list-inline-item"));
		}
		catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found!");
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException: Element is not attached to the page.");
        } catch (TimeoutException e) {
            System.out.println("TimeoutException: Operation took too long.");
        } catch (WebDriverException e) {
            System.out.println("WebDriverException: Issue with WebDriver.");
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
		finally {
		driver.quit();
		System.out.println(" Browser closed successfully.");
		}
	}

}
