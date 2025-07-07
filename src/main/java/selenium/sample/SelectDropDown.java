package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/**
This class Selects drop down from a given list.
*/
public class SelectDropDown {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://naveenautomationlabs.com/opencart/index.php");
        try{
            /*
            This method Selects drop down from a given list. Select the desired option by get text method and click on it
        */
            driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("phone");
            driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
            Select newSelect= new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
            List<WebElement> webElementList1= newSelect.getOptions();
            for(WebElement webElement: webElementList1){
                if(webElement.getText().equalsIgnoreCase("Laptops & Notebooks")){
                webElement.click();
            }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }finally {
            driver.close();
        }
    }

}
