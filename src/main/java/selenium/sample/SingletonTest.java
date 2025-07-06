package selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class SingletonTest {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getInstance().getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        DriverManager.getInstance().handleGDPRConsent();
        driver.findElement(By.name("q")).sendKeys("Singleton Design Pattern in Selenium");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
