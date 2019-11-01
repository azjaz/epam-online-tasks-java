package tasksJava.webdriver.pricingCalculatorTask2.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tasksJava.webdriver.pricingCalculatorTask2.page.CloudGoogleHomePage;
import tasksJava.webdriver.pricingCalculatorTask2.page.GoogleCloudPricingCalcPage;
import tasksJava.webdriver.pricingCalculatorTask2.page.TemporaryEmailServicePage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GooglePriceCalculatorTest {
    private String termToSearch = "Google Cloud Platform Pricing Calculator";
    String regExForCheckedValue = "\\d?.?\\d+\\.\\d+";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void correspondenceUserInputFieldsTest() {
        GoogleCloudPricingCalcPage testPage = new CloudGoogleHomePage(driver)
                .openHomePage()
                .searchForTerm(termToSearch)
                .clickOnRequiredLink()
                .activateComputeEngineBlock()
                .fillNumberOfInstancesField()
                .fillPurposeOfInstancesBlock()
                .chooseSoftwareBlock()
                .chooseVMachineClassBlock()
                .chooseMachineTypeBlock()
                .chooseGPUTypeBlock()
                .chooseLocalSSDBlock()
                .chooseDatacenterLocationBlock()
                .chooseCommittedUsageBlock()
                .pressAddToEstimateButton();

        String totalCostFromCalculator = Arrays.stream(testPage.getTotalCostFromCalculator())
                .filter((p) -> p.matches(regExForCheckedValue))
                .collect(Collectors.joining());

        TemporaryEmailServicePage testEmailServicePage = testPage.pressEmailEstimateButton()
                .fillEmailField()
                .pressSendEmailButton()
                .spinMessageList();

        String totalCostFromMail = Arrays.stream(testEmailServicePage.getTotalCostFromTheLetter())
                .filter((p) -> p.matches(regExForCheckedValue))
                .collect(Collectors.joining());

        Assert.assertEquals(totalCostFromCalculator, totalCostFromMail);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTermination() {
        driver.quit();
        driver = null;
    }
}
