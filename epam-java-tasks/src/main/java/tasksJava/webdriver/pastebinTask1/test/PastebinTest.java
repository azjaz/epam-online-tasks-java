package tasksJava.webdriver.pastebinTask1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tasksJava.webdriver.pastebinTask1.page.PastebinHomePage;

public class PastebinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Creation new Paste on pastebin.com")
    public void checkCreationOfNewPaste() {
        boolean expectedResultsOnPage = new PastebinHomePage(driver)
                .openPage()
                .fillRequiredFieldAndCreate("Hello from WebDriver", "helloweb")
                .compareRequiredElementsOnCreatedPage();
        Assert.assertTrue(expectedResultsOnPage, "The page was not created");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTermination() {
        driver.quit();
        driver = null;
    }
}
