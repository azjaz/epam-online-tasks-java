package tasksJava.webdriver.pastebinTask2.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tasksJava.webdriver.pastebinTask2.page.PastebinNewPastePage;
import tasksJava.webdriver.pastebinTask2.page.PastebinStartPage;

public class PastebinPasteTest {
    private WebDriver driver;

    private String pasteName = "how to gain dominance among developers";
    private String codePattern = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                    "git push origin master --force";

    private String syntaxHighlightType = "Bash";

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(description = "Checks if 3 elements on page were loaded")
    public void pageLoadingElementsTest() {
        PastebinNewPastePage expectedNewPastePage = new PastebinStartPage(driver)
                .openPage()
                .fillRequiredFieldAndCreate(codePattern, pasteName);
        boolean expectedPasteName = expectedNewPastePage.getPasteNameFromHeader(pasteName).size() > 0;
        Assert.assertTrue(expectedPasteName, "Page with this name was not found!");

        boolean expectedHighlightType = expectedNewPastePage.getSyntaxHighlightType(syntaxHighlightType).size() > 0;
        Assert.assertTrue(expectedHighlightType, "This paste has different from " + syntaxHighlightType + " syntax!");

        boolean expectedCodePattern = expectedNewPastePage.getCodePattern(codePattern);
        Assert.assertTrue(expectedCodePattern, "Code pattern was not found!");
    }


    @AfterMethod(alwaysRun = true)
    public void browserTermination() {
        driver.quit();
        driver = null;
    }
}
