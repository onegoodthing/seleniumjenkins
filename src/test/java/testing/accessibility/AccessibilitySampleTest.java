package testing.accessibility;


import com.deque.html.axecore.results.ResultType;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.deque.html.axecore.results.Results;
import java.util.List;

/**
 * Checking the accessibility testing on a website
  * */
public class AccessibilitySampleTest {

    private WebDriver driver;
    private static final List<String> WCAG_TAGS    = List.of("wcag2a", "wcag2aa", "wcag21a", "wcag21aa");
    private static final String robandPaulURL="https://robandpaul.ie/";
    @BeforeClass
    public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    }

    @Test
    public void checkAccessibility() {

        driver.get(robandPaulURL);

        Results axeResults = new AxeBuilder()
                .withTags(WCAG_TAGS).analyze(driver);

        /* … inside checkAccessibility() … */
        List<Rule> violations = axeResults.getViolations();
        if (!violations.isEmpty()) {

            // 1) keep the raw JSON for dashboards / manual triage
            String filePath = "target/axe-home";
          AxeReporter.writeResultsToJsonFile(filePath, axeResults);

            // 2) pretty-print a table to the console and cache it internally
            AxeReporter.getReadableAxeResults(
                    ResultType.Violations.getKey(),   // tells the reporter we only pass violations
                    driver,                           // current WebDriver instance
                    violations);                      // the violation list

            // 3) fail the test with the same table text
            Assert.fail(String.format(
                    "Accessibility check failed – %d violation(s). "
                            + "See JSON report(s) under %s-*.json%n%n%s",
                    violations.size(),
                    filePath,
                    AxeReporter.getAxeResultString()));
        }
    }

@AfterClass
    public void teardown() {
        driver.quit();
}
}
