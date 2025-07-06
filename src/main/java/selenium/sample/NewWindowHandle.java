package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class NewWindowHandle {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://academy.naveenautomationlabs.com/");
        driver.manage().window().maximize();
        /**
         * CLick on Demo Site link for new window
         */

        try {
            String pageTitleMain = driver.getTitle();
            System.out.println("Main Window page = " + pageTitleMain);
            driver.findElement(By.xpath("//a[normalize-space()='Demo Site']")).click();
            String mainWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            for (String childWindow : allWindows) {
                if (!mainWindow.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    String pageTitle = driver.getTitle();
                    System.out.println("Child Window = " + pageTitle);
                    driver.findElement(By.xpath("//span[@id='cart-total']")).click();
                    driver.close();
                }

            }
            driver.switchTo().window(mainWindow);
            /**
             * Performing actions in the main window
             */
            driver.findElement(By.xpath("//a[@class='edit']")).click();
            System.out.println("New Window title = " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}
